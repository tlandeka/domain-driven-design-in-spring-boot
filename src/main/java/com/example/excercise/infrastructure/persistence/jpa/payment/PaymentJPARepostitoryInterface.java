package com.example.excercise.infrastructure.persistence.jpa.payment;

import com.example.excercise.domain.model.payment.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentJPARepostitoryInterface extends CrudRepository<Payment, String> {

}
