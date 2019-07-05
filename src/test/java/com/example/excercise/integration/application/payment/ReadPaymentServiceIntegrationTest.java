package com.example.excercise.integration.application.payment;

import com.example.excercise.application.payment.ReadPaymentService;
import com.example.excercise.testdatafactory.domain.model.payment.PaymentBuilder;
import com.example.excercise.domain.model.payment.Payment;
import com.example.excercise.infrastructure.persistence.jpa.payment.PaymentJPARepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ReadPaymentServiceIntegrationTest {
    @Autowired
    private ReadPaymentService readPaymentService;

    @Autowired
    private PaymentJPARepository paymentJPARepository;

    @Test
    public void testReadPayment() {
        Payment aPayment = PaymentBuilder.aPaymentBuilder().withId("4ee3a8d8-ca7b-4290-a52c-dd5b6165ec47").build();
        paymentJPARepository.save(aPayment);

        Payment payment = readPaymentService.execute(aPayment.getId());

        // Verify the addition
        assertNotNull(payment);
        assertNotNull(payment.getId());
        assertEquals(aPayment.getId(), payment.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReadUnexistingPayment() {
        readPaymentService.execute("4ee3a8d8-ca7b-4290-a52c-dd5b61XXXXXX");
    }
}
