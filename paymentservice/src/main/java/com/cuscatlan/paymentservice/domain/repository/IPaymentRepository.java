package com.cuscatlan.paymentservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuscatlan.paymentservice.domain.entity.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Long>{
    
}
