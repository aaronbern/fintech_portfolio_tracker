package com.aaronbernard.investment.portfolio_tracker.service;

import com.aaronbernard.investment.portfolio_tracker.model.Investment;
import com.aaronbernard.investment.portfolio_tracker.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestmentService {

    private final InvestmentRepository investmentRepository;

    @Autowired
    public InvestmentService(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    public Investment saveInvestment(Investment investment) {
        return investmentRepository.save(investment);
    }

    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    public Optional<Investment> getInvestmentById(Long id) {
        return investmentRepository.findById(id);
    }

    public void deleteInvestment(Long id) {
        investmentRepository.deleteById(id);
    }
}
