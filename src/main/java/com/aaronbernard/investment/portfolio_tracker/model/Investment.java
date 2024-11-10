package com.aaronbernard.investment.portfolio_tracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Investment {

    public Investment(String assetName, String assetType, double quantity, double purchasePrice, LocalDate purchaseDate, String userEmail) {
        this.assetName = assetName;
        this.assetType = assetType;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.userEmail = userEmail;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Asset name cannot be blank")
    private String assetName;

    @NotBlank(message = "Asset type cannot be blank")
    private String assetType;

    @Positive(message = "Quantity must be greater than zero")
    private double quantity;

    @Positive(message = "Purchase price must be greater than zero")
    private double purchasePrice;

    @NotNull(message = "Purchase date is required")
    @PastOrPresent(message = "Purchase date cannot be in the future")
    @Column(nullable = false)
    private LocalDate purchaseDate;

    @Column(nullable = false)
    private String userEmail;  // New field to link investments with a specific user

    @Transient  // This value won't be stored in the database
    private double currentMarketValue;

    @Transient
    private double totalInvestmentValue;

    public Investment() {

    }

    public double getTotalInvestmentValue() {
        return quantity * purchasePrice;
    }

    public double getCurrentMarketValue() {
        return currentMarketValue;
    }

    public void setCurrentMarketValue(double currentMarketValue) {
        this.currentMarketValue = currentMarketValue;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "Investment{" +
                "id=" + id +
                ", assetName='" + assetName + '\'' +
                ", assetType='" + assetType + '\'' +
                ", quantity=" + quantity +
                ", purchasePrice=" + purchasePrice +
                ", purchaseDate=" + purchaseDate +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
