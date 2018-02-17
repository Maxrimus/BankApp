package com.ex.bankpowers;

import com.ex.Main;
import com.ex.User;
import com.ex.ValidFormat;
import com.ex.accprofile.BankAccount;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AccountActions {

    //There is a method in AllBankAccount to find a specific bank account of a user
    //called extractAccount(String username)
    //There is a method in BankAccount to enter a new entry of accountType and balance called
    //enterAccountType(Integer accType, Double balance)

    //There is a similar method in AllBankProfile to find a specific bank profile called
    //extractProfile(String username)
    //All setters and getters necessary to change data should be in BankProfile

    public static void viewAccountBalance(String username){
        BankAccount ba = Main.allBankAccounts.extractAccount(username);
        ArrayList<BankAccount.AccountTypes> acc= ba.getAccountTypeList();

        System.out.println("Your Accounts");
        for (int i = 0; i < acc.size(); i++){
            System.out.println("\t"+i+1+"-"+acc.get(i));
        }

        String userInput = Main.getUserInput();
        userInput = ValidFormat.loopUntilValid(userInput,"VALUE", 1,acc.size());

        for(int i = 1; i <= acc.size(); i++){
            if(userInput.equals(Integer.toString(i))){
                Double balance = ba.getAccountBalance(acc.get(i-1));
                System.out.println("Your account balance");
                NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
                System.out.println(formatter.format(balance));
            }
        }
        System.out.println("Do you want to do anything else?");
        System.out.println("\t1- Yes");
        System.out.println("\t2- No");
        userInput = Main.getUserInput();
        userInput = ValidFormat.loopUntilValid(userInput, "VALUE", 1, 2);

        if (userInput.equals("1")) {
            nextActions(User.Customer, username);
        }
        else if (userInput.equals("2")){
            System.out.println("Exiting...");
        }
    }




    public static void nextActions(User user, String username){
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
    }

    private static void CustomerActions(String userInput, String username){
        switch(userInput){
            case "1":   //View account balance
                //BankAccount bankAccount = AllBankProfiles.getInstance().extractProfile(username).getAccounts().get(0);
                AccountActions.viewAccountBalance(username);
                //System.out.println("$" + bankAccount.getBalance());
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                System.out.println("Exiting...");
                //Main.finish();
                break;
        }
    }

    private static void EmployeeActions(String userInput, String username){
        switch(userInput){
            case "1":
                System.out.println(Main.allBankAccounts);
                System.out.println("Enter the username of the account you would like to see");
                userInput = Main.getUserInput();
                userInput = ValidFormat.loopUntilValid(userInput, "ALPHANUM");
                userInput = ValidFormat.loopUntilValid(userInput,"SPACE");
                System.out.println(Main.allBankAccounts.extractAccount(userInput));

                System.out.println("Would you like to view their account balance?");
                System.out.println("\t1- Yes\n\t2- No");
                userInput = Main.getUserInput();
                userInput = ValidFormat.loopUntilValid(userInput, "VALUE", 1, 2);

                if (userInput.equals("1")){
                    viewAccountBalance(username);
                }
                else{
                    System.out.println("Do you want to do anything else?");
                    System.out.println("\t1- Yes\n\t2- No");
                    userInput = Main.getUserInput();
                    userInput = ValidFormat.loopUntilValid(userInput, "VALUE", 1, 2);

                    if (userInput.equals("1")){
                        nextActions(User.Employee, username);
                    }
                    else{
                        System.out.println("Exiting...");
                        //Main.finish();
                    }
                }

                break;
            case "2":
                break;
            case "3":
                JudgeApplications j = new JudgeApplications();
                j.judge();

                System.out.println("Do you want to do anything else?");
                System.out.println("\t1- Yes\n\t2- No");
                userInput = Main.getUserInput();
                userInput = ValidFormat.loopUntilValid(userInput, "VALUE", 1, 2);

                if (userInput.equals("1")){
                    nextActions(User.Employee, username);
                }
                else{
                    System.out.println("Exiting...");
                    //Main.finish();
                }
                break;
            case "4":
                System.out.println("Exiting...");
                //Main.finish();
                break;
        }
    }

    private static void AdminActions(String userInput, String username){
        switch(userInput){
            case "1":
                System.out.println(Main.allBankAccounts);
                System.out.println("Enter the username of the account you would like to see");
                userInput = Main.getUserInput();
                userInput = ValidFormat.loopUntilValid(userInput, "ALPHANUM");
                userInput = ValidFormat.loopUntilValid(userInput,"SPACE");
                System.out.println(Main.allBankAccounts.extractAccount(userInput));

                System.out.println("Would you like to view their account balance?");
                System.out.println("\t1- Yes\n\t2- No");
                userInput = Main.getUserInput();
                userInput = ValidFormat.loopUntilValid(userInput, "VALUE", 1, 2);

                if (userInput.equals("1")){
                    viewAccountBalance(username);
                }
                else{
                    System.out.println("Do you want to do anything else?");
                    System.out.println("\t1- Yes\n\t2- No");
                    userInput = Main.getUserInput();
                    userInput = ValidFormat.loopUntilValid(userInput, "VALUE", 1, 2);

                    if (userInput.equals("1")){
                        nextActions(User.Employee, username);
                    }
                    else{
                        System.out.println("Exiting...");
                        //Main.finish();
                    }
                }
                break;
            case "2":
                break;
            case "3":
                JudgeApplications j = new JudgeApplications();
                j.judge();
                System.out.println("Do you want to do anything else?");
                System.out.println("\t1- Yes\n\t2- No");
                userInput = Main.getUserInput();
                userInput = ValidFormat.loopUntilValid(userInput, "VALUE", 1, 2);

                if (userInput.equals("1")){
                    nextActions(User.Employee, username);
                }
                else{
                    System.out.println("Exiting...");
                    //Main.finish();
                }
                break;
            case "4":
                AdminCancellingPower.Cancel();
                break;
            case "5":
                System.out.println("Exiting...");
                //Main.finish();
                break;
        }
    }

    private static void printUserMenu(User user) {
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
