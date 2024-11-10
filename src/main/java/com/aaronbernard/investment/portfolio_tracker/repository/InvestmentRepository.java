package com.aaronbernard.investment.portfolio_tracker.repository;

import com.aaronbernard.investment.portfolio_tracker.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    List<Investment> findByUserEmail(String userEmail);
}
