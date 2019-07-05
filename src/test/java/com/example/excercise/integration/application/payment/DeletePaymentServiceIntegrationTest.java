package com.example.excercise.integration.application.payment;

import com.example.excercise.application.payment.DeletePaymentService;
import com.example.excercise.domain.model.payment.Payment;
import com.example.excercise.infrastructure.persistence.jpa.payment.PaymentJPARepository;
import com.example.excercise.testdatafactory.domain.model.payment.PaymentBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class DeletePaymentServiceIntegrationTest {
    @Autowired
    private DeletePaymentService deletePaymentService;

    @Autowired
    private PaymentJPARepository paymentJPARepository;

    @Test
    public void testDeleteExistingPayment() {
        Payment aPayment = PaymentBuilder.aPaymentBuilder().withId("4ee3a8d8-ca7b-4290-a52c-dd5b6165ec47").build();
        paymentJPARepository.save(aPayment);

        deletePaymentService.execute(aPayment.getId());

        Optional<Payment> payment = paymentJPARepository.findById(aPayment.getId());

        // Verify the addition
        assertEquals(false, payment.isPresent());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteUnexistingPayment() {
        deletePaymentService.execute("4ee3a8d8-ca7b-4290-a52c-dd5b61XXXXXX");
    }
}
