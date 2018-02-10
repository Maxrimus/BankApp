package com.ex;

import java.util.HashMap;
import java.util.HashSet;

//This class is a Singleton
public class AllAccounts {
    private HashSet<String> customerUsernames = new HashSet<>();
    private HashSet<String> employeeUsernames = new HashSet<>();
    private HashSet<String> adminUsernames = new HashSet<>();

    //Map Keys: password
    //Map Values: username
    private HashMap<String,String> customerPass = new HashMap<>();
    private HashMap<String,String> employeePass = new HashMap<>();
    private HashMap<String,String> adminPass = new HashMap<>();

    private AllAccounts(){}

    public static AllAccounts accounts = new AllAccounts();

    public boolean doesUserExist(User user, String username){
        return false;
    }

    public boolean doesPassMatch(User user, String username, String password){
        return false;
    }

    public void newUsername(User user, String username){

    }

    public void createAccount(User user, String username, String password){

    }

    public void deleteAccount(User user, String username, String password){

    }
}
