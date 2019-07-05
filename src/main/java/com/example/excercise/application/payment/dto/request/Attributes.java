package com.example.excercise.application.payment.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attributes {

    @JsonProperty("amount")
    private @Size(min = 1)
    String amount;

    @NotNull
    @JsonProperty("beneficiary_party")
    private BeneficiaryParty beneficiaryParty;

    @NotNull
    @JsonProperty("charges_information")
    private ChargesInformation chargesInformation;

    @Size(min = 1)
    @JsonProperty("currency")
    private String currency;

    @NotNull
    @JsonProperty("debtor_party")
    private DebtorParty debtorParty;

    @Size(min = 1)
    @JsonProperty("end_to_end_reference")
    private String endToEndReference;

    @NotNull
    @JsonProperty("fx")
    private Fx fx;

    @Size(min = 1)
    @JsonProperty("numeric_reference")
    private String numericReference;

    @Size(min = 1)
    @JsonProperty("payment_id")
    private String paymentId;

    @Size(min = 1)
    @JsonProperty("payment_purpose")
    private String paymentPurpose;

    @Size(min = 1)
    @JsonProperty("payment_scheme")
    private String paymentScheme;

    @Size(min = 1)
    @JsonProperty("payment_type")
    private String paymentType;

    @Size(min = 1)
    @JsonProperty("processing_date")
    private String processingDate;

    @Size(min = 1)
    @JsonProperty("reference")
    private String reference;

    @Size(min = 1)
    @JsonProperty("scheme_payment_sub_type")
    private String schemePaymentSubType;

    @Size(min = 1)
    @JsonProperty("scheme_payment_type")
    private String schemePaymentType;

    @NotNull
    @JsonProperty("sponsor_party")
    private SponsorParty sponsorParty;

    @JsonProperty("amount")
    public @Size(min = 1) String getAmount() {
        return amount;
    }

    public Double getAmountAsDouble(){
        return Double.valueOf(this.amount);
    }

    @JsonProperty("amount")
    public void setAmount(@Size(min = 1) String amount) {
        this.amount = amount;
    }

    @JsonProperty("beneficiary_party")
    public BeneficiaryParty getBeneficiaryParty() {
        return beneficiaryParty;
    }

    @JsonProperty("beneficiary_party")
    public void setBeneficiaryParty(BeneficiaryParty beneficiaryParty) {
        this.beneficiaryParty = beneficiaryParty;
    }

    @JsonProperty("charges_information")
    public ChargesInformation getChargesInformation() {
        return chargesInformation;
    }

    @JsonProperty("charges_information")
    public void setChargesInformation(ChargesInformation chargesInformation) {
        this.chargesInformation = chargesInformation;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("debtor_party")
    public DebtorParty getDebtorParty() {
        return debtorParty;
    }

    @JsonProperty("debtor_party")
    public void setDebtorParty(DebtorParty debtorParty) {
        this.debtorParty = debtorParty;
    }

    @JsonProperty("end_to_end_reference")
    public String getEndToEndReference() {
        return endToEndReference;
    }

    @JsonProperty("end_to_end_reference")
    public void setEndToEndReference(String endToEndReference) {
        this.endToEndReference = endToEndReference;
    }

    @JsonProperty("fx")
    public Fx getFx() {
        return fx;
    }

    @JsonProperty("fx")
    public void setFx(Fx fx) {
        this.fx = fx;
    }

    @JsonProperty("numeric_reference")
    public String getNumericReference() {
        return numericReference;
    }

    @JsonProperty("numeric_reference")
    public void setNumericReference(String numericReference) {
        this.numericReference = numericReference;
    }

    @JsonProperty("payment_id")
    public String getPaymentId() {
        return paymentId;
    }

    @JsonProperty("payment_id")
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    @JsonProperty("payment_purpose")
    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    @JsonProperty("payment_purpose")
    public void setPaymentPurpose(String paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
    }

    @JsonProperty("payment_scheme")
    public String getPaymentScheme() {
        return paymentScheme;
    }

    @JsonProperty("payment_scheme")
    public void setPaymentScheme(String paymentScheme) {
        this.paymentScheme = paymentScheme;
    }

    @JsonProperty("payment_type")
    public String getPaymentType() {
        return paymentType;
    }

    @JsonProperty("payment_type")
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @JsonProperty("processing_date")
    public String getProcessingDate() {
        return processingDate;
    }

    public Date getProcesingDateAsDate(){
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy");
        try {
            return  format.parse(this.processingDate);
        } catch (ParseException e) {
            return new Date();
        }
    }

    @JsonProperty("processing_date")
    public void setProcessingDate(String processingDate) {
        this.processingDate = processingDate;
    }

    @JsonProperty("reference")
    public String getReference() {
        return reference;
    }

    @JsonProperty("reference")
    public void setReference(String reference) {
        this.reference = reference;
    }

    @JsonProperty("scheme_payment_sub_type")
    public String getSchemePaymentSubType() {
        return schemePaymentSubType;
    }

    @JsonProperty("scheme_payment_sub_type")
    public void setSchemePaymentSubType(String schemePaymentSubType) {
        this.schemePaymentSubType = schemePaymentSubType;
    }

    @JsonProperty("scheme_payment_type")
    public String getSchemePaymentType() {
        return schemePaymentType;
    }

    @JsonProperty("scheme_payment_type")
    public void setSchemePaymentType(String schemePaymentType) {
        this.schemePaymentType = schemePaymentType;
    }

    @JsonProperty("sponsor_party")
    public SponsorParty getSponsorParty() {
        return sponsorParty;
    }

    @JsonProperty("sponsor_party")
    public void setSponsorParty(SponsorParty sponsorParty) {
        this.sponsorParty = sponsorParty;
    }

}