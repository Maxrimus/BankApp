package com.ex.makingaccount;

public class AccountApplication {
    private String fullname;
    private String fullname2;
    private String address;
    private String ssn;
    private String birthdate;
    private String accountType;
    private String employment;

    public AccountApplication() {}

    public void apply() {}

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setFullname2(String fullname2) {
        this.fullname2 = fullname2;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    @Override
    public String toString() {
        return "AccountApplication{" +
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
