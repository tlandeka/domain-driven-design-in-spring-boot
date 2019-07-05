package com.example.excercise.application.payment.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdatePayment {

    @Size(min = 1)
    @JsonProperty("payment_type")
    private String paymentType;
    ;
    @Size(min = 1)
    @JsonProperty("currency")
    private String currency;

    @Size(min = 1)
    @JsonProperty("payment_scheme")
    private String paymentScheme;

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPaymentScheme() {
        return paymentScheme;
    }

    public void setPaymentScheme(String paymentScheme) {
        this.paymentScheme = paymentScheme;
    }
}
