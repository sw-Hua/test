package com.asd.backened.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.asd.backened.common.R;
import com.asd.backened.entity.User;
import com.asd.backened.service.UserService;
import com.asd.backened.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**   Xuhao Guo
     * Send a mobile message verification code
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session){
        //Get a cell phone number
        String phone = user.getPhone();

        if(StringUtils.isNotEmpty(phone)){
            //Generate a random 4-digit verification code
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("code={}",code);


            redisTemplate.opsForValue().set(phone,code,5,TimeUnit.MINUTES);

            return R.success("The mobile phone verification code is successfully sent.");
        }

        return R.error("Failed to send short messages.");
    }

    /**
     * Mobile user login
     * @param map
     * @param session
     * @return
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session){
        log.info(map.toString());

        //Get a cell phone number
        String phone = map.get("phone").toString();

        //get code
        String code = map.get("code").toString();

        //The saved verification code is obtained from the Session. Procedure
        //Object codeInSession = session.getAttribute(phone);

        //Get the cached verification code from Redis
        Object codeInSession = redisTemplate.opsForValue().get(phone);

        //Compare the verification code (the verification code submitted on the page and the verification code saved in the Session)
        if(codeInSession != null && codeInSession.equals(code)){
            //If the comparison is successful, the login is successful

            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,phone);

            User user = userService.getOne(queryWrapper);
            if(user == null){
                //Check whether the user corresponding to the current mobile phone number is a new user. If the user is a new user, the system automatically completes registratio
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            session.setAttribute("user",user.getId());

            //If the login succeeds, delete the verification code cached in Redis
            redisTemplate.delete(phone);

            return R.success(user);
        }
        return R.error("login failure");
    }

}
