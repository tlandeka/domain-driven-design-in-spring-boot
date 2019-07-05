package com.example.excercise.integration.application.payment;

import com.example.excercise.application.payment.ReadAllPaymentsService;
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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ReadAllPaymentServiceIntegrationTest {
    @Autowired
    private ReadAllPaymentsService readAllPaymentsService;

    @Autowired
    private PaymentJPARepository paymentJPARepository;

    @Test
    public void testReadAllPayment() {
        paymentJPARepository.deleteAll();

        Payment aPayment = PaymentBuilder.aPaymentBuilder().withId("4ee3a8d8-ca7b-4290-a52c-dd5b6165ec47").build();
        Payment bPayment = PaymentBuilder.aPaymentBuilder().withId("4ee3a8d8-ca7b-4290-a52c-dd5b6165ec48").build();

        paymentJPARepository.save(aPayment);
        paymentJPARepository.save(bPayment);

        Iterable<Payment> payments = readAllPaymentsService.execute();

        List<Payment> paymentList = StreamSupport.stream(payments.spliterator(), false)
                .collect(Collectors.toList());

        // Verify the addition
        assertEquals(2, paymentList.size());
    }

}
