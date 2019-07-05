package com.example.excercise.testdatafactory.domain.model.payment;

import com.example.excercise.domain.model.payment.Account;
import com.example.excercise.domain.model.payment.Payment;

import java.util.Date;

public class PaymentBuilder {
    private String Id;

    private String type;

    private Integer version;

    private String organisationId;

    private Double amount;

    private String currency;

    private String endToEndReference;

    private String numericReference;

    private String reference;

    private String paymentId;

    private String paymentPurpose;

    private String paymentScheme;

    private String paymentType;

    private Date processingDate;

    private String schemePaymentSubType;

    private String schemePaymentType;

    String fxContractReference;

    Double fxExchangeRate;

    String fxOriginalCurrency;

    Account beneficiaryAccountNumber;

    Account debtorAccountNumber;

    Account sponsorAccountNumber;

    String bearerCode;

    Double senderChargeAmount;

    Double receiverChargeAmount;

    public PaymentBuilder() {
        this.Id = new String("4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43");
        this.type = new String("Payment");
        this.version = new Integer(0);
        this.organisationId = new String("743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb");
        this.amount = new Double("10.00");
        this.currency = new String("GBP");
        this.endToEndReference = new String("End to End test");
        this.numericReference = new String("123123");
        this.reference = new String("Payment for testing");
        this.paymentId = new String("123456000");
        this.paymentPurpose = new String("Paying testing");
        this.paymentScheme = new String("FPS");
        this.paymentType = new String("Credit");
        this.processingDate = new Date();
        this.schemePaymentType = new String("ImmediatePayment");
        this.schemePaymentSubType = new String("InternetBanking");
        this.fxContractReference = new String("FX123");
        this.fxExchangeRate = new Double("2.000000");
        this.fxOriginalCurrency = new String("USD");
        this.beneficiaryAccountNumber = AccountBuilder.aAccountBuilder().withNumber(new String("31926819")).build();
        this.debtorAccountNumber = AccountBuilder.aAccountBuilder().withNumber(new String("56781234")).build();
        this.sponsorAccountNumber = AccountBuilder.aAccountBuilder().withNumber(new String("GB29XABC10161234567801")).build();
        this.bearerCode = "SHAR";
        this.senderChargeAmount = new Double("10.00");
        this.receiverChargeAmount = new Double("1.50");
    }

    public static PaymentBuilder aPaymentBuilder(){
        return new PaymentBuilder();
    }

    public PaymentBuilder withId(String id){
        this.Id = id;
        return this;
    }

    public PaymentBuilder withBeneficiaryAccountNumber(Account account){
        this.beneficiaryAccountNumber = account;
        return this;
    }

    public PaymentBuilder withDebtorAccountNumber(Account account){
        this.debtorAccountNumber = account;
        return this;
    }

    public PaymentBuilder withSponsorAccountNumber(Account account){
        this.sponsorAccountNumber = account;
        return this;
    }

    public Payment build(){
        return new Payment(Id,type, version, organisationId, amount, currency, endToEndReference, numericReference, reference, paymentId, paymentPurpose,
                paymentScheme,paymentType, processingDate, schemePaymentSubType,schemePaymentType, fxContractReference, fxExchangeRate, fxOriginalCurrency,
                beneficiaryAccountNumber, debtorAccountNumber, sponsorAccountNumber, bearerCode, senderChargeAmount, receiverChargeAmount);
    }
}
