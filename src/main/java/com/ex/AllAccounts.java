package com.ex;

import com.ex.accprofile.AllBankAccounts;
import com.ex.accprofile.AllBankProfiles;
import com.ex.accprofile.BankAccount;
import com.ex.accprofile.BankProfile;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//This class is a Singleton
public class AllAccounts implements Serializable{

    private static final long serialVersionUID = 1L;

    //hashset to check if username exists
    private HashSet<String> customerUsernames = new HashSet<>();
    private HashSet<String> employeeUsernames = new HashSet<>();
    private HashSet<String> adminUsernames = new HashSet<>();

    //Map Keys: username
    //Map Values: password
    private HashMap<String,String> customerPass = new HashMap<>();
    private HashMap<String,String> employeePass = new HashMap<>();
    private HashMap<String,String> adminPass = new HashMap<>();


    private AllAccounts(){
    }

    //Calls this on application start up if the logininfo file is empty
    public void makeAllUsers(){
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

    public static AllAccounts setAccounts(AllAccounts accs){
        accounts = accs;
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

    public boolean doesAccountExist(String username) {
        if (customerPass.containsKey(username)){
            return true;
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
        if (username == null){
            return;
        }
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

    public HashMap<String, String> getEmployeePass() {
        return employeePass;
    }

    public HashMap<String, String> getAdminPass() {
        return adminPass;
    }

    public void createAccount(String username, String password){
        customerPass.put(username, password);
    }

    public void deleteAccount(String username){
        customerPass.remove(username);
    }

    public void deleteUsername(String username){
        customerUsernames.remove(username);
    }

    public HashSet<String> getAdminUsernames() {
        return adminUsernames;
    }

    public HashMap<String, String> getCustomerPass() {
        return customerPass;
    }

    public void PrintLogins(){
        System.out.println("Customer Logins:");
        for(Map.Entry<String,String> entry:customerPass.entrySet()) System.out.println("Username: " + entry.getKey() + " Password: " + entry.getValue());
        System.out.println("Employee Logins:");
        for(Map.Entry<String,String> entry:employeePass.entrySet()) System.out.println("Username: " + entry.getKey() + " Password: " + entry.getValue());
        System.out.println("Admin Logins:");
        for(Map.Entry<String,String> entry:adminPass.entrySet()) System.out.println("Username: " + entry.getKey() + " Password: " + entry.getValue());
    }
}
