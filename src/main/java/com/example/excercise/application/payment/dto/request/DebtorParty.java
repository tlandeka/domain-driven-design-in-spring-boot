package com.example.excercise.application.payment.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DebtorParty {

    @Size(min = 1)
    @JsonProperty("account_name")
    private String accountName;

    @Size(min = 1)
    @JsonProperty("account_number")
    private String accountNumber;

    @Size(min = 1)
    @JsonProperty("account_number_code")
    private String accountNumberCode;

    @Size(min = 1)
    @JsonProperty("address")
    private String address;

    @Size(min = 1)
    @JsonProperty("bank_id")
    private String bankId;

    @Size(min = 1)
    @JsonProperty("bank_id_code")
    private String bankIdCode;

    @Size(min = 1)
    @JsonProperty("name")
    private String name;

    @JsonProperty("account_name")
    public String getAccountName() {
        return accountName;
    }

    @JsonProperty("account_name")
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @JsonProperty("account_number")
    public String getAccountNumber() {
        return accountNumber;
    }

    @JsonProperty("account_number")
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @JsonProperty("account_number_code")
    public String getAccountNumberCode() {
        return accountNumberCode;
    }

    @JsonProperty("account_number_code")
    public void setAccountNumberCode(String accountNumberCode) {
        this.accountNumberCode = accountNumberCode;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("bank_id")
    public String getBankId() {
        return bankId;
    }

    @JsonProperty("bank_id")
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    @JsonProperty("bank_id_code")
    public String getBankIdCode() {
        return bankIdCode;
    }

    @JsonProperty("bank_id_code")
    public void setBankIdCode(String bankIdCode) {
        this.bankIdCode = bankIdCode;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

}