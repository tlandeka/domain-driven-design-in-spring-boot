package com.example.excercise.integration.application.payment;

import com.example.excercise.application.payment.UpdatePaymentService;
import com.example.excercise.application.payment.dto.request.UpdatePayment;
import com.example.excercise.domain.model.payment.Payment;
import com.example.excercise.infrastructure.persistence.jpa.payment.PaymentJPARepository;
import com.example.excercise.testdatafactory.application.payment.dto.TestData;
import com.example.excercise.testdatafactory.domain.model.payment.PaymentBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class UpdatePaymentServiceIntegrationTest {
    @Autowired
    private UpdatePaymentService updatePaymentService;

    @Autowired
    private PaymentJPARepository paymentJPARepository;

    private UpdatePayment updatePayment;

    @Before
    public void setUp(){
        this.updatePayment = TestData.getUpdatePaymentDto();
    }

    @Test
    public void updateExistingPayment() {
        Payment aPayment = PaymentBuilder.aPaymentBuilder().withId("4ee3a8d8-ca7b-4290-a52c-dd5b6165ec47").build();
        paymentJPARepository.save(aPayment);

        updatePaymentService.execute(this.updatePayment, aPayment.getId());

        Payment payment = paymentJPARepository.findById(aPayment.getId()).get();

        // Verify the addition
        assertNotNull(payment);
        assertNotEquals(aPayment.getCurrency(), updatePayment.getCurrency());
        assertNotEquals(aPayment.getPaymentType(), updatePayment.getPaymentType());
        assertNotEquals(aPayment.getPaymentScheme(), updatePayment.getPaymentScheme());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateUnexistingPayment() {
        updatePaymentService.execute(this.updatePayment,"4ee3a8d8-ca7b-4290-a52c-dd5b61XXXXXX");
    }
}
