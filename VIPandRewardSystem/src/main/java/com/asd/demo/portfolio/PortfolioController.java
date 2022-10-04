package com.asd.demo.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PortfolioController {
    @Autowired
    private PortfolioService service;
    @GetMapping("/portfolio")
    public String showPortfolio(Model model){
        List<Portfolio> listPortfolio = service.listAll();
        model.addAttribute("listPortfolio", listPortfolio);
        return "portfolio";
    }
}
