package com.ex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {

    static Logger logger = LogManager.getLogger();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Starting console action
        System.out.println("||| R3VATUR3 BANKING |||\n");
        printMainMenu();

        //This string reference handles all scanner input
        String userInput = getUserInput();

        //Check if input is a valid number between 1 - 3
        userInput = ValidFormat.loopUntilValid(userInput,"VALUE", 1, 4);

        if (userInput.equals("1")) {//Login selected
            printLoginMenu();
            userInput = getUserInput();
            userInput = ValidFormat.loopUntilValid(userInput,"VALUE", 1, 3);

            if (userInput.equals("1")) { //Customer logging in
                System.out.println("Welcome back customer!\tBeginning client login...");
                Login newlogin = new Login(User.Customer);
            } else if (userInput.equals("2")) { //Employee logging in
                System.out.println("Hello!\tBeginning portal login...");
                Login newlogin = new Login(User.Employee);
            } else if (userInput.equals("3")) { //Admin logging in
                System.out.println("Hello, welcome back!\tInitializing portal login...");
                Login newlogin = new Login(User.Admin);
            }

        } else if (userInput.equals("2")) {//Apply for account selected
            //Will call AccountApplication class

        } else if (userInput.equals("3")) {//Register for account selected
            //Will call Register class

        } else if (userInput.equals("4")){//Exit selected, Do nothing
            System.out.println("Exiting Client...");
        }
    }

    public Main(){

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
    }

    public static String getUserInput(){
        return sc.next();
    }
}
