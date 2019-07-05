package com.example.excercise.integration.application.payment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.example.excercise.testdatafactory.application.payment.dto.TestData;
import com.example.excercise.application.payment.CreatePaymentService;
import com.example.excercise.application.payment.dto.request.CreatePayment;
import com.example.excercise.domain.model.payment.Payment;
import com.example.excercise.infrastructure.persistence.jpa.payment.PaymentJPARepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class CreatePaymentServiceIntegrationTest {
    @Autowired
    private CreatePaymentService createPaymentService;

    @Autowired
    private PaymentJPARepository paymentJPARepository;

    private List<CreatePayment> createPayments;

    @Before
    public void setUp() throws IOException {
        this.createPayments = TestData.getCreatePaymentDto();
    }

    @Test
    public void testCreatePayment() {
        // Test adding the payment
        Payment payment = createPaymentService.execute(createPayments.get(0), createPayments.get(0).getId());

        // Verify the addition
        assertNotNull(payment);
        assertNotNull(payment.getId());
        assertEquals("4ee3a8d8-ca7b-4290-a52c-dd5b6165ec44", payment.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExistingCreatePayment() {
        createPaymentService.execute(createPayments.get(0), createPayments.get(0).getId());
        createPaymentService.execute(createPayments.get(0), createPayments.get(0).getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMissingAccountCreatePayment() {
        createPaymentService.execute(createPayments.get(1), createPayments.get(1).getId());
    }
}
