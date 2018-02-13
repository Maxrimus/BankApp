package com.ex.accprofile;

import java.io.Serializable;
import java.util.ArrayList;

public class AllBankAccounts implements Serializable {

    private static final long serialVersionUID = 1L;

    private static ArrayList<BankAccount> bankaccs = new ArrayList<>();

    public AllBankAccounts() {

    }

    public BankAccount extractAccount(String username){

        for (int i = 0; i < bankaccs.size(); i++){
            if (bankaccs.get(i).getUsername().equals(username)){

                return bankaccs.get(i);
            }
        }
        return new BankAccount("NO ACCOUNT FOUND IN FILE");
    }

    public void insertAccount(BankAccount bankAccount){
        bankaccs.add(bankAccount);
    }
}
