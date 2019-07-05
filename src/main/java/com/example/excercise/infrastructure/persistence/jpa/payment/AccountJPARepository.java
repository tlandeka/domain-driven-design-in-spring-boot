package com.example.excercise.infrastructure.persistence.jpa.payment;

import com.example.excercise.domain.model.payment.Account;
import com.example.excercise.domain.model.payment.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountJPARepository implements AccountRepository {

    @Autowired
    AccountJPARepositoryInterface crudRepository;

    @Override
    public Account save(Account account){
        return crudRepository.save(account);
    }

    @Override
    public Account findByNumber(String number){
        return crudRepository.findByNumber(number);
    }

    @Override
    public void deleteAll(){
        crudRepository.deleteAll();
    }
}
