package com.asd.demo.reward;

import com.asd.demo.pointSystem.PointSystem;
import com.asd.demo.pointSystem.PointSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RewardController {
    @Autowired private RewardService service;


//    @GetMapping("/reward")
//    public String showReward(Model model){
//        List<Reward> listRewards = service.listAll();
//        model.addAttribute("listRewards", listRewards);
//        return "reward";
//    }

}
