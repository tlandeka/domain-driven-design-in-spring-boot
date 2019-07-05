package com.example.excercise.integration.infrastructure.persistence.jpa.payment;

import com.example.excercise.testdatafactory.domain.model.payment.PaymentBuilder;
import com.example.excercise.domain.model.payment.Payment;
import com.example.excercise.infrastructure.persistence.jpa.payment.PaymentJPARepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PaymentJPARepositoryIntegrationTest {
    @Autowired
    private PaymentJPARepository paymentJPARepository;

    @Test
    public void testFindById() {
        Payment aPayment = PaymentBuilder.aPaymentBuilder().withId("4ee3a8d8-ca7b-4290-a52c-dd5b6165ec47").build();
        paymentJPARepository.save(aPayment);

        Optional<Payment> payment = paymentJPARepository.findById(aPayment.getId());

        assertThat(aPayment.getId(), is(equalTo(payment.get().getId())));
    }
}
