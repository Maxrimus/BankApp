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

    private static void viewAccountBalance(String username){
        BankAccount ba = Main.allBankAccounts.extractAccount(username);
        ArrayList<BankAccount.AccountTypes> acc= ba.getAccountTypeList();

        System.out.println("Which account balance would you like to view?");
        for (int i = 0; i < acc.size(); i++){
            System.out.println("\t"+i+1+"-"+acc.get(i));
        }

        String userInput = Main.getUserInput();
        userInput = ValidFormat.loopUntilValid(userInput,"VALUE", 1,acc.size());
        BankAccount.AccountTypes type = acc.get(Integer.parseInt(userInput)-1);
        Double balance = ba.getAccountBalance(type);
        System.out.println("Your account balance");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(formatter.format(balance));

//        for(int i = 1; i <= acc.size(); i++){
//            if(userInput.equals(Integer.toString(i))){
//                Double balance = ba.getAccountBalance(acc.get(i-1));
//                System.out.println("Your account balance");
//                NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
//                System.out.println(formatter.format(balance));
//                break;
//            }
//        }

    }

    private static void withdraw(String username){
        BankAccount ba = Main.allBankAccounts.extractAccount(username);
        ArrayList<BankAccount.AccountTypes> acc= ba.getAccountTypeList();

        System.out.println("Which account would you like to withdraw from?");
        for (int i = 0; i < acc.size(); i++){
            System.out.println("\t"+(i+1)+"- "+acc.get(i));
        }

        String userInput = Main.getUserInput();
        userInput = ValidFormat.loopUntilValid(userInput,"VALUE", 1,acc.size());
        BankAccount.AccountTypes type = acc.get(Integer.parseInt(userInput)-1);

        Double currentBalance = ba.getAccountBalance(type);
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Your current balance: " + formatter.format(currentBalance));

        if (currentBalance == 0.0){
            System.out.println("You don't have enough to withdraw from");
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
        System.out.println("How much would you like to withdraw?");
        userInput = Main.getUserInput();

        if (ValidFormat.isCurrency(userInput)){
            if (Double.parseDouble(userInput) <= currentBalance && Double.parseDouble(userInput) > 0){
                System.out.println("Processing...");
                ba.withdrawMoney(type, Double.parseDouble(userInput));
                System.out.println("Your remaining balance in the account");
                System.out.println(ba.getAccountBalance(type));
            }
            else{
                System.out.println("The amount specified is not allowed");
                System.out.println("Leaving transaction...");
            }
        }
        else{
            System.out.println("Your input is invalid");
            System.out.println("Leaving transaction");
        }

    }

    private static void deposit(String username){
        BankAccount ba = Main.allBankAccounts.extractAccount(username);
        ArrayList<BankAccount.AccountTypes> acc= ba.getAccountTypeList();

        System.out.println("Which account would you like to deposit to?");
        for (int i = 0; i < acc.size(); i++){
            System.out.println("\t"+(i+1)+"- "+acc.get(i));
        }

        String userInput = Main.getUserInput();
        userInput = ValidFormat.loopUntilValid(userInput,"VALUE", 1,acc.size());
        BankAccount.AccountTypes type = acc.get(Integer.parseInt(userInput)-1);

        Double currentBalance = ba.getAccountBalance(type);
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Your current balance: " + formatter.format(currentBalance));

        System.out.println("How much would you like to deposit?");
        userInput = Main.getUserInput();

        if (ValidFormat.isCurrency(userInput)){
            if (Double.parseDouble(userInput) > 0){
                System.out.println("Processing...");
                ba.depositMoney(type, Double.parseDouble(userInput));
                System.out.println("Your new balance in the account");
                System.out.println(ba.getAccountBalance(type));
            }
            else{
                System.out.println("The amount specified is not allowed");
                System.out.println("Leaving transaction...");
            }
        }
        else{
            System.out.println("Your input is invalid");
            System.out.println("Leaving transaction");
        }
    }

    private static void transfer(String username){
        BankAccount ba = Main.allBankAccounts.extractAccount(username);
        ArrayList<BankAccount.AccountTypes> acc= ba.getAccountTypeList();

        System.out.println("Which account would you like to transfer from?");
        for (int i = 0; i < acc.size(); i++){
            System.out.println("\t"+(i+1)+"- "+acc.get(i));
        }

        String userInput = Main.getUserInput();
        userInput = ValidFormat.loopUntilValid(userInput,"VALUE", 1,acc.size());
        BankAccount.AccountTypes type = acc.get(Integer.parseInt(userInput)-1);
        Double currentBalance = ba.getAccountBalance(type);

        System.out.println("Are you transferring to one of your accounts or to another customer?");
        System.out.println("\t1- Myself");
        System.out.println("\t2- Another person");

        userInput = Main.getUserInput();
        userInput = ValidFormat.loopUntilValid(userInput, "VALUE", 1, 2);

        if (userInput.equals("1")){
            System.out.println("Which account are you transferring to?");
            int i = 0;
            while (i < acc.size()) {
                if (acc.get(i) != type){
                    System.out.println("\t"+ (i+1) + acc.get(i));
                }
                i++;
            }

            userInput = Main.getUserInput();
            userInput = ValidFormat.loopUntilValid(userInput, "VALUE", 1, acc.size());
            BankAccount.AccountTypes type2 = acc.get(Integer.parseInt(userInput) - 1);

            System.out.println("How much do you want to transfer?");
            userInput = Main.getUserInput();

            if (ValidFormat.isCurrency(userInput)){
                if (Double.parseDouble(userInput) > 0 || Double.parseDouble(userInput) <= currentBalance){
                    System.out.println("Processing...");
                    ba.withdrawMoney(type, Double.parseDouble(userInput));
                    System.out.println("Your remaining balance in the account");
                    System.out.println(ba.getAccountBalance(type));
                    ba.depositMoney(type2, Double.parseDouble(userInput));
                    System.out.println("Your new balance in the other account");
                    System.out.println(ba.getAccountBalance(type2));
                    System.out.println("Leaving transaction...");
                }
                else{
                    System.out.println("The amount specified is not allowed");
                    System.out.println("Leaving transaction...");
                }
            }
            else{
                System.out.println("Your input is invalid");
                System.out.println("Leaving transaction");
            }
        }
        else if (userInput.equals("2")){
            System.out.println("Enter the username of the person you're transferring to");
            userInput = Main.getUserInput();
            userInput = ValidFormat.loopUntilValid(userInput, "ALPHANUM");
            userInput = ValidFormat.loopUntilValid(userInput,"SPACE");
            boolean exist = Main.accounts.doesUserExist(User.Customer, userInput);

            if (exist){
                BankAccount anotherOne = Main.allBankAccounts.extractAccount(userInput);
                ArrayList<BankAccount.AccountTypes> theirAccs = anotherOne.getAccountTypeList();

                boolean hasChecking = false;
                for (BankAccount.AccountTypes theirAcc : theirAccs) {
                    if (theirAcc == BankAccount.AccountTypes.CHECKING) {
                        hasChecking = true;
                        break;
                    }
                }

                if (!hasChecking){
                    System.out.println("They do not have a checking account to transfer to");
                    System.out.println("Leaving transaction...");
                    return;
                }

                System.out.println("How much do you want to transfer?");
                userInput = Main.getUserInput();

                if (ValidFormat.isCurrency(userInput)){
                    if (Double.parseDouble(userInput) > 0 || Double.parseDouble(userInput) <= currentBalance){
                        System.out.println("Processing...");
                        ba.withdrawMoney(type, Double.parseDouble(userInput));
                        System.out.println("Your remaining balance in the account");
                        System.out.println(ba.getAccountBalance(type));
                        anotherOne.depositMoney(BankAccount.AccountTypes.CHECKING, Double.parseDouble(userInput));
                        System.out.println("Successfully transferred");
                        System.out.println("Leaving transaction....");
                    }
                    else{
                        System.out.println("The amount specified is not allowed");
                        System.out.println("Leaving transaction...");
                    }
                }
                else{
                    System.out.println("Your input is invalid");
                    System.out.println("Leaving transaction");
                }
            }
            else{
                System.out.println("No one by that username exists");
                System.out.println("Leaving transaction....");
            }
        }
    }

    public static void nextActions(User user, String username) {
        printUserMenu(user);
        String userInput = Main.getUserInput();

        //Implement next actions
        if (user == User.Customer) {
            userInput = ValidFormat.loopUntilValid(userInput, "VALUE", 1, 5);
            CustomerActions(userInput, username);
        } else if (user == User.Employee) {
            userInput = ValidFormat.loopUntilValid(userInput, "VALUE", 1, 4);
            EmployeeActions(userInput, username);
        } else if (user == User.Admin) {
            userInput = ValidFormat.loopUntilValid(userInput, "VALUE", 1, 5);
            AdminActions(userInput, username);
        }
    }

    private static void CustomerActions(String userInput, String username){
        switch(userInput){
            case "1":   //View account balance
                viewAccountBalance(username);
                doSomethingElse(User.Customer, username);
                break;
            case "2":   //Withdraw
                withdraw(username);
                doSomethingElse(User.Customer, username);
                break;
            case "3":   //Deposit
                deposit(username);
                doSomethingElse(User.Customer, username);
                break;
            case "4":   //Transfer
                transfer(username);
                doSomethingElse(User.Customer, username);
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

                doSomethingElse(User.Employee, username);
                break;
            case "2":
                System.out.println(Main.allBankProfiles);
                System.out.println("Enter the username of the profile you would like to see");
                userInput = Main.getUserInput();
                userInput = ValidFormat.loopUntilValid(userInput, "ALPHANUM");
                userInput = ValidFormat.loopUntilValid(userInput,"SPACE");
                System.out.println(Main.allBankProfiles.extractProfile(userInput));

                doSomethingElse(User.Employee, username);
                break;
            case "3":
                JudgeApplications j = new JudgeApplications();
                j.judge();
                doSomethingElse(User.Employee, username);
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
                doSomethingElse(User.Admin,username);
                break;
            case "2":
                System.out.println(Main.allBankProfiles);
                System.out.println("Enter the username of the profile you would like to see");
                userInput = Main.getUserInput();
                userInput = ValidFormat.loopUntilValid(userInput, "ALPHANUM");
                userInput = ValidFormat.loopUntilValid(userInput,"SPACE");
                System.out.println(Main.allBankProfiles.extractProfile(userInput));

                doSomethingElse(User.Admin, username);
                break;
            case "3":
                JudgeApplications j = new JudgeApplications();
                j.judge();
                doSomethingElse(User.Admin,username);
                break;
            case "4":
                AdminCancellingPower.Cancel();
                doSomethingElse(User.Admin,username);
                break;
            case "5":
                System.out.println("Exiting...");
                //Main.finish();
                break;
        }
    }

    private static void doSomethingElse(User user, String username){
        System.out.println("Do you want to do anything else?");
        System.out.println("\t1- Yes\n\t2- No");
        String userInput = Main.getUserInput();
        userInput = ValidFormat.loopUntilValid(userInput, "VALUE", 1, 2);

        if (userInput.equals("1")){
            nextActions(user, username);
        }
        else{
            System.out.println("Exiting...");
            //Main.finish();
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
