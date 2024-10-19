package com.cuscatlan.paymentservice.application.dtos;

public class PaymentResponse {
    private Long orderId;
    private String status;
    private String message;

    public PaymentResponse(Long orderId, String status, String message) {
        this.orderId = orderId;
        this.status = status;
        this.message = message;
    }

    // Getters y Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
