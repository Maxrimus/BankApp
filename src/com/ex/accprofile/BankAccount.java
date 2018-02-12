package com.ex.accprofile;

import java.io.Serializable;

public class BankAccount implements Serializable{

    private static final long serialVersionUID = 1L;

    private String username;
    private String fullname;
    private String fullname2;
    private String address;
    private String ssn;
    private String birthdate;
    private String accountType;
    private String employment;

    public BankAccount(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname2() {
        return fullname2;
    }

    public void setFullname2(String fullname2) {
        this.fullname2 = fullname2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "fullname='" + fullname + '\'' +
                ", fullname2='" + fullname2 + '\'' +
                ", address='" + address + '\'' +
                ", ssn='" + ssn + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", accountType='" + accountType + '\'' +
                ", employment='" + employment + '\'' +
                '}';
    }
}
