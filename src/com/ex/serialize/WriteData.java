package com.ex.serialize;

import com.ex.accprofile.BankAccount;
import com.ex.accprofile.BankProfile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteData {
    static ObjectOutputStream out = null;

    public static void writeBankData(String username, BankAccount bankacc) {
        try {
            out = new ObjectOutputStream(new FileOutputStream("resources/bankaccounts"+username));
            out.writeObject(bankacc);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeProfileData(String username, BankProfile bankpro){
        try {
            out = new ObjectOutputStream(new FileOutputStream("resources/bankaccounts"+username));
            out.writeObject(bankpro);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
