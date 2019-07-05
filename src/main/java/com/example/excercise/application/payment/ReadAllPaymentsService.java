package com.example.excercise.application.payment;

import com.example.excercise.domain.model.payment.Payment;
import com.example.excercise.infrastructure.persistence.jpa.payment.PaymentJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ReadAllPaymentsService {

    @Autowired
    private PaymentJPARepository paymentJPARepository;

    @Transactional
    public Iterable<Payment> execute() {
        return paymentJPARepository.findAll();
    }
}
