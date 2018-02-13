package com.ex.bankpowers;

public class JudgeApplications {

    public void judge(){
        //Must call ReadObjectData.loadApplications() in order to pull up open applications

        // If an application is approved, must make a BankAccount and BankProfile and set
        // all appropriate fields with the info in the AccountApplication using the setters
        // *** Check account type specified on application
        //      1 - Checking
        //      2 - Savings
        //      3 - Joint
        //
        //Afterwards Must insert the newly created BankAccount and BankProfile into respective
        //AllBankAccounts and AllBankProfile classes.
        //
        // Access their instances by calling AllBankAccount.getInstance() or AllBankProfile.getInstance()
        //Their data will already get written to file in the finish() method in the Main.java class
        //Once done, customer can then register for an account and login.
        //Otherwise, customer can never register.

        //If an application is denied, must delete their registered username from
        //customerUsernames in AllAccounts using the deleteUsername(String username) method.
        //This is to free up that username as an available and existing username for new applicants
    }
}
