package com.example.excercise.domain.model.payment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {

    @Id
    String number;

    @Column
    String name;

    @Column
    String numberCode;

    @Column(nullable = true)
    Integer type;

    @Column
    String address;

    @Column
    String fullName;

    @ManyToOne
    Bank bankId;

    public Account() {
    }

    public Account(String number, String name, String numberCode, Integer type, String address, String fullName, Bank bankId) {
        this.number = number;
        this.name = name;
        this.numberCode = numberCode;
        this.type = type;
        this.address = address;
        this.fullName = fullName;
        this.bankId = bankId;
    }

}
