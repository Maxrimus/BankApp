package com.ex;

import java.util.HashMap;
import java.util.HashSet;

//This class is a Singleton
public class AllAccounts {
    //hashset to check if username exists
    private HashSet<String> customerUsernames = new HashSet<>();
    private HashSet<String> employeeUsernames = new HashSet<>();
    private HashSet<String> adminUsernames = new HashSet<>();

    //Map Keys: username
    //Map Values: password
    private HashMap<String,String> customerPass = new HashMap<>();
    private HashMap<String,String> employeePass = new HashMap<>();
    private HashMap<String,String> adminPass = new HashMap<>();

    public HashSet<String> getEmployeeUsernames() {
        return employeeUsernames;
    }

    private AllAccounts(){
        //Initializing Employee accounts
        employeeUsernames.add("calzhe");
        employeeUsernames.add("maxrimus");
        employeePass.put("calzhe", "password");
        employeePass.put("maxrimus", "password1");

        //Initializing Admin accounts
        adminUsernames.add("august");
        adminUsernames.add("mitch");
        adminPass.put("august", "password");
        adminPass.put("mitch", "password1");

        //Hardcoded customers
        customerUsernames.add("a");
        customerUsernames.add("b");
        customerUsernames.add("c");
        customerPass.put("a","1");
        customerPass.put("b","2");
        customerPass.put("c","3");
    }

    private static AllAccounts accounts = new AllAccounts();

    public static AllAccounts getAccounts(){
        if (accounts == null){
            accounts = new AllAccounts();
        }
        return accounts;
    }

    public boolean doesUserExist(User user, String username){
        switch (user) {
            case Customer:
                if (customerUsernames.contains(username)) {
                    return true;
                }
                break;
            case Employee:
                if (employeeUsernames.contains(username)) {
                    return true;
                }
                break;
            case Admin:
                if (adminUsernames.contains(username)) {
                    return true;
                }
                break;
        }
        return false;
    }

    public boolean doesPassMatch(User user, String username, String password){
        switch (user) {
            case Customer: {
                if (customerPass.containsKey(username) && customerPass.get(username).equals(password)){
                    return true;
                }
                break;
            }
            case Employee: {
                if (employeePass.containsKey(username) && employeePass.get(username).equals(password)){
                    return true;
                }
                break;
            }
            case Admin: {
                if (adminPass.containsKey(username) && adminPass.get(username).equals(password)){
                    return true;
                }
                break;
            }
        }
        return false;
    }

    public void newUsername(User user, String username){
        switch (user) {
            case Customer:
                customerUsernames.add(username);
                break;
            case Employee:
                employeeUsernames.add(username);
                break;
            case Admin:
                adminUsernames.add(username);
                break;
        }
    }

    public void createAccount(String username, String password){
        customerPass.put(username, password);
    }

    public void deleteAccount(String username){
        customerUsernames.remove(username);
        customerPass.remove(username);
    }
}
