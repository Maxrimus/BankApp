package com.ex.serialize;

import com.ex.AllAccounts;
import com.ex.accprofile.AllBankAccounts;
import com.ex.accprofile.AllBankProfiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import static com.ex.Main.accounts;

public class ReadObjectData {
    static ObjectInputStream in = null;

    public static AllAccounts loadLoginData(){
        try {
            in = new ObjectInputStream(new FileInputStream("resources/logininfo"));
            return (AllAccounts)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            //If logininfo file is empty which causes the exception
            //recreate all users and write them into logininfo file.
            accounts.makeAllUsers();
            WriteObjectData.writeLoginInfo(accounts);
        }

        System.out.println("Did not find login info file");
        return accounts;
    }

    public static AllBankAccounts loadBankData(){
        try {
            in = new ObjectInputStream(new FileInputStream("resources/bankaccdata"));
            return (AllBankAccounts)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Did not find bankaccdata file");
        return new AllBankAccounts();
    }

    public static AllBankProfiles loadProfileData(){
        try {
            in = new ObjectInputStream(new FileInputStream("resources/bankprodata"));
            return (AllBankProfiles)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Did not find bankprodata");
        return new AllBankProfiles();
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
