package com.example.excercise.domain.model.payment.repository;

import com.example.excercise.domain.model.payment.Payment;

import java.util.Optional;

public interface PaymentRepository {
    Payment save(Payment payment);
    Optional<Payment> findById(String id);
    void deleteAll();
    void delete(Payment payment);
    Iterable<Payment> findAll();
}
