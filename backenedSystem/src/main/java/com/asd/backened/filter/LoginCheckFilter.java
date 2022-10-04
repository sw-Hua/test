package com.asd.backened.filter;

import com.alibaba.fastjson.JSON;
import com.asd.backened.common.BaseContext;
import com.asd.backened.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Xuhao Guo
 * Check whether the user has logged in
 */
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter{
    //Path matcher with wildcard support
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1、Gets the URI for this request
        String requestURI = request.getRequestURI();// /backend/index.html

        log.info("Blocking a request：{}",requestURI);

        //Define the request path that does not need to be processed
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/sendMsg",
                "/user/login",
                "/doc.html",
                "/webjars/**",
                "/swagger-resources",
                "/v2/api-docs"
        };

        //2、Determine whether the request needs to be processed
        boolean check = check(urls, requestURI);

        //3、If no processing is required, release the data
        if(check){
            log.info("This request {} does not need to be processed",requestURI);
            filterChain.doFilter(request,response);
            return;
        }

        //4-1、Determine the login status. If you have logged in, allow the service
        if(request.getSession().getAttribute("employee") != null){
            log.info("The user has logged in. The user ID is：{}",request.getSession().getAttribute("employee"));

            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);

            filterChain.doFilter(request,response);
            return;
        }

        //4-2、Determine the login status. If you have logged in, allow the service
        if(request.getSession().getAttribute("user") != null){
            log.info("The user has logged in. The user ID is:{}",request.getSession().getAttribute("user"));

            Long userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);

            filterChain.doFilter(request,response);
            return;
        }

        log.info("The user is not logged in.");
        //5、If the user is not logged in, the user returns the result of not logging in, and responds to the client page through the output stream
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;

    }

    /**
     * If the paths match, check whether the request needs to be allowed
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls,String requestURI){
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if(match){
                return true;
            }
        }
        return false;
    }
}
