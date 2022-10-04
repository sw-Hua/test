package com.asd.payment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "crud", urlPatterns = "/crud")
public class crud extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");//通用编码，utf-8
        req.setCharacterEncoding("utf-8");
        //把商品信息放进session购物车
        HttpSession session = req.getSession();
        ArrayList<Food> cart = (ArrayList<Food>) session.getAttribute("cart");
        if(cart==null){
            cart = new ArrayList<Food>();//创建购物车
            session.setAttribute("cart", cart);
            cart.add(0,new Food(1, " Goose Liver", "Western Food", 299,1));
            cart.add(1,new Food(2, "Beef tomato mixed with pasta", "Western Food", 99,1));
            cart.add(2,new Food(3, "Borscht Soup", "Western Food", 129,1));
        }
        resp.sendRedirect("food.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);//数据转手给get方法
    }
}

