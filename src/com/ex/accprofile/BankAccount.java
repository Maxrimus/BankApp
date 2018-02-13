package com.ex.accprofile;

import java.util.*;

public class BankAccount {
    private String username;
    private String accountNumber;
    private AccountTypes accountType;
    private Double balance;
    Random rand;

    public String getUsername() {
        return username;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public AccountTypes getAccountType() {
        return accountType;
    }

    public Double getBalance() {
        return balance;
    }

    // Key Integer values so far:
    // 1 - Checking account balance
    // 2 - Savings account balance
    // 3 - Joint account balance
    public enum AccountTypes{
        CHECKING(1),
        SAVINGS(2),
        JOINT(3);

        private int value;

        public int getValue() {
            return value;
        }

        private AccountTypes(int value){
            this.value = value;
        }
    }

    public BankAccount(){}

    public BankAccount(String username, String accountNumber, double startingBalance){
        this.username = username;
        this.accountNumber = accountNumber;
        this.balance = startingBalance;
        rand = new Random();
    }

    @Override
    public String toString() {
        return accountNumber + " " + accountType.name() + " Balance: " + balance;
    }
}
