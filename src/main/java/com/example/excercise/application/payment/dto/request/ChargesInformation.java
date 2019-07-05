package com.example.excercise.application.payment.dto.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChargesInformation {

    @Size(min = 1)
    @JsonProperty("bearer_code")
    private String bearerCode;

    @JsonProperty("sender_charges")
    private List<SenderCharge> senderCharges = null;

    @Size(min = 1)
    @JsonProperty("receiver_charges_amount")
    private String receiverChargesAmount;

    @Size(min = 1)
    @JsonProperty("receiver_charges_currency")
    private String receiverChargesCurrency;

    @JsonProperty("bearer_code")
    public String getBearerCode() {
        return bearerCode;
    }

    @JsonProperty("bearer_code")
    public void setBearerCode(String bearerCode) {
        this.bearerCode = bearerCode;
    }

    @JsonProperty("sender_charges")
    public List<SenderCharge> getSenderCharges() {
        return senderCharges;
    }

    public SenderCharge getSenderCharge(String senderCurrency) {
        for (SenderCharge senderCharge : this.senderCharges) {
            if(senderCharge.getCurrency().equals(senderCurrency)){
                return senderCharge;
            }
        }

        return null;
    }

    @JsonProperty("sender_charges")
    public void setSenderCharges(List<SenderCharge> senderCharges) {
        this.senderCharges = senderCharges;
    }

    @JsonProperty("receiver_charges_amount")
    public String getReceiverChargesAmount() {
        return receiverChargesAmount;
    }

    public Double getReceiverChargesAmountAsDouble() {
        return Double.valueOf(receiverChargesAmount);
    }

    @JsonProperty("receiver_charges_amount")
    public void setReceiverChargesAmount(String receiverChargesAmount) {
        this.receiverChargesAmount = receiverChargesAmount;
    }

    @JsonProperty("receiver_charges_currency")
    public String getReceiverChargesCurrency() {
        return receiverChargesCurrency;
    }

    @JsonProperty("receiver_charges_currency")
    public void setReceiverChargesCurrency(String receiverChargesCurrency) {
        this.receiverChargesCurrency = receiverChargesCurrency;
    }

}