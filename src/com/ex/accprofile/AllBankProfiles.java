package com.ex.accprofile;

import java.io.Serializable;
import java.util.ArrayList;

public class AllBankProfiles implements Serializable{

    private static final long serialVersionUID = 1L;

    private static ArrayList<BankProfile> bankpros = new ArrayList<>();

    public AllBankProfiles(){

    }

    public BankProfile extractProfile(String username){
        for(int i = 0; i < bankpros.size(); i++){
            if (bankpros.get(i).getUsername().equals(username)){
                return bankpros.get(i);
            }
        }
        return new BankProfile("NO ACCOUNT FOUND IN FILE");
    }

    public void insertProfile(BankProfile bankProfile){
        bankpros.add(bankProfile);
    }
}
