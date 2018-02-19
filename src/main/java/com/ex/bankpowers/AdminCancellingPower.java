package com.ex.bankpowers;

import com.ex.Main;
import com.ex.ValidFormat;
import com.ex.accprofile.AllBankAccounts;

public class AdminCancellingPower {

    //There are methods defined in AllAccounts to deleteAccount(String username)
    //and deleteUsername(String username. They must both be called because they delete from
    //two different data structures. Do not merge the two methods into one, they are kept
    //separate for function in another aspect of the project
    //
    //There is a method defined in AllBankProfiles to deleteProfile(String username)
    //There is a method defined in AllBankAccounts to deleteBankAccount(String username)
    public static void Cancel(){
        System.out.println(Main.allBankAccounts.toString());
        System.out.println("Enter the username of the account you would like to cancel");
        String userInput = Main.getUserInput();
        userInput = ValidFormat.loopUntilValid(userInput, "ALPHANUM");
        userInput = ValidFormat.loopUntilValid(userInput,"SPACE");

        Main.allBankAccounts.deleteBankAccount(userInput);
        Main.allBankProfiles.deleteProfile(userInput);
        Main.accounts.deleteAccount(userInput);

        //userInput = ValidFormat.loopUntilValid(userInput,"VALUE",1,AllBankAccounts.getInstance().getNumberOfAccounts());
        //AllBankAccounts.getInstance().getBankaccs().remove(Integer.parseInt(userInput) - 1);

    }
}
