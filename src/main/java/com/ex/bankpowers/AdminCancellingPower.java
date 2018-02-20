package com.ex.bankpowers;

import com.ex.Main;
import com.ex.ValidFormat;
import com.ex.accprofile.AllBankAccounts;
import com.ex.accprofile.BankProfile;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.ex.Main.conn;

public class AdminCancellingPower {

    //There are methods defined in AllAccounts to deleteAccount(String username)
    //and deleteUsername(String username. They must both be called because they delete from
    //two different data structures. Do not merge the two methods into one, they are kept
    //separate for function in another aspect of the project
    //
    //There is a method defined in AllBankProfiles to deleteProfile(String username)
    //There is a method defined in AllBankAccounts to deleteBankAccount(String username)
    public static void Cancel() throws SQLException {
        System.out.println(Main.allBankAccounts.toString());
        System.out.println("Enter the username of the account you would like to cancel");
        String userInput = Main.getUserInput();
        userInput = ValidFormat.loopUntilValid(userInput, "ALPHANUM");
        userInput = ValidFormat.loopUntilValid(userInput,"SPACE");

        int accountid = Main.allBankAccounts.extractAccount(userInput).getId();
        List<BankProfile> profiles = Main.allBankProfiles.extractProfile(userInput);

        PreparedStatement statement = conn.prepareStatement("DELETE FROM accountsprofiles WHERE accountid = ?");
        statement.setInt(1,accountid);
        statement.executeUpdate();

        statement = conn.prepareStatement("DELETE FROM accounts WHERE id = ?");
        statement.setInt(1,accountid);
        statement.executeUpdate();

        for(BankProfile bp:profiles){
            int profileid = bp.getId();
            statement = conn.prepareStatement("DELETE FROM profiles WHERE id = ?");
            statement.setInt(1,profileid);
            statement.executeUpdate();
        }

        Main.allBankAccounts.deleteBankAccount(userInput);
        Main.allBankProfiles.deleteProfile(userInput);

        //userInput = ValidFormat.loopUntilValid(userInput,"VALUE",1,AllBankAccounts.getInstance().getNumberOfAccounts());
        //AllBankAccounts.getInstance().getBankaccs().remove(Integer.parseInt(userInput) - 1);

    }
}
