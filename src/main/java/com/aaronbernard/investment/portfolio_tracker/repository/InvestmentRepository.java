package com.aaronbernard.investment.portfolio_tracker.repository;

import com.aaronbernard.investment.portfolio_tracker.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {
}