package com.example.excercise.application.payment;

import com.example.excercise.application.payment.builder.PaymentBuilder;
import com.example.excercise.application.payment.dto.request.UpdatePayment;
import com.example.excercise.domain.model.payment.Payment;
import com.example.excercise.infrastructure.persistence.jpa.payment.PaymentJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UpdatePaymentService {

    @Autowired
    private PaymentJPARepository paymentJPARepository;

    @Autowired
    private PaymentBuilder paymentBuilder;

    @Transactional
    public void execute(UpdatePayment updatePayment, String paymentId) {
        Optional<Payment> paymentOptional = paymentJPARepository.findById(paymentId);

        if (!paymentOptional.isPresent()) {
            throw new IllegalArgumentException("Payment is not exist");
        }

        Payment payment = paymentOptional.get();

        this.paymentBuilder
                .setPayment(payment)
                .setUpdatePayment(updatePayment)
                .buildOnUpdate();

        paymentJPARepository.save(payment);
    }
}
