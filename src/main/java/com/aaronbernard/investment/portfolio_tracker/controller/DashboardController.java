package com.aaronbernard.investment.portfolio_tracker.controller;

import com.aaronbernard.investment.portfolio_tracker.model.Investment;
import com.aaronbernard.investment.portfolio_tracker.service.InvestmentService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    private final InvestmentService investmentService;

    public DashboardController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal OAuth2User principal, Model model) {
        String userEmail = principal.getAttribute("email");
        model.addAttribute("name", principal.getAttribute("name"));

        List<Investment> investments = investmentService.getInvestmentsByUser(userEmail);
        model.addAttribute("investments", investments);

        return "dashboard";
    }
}
