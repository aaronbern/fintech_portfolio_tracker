package com.aaronbernard.investment.portfolio_tracker.service;

import com.aaronbernard.investment.portfolio_tracker.model.Investment;
import com.aaronbernard.investment.portfolio_tracker.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;  // Make sure this resolves
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class DatabaseSeeder {

    private final InvestmentRepository investmentRepository;

    @Autowired
    public DatabaseSeeder(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    @PostConstruct
    public void seedDatabase() {
        List<Investment> investments = Arrays.asList(
                new Investment("Apple Inc.", "Stock", 10, 150.50, LocalDate.of(2023, 1, 10), "aaronbernard24@gmail.com"),
                new Investment("Tesla Inc.", "Stock", 5, 800.75, LocalDate.of(2023, 2, 15), "aaronbernard24@gmail.com"),
                new Investment("Bitcoin", "Cryptocurrency", 0.1, 45000.00, LocalDate.of(2022, 11, 20), "aaronbernard24@gmail.com"),
                new Investment("Gold ETF", "ETF", 20, 180.30, LocalDate.of(2023, 3, 5), "aaronbernard24@gmail.com")
        );
        investmentRepository.saveAll(investments);
    }
}
