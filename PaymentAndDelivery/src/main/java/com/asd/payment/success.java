package com.asd.payment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="success",urlPatterns = "/order")
public class success extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");//通用编码，utf-8，gbk--中文
        request.setCharacterEncoding("utf-8");
        //
        //进入付款页面
        //进入数据库，今天的价格
        //
        //
        response.sendRedirect("/success.html");
        //
        //跳转到首页
        //存储订单信息：未付款
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);//数据转手给get方法
    }
}
