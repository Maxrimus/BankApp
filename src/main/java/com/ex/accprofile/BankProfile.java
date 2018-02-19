package com.ex.accprofile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BankProfile implements Serializable{

    private String username;
    private String fullname;
    private String fullname2;
    private String email;
    private String ssn;
    private String ssn2;
    private String employment;
    private String employment2;
    private List<BankAccount> accounts;

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    private int numberOfAccounts;
    private AllBankAccounts aBA = AllBankAccounts.getInstance();

    public String getUsername() { return username; }
    public String getFullname() { return fullname; }
    public String getFullname2() {
        if (fullname2 == null){ return "";}
        return fullname2;
    }
    public String getEmail() { return email; }
    public String getSsn() { return ssn; }
    public String getSsn2() {
        if (ssn2 == null){ return "";}
        return ssn2;
    }
    public String getEmployment() { return employment; }
    public String getEmployment2() {
        if (employment2 == null){
            return "";
        }
        return employment2;
    }

    public void setEmail(String email) { this.email = email; }

    public BankProfile(String username, String email, String fullname, String ssn, String employment){
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.ssn = ssn;
        this.employment = employment;
        this.fullname2 = null;
        this.ssn2 = null;
        this.employment2 = null;
        accounts = new ArrayList<>();
        numberOfAccounts = 0;
    }

    public BankProfile(String username, String email, String fullname, String ssn, String employment,
                       String fullname2, String ssn2, String employment2){
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.ssn = ssn;
        this.employment = employment;
        this.fullname2 = fullname2;
        this.ssn2 = ssn2;
        this.employment2 = employment2;
        accounts = new ArrayList<>();
        numberOfAccounts = 0;
    }

    public BankProfile(){}

//    public BankAccount addAccount(int startingBalance, String accountNumber, String username, int accountType){
//        BankAccount bankAccount = new BankAccount(username,accountNumber,startingBalance,accountType);
//        accounts.add(bankAccount);
//        return bankAccount;
//    }

    @Override
    public String toString() {
        String toReturn = "";
        toReturn += "Username: " + username + "\n";
        toReturn += "Full Name: " + fullname + "\n";
        toReturn += "Email: " + email + "\n";
        toReturn += "SSN: " + ssn + "\n";
        toReturn += "Employment: " + employment + "\n";
        toReturn += "Account Numbers: ";
        for(BankAccount ba:accounts) toReturn += ba.getNumOfAccounts() + " ";
        return toReturn;
    }
}
