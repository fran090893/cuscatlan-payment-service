package com.cuscatlan.paymentservice.domain.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    
    private Long id;
    private Long customerId;
    private String shippingAddress;
    private Double total;
    private String status;
    private LocalDateTime createdAt;
    private List<DetailOrderDTO> products;

    public OrderDTO() {}

    public OrderDTO(Long id, Long customerId, String shippingAddress, Double total, String status, LocalDateTime createdAt, List<DetailOrderDTO> products) {
        this.id = id;
        this.customerId = customerId;
        this.shippingAddress = shippingAddress;
        this.total = total;
        this.status = status;
        this.createdAt = createdAt;
        this.products = products;
    }

    public Long getId(){
        return id;
    }

    public Long getCustomerId(){
        return customerId;
    }

    public Double getTotal(){
        return total;
    }

    public List<DetailOrderDTO> getProducts(){
        return products;
    }

    public String getStatus(){
        return status;
    }

    public String getShippingAddress(){
        return shippingAddress;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
}
