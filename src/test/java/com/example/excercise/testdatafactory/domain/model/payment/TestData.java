package com.example.excercise.testdatafactory.domain.model.payment;

import com.example.excercise.domain.model.payment.Account;
import com.example.excercise.domain.model.payment.Bank;

import java.util.ArrayList;

public class TestData {
    public static ArrayList<Bank> getBanks(){
        ArrayList<Bank> banks = new ArrayList<>();
        banks.add(new Bank(new Integer(123123), new String("GBDSC"), new String("Mostar Bank")));
        banks.add(new Bank(new Integer(203301), new String("GBDSC"), new String("Zagreb Bank")));
        banks.add(new Bank(new Integer(403000), new String("GBDSC"), new String("London Bank")));

        return banks;
    }

    public static ArrayList<Account> getAccounts(){
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(AccountBuilder.aAccountBuilder().withNumber(new String("31926819")).
                withBankId(new Bank(new Integer(403000), new String("GBDSC"), new String("London Bank"))).build());

        accounts.add(AccountBuilder.aAccountBuilder().withNumber(new String("56781234")).
                withBankId(new Bank(new Integer(123123), new String("GBDSC"), new String("Mostar Bank"))).build());

        accounts.add(AccountBuilder.aAccountBuilder().withNumber(new String("GB29XABC10161234567801")).
                withBankId(new Bank(new Integer(403000), new String("GBDSC"), new String("London Bank"))).build());

        return accounts;
    }

}
