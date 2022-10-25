package com.asd.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class vipMainController {
    @GetMapping("/show")

    public String showHomePage(){
        return "index";
    }
}
