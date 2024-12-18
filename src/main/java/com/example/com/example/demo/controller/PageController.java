package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    /** Home page.*/
    @GetMapping("/")
    public String index(Model model) {
    	model.addAttribute("message","Welcome");
        return "index";
    }
    
    /** Home page.*/
    @GetMapping("/computer")
    public String computer(Model model) {
    	model.addAttribute("message","Welcome to user");
        return "index";
    }
}
