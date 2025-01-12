package com.Shopping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Shopping.model.Queries;
import com.Shopping.service.QueriesService;

@Controller
public class HomeController {

    @GetMapping({ "/index", "/index1" })
    public String sayIndex() {
        return "index1";
    }

    @GetMapping("/hello")
    public ModelAndView sayHello() {
        return new ModelAndView("hello", "hello", "Hello Mr.Ismail");
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, Model model) {
        if (error != null)
            model.addAttribute("error", "Invalid username and Password");
        if (logout != null)
            model.addAttribute("logout", "You have logged out successfully");
        return "login";
    }

    @GetMapping("/aboutus")
    public String sayAbout() {
        return "aboutUs";
    }

    @Autowired
    private QueriesService queryService;

    @GetMapping("/contactus")
    public ModelAndView getQuery() {
        Queries query = new Queries();
        return new ModelAndView("contactUs", "contact", query);
    }

    @PostMapping("/contactus")
    public String addQuery(@Valid @ModelAttribute("contact") Queries query, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "contactUs";
        }
        
        queryService.addQuery(query);
        model.addAttribute("querySuccess",
                "Thank you, Your message has been stored. We will contact you via your registered email.");
        return "redirect:/index";  // Redirect after successful query submission
    }
}
