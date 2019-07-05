package com.example.excercise.domain.model.payment.repository;

import com.example.excercise.domain.model.payment.Bank;

public interface BankRepository {
    public Bank save(Bank bank);

    public void deleteAll();
}
