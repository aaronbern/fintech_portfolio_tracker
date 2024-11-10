package com.aaronbernard.investment.portfolio_tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";  // Refers to index.html in resources/templates
    }
}