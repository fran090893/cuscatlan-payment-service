package com.cuscatlan.paymentservice.infrastructure;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cuscatlan.paymentservice.domain.entity.Payment;
import com.cuscatlan.paymentservice.domain.repository.IPaymentRepository;

@DataJpaTest
public class PaymentRepositoryTest {
    @Autowired
    private IPaymentRepository paymentRepository;

    @Test
    public void testSavePayment(){
        //arrange
        Payment payment = new Payment(1L,1L,10.25,"credit_card");
        //act
        Payment savedPayment = paymentRepository.save(payment);
        //assert
        assertNotNull(savedPayment);
    }
}
