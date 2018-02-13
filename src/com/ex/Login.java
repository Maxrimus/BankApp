package com.ex;


import com.ex.accprofile.AllBankAccounts;
import com.ex.accprofile.AllBankProfiles;
import com.ex.accprofile.BankAccount;
import com.ex.bankpowers.AdminCancellingPower;
import com.ex.bankpowers.JudgeApplications;

import static com.ex.Main.accounts;
import static com.ex.Main.start;

public class Login {
    User user;

    public Login(User user){    //First instance of login attempt

        //MOVE THIS TO LOGIN METHOD!
        this.user = user;
        login();
    }

    public boolean login() {
        System.out.println("Enter username");
        String username = Main.getUserInput();
        username = ValidFormat.loopUntilValid(username, "ALPHANUM");
        username = ValidFormat.loopUntilValid(username,"SPACE");
        System.out.println("Enter password");
        String password = Main.getUserInput();
        password = ValidFormat.loopUntilValid(password,"SPACE");

        boolean exist = accounts.doesUserExist(user, username);
        boolean validlogin = accounts.doesPassMatch(user, username, password);
        int loginattempts = 0;

        //If username or password is invalid, keep looping and ask to try again
        while (!exist || !validlogin){
            loginattempts++;

            if (loginattempts == 5) {
                System.out.println("Invalid Username or Password");
                System.out.println("You've exceeded login attempts");
                System.out.println("Please try again later\n\n\n");
                //Start new instance of program and end old instance
                start();
                return false;
            }

            System.out.println("Invalid Username or Password.");
            System.out.println("Please try again");
            System.out.println("Enter username");
            username = Main.getUserInput();
            username = ValidFormat.loopUntilValid(username, "ALPHANUM");
            username = ValidFormat.loopUntilValid(username,"SPACE");
            System.out.println("Enter password");
            password = Main.getUserInput();
            password = ValidFormat.loopUntilValid(password, "SPACE");
            exist = accounts.doesUserExist(user, username);
            validlogin = accounts.doesPassMatch(user, username, password);

        }

        printUserMenu(user);
        String userInput = Main.getUserInput();

        //Implement next actions
        if (user == User.Customer) {
            userInput = ValidFormat.loopUntilValid(userInput, "VALUE", 1, 5);
            CustomerActions(userInput, username);
        } else if (user == User.Employee) {
            userInput = ValidFormat.loopUntilValid(userInput, "VALUE", 1, 4);
            EmployeeActions(userInput,username);
        } else if (user == User.Admin) {
            userInput = ValidFormat.loopUntilValid(userInput, "VALUE", 1, 5);
            AdminActions(userInput,username);
        }

        return true;
    }

    public void CustomerActions(String userInput, String username){
        switch(userInput){
            case "1":
                BankAccount bankAccount = AllBankProfiles.getInstance().extractProfile(username).getAccounts().get(0);
                System.out.println("$" + bankAccount.getBalance());
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                System.out.println();
                break;
        }
    }

    public void EmployeeActions(String userInput, String username){
        switch(userInput){
            case "1":
                break;
            case "2":
                break;
            case "3":
                JudgeApplications j = new JudgeApplications();
                j.judge();
                break;
            case "4":
                break;
        }
    }

    public void AdminActions(String userInput, String username){
        switch(userInput){
            case "1":
                break;
            case "2":
                break;
            case "3":
                JudgeApplications j = new JudgeApplications();
                j.judge();
                break;
            case "4":
                AdminCancellingPower.Cancel();
                break;
            case "5":
                break;
        }
    }

    public void printUserMenu(User user) {
        System.out.println("Success!\nWelcome back!\n");
        if (user == User.Customer) {
            System.out.println("||Customer Client||\n");
            System.out.println("|What would you like to do?|");
            System.out.println("\t1- View Account Balance");
            System.out.println("\t2- Withdraw");
            System.out.println("\t3- Deposit");
            System.out.println("\t4- Transfer Funds");
            System.out.println("\t5- Exit");
        } else if (user == User.Employee) {
            System.out.println("||Employee Portal||\n");
            System.out.println("|Specify your next action|");
            System.out.println("\t1- Pull up a customer's bank account");
            System.out.println("\t2- Pull up a customer's bank profile");
            System.out.println("\t3- Judge open account applications");
            System.out.println("\t4- Exit");
        } else if (user == User.Admin) {
            System.out.println("||Admin Portal||\n");
            System.out.println("|Specify your next action|");
            System.out.println("\t1- Pull up a customer's bank account");
            System.out.println("\t2- Pull up a customer's bank profile");
            System.out.println("\t3- Judge open account applications");
            System.out.println("\t4- Cancel a customer's account");
            System.out.println("\t5- Exit");
        }
    }

}
