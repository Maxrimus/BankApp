package com.ex.accprofile;

public class BankProfile {

    private String username;
    private String fullname;
    private String fullname2;
    private String email;
    private String ssn;
    private String ssn2;
    private String employment;
    private String employment2;

    public BankProfile(){
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

    public String getSsn2() {
        return ssn2;
    }

    public void setSsn2(String ssn2) {
        this.ssn2 = ssn2;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public String getEmployment2() {
        return employment2;
    }

    public void setEmployment2(String employment2) {
        this.employment2 = employment2;
    }

    @Override
    public String toString() {
        return "BankProfile{" +
                "username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", fullname2='" + fullname2 + '\'' +
                ", email='" + email + '\'' +
                ", ssn='" + ssn + '\'' +
                ", ssn2='" + ssn2 + '\'' +
                ", employment='" + employment + '\'' +
                ", employment2='" + employment2 + '\'' +
                '}';
    }
}
