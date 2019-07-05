package com.example.excercise.testdatafactory.domain.model.payment;

import com.example.excercise.domain.model.payment.Account;
import com.example.excercise.domain.model.payment.Bank;

public class AccountBuilder {
    String number;

    String name;

    String numberCode;

    Integer type;

    String address;

    String fullName;

    Bank bankId;

    public AccountBuilder() {
        this.address = new String("New address in london");
        this.number = new String("31926819");
        this.name = new String("Tomo Test");
        this.numberCode = new String("BBAN");
        this.type = new Integer(0);
        this.fullName = new String("Tomislav Landeka");
        this.bankId = new Bank();
    }

    public static AccountBuilder aAccountBuilder(){
        return new AccountBuilder();
    }

    public AccountBuilder withNumber(String number){
        this.number = number;
        return this;
    }

    public AccountBuilder withBankId(Bank bankId){
        this.bankId = bankId;
        return this;
    }

    public Account build(){
        return new Account(this.number, this.name, this.numberCode, this.type, this.address, this.fullName, this.bankId);
    }
}
