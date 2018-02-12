package com.ex.makingaccount;

import com.ex.Main;
import com.ex.ValidFormat;

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

    public void register(){
        System.out.println("Enter Username:");
        String userInput = Main.getUserInput();
        userInput = ValidFormat.loopUntilValid(userInput, "ALPHANUM");
        userInput = ValidFormat.loopUntilValid(userInput, "SPACE");
        userInput = ValidFormat.loopUntilValid(userInput, "EXIST");
        username = userInput;

        System.out.println("Enter Password");
        userInput = ValidFormat.loopUntilValid(userInput, "SPACE");
        userInput = ValidFormat.loopUntilValid(userInput, "PASSWORD");
        password = userInput;

        System.out.println("Enter your email");
        userInput = ValidFormat.loopUntilValid(userInput, "SPACE");
        userInput = ValidFormat.loopUntilValid(userInput, "EMAIL");
        email = userInput;


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
