package com.cuscatlan.paymentservice.infrastructure.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.cuscatlan.paymentservice.crosscutting.exception.ExternalServiceException;
import com.cuscatlan.paymentservice.domain.dtos.OrderDTO;

@Repository
public class OrderIntegration {
    private final RestTemplate restTemplate;

    private String productServiceUrl = "http://localhost:8081/orders/";

    public OrderIntegration(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    
    public OrderDTO getOrderById(Long id) {
       try{
            String url = productServiceUrl + "GetOrderById?id=" + id.toString();
            System.out.println("URL: " + url);

            OrderDTO order = restTemplate.getForObject(url, OrderDTO.class);
            return order;
       } catch(Exception e){
            throw new ExternalServiceException("Failed to call GetOrderById." + e.getMessage());
       }
            
    }
}
