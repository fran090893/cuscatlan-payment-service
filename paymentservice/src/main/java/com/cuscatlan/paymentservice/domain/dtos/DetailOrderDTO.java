package com.cuscatlan.paymentservice.domain.dtos;

public class DetailOrderDTO {
    private Long id;
    private Long productId;
    private Integer quantity;
    private Double price;

    public DetailOrderDTO() {}

    public DetailOrderDTO(Long id, Long productId,Integer quantity,Double price) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }    

    public Long getId(){
        return id;
    }
    public Long getProductId(){
        return productId;
    }
    public Integer getQuantity(){
        return quantity;
    }
    public Double getPrice(){
        return price;
    }
}
