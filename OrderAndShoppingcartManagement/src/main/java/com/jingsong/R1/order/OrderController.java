package com.jingsong.R1.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class OrderController {
    @Autowired private OrderService service;

    @GetMapping("/order")
    public String showOrderList(Model model){
        List<Order> orderList = service.listAll();
        model.addAttribute("listOrders",orderList);

        return "orders";
    }

    @GetMapping("/orders/new")
    public String showNewForm(Model model){
        model.addAttribute("order", new  Order());
        model.addAttribute("pageTitle", "Add New Order");
        return "orderForm";
    }

    @PostMapping("/orders/save")
    public String saveOrder(Order order, RedirectAttributes ra){
        service.save(order);
        ra.addFlashAttribute("message", "The order has been saved successfully");
        return "redirect:/order";
    }

    @GetMapping("/orders/edit/{OrderID}")
    public String showEditForm(@PathVariable("OrderID") Integer id, Model model, RedirectAttributes ra){
        try{
            Order order = service.get(id);
            model.addAttribute("order", order);
            model.addAttribute("pageTitle", "Edit Order (ID :"+ id +")");
            return "orderForm";
        } catch (OrderNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/order";
        }
    }

    @GetMapping("/orders/delete/{OrderID}")
    public String deleteUser(@PathVariable("OrderID") Integer id, RedirectAttributes ra){
        try{
            service.delete(id);
        } catch (OrderNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/order";
    }

}
