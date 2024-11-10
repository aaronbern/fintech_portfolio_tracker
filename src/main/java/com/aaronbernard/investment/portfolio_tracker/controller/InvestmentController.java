package com.aaronbernard.investment.portfolio_tracker.controller;

import com.aaronbernard.investment.portfolio_tracker.model.Investment;
import com.aaronbernard.investment.portfolio_tracker.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.oauth2.core.user.OAuth2User;
import jakarta.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/api/investments")
public class InvestmentController {

    private final InvestmentService investmentService;

    @Autowired
    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @PostMapping
    public Investment addInvestment(@Valid @RequestBody Investment investment) {
        return investmentService.saveInvestment(investment);
    }

    @GetMapping
    public List<Investment> getUserInvestments(@AuthenticationPrincipal OAuth2User principal) {
        String userEmail = principal.getAttribute("email");
        return investmentService.getInvestmentsByUser(userEmail);
    }
    @GetMapping("/{id}")
    public Investment getInvestmentById(@PathVariable Long id) {
        return investmentService.getInvestmentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Investment not found"));
    }

    @PutMapping("/{id}")
    public Investment updateInvestment(@PathVariable Long id, @RequestBody Investment updatedInvestment) {
        return investmentService.updateInvestment(id, updatedInvestment);
    }

    @DeleteMapping("/{id}")
    public void deleteInvestment(@PathVariable Long id) {
        investmentService.deleteInvestment(id);
    }
}
