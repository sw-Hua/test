package com.asd.demo.portfolio;
import com.asd.demo.premium.Premium;
import com.asd.demo.premium.PremiumService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PortfolioController {
    @Autowired
    private PortfolioService service;

    @Autowired
    private PremiumService premiumService;
    @GetMapping("/portfolio")
    public String showPortfolio(Model model, HttpSession session){
        List<Portfolio> listPortfolio = service.listAll();
        List<Premium> listPremiums = premiumService.listAll();
        //model.addAttribute("listPortfolio", listPortfolio);
        //model.addAttribute("listPremiums", listPremiums);

        List<Premium> listShowPremiums = new ArrayList<>();
        Portfolio showPortfolio = new Portfolio();

        Integer userId = (Integer)session.getAttribute("userId");
        //System.out.println("userId: "+ userId);
        for (Premium premium : listPremiums) {
            if (premium.getUserID().equals(userId)){
                listShowPremiums.add(premium);
            }
        }

        for (Portfolio portfolio : listPortfolio) {
            if (portfolio.getUserID().equals(userId)){
                showPortfolio = portfolio;
            }
        }

        //System.out.println("listPremiums: " + listPremiums);
        //System.out.println("listShowPremiums: " + listShowPremiums);
        model.addAttribute("listShowPremiums",listShowPremiums);
        model.addAttribute("showPortfolio",showPortfolio);
        session.setAttribute("showPortfolio", showPortfolio);
        return "portfolio";
    }

    @PostMapping("/portfolio/save")
    public String saveString(Portfolio portfolio, RedirectAttributes ra, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        System.out.println("拿到的: ");
        System.out.println(portfolio);

        service.editCustomer(portfolio);
        System.out.println("修改后: ");
        System.out.println(portfolio);

        ra.addFlashAttribute("message", "Please check your email to verify"); // 增加一个message
        String siteURL = Utility.getSiteURL(request);
        service.sendVerificationEmail(portfolio, siteURL);

        // service.save(portfolio);

        // service.sendVerificationEmail(portfolio, "123");

        return "redirect:/portfolio";
    }



    @GetMapping("/portfolio/edit/{id}")
    public String editForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra, HttpSession session){


        Portfolio customer2 = (Portfolio)session.getAttribute("showPortfolio");

        // Portfolio customer = service.get(id);

        model.addAttribute("Portfolio", customer2);
        model.addAttribute("pageTitle", "Edit User (ID: " + id + ")");
        return "portfolio_form";

    }

    @GetMapping("/verify")
    public String verifyEmail(@Param("code") String code) {
        if (service.verify(code)) {
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }
}
