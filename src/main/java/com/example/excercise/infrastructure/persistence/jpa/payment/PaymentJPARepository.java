package com.example.excercise.infrastructure.persistence.jpa.payment;

import com.example.excercise.domain.model.payment.Payment;
import com.example.excercise.domain.model.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentJPARepository implements PaymentRepository {

    @Autowired
    PaymentJPARepostitoryInterface paymentJPARepostitoryInterface;

    @Override
    public Payment save(Payment payment) {
        return paymentJPARepostitoryInterface.save(payment);
    }

    @Override
    public Optional<Payment> findById(String id) {
        return paymentJPARepostitoryInterface.findById(id);
    }

    @Override
    public void deleteAll() {
        paymentJPARepostitoryInterface.deleteAll();
    }

    @Override
    public void delete(Payment payment) {
        paymentJPARepostitoryInterface.delete(payment);
    }

    @Override
    public Iterable<Payment> findAll() {
        return paymentJPARepostitoryInterface.findAll();
    }
}
