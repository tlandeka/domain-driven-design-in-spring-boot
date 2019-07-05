package com.example.excercise.application.payment.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Fx {

    @Size(min = 1)
    @JsonProperty("contract_reference")
    private String contractReference;

    @Size(min = 1)
    @JsonProperty("exchange_rate")
    private String exchangeRate;

    @Size(min = 1)
    @JsonProperty("original_amount")
    private String originalAmount;

    @Size(min = 1)
    @JsonProperty("original_currency")
    private String originalCurrency;

    @JsonProperty("contract_reference")
    public String getContractReference() {
        return contractReference;
    }

    @JsonProperty("contract_reference")
    public void setContractReference(String contractReference) {
        this.contractReference = contractReference;
    }

    @JsonProperty("exchange_rate")
    public String getExchangeRate() {
        return exchangeRate;
    }

    public Double getExchangeRateAsDouble() {
        return Double.valueOf(exchangeRate);
    }

    @JsonProperty("exchange_rate")
    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @JsonProperty("original_amount")
    public String getOriginalAmount() {
        return originalAmount;
    }

    @JsonProperty("original_amount")
    public void setOriginalAmount(String originalAmount) {
        this.originalAmount = originalAmount;
    }

    @JsonProperty("original_currency")
    public String getOriginalCurrency() {
        return originalCurrency;
    }

    @JsonProperty("original_currency")
    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

}