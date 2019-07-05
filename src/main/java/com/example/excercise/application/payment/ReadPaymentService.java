package com.example.excercise.application.payment;

import com.example.excercise.domain.model.payment.Payment;
import com.example.excercise.infrastructure.persistence.jpa.payment.PaymentJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ReadPaymentService {

    @Autowired
    private PaymentJPARepository paymentJPARepository;

    @Transactional
    public Payment execute(String Id) {
        Optional<Payment> payment = paymentJPARepository.findById(Id);
        if (!payment.isPresent()) {
            throw new IllegalArgumentException("Payment is not exist");
        }

        return payment.get();
    }
}
