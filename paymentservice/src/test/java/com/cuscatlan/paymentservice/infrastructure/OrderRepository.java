package com.cuscatlan.paymentservice.infrastructure;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.cuscatlan.paymentservice.domain.dtos.DetailOrderDTO;
import com.cuscatlan.paymentservice.domain.dtos.OrderDTO;
import com.cuscatlan.paymentservice.infrastructure.repositories.OrderIntegration;

public class OrderRepository {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private OrderIntegration orderIntegration;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetOrder(){
        //Arrange
        List<DetailOrderDTO> orderProducts = Arrays.asList(
            new DetailOrderDTO(1L,1L, 2, 10.0),
            new DetailOrderDTO(2L,1L, 1, 10.0)
        );
        OrderDTO mockResponse = new OrderDTO(1L, 2L, "San Salvador", 10.50,"pending",LocalDateTime.now(), orderProducts);
        when(restTemplate.getForObject("http://localhost:8081/orders/GetOrderById?id=1", OrderDTO.class))
            .thenReturn(mockResponse);
        //Act
        OrderDTO order = orderIntegration.getOrderById(1L);
        //Assert
        assertNotNull(order);
    }
}
