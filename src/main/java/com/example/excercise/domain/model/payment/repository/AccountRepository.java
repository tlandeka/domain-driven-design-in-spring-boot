package com.example.excercise.domain.model.payment.repository;

import com.example.excercise.domain.model.payment.Account;

public interface AccountRepository {
    public Account save(Account account);
    public Account findByNumber(String number);
    public void deleteAll();
}
