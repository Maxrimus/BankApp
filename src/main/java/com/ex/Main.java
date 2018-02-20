package com.ex;

import com.ex.accprofile.AllBankAccounts;
import com.ex.accprofile.AllBankProfiles;
import com.ex.accprofile.BankProfile;
import com.ex.makingaccount.AccountApplication;
import com.ex.makingaccount.AllApplications;
import com.ex.makingaccount.Register;
import com.ex.serialize.ReadObjectData;
import com.ex.serialize.WriteObjectData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.sql.*;


public class Main {

    static Logger logger = LogManager.getLogger();
    static Scanner sc = new Scanner(System.in);
    public static Connection conn;
    public static AllAccounts accounts = AllAccounts.getAccounts();
    public static AllApplications allApplications = AllApplications.getApplications();
    public static AllBankAccounts allBankAccounts = AllBankAccounts.getInstance();
    public static AllBankProfiles allBankProfiles = AllBankProfiles.getInstance();

    public Main(){
        //Loading login data from file
        try {
            SetupDatabase();
            ReadObjectData.loadLoginData();
            ReadObjectData.loadApplications();
            ReadObjectData.loadBankData();
            ReadObjectData.loadProfileData();
//            accounts.PrintLogins();
//            System.out.println(allApplications.toString());
//            System.out.println(allBankAccounts.toString());
//            System.out.println(allBankProfiles.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //AllAccounts.getAccounts().makeAllUsers();
        System.out.println();
    }

    public static void main(String[] args) {
        //Calling application to start
        Main m = new Main();
        try {
            start();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void SetupDatabase() throws SQLException{
        String serverURL = "jdbc:postgresql://rev-pg-test.cyj6am5rzlko.us-east-2.rds.amazonaws.com:5432/rev_db";
        Properties props = new Properties();
        String username = "";
        String password = "";
        List<String> lines = new ArrayList<String>();
        String line = "";
        String dataFile = "resources/credentials.txt";
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(dataFile));
            while((line = bufferedReader.readLine()) != null) lines.add(line);
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            dataFile + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + dataFile + "'");
        }
        username = lines.get(0);
        password = lines.get(1);
        props.setProperty("user",username);
        props.setProperty("password",password);
        conn = DriverManager.getConnection(serverURL,props);
    }

    public static void start() throws SQLException {
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
                AllBankProfiles bankProfiles = AllBankProfiles.getInstance();
//                BankProfile myprof = bankProfiles.extractProfile(newUser.getUsername());
//                myprof.setEmail(newUser.getEmail());
                accounts.createAccount(newUser.getUsername(),newUser.getPassword());

                System.out.println("You're all set!!\nPlease log in now");
                Login login = new Login(User.Customer);
            }


        } else if (userInput.equals("4")){//Exit selected, Do nothing
            System.out.println("Exiting Client...");
        }
        finish();
    }

    public static void finish(){
        try {
            //WriteObjectData.writeLoginInfo(accounts);
            WriteObjectData.writeBankProfiles(AllBankProfiles.getInstance());
            WriteObjectData.writeBankAccounts(AllBankAccounts.getInstance());
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
