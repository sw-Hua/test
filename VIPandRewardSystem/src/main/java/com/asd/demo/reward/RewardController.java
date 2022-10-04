package com.asd.demo.reward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
