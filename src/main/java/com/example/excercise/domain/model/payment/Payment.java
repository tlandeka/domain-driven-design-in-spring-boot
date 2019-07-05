package com.example.excercise.domain.model.payment;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Entity
public class Payment {

    @Id
    private String Id;

    @Column
    private String type;

    @Column
    private Integer version;

    @Column
    private String organisationId;

    @Column
    private Double amount;

    @Column
    private String currency;

    @Column
    private String endToEndReference;

    @Column
    private String numericReference;

    @Column
    private String reference;

    @Column
    private String paymentId;

    @Column
    private String paymentPurpose;

    @Column
    private String paymentScheme;

    @Column
    private String paymentType;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date processingDate;

    @Column
    private String schemePaymentSubType;

    @Column
    private String schemePaymentType;

    @Column
    String fxContractReference;

    @Column
    Double fxExchangeRate;

    @Column
    String fxOriginalCurrency;

    @ManyToOne(targetEntity = Account.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "beneficiary_account_number")
    Account beneficiaryAccountNumber;

    @ManyToOne(targetEntity = Account.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "debtor_account_number")
    Account debtorAccountNumber;

    @ManyToOne(targetEntity = Account.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "sponsor_account_number")
    Account sponsorAccountNumber;

    @Column
    String bearerCode;

    @Column
    Double senderChargeAmount;

    @Column
    Double receiverChargeAmount;

    public Payment() {
    }

    public Payment(String id, String type, Integer version, String organisationId, Double amount, String currency,
                   String endToEndReference, String numericReference, String reference, String paymentId, String paymentPurpose, String paymentScheme,
                   String paymentType, Date processingDate, String schemePaymentSubType, String schemePaymentType, String fxContractReference,
                   Double fxExchangeRate, String fxOriginalCurrency, Account beneficiaryAccountNumber,
                   Account debtorAccountNumber, Account sponsorAccountNumber, String bearerCode, Double senderChargeAmount, Double receiverChargeAmount) {
        this.setId(id);
        this.setType(type);
        this.version = version;
        this.setOrganisationId(organisationId);
        this.amount = amount;
        this.setCurrency(currency);
        this.endToEndReference = endToEndReference;
        this.numericReference = numericReference;
        this.reference = reference;
        this.paymentId = paymentId;
        this.paymentPurpose = paymentPurpose;
        this.setPaymentScheme(paymentScheme);
        this.paymentType = paymentType;
        this.processingDate = processingDate;
        this.schemePaymentSubType = schemePaymentSubType;
        this.schemePaymentType = schemePaymentType;
        this.fxContractReference = fxContractReference;
        this.fxExchangeRate = fxExchangeRate;
        this.fxOriginalCurrency = fxOriginalCurrency;
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
        this.debtorAccountNumber = debtorAccountNumber;
        this.sponsorAccountNumber = sponsorAccountNumber;
        this.bearerCode = bearerCode;
        this.senderChargeAmount = senderChargeAmount;
        this.receiverChargeAmount = receiverChargeAmount;
    }


    private void setId(String id) {
        UUID.fromString(id);
        Id = id;
    }

    private void setOrganisationId(String organisationId){
        UUID.fromString(organisationId);
        this.organisationId = organisationId;
    }

    private void setPaymentScheme(String paymentScheme){
        if(!paymentScheme.equals("FPS") && !paymentScheme.equals("SWIFT")){
            throw new IllegalArgumentException("Unsupported payment scheme");
        }

        this.paymentScheme = paymentScheme;
    }

    private void setType(String type){
        if(!type.equals("Payment") && !type.equals("TestPayment")){
            throw new IllegalArgumentException("Unsupported type " + type);
        }

        this.type = type;
    }

    /**
     * Value Object example
     * @param currencyIso
     */
    private void setCurrency(String currencyIso){
        Currency currency = new Currency(currencyIso);
        this.currency = currency.getIsoCode();
    }

    public void updateCurrency(String currency){
        this.setCurrency(currency);
    }

    public void updateType(String type){
        this.setType(type);
    }

    public void updatePaymentScheme(String paymentScheme){
        this.setPaymentScheme(paymentScheme);
    }

    public String getId(){
        return this.Id;
    }

}
