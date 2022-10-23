package com.asd.demo.premium;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PremiumController {
    @Autowired
    private PremiumService service;

    @GetMapping("/premium")
    public String showPremium(Model model){
        List<Premium> listPremium = service.listAll();
        model.addAttribute("listPremium", listPremium); // add new Attribute
        return "premium";
    }

    @GetMapping("/premium/newPlan/{id}")
    public String showNewForm(Model model, @PathVariable("id") Integer id, HttpSession httpSession){
        Integer userId = (Integer)httpSession.getAttribute("userId");


        model.addAttribute("vipID", id);
        model.addAttribute("userID", httpSession.getAttribute("userId"));
        model.addAttribute("premium", new Premium()); // new Premium
        model.addAttribute("pageTitle", "Add New Plan"); // method, adding a new map
        return "premium_form";
    }

    @PostMapping("/premium/save")
    public String saveString(Premium premium, RedirectAttributes ra){
        service.save(premium);
        ra.addFlashAttribute("message", "Coupon have redeemed successfully");
        return "redirect:/premium";
    }
}
