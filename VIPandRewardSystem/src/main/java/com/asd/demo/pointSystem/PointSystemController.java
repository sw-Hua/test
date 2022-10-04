package com.asd.demo.pointSystem;

import com.asd.demo.vip.UserNotFoundException;
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
public class PointSystemController {
    @Autowired
    private PointSystemService service;

    @GetMapping("/reward")
    public String showPointSystem(Model model, HttpSession session) throws PointSystemNotFoundException, UserNotFoundException {
        List<PointSystem> listPointSystem = service.listAll();

        Integer pointSystemID = (Integer)session.getAttribute("pointSystemID");

        PointSystem pointSystem = service.get(pointSystemID);


        model.addAttribute("listPointSystem", listPointSystem);
        model.addAttribute("pointSystem", pointSystem);
        return "reward";
    }

    /*
    @GetMapping("/redeem")
    public String showForm(Model model, HttpSession session) throws PointSystemNotFoundException, UserNotFoundException {
        // model.addAttribute();
//        Integer userId = (Integer)session.getAttribute("userId");
//        PointSystem pointSystem = service.get(userId);
//        model.addAttribute("pointSystem", pointSystem);

        return "redeem_form";
    }

     */

    @PostMapping("/reward/redeem/completed")
    public String saveString(PointSystem pointSystem, RedirectAttributes ra){
        service.save(pointSystem);
        ra.addFlashAttribute("message", "消费券成功兑换!");
        return "redeem_form";
    }

    @GetMapping("/reward/redeem/{id}")
    public String editRedeem(@PathVariable("id") Integer id, Model model,RedirectAttributes ra){

        try {
            // service.minusPoint(service.get(0));
            PointSystem pointSystem = service.get(0);
            model.addAttribute("pointSystem", pointSystem);
            ra.addFlashAttribute("message", "消费券成功兑换!"); // 增加一个message
            return "redeem_form";
        }catch (PointSystemNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/redeem";
        }
    }



}
