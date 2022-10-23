package com.asd.demo.activity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ActivityController {
    @Autowired
    private ActivityService service;

    @GetMapping("/activity")
    public String showActivity(Model model, HttpSession session){
        List<Activity> listActivity = service.listAll();
        List<Activity> listShowActivity = new ArrayList<>();
        Object userId = session.getAttribute("userId");
        for (Activity activity : listActivity) {
            if (activity.getUserID().equals(userId)){
                listShowActivity.add(activity);
            }
        }
        model.addAttribute("listActivity", listShowActivity);
        model.addAttribute("numOfLastAddVoucher", session.getAttribute("numOfLastAddVoucher"));
        session.setAttribute("numOfVoucher", listActivity.size());
        return "activity";
    }
}
