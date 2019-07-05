package com.example.excercise.application.payment;

import com.example.excercise.application.payment.builder.PaymentBuilder;
import com.example.excercise.application.payment.dto.request.CreatePayment;
import com.example.excercise.domain.model.payment.Account;
import com.example.excercise.domain.model.payment.Payment;
import com.example.excercise.infrastructure.persistence.jpa.payment.AccountJPARepository;
import com.example.excercise.infrastructure.persistence.jpa.payment.PaymentJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CreatePaymentService {

    @Autowired
    private PaymentJPARepository paymentJPARepository;

    @Autowired
    private AccountJPARepository accountJPARepository;

    @Autowired
    private PaymentBuilder paymentBuilder;

    @Transactional
    public Payment execute(CreatePayment createPayment, String paymentId) {
        Account accountBeneficier = accountJPARepository.findByNumber(createPayment.getAttributes().getBeneficiaryParty().getAccountNumber());
        Account accountDebtor = accountJPARepository.findByNumber(createPayment.getAttributes().getDebtorParty().getAccountNumber());
        Account accountSponsor = accountJPARepository.findByNumber(createPayment.getAttributes().getSponsorParty().getAccountNumber());

        if (accountBeneficier == null || accountDebtor == null || accountSponsor == null) {
            throw new IllegalArgumentException("Some accounts are not registered!");
        }

        if (paymentJPARepository.findById(paymentId).isPresent()) {
            throw new IllegalArgumentException("Payment already exist!");
        }

        Payment payment = this.paymentBuilder
                .setAccountBeneficier(accountBeneficier)
                .setAccountDebtor(accountDebtor)
                .setAccountSponsor(accountSponsor)
                .setCreatePayment(createPayment)
                .setPaymentId(paymentId)
                .buildOnCreate()
                .getPayment();

        return this.paymentJPARepository.save(payment);
    }

}
