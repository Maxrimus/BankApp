package com.ex.makingaccount;

import com.ex.serialize.ReadObjectData;

import java.io.Serializable;
import java.util.ArrayList;

//This class is a singleton
public class AllApplications implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<AccountApplication> bankapps = new ArrayList<>();

    public ArrayList<AccountApplication> getBankapps() {
        return bankapps;
    }

    public int getAmount(){
        return bankapps.size();
    }

    private AllApplications() {
        //AllApplications applications = ReadObjectData.loadApplications();
    }

    private static AllApplications applications = new AllApplications();

    public static AllApplications getApplications(){
        if (applications == null){
            applications = new AllApplications();
        }
        return applications;
    }

    public AccountApplication extractApplication(int index){

        if (bankapps.size() != 0){
            return bankapps.get(index);
        }
        else{
            System.out.println("There are no more open applications");
            return new AccountApplication();
        }
    }

    public void closeApplication(int application){ bankapps.remove(application); }

    public void enterNewApplication(AccountApplication app){
        bankapps.add(app);
    }

    public String toString(){
        String toReturn = "Applications: ";
        toReturn += "\n\n";
        for(int i = 0; i < bankapps.size(); i++){
            toReturn += (i+1) + " " + bankapps.get(i).toString();
        }
        return toReturn;
    }

    public String getAppNames(){
        String toReturn = "Applications: ";
        toReturn += "\n\n";
        for(int i = 0; i < bankapps.size(); i++){
            toReturn += (i+1) + " " + bankapps.get(i).getFullname();
        }
        return toReturn;
    }
}
