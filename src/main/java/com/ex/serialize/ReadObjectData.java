package com.ex.serialize;

import com.ex.AllAccounts;
import com.ex.Main.*;
import com.ex.accprofile.AllBankAccounts;
import com.ex.accprofile.AllBankProfiles;
import com.ex.accprofile.BankAccount;
import com.ex.accprofile.BankProfile;
import com.ex.makingaccount.AccountApplication;
import com.ex.makingaccount.AllApplications;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ex.Main.accounts;
import static com.ex.Main.conn;

public class ReadObjectData {
    static ObjectInputStream in = null;

    public static void loadLoginData() throws SQLException{
        /*try {
            in = new ObjectInputStream(new FileInputStream("resources/logininfo"));
            return (AllAccounts)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            //If logininfo file is empty which causes the exception
            //recreate all users and write them into logininfo file.
            accounts.makeAllUsers();
            WriteObjectData.writeLoginInfo(accounts);
        }

        System.out.println("Did not find login info file");
        return accounts;*/
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT username,password,accesslevel FROM profiles");
        while(resultSet.next()){
            if(resultSet.getInt("accesslevel") == 0) accounts.getCustomerPass().put(resultSet.getString("username"),resultSet.getString("password"));
            if(resultSet.getInt("accesslevel") == 1) accounts.getEmployeePass().put(resultSet.getString("username"),resultSet.getString("password"));
            if(resultSet.getInt("accesslevel") == 2) accounts.getAdminPass().put(resultSet.getString("username"),resultSet.getString("password"));
        }
    }

    public static AllApplications loadApplications() throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM applications");
        while(resultSet.next()){
            AccountApplication accountApplication = new AccountApplication(resultSet.getString("username"),resultSet.getString("email"),resultSet.getInt("accounttype"),
                    resultSet.getString("first_name")+" "+resultSet.getString("last_name"),resultSet.getString("ssn"),
                    resultSet.getString("employment"));
            AllApplications.getApplications().enterNewApplication(accountApplication);
        }
        return AllApplications.getApplications();
    }

    public static AllBankAccounts loadBankData() throws SQLException {
        /*try {
            in = new ObjectInputStream(new FileInputStream("resources/bankaccdata"));
            return (AllBankAccounts)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            //e.printStackTrace();
        }

        System.out.println("bankaccdata file currently empty. Creating new instance");*/
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts");
        Statement statement1 = conn.createStatement();
        while(resultSet.next()){
            ResultSet resultSet1 = statement1.executeQuery("SELECT username FROM profiles WHERE id=(SELECT profileid FROM accountsprofiles WHERE accountid = "+ resultSet.getInt("id") +")");
            while(resultSet1.next()){
                BankAccount bankAccount = new BankAccount(resultSet1.getString("username"),resultSet.getString("accountnumber"),resultSet.getInt("balance")
                        ,resultSet.getInt("accounttype"));
                AllBankAccounts.getInstance().insertAccount(bankAccount);
            }
        }
        return AllBankAccounts.getInstance();
    }

    public static AllBankProfiles loadProfileData() throws SQLException {
//        try {
//            in = new ObjectInputStream(new FileInputStream("resources/bankprodata"));
//            return (AllBankProfiles)in.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            //e.printStackTrace();
//        }
//        System.out.println("bankprodata file currently empty. Creating new instance");
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM profiles");
        Statement statement1 = conn.createStatement();
        while(resultSet.next()){
            BankProfile bankProfile = new BankProfile(resultSet.getString("username"),resultSet.getString("email"),
                    resultSet.getString("first_name") + " " + resultSet.getString("last_name"),resultSet.getString("ssn"),
                    resultSet.getString("employment"));

            AllBankProfiles.getInstance().insertProfile(bankProfile);
        }
        return AllBankProfiles.getInstance();

    }



//    public static BankAccount readBankData(String username){
//        try {
//            in = new ObjectInputStream(new FileInputStream("resources/bankaccounts"+ username));
//            return (BankAccount)in.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            if (in != null){
//                try {
//                    in.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        System.out.println("No bank account found");
//        return new BankAccount();
//    }
//
//    public static BankProfile readProfileData(String username){
//        try {
//            in = new ObjectInputStream(new FileInputStream("resources/bankprofiles"));
//            return (BankProfile)in.readObject();
//        } catch (IOException | ClassNotFoundException e){
//            e.printStackTrace();
//        } finally {
//            if (in != null){
//                try {
//                    in.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        System.out.println("No bank profile found");
//        return new BankProfile();
//    }

}