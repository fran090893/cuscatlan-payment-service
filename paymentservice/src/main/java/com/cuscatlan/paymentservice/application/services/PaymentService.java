package com.cuscatlan.paymentservice.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuscatlan.paymentservice.application.dtos.PaymentRequest;
import com.cuscatlan.paymentservice.application.dtos.PaymentResponse;
import com.cuscatlan.paymentservice.domain.dtos.OrderDTO;
import com.cuscatlan.paymentservice.domain.entity.Payment;
import com.cuscatlan.paymentservice.domain.repository.IPaymentRepository;
import com.cuscatlan.paymentservice.infrastructure.OrderIntegration;

@Service
public class PaymentService {

    @Autowired
    private OrderIntegration orderIntegration;

    @Autowired
    private IPaymentRepository paymentRepository;

    public PaymentResponse processPayment(PaymentRequest request) {
        //get order information from microservice order
        OrderDTO order = orderIntegration.getOrderById(request.getOrderId());

        //initialize payment
        Payment payment = new Payment(request.getOrderId(), request.getCustomerId(), order.getTotal(), request.getPaymentMethod());

        //simulate payment process
        if (order.getTotal() != null && order.getTotal() > 0) {
            payment.setStatus("SUCCESS");
            paymentRepository.save(payment);

            return new PaymentResponse(request.getOrderId(), "SUCCESS", "El pago de $" + order.getTotal().toString() + " se realizó con éxito.");
        } else {
            payment.setStatus("FAILED");
            paymentRepository.save(payment);

            return new PaymentResponse(request.getOrderId(), "FAILED", "No se pudo procesar el pago.");
        }
    }
}
