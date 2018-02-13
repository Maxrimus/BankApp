package com.ex.makingaccount;

import com.ex.Main;
import com.ex.User;
import com.ex.ValidFormat;
import com.ex.accprofile.BankAccount;

import static com.ex.Main.accounts;

public class AccountApplication {
    private String username;
    private String email;
    private String fullname;
    private String fullname2;
    private String ssn;
    private String ssn2;
    private Integer accountType;
    private String employment;
    private String employment2;

    public AccountApplication() {
    }

    public void apply() {
        System.out.println("Enter Username:");
        String userInput = Main.getUserInput();
        userInput = ValidFormat.loopUntilValid(userInput, "ALPHANUM");
        userInput = ValidFormat.loopUntilValid(userInput, "SPACE");
        userInput = ValidFormat.loopUntilValid(userInput, "EXIST");
        username = userInput;
        accounts.newUsername(User.Customer,username);

        System.out.println("Enter Email:");
        userInput = Main.getUserInput();
        userInput = ValidFormat.loopUntilValid(userInput,"EMAIL");
        email = userInput;

        System.out.println("Enter your full name:");
        userInput = Main.getUserInput();
        userInput = ValidFormat.loopUntilValid(userInput, "NAME");
        fullname = userInput;

        System.out.println("Enter the account type you're applying for");
        System.out.println("\t1- Checking");
        System.out.println("\t2- Savings");
        System.out.println("\t3- Joint");
        userInput = Main.getUserInput();
        userInput = ValidFormat.loopUntilValid(userInput, "VALUE", 1,3);

        switch (userInput) {
            case "1":
                accountType = BankAccount.AccountTypes.CHECKING.getValue();
                System.out.println("Enter your SSN in the format of ***-**-****");
                userInput = Main.getUserInput();
                userInput = ValidFormat.loopUntilValid(userInput, "SSN");
                ssn = userInput;

                System.out.println("What is your current job title?");
                userInput = Main.getUserInput();
                userInput = ValidFormat.loopUntilValid(userInput, "LETTERS");
                employment = userInput;
                break;
            case "2":
                accountType = BankAccount.AccountTypes.SAVINGS.getValue();
                System.out.println("Enter your SSN in the format of ***-**-****");
                userInput = Main.getUserInput();
                userInput = ValidFormat.loopUntilValid(userInput, "SSN");
                ssn = userInput;

                System.out.println("What is your current job title?");
                userInput = Main.getUserInput();
                userInput = ValidFormat.loopUntilValid(userInput, "LETTERS");
                employment = userInput;
                break;
            case "3":
                accountType = BankAccount.AccountTypes.JOINT.getValue();
                System.out.println("Enter your spouse's full name:");
                userInput = Main.getUserInput();
                userInput = ValidFormat.loopUntilValid(userInput, "NAME");
                fullname2 = userInput;

                System.out.println("Enter your SSN in the format of ***-**-****");
                userInput = Main.getUserInput();
                userInput = ValidFormat.loopUntilValid(userInput, "SSN");
                ssn = userInput;

                System.out.println("Enter your spouse's SSN");
                userInput = Main.getUserInput();
                userInput = ValidFormat.loopUntilValid(userInput, "SSN");
                ssn2 = userInput;

                System.out.println("What is your spouse's current job title?");
                userInput = Main.getUserInput();
                userInput = ValidFormat.loopUntilValid(userInput, "LETTERS");
                employment2 = userInput;
                break;
        }

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() { return email; }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setFullname2(String fullname2) {
        this.fullname2 = fullname2;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setSsn2(String ssn2) {
        this.ssn2 = ssn2;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getFullname2() {
        return fullname2;
    }

    public String getSsn() {
        return ssn;
    }

    public String getSsn2() {
        return ssn2;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public String getEmployment() {
        return employment;
    }

    public String getEmployment2() {
        return employment2;
    }

    @Override
    public String toString() {
        return "AccountApplication{" +
                "username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", fullname2='" + fullname2 + '\'' +
                ", ssn='" + ssn + '\'' +
                ", ssn2='" + ssn2 + '\'' +
                ", accountType='" + accountType + '\'' +
                ", employment='" + employment + '\'' +
                ", employment2='" + employment2 + '\'' +
                '}';
    }
}
