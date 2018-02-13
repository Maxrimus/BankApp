package com.ex.accprofile;

import java.io.Serializable;
import java.util.ArrayList;

//This class is a singleton
public class AllBankAccounts implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<BankAccount> bankaccs = new ArrayList<>();

    public ArrayList<BankAccount> getBankaccs() {
        return bankaccs;
    }

    private static int numberOfAccounts;

    public int getNumberOfAccounts(){
        return numberOfAccounts;
    }

    public void incrementNumbersOfAccounts(){
        numberOfAccounts++;
    }

    private AllBankAccounts() {
        numberOfAccounts = 0;
    }

    private static AllBankAccounts allBankAccounts = new AllBankAccounts();

    public static AllBankAccounts getInstance(){
        if (allBankAccounts == null){
            allBankAccounts = new AllBankAccounts();
        }
        return allBankAccounts;
    }

    public BankAccount extractAccount(String username){

        for (int i = 0; i < bankaccs.size(); i++){
            if (bankaccs.get(i).getUsername().equals(username)){

                return bankaccs.get(i);
            }
        }
        return new BankAccount();
    }

    public void deleteBankAccount(String username){
        for (int i = 0; i < bankaccs.size(); i++){
            if (bankaccs.get(i).getUsername().equals(username)){
                bankaccs.remove(bankaccs.get(i));
            }
        }
    }

    public void insertAccount(BankAccount bankAccount){
        bankaccs.add(bankAccount);
        System.out.println();
    }

    @Override
    public String toString() {
        String toReturn = "Accounts: ";
        toReturn += "\n\n";
        for(int i = 0; i < bankaccs.size(); i++){
            toReturn += (i+1) + " " + bankaccs.get(i).toString();
        }
        return toReturn;
    }
}
