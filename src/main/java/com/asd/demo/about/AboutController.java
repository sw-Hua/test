package com.asd.demo.about;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StreamUtils;


import java.util.List;

@Controller
public class AboutController {
    @Autowired private AboutService service;

    @GetMapping("/about")
    public String showAbout(Model model, HttpSession session){
        session.setAttribute("userId", 10001);
        List<About> listAbout = service.listAll();
        model.addAttribute("listAbout", listAbout);
        return "about";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)

    public void getImage(HttpServletResponse response) throws IOException {

        ClassPathResource imgFile = new ClassPathResource("images/r1.jpg");

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }
}
