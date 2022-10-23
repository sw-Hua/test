package com.asd.demo.payment;

import com.asd.demo.activity.Activity;
import com.asd.demo.activity.ActivityService;
import com.asd.demo.activity.activityNotFoundException;
import com.asd.demo.vip.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PaymentController {
    @Autowired
    private PaymentService service;

    @Autowired
    ActivityService activityService;

    @GetMapping("/payment")
    public String showPayment(Model model, HttpSession session){
        //List<Payment> listPayment = service.listAll();
        List<Activity> listActivity = activityService.listAll();
        Activity activity = new Activity();
        model.addAttribute("listActivity", listActivity);
        session.setAttribute("listActivity", listActivity);
        System.out.println("listActivity" + session.getAttribute("listActivity"));
        model.addAttribute("activity", activity);
        model.addAttribute("numOfVoucher", session.getAttribute("numOfVoucher"));
        model.addAttribute("userId", session.getAttribute("userId"));
        return "payment";
    }

//    @GetMapping("/payment/completed/{id}")
//    public String showDeleteForm(@PathVariable("id") Integer id, RedirectAttributes ra){
//
//        activityService.delete(id);
//        return "redirect:/payment";
//    }

    @GetMapping("/payment/completed")
    public String showDeleteForm2(Model model, Activity activity, HttpSession session, RedirectAttributes ra){
        //System.out.println(session.getAttribute("listActivity"));
        //List<Activity> listActivity = (List<Activity>)session.getAttribute("listActivity");

        //activityService.delete(listActivity.size());
        System.out.println(activity);
        if (activity == null){
            ra.addFlashAttribute("message", "Not Found Your Voucher ID"); // 增加一个message
            return "redirect:/payment";
        }
        int i = 0;
        List<Activity> listActivity = (List<Activity>)session.getAttribute("listActivity");
        for (Activity activity1 : listActivity) {
            if (activity1.getVoucherID().equals(activity.getVoucherID())){
                activityService.delete(activity.getVoucherID());
                ra.addFlashAttribute("messageSuccess", "Exchange successfully"); // 增加一个message
                i=1;
            }
        }

        if (i==0){
            //没有触发过
            ra.addFlashAttribute("message", "Not Found Your Voucher ID"); // 增加一个message
            return "redirect:/payment";
        }
        i=0;

        return "redirect:/payment";



    }
}
