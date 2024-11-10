package com.aaronbernard.investment.portfolio_tracker.controller;

import com.aaronbernard.investment.portfolio_tracker.model.Investment;
import com.aaronbernard.investment.portfolio_tracker.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Investment addInvestment(@RequestBody Investment investment) {
        return investmentService.saveInvestment(investment);
    }

    @GetMapping
    public List<Investment> getAllInvestments() {
        return investmentService.getAllInvestments();
    }

    @GetMapping("/{id}")
    public Investment getInvestmentById(@PathVariable Long id) {
        return investmentService.getInvestmentById(id)
                .orElseThrow(() -> new RuntimeException("Investment not found with id " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteInvestment(@PathVariable Long id) {
        investmentService.deleteInvestment(id);
    }
}
