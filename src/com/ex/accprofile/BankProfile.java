package com.ex.accprofile;

public class BankProfile {

    private String username;
    private String email;
    private String ssn;
    private String birthdate;

    public BankProfile(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "BankProfile{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", ssn='" + ssn + '\'' +
                ", birthdate='" + birthdate + '\'' +
                '}';
    }
}
