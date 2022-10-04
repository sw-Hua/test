/**
 * Copyright (C), 2015-2022, XXX有限公司
 * FileName: payment
 * Author:   benjamen
 * Date:     2022/9/5 17:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.asd.payment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class payment {
    @GetMapping("")
    public String showHomePage(){
        return "payment.html";
    }
}
