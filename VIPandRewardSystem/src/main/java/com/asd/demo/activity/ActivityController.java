package com.asd.demo.activity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ActivityController {
    @Autowired
    private ActivityService service;

    @GetMapping("/activity")
    public String showActivity(Model model){
        List<Activity> listActivity = service.listAll();
        model.addAttribute("listActivity", listActivity);
        return "activity";
    }
}
