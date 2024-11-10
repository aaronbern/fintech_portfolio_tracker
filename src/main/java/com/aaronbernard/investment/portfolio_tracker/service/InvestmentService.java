package com.aaronbernard.investment.portfolio_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.aaronbernard.investment.portfolio_tracker.model.Investment;
import com.aaronbernard.investment.portfolio_tracker.repository.InvestmentRepository;
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

    public List<Investment> getInvestmentsByUser(String userEmail) {
        return investmentRepository.findByUserEmail(userEmail);
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

    public Investment updateInvestment(Long id, Investment updatedInvestment) {
        return investmentRepository.findById(id)
                .map(existingInvestment -> {
                    existingInvestment.setAssetName(updatedInvestment.getAssetName());
                    existingInvestment.setAssetType(updatedInvestment.getAssetType());
                    existingInvestment.setQuantity(updatedInvestment.getQuantity());
                    existingInvestment.setPurchasePrice(updatedInvestment.getPurchasePrice());
                    existingInvestment.setPurchaseDate(updatedInvestment.getPurchaseDate());
                    return investmentRepository.save(existingInvestment);
                })
                .orElseThrow(() -> new RuntimeException("Investment not found with id " + id));
    }

    public void deleteInvestment(Long id) {
        investmentRepository.deleteById(id);
    }
}
