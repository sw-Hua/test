package com.asd.demo.vipSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class VipSystemController {
    @Autowired private VipService service;

    @GetMapping("/vipSystem")
    public String showReward(Model model){
        List<VipSystem> listVipSystem = service.listAll();
        model.addAttribute("listVipSystem", listVipSystem);
        return "vipSystem";
    }
}
