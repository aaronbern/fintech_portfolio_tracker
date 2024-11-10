package com.aaronbernard.investment.portfolio_tracker;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Objects;

@SpringBootApplication
@EnableJpaRepositories("com.aaronbernard.investment.portfolio_tracker.repository")
public class PortfolioTrackerApplication {
	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
				.directory("C:/Users/aaron/OneDrive/Desktop/Code/ApexApiTest/portfolio-tracker")
				.load();

		System.setProperty("GOOGLE_CLIENT_ID", Objects.requireNonNull(dotenv.get("GOOGLE_CLIENT_ID")));
		System.setProperty("GOOGLE_SECRET_OAUTH", Objects.requireNonNull(dotenv.get("GOOGLE_SECRET_OAUTH")));

		SpringApplication.run(PortfolioTrackerApplication.class, args);
	}
}