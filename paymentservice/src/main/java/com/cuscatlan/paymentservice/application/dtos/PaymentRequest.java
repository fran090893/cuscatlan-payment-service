package com.cuscatlan.paymentservice.application.dtos;

import javax.validation.constraints.NotNull;

import jakarta.validation.constraints.NotBlank;

public class PaymentRequest {
    @NotNull(message = "orderId is required")
    private Long orderId;
    @NotNull(message = "customerId is required")
    private Long customerId;
    @NotNull(message = "paymentMethod is required")
    @NotBlank(message = "paymentMethod is required")
    private String paymentMethod;

    // Constructor
    public PaymentRequest(Long orderId, Long customerId, String paymentMethod) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.paymentMethod = paymentMethod;
    }

    // Getters  Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
