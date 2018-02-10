package com.ex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {

    static Logger logger = LogManager.getLogger();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Starting console action
        System.out.println("||| R3VATUR3 BANKING |||");
        printMainMenu();

        //This string reference handles all scanner input
        String userInput = getUserInput();

        //Check if input is valid
        boolean invalid = true;
        while (invalid) {
            if (userInput.length() == 1 && Character.isDigit(userInput.charAt(0)) && ValidFormat.isMinMaxLength(userInput, 1, 3)) {
                invalid = false;
            }
            else {
                System.out.println("No matching input");
                System.out.println("Please try again");
                printMainMenu();
                userInput = getUserInput();
            }
        }

        if (userInput.equals("1")){
            //Login selected
            printLoginMenu();
            userInput = getUserInput();
            //Will call Login class
        }
        else if (userInput.equals("2")){
            //Apply for account selected
            //Will call AccountApplication class
        }
        else if (userInput.equals("3")){
            //Register for account selected
            //WIll call Register class
        }


    }

    public Main(){

    }

    public int[] sort(int[] toSort){
        int[] toReturn = toSort;
        boolean sorted = false;
        int a, b;
        while(!sorted)
        {
            sorted = true;
            for(int i = 0; i < toReturn.length-1; i++)
            {
                if((a=toReturn[i])>(b=toReturn[i+1]))
                {
                    toReturn[i] = b;
                    toReturn[i+1] = a;
                    sorted = false;
                }
            }
        }
        return toReturn;
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

    private static String getUserInput(){
        return sc.next();
    }
}
