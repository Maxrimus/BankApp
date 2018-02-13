package com.ex;

import com.ex.accprofile.AllBankAccounts;
import com.ex.accprofile.AllBankProfiles;
import com.ex.accprofile.BankAccount;
import com.ex.accprofile.BankProfile;
import com.ex.makingaccount.AccountApplication;
import com.ex.makingaccount.AllApplications;
import com.ex.makingaccount.Register;
import com.ex.serialize.ReadObjectData;
import com.ex.serialize.WriteObjectData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;


public class Main {

    static Logger logger = LogManager.getLogger();
    static Scanner sc = new Scanner(System.in);
    public static AllAccounts accounts = AllAccounts.getAccounts();

    public Main(){
        //Loading login data from file
        accounts = ReadObjectData.loadLoginData();
    }

    public static void main(String[] args) {
        //Calling application to start
        Main m = new Main();
        start();
    }

    public static void start(){
        //Starting console action
        System.out.println("||| R3VATUR3 BANKING |||\n");
        printMainMenu();
        String userInput = getUserInput();

        //Check if input is a valid number between 1 - 3
        userInput = ValidFormat.loopUntilValid(userInput,"VALUE", 1, 4);

        if (userInput.equals("1")) {//Login selected
            printLoginMenu();
            userInput = getUserInput();
            userInput = ValidFormat.loopUntilValid(userInput,"VALUE", 1, 3);

            switch (userInput) {
                case "1": { //Customer logging in
                    System.out.println("Welcome back customer!\tBeginning client login...");
                    Login newlogin = new Login(User.Customer);
                    break;
                }
                case "2": { //Employee logging in
                    System.out.println("Hello!\tBeginning portal login...");
                    Login newlogin = new Login(User.Employee);
                    break;
                }
                case "3": { //Admin logging in
                    System.out.println("Hello, welcome back!\tInitializing portal login...");
                    Login newlogin = new Login(User.Admin);
                    break;
                }
                case "4":
                    System.out.println("Exiting...");
                    finish();
                    break;
            }

        } else if (userInput.equals("2")) {//Apply for account selected
            AccountApplication newApp = new AccountApplication();
            newApp.apply();
            AllApplications applications = AllApplications.getApplications();
            applications.enterNewApplication(newApp);

            // After user completes application, write their application to application file
            WriteObjectData.writeBankApplications(applications);

            System.out.println("You have completed the application");
            System.out.println("You may try to register to see if your application has been approved");
            System.out.println("Client will now exit....");

        } else if (userInput.equals("3")) {//Register for account selected
            //Will call Register class
            Register newUser = new Register();

            if (newUser.register()){
                AllBankProfiles bankProfiles = ReadObjectData.loadProfileData();
                BankProfile myprof = bankProfiles.extractProfile(newUser.getUsername());
                myprof.setEmail(newUser.getEmail());

                System.out.println("You're all set!!\nPlease log in now");
                Login login = new Login(User.Customer);
            }


        } else if (userInput.equals("4")){//Exit selected, Do nothing
            System.out.println("Exiting Client...");
            finish();
        }
    }

    public static void finish(){
        WriteObjectData.writeLoginInfo(accounts);
        WriteObjectData.writeBankAccounts(AllBankAccounts.getInstance());
        WriteObjectData.writeBankProfiles(AllBankProfiles.getInstance());
    }

    public static void printMainMenu(){
        System.out.println("|Enter the number corresponding to your action|");
        System.out.println("\t1- Login");
        System.out.println("\t2- Apply for an account");
        System.out.println("\t3- Register for online banking");
        System.out.println("\t4- Exit");
    }

    public static void printLoginMenu(){
        System.out.println("|Who is logging in?|");
        System.out.println("\t1- Customer");
        System.out.println("\t2- Employee");
        System.out.println("\t3- Admin");
        System.out.println("\t4- Exit");
    }

    //Call this in any class or method when console input is needed
    public static String getUserInput(){
        return sc.nextLine();
    }

}
