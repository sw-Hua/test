package com.asd.demo.vip;

import com.asd.demo.activity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller

public class VipUserController {
    @Autowired private VipUserService service;

    @GetMapping("/vipMain")
    public String showVipUserList(Model model, HttpSession session){
        session.setAttribute("userId", 10001);
        session.setAttribute("pointSystemID", 0);
        List<VipUser> listVipUsers = service.listAll();
        model.addAttribute("listVipUsers", listVipUsers);
        model.addAttribute("userId", session.getAttribute("userId"));
        return "vipMain";
    }

    // 添加新user
    @GetMapping("/vipUsers/new") //这边控制得url
    public String showNewForm(Model model){
        model.addAttribute("vipUser", new VipUser()); // 方法, 添加一个新的映射
        model.addAttribute("pageTitle", "Add New VIP User"); // 方法, 添加一个新的映射
        return "vipUser_form"; // 这边是本地的链接
    }

    @PostMapping("/vipUsers/save")
    public String saveString(VipUser vipUser, RedirectAttributes ra){
        service.save(vipUser);
        ra.addFlashAttribute("message", "The plan have been saved successfully."); // 增加一个message
        return "redirect:/vipMain";
    }

    @GetMapping("/vipUsers/edit/{id}")
    public String editForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            VipUser user = service.get(id);

            model.addAttribute("vipUser", user);
            model.addAttribute("pageTitle", "Edit User (ID: " + id + ")");
            return "vipUser_form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage()); // 增加一个message 这边也可以用e.getMessage()
            return "redirect:/vipMain";
        }
    }

    @GetMapping("/vipUsers/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Integer id, RedirectAttributes ra){
        service.delete(id);
        ra.addFlashAttribute("message", "The plan have been DELETE successfully."); // 增加一个message
        return "redirect:/vipMain";
    }



}
