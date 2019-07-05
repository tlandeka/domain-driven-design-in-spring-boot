package com.example.excercise.domain.model.payment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bank {

    @Id
    private int id;

    @Column(length = 10)
    private String code;

    @Column(length = 25)
    private String name;

    public Bank(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Bank() {
    }
}
