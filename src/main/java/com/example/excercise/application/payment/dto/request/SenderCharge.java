package com.example.excercise.application.payment.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SenderCharge {

    @Size(min = 1)
    @JsonProperty("amount")
    private String amount;

    @Size(min = 1)
    @JsonProperty("currency")
    private String currency;

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    public Double getAmountAsDouble(){
        return Double.valueOf(this.amount);
    }

    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

}