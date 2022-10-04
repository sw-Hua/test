package com.asd.demo.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PaymentController {
    @Autowired
    private PaymentService service;

    @GetMapping("/payment")
    public String showPayment(Model model){
        List<Payment> listPayment = service.listAll();
        model.addAttribute("listPayment", listPayment);
        return "payment";
    }
}
