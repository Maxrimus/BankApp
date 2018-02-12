package com.ex.accprofile;

import java.io.Serializable;

public class BankProfile implements Serializable{

    private static final long serialVersionUID = 1L;

    private String username;
    private String fullname;
    private String fullname2;
    private String emai;
    private String ssn;
    private String birthdate;
    private String securityQ1;
    private String securityQ2;
    private String securityQ3;
    private String securityAns1;
    private String securityAns2;
    private String securityAns3;

    public BankProfile(String username){
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

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
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

    public String getSecurityQ1() {
        return securityQ1;
    }

    public void setSecurityQ1(String securityQ1) {
        this.securityQ1 = securityQ1;
    }

    public String getSecurityQ2() {
        return securityQ2;
    }

    public void setSecurityQ2(String securityQ2) {
        this.securityQ2 = securityQ2;
    }

    public String getSecurityQ3() {
        return securityQ3;
    }

    public void setSecurityQ3(String securityQ3) {
        this.securityQ3 = securityQ3;
    }

    public String getSecurityAns1() {
        return securityAns1;
    }

    public void setSecurityAns1(String securityAns1) {
        this.securityAns1 = securityAns1;
    }

    public String getSecurityAns2() {
        return securityAns2;
    }

    public void setSecurityAns2(String securityAns2) {
        this.securityAns2 = securityAns2;
    }

    public String getSecurityAns3() {
        return securityAns3;
    }

    public void setSecurityAns3(String securityAns3) {
        this.securityAns3 = securityAns3;
    }

    @Override
    public String toString() {
        return "BankProfile{" +
                "fullname='" + fullname + '\'' +
                ", fullname2='" + fullname2 + '\'' +
                ", emai='" + emai + '\'' +
                ", ssn='" + ssn + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", securityQ1='" + securityQ1 + '\'' +
                ", securityQ2='" + securityQ2 + '\'' +
                ", securityQ3='" + securityQ3 + '\'' +
                ", securityAns1='" + securityAns1 + '\'' +
                ", securityAns2='" + securityAns2 + '\'' +
                ", securityAns3='" + securityAns3 + '\'' +
                '}';
    }
}
