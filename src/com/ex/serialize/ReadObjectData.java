package com.ex.serialize;

import com.ex.accprofile.BankAccount;
import com.ex.accprofile.BankProfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObjectData {
    static ObjectInputStream in = null;

    public static BankAccount readBankData(String username){
        try {
            in = new ObjectInputStream(new FileInputStream("resources/bankaccounts"+ username));
            return (BankAccount)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("No bank account found");
        return new BankAccount();
    }

    public static BankProfile readProfileData(String username){
        try {
            in = new ObjectInputStream(new FileInputStream("resources/bankprofiles"));
            return (BankProfile)in.readObject();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("No bank profile found");
        return new BankProfile();
    }

}
