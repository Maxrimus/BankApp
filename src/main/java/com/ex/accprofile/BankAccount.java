package com.ex.accprofile;

import com.ex.makingaccount.AccountApplication;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static com.ex.Main.conn;

public class BankAccount implements Serializable{
    private String username;
    private String accountNumber;
    private int numOfAccounts = 1;
    private int id;
    //private AccountTypes accountType;
    //private Double balance;
    Random rand;

    private ArrayList<AccountTypes> myAccounts = new ArrayList<>();
    private HashMap<AccountTypes, Double> accsBalance = new HashMap<>();

    public String getUsername() {
        return username;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public ArrayList<AccountTypes> getAccountTypeList(){
        return myAccounts;
    }

    public int getNumOfAccounts(){
        return numOfAccounts;
    }

    public Double getAccountBalance(AccountTypes accountType){
        return accsBalance.get(accountType);
    }

    public AccountTypes intToAccountType(int type){
        switch (type){
            case 1:
                return AccountTypes.CHECKING;
            case 2:
                return AccountTypes.SAVINGS;
            case 3:
                return AccountTypes.JOINT;
        }

        return null;
    }

    public void addAccountType(AccountTypes type){
        accsBalance.put(type, 0.0);
        myAccounts.add(type);
        numOfAccounts++;
    }

    public void depositMoney(AccountTypes accountType, Double amt){
        Double current = accsBalance.get(accountType);
        accsBalance.put(accountType, current + amt);
    }

    public void withdrawMoney(AccountTypes accountType, Double amt){
        Double current = accsBalance.get(accountType);
        accsBalance.put(accountType, current - amt);
    }

    public boolean doesAccountTypeExist(AccountTypes accountType){
        return myAccounts.contains(accountType);
    }

//    public AccountTypes getAccountType() {
//        return accountType;
//    }

//    public Double getBalance() {
//        return balance;
//    }

    // Key Integer values so far:
    // 1 - Checking account balance
    // 2 - Savings account balance
    // 3 - Joint account balance
    public enum AccountTypes{
        CHECKING(1),
        SAVINGS(2),
        JOINT(3);

        private int value;

        public int getValue() {
            return value;
        }

        private AccountTypes(int value){
            this.value = value;
        }
    }

    public BankAccount(){}

    public int getId() {
        return id;
    }

    public BankAccount(String username, double startingBalance, Integer accountType, int id){
        this.username = username;
        rand = new Random();
        try {
            accountNumber = generateAccountNumber();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.id = id;
        if(accountType == 1) {
            accsBalance.put(AccountTypes.CHECKING, startingBalance);
            myAccounts.add(AccountTypes.CHECKING);
        }
        if(accountType == 2) {
            accsBalance.put(AccountTypes.SAVINGS, startingBalance);
            myAccounts.add(AccountTypes.SAVINGS);
        }
        if(accountType == 3) {
            accsBalance.put(AccountTypes.JOINT, startingBalance);
            myAccounts.add(AccountTypes.JOINT);
        }
        numOfAccounts++;
    }

    public BankAccount(String username, String accountNumber, double startingBalance, Integer accountType, int id){
        this.username = username;
        this.accountNumber = accountNumber;
        this.id = id;
        if(accountType == 1) {
            accsBalance.put(AccountTypes.CHECKING, startingBalance);
            myAccounts.add(AccountTypes.CHECKING);
        }
        if(accountType == 2) {
            accsBalance.put(AccountTypes.SAVINGS, startingBalance);
            myAccounts.add(AccountTypes.SAVINGS);
        }
        if(accountType == 3) {
            accsBalance.put(AccountTypes.JOINT, startingBalance);
            myAccounts.add(AccountTypes.JOINT);
        }
        rand = new Random();
    }

    private String generateAccountNumber() throws SQLException {
        boolean found = false;
        int possibleNumber = 0;
        while(!found){
            possibleNumber = rand.nextInt(900000000)+100000000;
            PreparedStatement statement = conn.prepareStatement("SELECT accountnumber FROM accounts WHERE accountnumber = ?");
            statement.setInt(1,possibleNumber);
            ResultSet resultSet = statement.executeQuery();
            if(!resultSet.next()) found = true;
        }
        return "" + possibleNumber;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "username='" + username + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", numOfAccounts=" + numOfAccounts +
                ", rand=" + rand +
                ", myAccounts=" + myAccounts +
                ", accsBalance=" + accsBalance +
                '}';
    }

    //    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        int i = 0;
//        while (i < numOfAccounts){
//            if (myAccounts.contains(AccountTypes.CHECKING)){
//                sb.append("Checking ");
//            }
//            else if (myAccounts.contains(AccountTypes.SAVINGS)){
//                sb.append("Savings ");
//            }
//            else if (myAccounts.contains(AccountTypes.JOINT)){
//                sb.append("Joint ");
//            }
//        }
//
//        return "BankAccount{" +
//                "username='" + username + '\'' +
//                ", accountNumber=" + accountNumber +
//                ", accounts=" + sb.toString() +
//                '}';
//    }
}
