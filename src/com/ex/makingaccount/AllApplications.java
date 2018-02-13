package com.ex.makingaccount;

import java.io.Serializable;
import java.util.ArrayList;

//This class is a singleton
public class AllApplications implements Serializable {

    private static final long serialVersionUID = 1L;

    private static ArrayList<AccountApplication> bankapps = new ArrayList<>();

    private AllApplications() {

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

    public void closeApplication(AccountApplication application){
        bankapps.add(application);
    }

    public void enterNewApplication(AccountApplication app){
        bankapps.add(app);
    }
}
