package com.ex.accprofile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//This class is a singleton
public class AllBankProfiles implements Serializable{

    private static final long serialVersionUID = 1L;

    public ArrayList<BankProfile> getBankpros() {
        return bankpros;
    }

    private ArrayList<BankProfile> bankpros = new ArrayList<>();

    private AllBankProfiles(){
    }

    private static AllBankProfiles allBankProfiles = new AllBankProfiles();

    public static AllBankProfiles getInstance(){
        if (allBankProfiles == null){
            allBankProfiles = new AllBankProfiles();
        }
        return allBankProfiles;
    }

    public List<BankProfile> extractProfile(String username){
        List<BankProfile> profiles = new ArrayList<>();
        for(int i = 0; i < bankpros.size(); i++){
            if (bankpros.get(i).getUsername().equals(username)){
                profiles.add(bankpros.get(i));
            }
        }
        if(profiles.size() > 0) return profiles;
        else{
            profiles.add(new BankProfile());
            return profiles;
        }
    }

    public void deleteProfile(String username){
        for (int i = 0; i < bankpros.size(); i++){
            if (bankpros.get(i).getUsername().equals(username)){
                bankpros.remove(bankpros.get(i));
            }
        }
    }

    public void insertProfile(BankProfile bankProfile){
        bankpros.add(bankProfile);
    }

    @Override
    public String toString() {
        String toReturn = "Profiles:" + "\n";
        for(BankProfile bp:bankpros){
            toReturn += bp.toString() + "\n\n";
        }
        return toReturn;
    }
}
