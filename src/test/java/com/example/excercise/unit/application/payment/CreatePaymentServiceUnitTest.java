package com.example.excercise.unit.application.payment;

import com.example.excercise.application.payment.CreatePaymentService;
import com.example.excercise.application.payment.builder.PaymentBuilder;
import com.example.excercise.application.payment.dto.request.CreatePayment;
import com.example.excercise.domain.model.payment.Account;
import com.example.excercise.domain.model.payment.Payment;
import com.example.excercise.infrastructure.persistence.jpa.payment.AccountJPARepository;
import com.example.excercise.infrastructure.persistence.jpa.payment.PaymentJPARepository;
import com.example.excercise.testdatafactory.application.payment.dto.TestData;
import com.example.excercise.testdatafactory.domain.model.payment.AccountBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
@Transactional
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class CreatePaymentServiceUnitTest {
    @Mock
    private PaymentJPARepository paymentJPARepository;

    @Mock
    private AccountJPARepository accountJPARepository;

    @Mock
    private PaymentBuilder paymentBuilder;

    @InjectMocks
    private CreatePaymentService createPaymentService;

    private List<CreatePayment> createPayments;

    @Before
    public void setup() throws IOException {
        MockitoAnnotations.initMocks(this);
        this.createPayments = TestData.getCreatePaymentDto();
    }

    @Test
    public void testCreate() {

        //Create Accoutns
        Account mockAccount = AccountBuilder.aAccountBuilder().build();

        //Create Payment
        Payment mockPayment = com.example.excercise.testdatafactory.domain.model.payment.PaymentBuilder.aPaymentBuilder().build();

        when(accountJPARepository.findByNumber(any(String.class))).thenReturn(mockAccount);
        when(paymentJPARepository.findById(any(String.class))).thenReturn(Optional.empty());
        when(paymentJPARepository.save(any(Payment.class))).thenReturn(mockPayment);

        when(paymentBuilder.setAccountBeneficier(any())).thenReturn(paymentBuilder);
        when(paymentBuilder.setAccountDebtor(any())).thenReturn(paymentBuilder);
        when(paymentBuilder.setAccountSponsor(any())).thenReturn(paymentBuilder);
        when(paymentBuilder.setCreatePayment(any())).thenReturn(paymentBuilder);
        when(paymentBuilder.setPaymentId(any())).thenReturn(paymentBuilder);
        when(paymentBuilder.buildOnCreate()).thenReturn(paymentBuilder);
        when(paymentBuilder.getPayment()).thenReturn(mockPayment);

        Payment payment = createPaymentService.execute(createPayments.get(0), createPayments.get(0).getId());

        // Verify the save
        assertEquals(mockPayment.getId(), payment.getId());
    }
}
