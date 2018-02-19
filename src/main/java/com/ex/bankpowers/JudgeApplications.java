package com.ex.bankpowers;

import com.ex.AllAccounts;
import com.ex.Main;
import com.ex.User;
import com.ex.ValidFormat;
import com.ex.accprofile.AllBankAccounts;
import com.ex.accprofile.AllBankProfiles;
import com.ex.accprofile.BankAccount;
import com.ex.accprofile.BankProfile;
import com.ex.makingaccount.AccountApplication;
import com.ex.makingaccount.AllApplications;
import com.ex.serialize.ReadObjectData;
import com.ex.serialize.WriteObjectData;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ex.Main.conn;

public class JudgeApplications {

    public JudgeApplications(){
    }

    public void judge(){
        //Must call ReadObjectData.loadApplications() in order to pull up open applications
        AllApplications allApps = Main.allApplications;
        AllBankAccounts bankAccounts = Main.allBankAccounts;
        AllBankProfiles bankProfiles = Main.allBankProfiles;

        int appNumber = 0;
        if(allApps.getAmount() <= 0) {
            System.out.println("No Applications");
            return;
        }

        System.out.println("Which Application would you like to judge?");
        System.out.println(allApps.getAppNames());
        String userInput = Main.getUserInput();
        userInput = ValidFormat.loopUntilValid(userInput,"VALUE",1,allApps.getAmount());
        appNumber = Integer.parseInt(userInput)-1;
        AccountApplication application = allApps.extractApplication(appNumber);
        System.out.println(application.toString());
        System.out.println("Would you like to accept this application?(Yes/No):");
        boolean valid = false;
        while(!valid){
            userInput = Main.getUserInput();
            if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("No")|| userInput.equals("no")) valid = true;
            else System.out.println("Invalid input. Please type either Yes or No");
        }
        // If an application is approved, must make a BankAccount and BankProfile and set
        // all appropriate fields with the info in the AccountApplication using the setters
        // *** Check account type specified on application
        //      1 - Checking
        //      2 - Savings
        //      3 - Joint
        //
        if(userInput.equals("Yes") || userInput.equals("yes")){     //Application gets approved

            //If the account type specified is "CHECKING" or "SAVINGS"
            if(application.getAccountType() == BankAccount.AccountTypes.CHECKING.getValue() || application.getAccountType() == BankAccount.AccountTypes.SAVINGS.getValue()){

                if (Main.accounts.doesAccountExist(application.getUsername())){
                    BankAccount ba = bankAccounts.extractAccount(application.getUsername());
                    ba.addAccountType(ba.intToAccountType(application.getAccountType()));
                }
                else {
                    BankProfile newProfile = new BankProfile(application.getUsername(), application.getEmail(), application.getFullname(), application.getSsn(),
                            application.getEmployment(),-1,User.Customer);
                    BankAccount newAccount = new BankAccount(application.getUsername(), 0.0, application.getAccountType(),-1);
                    bankProfiles.insertProfile(newProfile);
                    bankAccounts.insertAccount(newAccount);
                    Main.accounts.createAccount(application.getUsername(), "");
                }
            }
            else{       //The account type is "JOINT"
                BankProfile newProfile = new BankProfile(application.getUsername(), application.getEmail(), application.getFullname(), application.getSsn(),
                        application.getEmployment(), application.getFullname2(), application.getSsn2(), application.getEmployment2(),-1,User.Customer);
                BankAccount newAccount = new BankAccount(application.getUsername(),  0, application.getAccountType(),-1);
                bankProfiles.insertProfile(newProfile);
                bankAccounts.insertAccount(newAccount);
                Main.accounts.createAccount(application.getUsername(), "");
            }

            try {
                PreparedStatement statement = conn.prepareStatement("DELETE FROM applications WHERE username = ?");
                statement.setString(1,application.getUsername());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            allApps.closeApplication(appNumber);
            //Main.finish();
            //WriteObjectData.writeBankApplications(allApps);
        }
        else if(userInput.equals("No")|| userInput.equals("no")){ // Application denied
            allApps.closeApplication(appNumber);
            Main.accounts.deleteUsername(application.getUsername());

            try {
                PreparedStatement statement = conn.prepareStatement("DELETE FROM applications WHERE username = ?");
                statement.setString(1,application.getUsername());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //WriteObjectData.writeBankApplications(allApps);
        }
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
