package com.ex.serialize;

import com.ex.AllAccounts;
import com.ex.Main.*;
import com.ex.User;
import com.ex.accprofile.AllBankAccounts;
import com.ex.accprofile.AllBankProfiles;
import com.ex.accprofile.BankAccount;
import com.ex.accprofile.BankProfile;
import com.ex.makingaccount.AccountApplication;
import com.ex.makingaccount.AllApplications;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ex.Main.accounts;
import static com.ex.Main.conn;

public class ReadObjectData {
    static ObjectInputStream in = null;

    public static void loadLoginData() throws SQLException{
        PreparedStatement statement = conn.prepareStatement("SELECT username,password,accesslevel FROM profiles");
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            if(resultSet.getInt("accesslevel") == 0) {
                accounts.getCustomerPass().put(resultSet.getString("username"),resultSet.getString("password"));
                accounts.newUsername(User.Customer,resultSet.getString("username"));
            }
            if(resultSet.getInt("accesslevel") == 1) {
                accounts.getEmployeePass().put(resultSet.getString("username"),resultSet.getString("password"));
                accounts.newUsername(User.Employee,resultSet.getString("username"));
            }
            if(resultSet.getInt("accesslevel") == 2) {
                accounts.getAdminPass().put(resultSet.getString("username"),resultSet.getString("password"));
                accounts.newUsername(User.Admin,resultSet.getString("username"));
            }
        }
    }

    public static AllApplications loadApplications() throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT id,username,email,accounttype,first_name1,last_name1,ssn1,employment1 FROM applications");
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            AccountApplication accountApplication = new AccountApplication(resultSet.getString("username"),resultSet.getString("email"),resultSet.getInt("accounttype"),
                    resultSet.getString("first_name1")+" "+resultSet.getString("last_name1"),resultSet.getString("ssn1"),
                    resultSet.getString("employment1"),resultSet.getInt("id"));
            AllApplications.getApplications().enterNewApplication(accountApplication);
        }
        return AllApplications.getApplications();
    }

    public static AllBankAccounts loadBankData() throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT id,accountnumber,balance,accounttype FROM accounts");
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            PreparedStatement statement1 = conn.prepareStatement("SELECT username FROM profiles WHERE id IN(SELECT profileid FROM accountsprofiles WHERE accountid = ?)");
            statement1.setInt(1, resultSet.getInt("id"));
            ResultSet resultSet1 = statement1.executeQuery();
            while(resultSet1.next()){
                BankAccount bankAccount = new BankAccount(resultSet1.getString("username"),resultSet.getString("accountnumber"),resultSet.getInt("balance")
                        ,resultSet.getInt("accounttype"), resultSet.getInt("id"));
                AllBankAccounts.getInstance().insertAccount(bankAccount);
            }
        }
        return AllBankAccounts.getInstance();
    }

    public static AllBankProfiles loadProfileData() throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT id,username,email,first_name,last_name,ssn,employment,accesslevel FROM profiles");
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            BankProfile bankProfile = new BankProfile(resultSet.getString("username"),resultSet.getString("email"),
                    resultSet.getString("first_name") + " " + resultSet.getString("last_name"),resultSet.getString("ssn"),
                    resultSet.getString("employment"),resultSet.getInt("id"),User.values()[resultSet.getInt("accesslevel")]);

            AllBankProfiles.getInstance().insertProfile(bankProfile);
        }
        return AllBankProfiles.getInstance();

    }
}
