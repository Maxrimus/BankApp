package com.ex.accprofile;

import java.util.HashMap;

public class BankAccount {
    private String username;
    private int numberOfAccounts;

    // Key Integer values so far:
    // 1 - Checking account balance
    // 2 - Savings account balance
    // 3 - Joint account balance
    private HashMap<Integer, Double> accType_Balance = new HashMap<>();

    public BankAccount(){

    }

    public void enterAccountType (Integer accType, Double balance){
        accType_Balance.put(accType, balance);
    }

    public void changeBalance(Integer accType, Double balance){
        accType_Balance.put(accType, balance);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public void setNumberOfAccounts(int numberOfAccounts) {
        this.numberOfAccounts = numberOfAccounts;
    }

    public HashMap<Integer, Double> getAccType_Balance() {
        return accType_Balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "username='" + username + '\'' +
                ", numberOfAccounts=" + numberOfAccounts +
                '}';
    }
}
