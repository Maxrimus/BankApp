package com.ex.makingaccount;

import com.ex.Main;
import com.ex.User;
import com.ex.ValidFormat;
import com.ex.accprofile.AllBankAccounts;
import com.ex.accprofile.BankAccount;

import static com.ex.Main.accounts;

public class Register {
    private String username;
    private String password;
    private String email;

    //private String securityQ1;
    //private String securityQ2;
    //private String securityQ3;
    //private String securityA1;
    //private String securityA2;
    //private String securityA3;

    public Register() {}

    public boolean register(){

        System.out.println("Enter Username:");
        String userInput = Main.getUserInput();
        userInput = ValidFormat.loopUntilValid(userInput, "ALPHANUM");
        userInput = ValidFormat.loopUntilValid(userInput, "SPACE");
        userInput = ValidFormat.loopUntilValid(userInput, "EXIST");
        username = userInput;

        //Checking if customer has an (username, password) entry in AllAccounts
        if (!accounts.getCustomerPass().containsKey(username)){
            System.out.println("There is no account with that username");
            System.out.println("Please make sure you sent in a bank application before trying to register");
            System.out.println("If you already applied, your application may not have been approved yet or has been denied");
            System.out.println("Please call customer service to find out your application status\n");
            System.out.println("Exiting...");
            return false;
        }

        System.out.println("Enter Password");
        userInput = ValidFormat.loopUntilValid(userInput, "SPACE");
        userInput = ValidFormat.loopUntilValid(userInput, "PASSWORD");
        password = userInput;

        System.out.println("Enter your email");
        userInput = ValidFormat.loopUntilValid(userInput, "SPACE");
        userInput = ValidFormat.loopUntilValid(userInput, "EMAIL");
        email = userInput;

        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    //    public void setSecurityQ1(String securityQ1) {
//        this.securityQ1 = securityQ1;
//    }
//
//    public void setSecurityQ2(String securityQ2) {
//        this.securityQ2 = securityQ2;
//    }
//
//    public void setSecurityQ3(String securityQ3) {
//        this.securityQ3 = securityQ3;
//    }
//
//    public void setSecurityA1(String securityA1) {
//        this.securityA1 = securityA1;
//    }
//
//    public void setSecurityA2(String securityA2) {
//        this.securityA2 = securityA2;
//    }
//
//    public void setSecurityA3(String securityA3) {
//        this.securityA3 = securityA3;
//    }

    @Override
    public String toString() {
        return "Register{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
//                ", securityQ1='" + securityQ1 + '\'' +
//                ", securityQ2='" + securityQ2 + '\'' +
//                ", securityQ3='" + securityQ3 + '\'' +
//                ", securityA1='" + securityA1 + '\'' +
//                ", securityA2='" + securityA2 + '\'' +
//                ", securityA3='" + securityA3 + '\'' +
                '}';
    }
}
