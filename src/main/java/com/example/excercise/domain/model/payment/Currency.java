package com.example.excercise.domain.model.payment;

public class Currency {
    private String isoCode;

    Currency(String isoCode) {
        this.setIsoCode(isoCode);
    }

    private void setIsoCode(String isoCode) {
        if (!isoCode.matches("^[A-Z]{3}$")) {
            throw new IllegalArgumentException("Invalid currency ISO code!");
        }

        this.isoCode = isoCode;
    }

    public String getIsoCode() {
        return isoCode;
    }
}
