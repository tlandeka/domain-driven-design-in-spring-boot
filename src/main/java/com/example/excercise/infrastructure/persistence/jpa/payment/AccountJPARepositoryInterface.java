package com.example.excercise.infrastructure.persistence.jpa.payment;

import com.example.excercise.domain.model.payment.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJPARepositoryInterface extends CrudRepository<Account, String> {
    @Override
    Account save(Account account);

    Account findByNumber(String number);

    @Override
    void deleteAll();
}
