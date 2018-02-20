package com.ex.serialize;

import com.ex.AllAccounts;
import com.ex.User;
import com.ex.accprofile.AllBankAccounts;
import com.ex.accprofile.AllBankProfiles;
import com.ex.accprofile.BankAccount;
import com.ex.accprofile.BankProfile;
import com.ex.makingaccount.AccountApplication;
import com.ex.makingaccount.AllApplications;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ex.Main.*;

public class WriteObjectData {
    static ObjectOutputStream out = null;

//    public static void writeLoginInfo(AllAccounts accs){
//        try {
//            out = new ObjectOutputStream(new FileOutputStream("resources/logininfo"));
//            out.writeObject(accs);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//
//    }

    public static void writeBankApplications(AllApplications aa) throws SQLException {
//        try {
//            out = new ObjectOutputStream(new FileOutputStream("resources/applications"));
//            out.writeObject(aa);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }



        for(AccountApplication allApps:aa.getBankapps()) {
            if (allApps.getId() == -1 || allApps.getId() == 0) {
                String fullname1 = allApps.getFullname();
                String fullname2 = allApps.getFullname2();
                String[] names1 = fullname1.split(" ");
                String[] names2 = new String[2];
                if(fullname2 != null) names2 = fullname2.split(" ");
                PreparedStatement statement = conn.prepareStatement("INSERT INTO applications (email,first_name1,last_name1,first_name2,last_name2,ssn1,ssn2,employment1,employment2,accounttype,username) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?)");
                statement.setString(1,allApps.getEmail());
                statement.setString(2,names1[0]);
                statement.setString(3,names1[1]);
                if(fullname2 != null){
                    statement.setString(4,names2[0]);
                    statement.setString(5,names2[1]);
                }
                else{
                    statement.setString(4,null);
                    statement.setString(5,null);
                }
                statement.setString(6,allApps.getSsn());
                statement.setString(7,allApps.getSsn2());
                statement.setString(8,allApps.getEmployment());
                statement.setString(9,allApps.getEmployment2());
                statement.setInt(10, allApps.getAccountType());
                statement.setString(11,allApps.getUsername());
                statement.executeUpdate();
            } else {
                String fullname1 = allApps.getFullname();
                String fullname2 = allApps.getFullname2();
                String[]names1 = fullname1.split(" ");
                String[]names2 = fullname2.split(" ");
                PreparedStatement statement = conn.prepareStatement("UPDATE applications SET email = ? ,first_name1 = ?,last_name1 = ?,first_name2 = ?,last_name2 = ?,ssn1 = ?,ssn2 = ?,employment1 = ?," +
                        "employment2 = ?,accounttype = ?,username = ? WHERE id = ?");
                statement.setString(1,allApps.getEmail());
                statement.setString(2,names1[0]);
                statement.setString(3,names1[1]);
                statement.setString(4,names2[0]);
                statement.setString(5,names2[1]);
                statement.setString(6,allApps.getSsn());
                statement.setString(7,allApps.getSsn2());
                statement.setString(8,allApps.getEmployment());
                statement.setString(9,allApps.getEmployment2());
                statement.setInt(10, allApps.getAccountType());
                statement.setString(11,allApps.getUsername());
                statement.setInt(12,allApps.getId());
                statement.executeUpdate();
            }
        }
    }

    public static void writeBankAccounts(AllBankAccounts allBankAccounts) throws SQLException{
//        try {
//            out = new ObjectOutputStream(new FileOutputStream("resources/bankaccdata"));
//            out.writeObject(allBankAccounts);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (out != null){
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        for(BankAccount ba:allBankAccounts.getBankaccs()){
            if(ba.getId() == -1){
                for(BankAccount.AccountTypes at:ba.getAccountTypeList()){
                    PreparedStatement statement = conn.prepareStatement("INSERT INTO accounts (accountnumber,accounttype,balance) VALUES (?,?,?)");
                    statement.setInt(1,Integer.parseInt(ba.getAccountNumber()));
                    statement.setInt(2,at.getValue());
                    statement.setDouble(3,ba.getAccountBalance(at));
                    statement.executeUpdate();


                    statement = conn.prepareStatement("SELECT id FROM accounts WHERE accountnumber = ?");
                    statement.setInt(1,Integer.parseInt(ba.getAccountNumber()));
                    ResultSet resultSet = statement.executeQuery();
                    int accountId = -1;
                    if(resultSet.next()) accountId = resultSet.getInt("id");

                    statement = conn.prepareStatement("SELECT id FROM profiles WHERE username = ?");
                    statement.setString(1,ba.getUsername());
                    resultSet = statement.executeQuery();
                    int profileId = -1;
                    while(resultSet.next()) {
                        profileId = resultSet.getInt("id");
                        statement = conn.prepareStatement("INSERT INTO accountsprofiles (accountid,profileid) VALUES (?,?)");
                        statement.setInt(1,accountId);
                        statement.setInt(2,profileId);
                        statement.executeUpdate();
                    }
                }
            }
            else{
                for(BankAccount.AccountTypes at:ba.getAccountTypeList()) {
                    PreparedStatement statement = conn.prepareStatement("UPDATE accounts SET accountnumber = ?, accounttype = ?, balance = ? WHERE id = ? ");
                    statement.setInt(1, Integer.parseInt(ba.getAccountNumber()));
                    statement.setInt(2, at.getValue());
                    statement.setDouble(3, ba.getAccountBalance(at));
                    statement.setInt(4,ba.getId());
                    statement.executeUpdate();
//                    statement = conn.prepareStatement("UPDATE accountsprofiles SET profileid = ? WHERE accountid = ?");
//                    statement.setInt(1,allBankProfiles.extractProfile(ba.getUsername()).getId());
//                    statement.setInt(2,ba.getId());
//                    statement.executeUpdate();
                }
            }
        }
    }

    public static void writeBankProfiles(AllBankProfiles allBankProfiles) throws SQLException {
//        try {
//            out = new ObjectOutputStream(new FileOutputStream("resources/bankprodata"));
//            out.writeObject(allBankProfiles);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (out != null){
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        for(BankProfile bp:allBankProfiles.getBankpros()){
            if(bp.getId() == -1){
                if(bp.getFullname2() == null){
                    String fullName = bp.getFullname();
                    String[] names = fullName.split(" " );
                    PreparedStatement statement = conn.prepareStatement("INSERT INTO profiles (username,email,first_name,last_name,ssn,employment,accesslevel,password) VALUES (?,?,?,?,?,?,?,?)");
                    statement.setString(1,bp.getUsername());
                    statement.setString(2,bp.getEmail());
                    statement.setString(3,names[0]);
                    statement.setString(4,names[1]);
                    statement.setString(5,bp.getSsn());
                    statement.setString(6,bp.getEmployment());
                    statement.setInt(7,bp.getUser().getI());
                    statement.setString(8,accounts.getPassword(bp.getUser(),bp.getUsername()));
                    statement.executeUpdate();
                }
                else{
                    String fullName = bp.getFullname();
                    String[] names = fullName.split(" " );
                    PreparedStatement statement = conn.prepareStatement("INSERT INTO profiles (username,email,first_name,last_name,ssn,employment,accesslevel,password) VALUES (?,?,?,?,?,?,?,?)");
                    statement.setString(1,bp.getUsername());
                    statement.setString(2,bp.getEmail());
                    statement.setString(3,names[0]);
                    statement.setString(4,names[1]);
                    statement.setString(5,bp.getSsn());
                    statement.setString(6,bp.getEmployment());
                    statement.setInt(7,bp.getUser().getI());
                    statement.setString(8,accounts.getPassword(bp.getUser(),bp.getUsername()));
                    statement.executeUpdate();
                    fullName = bp.getFullname2();
                    names = fullName.split(" " );
                    statement = conn.prepareStatement("INSERT INTO profiles (username,email,first_name,last_name,ssn,employment,accesslevel,password) VALUES (?,?,?,?,?,?,?,?)");
                    statement.setString(1,bp.getUsername());
                    statement.setString(2,bp.getEmail());
                    statement.setString(3,names[0]);
                    statement.setString(4,names[1]);
                    statement.setString(5,bp.getSsn2());
                    statement.setString(6,bp.getEmployment2());
                    statement.setInt(7,bp.getUser().getI());
                    statement.setString(8,accounts.getPassword(bp.getUser(),bp.getUsername()));
                    statement.executeUpdate();
                }
            }
            else{
                if(bp.getFullname2() == null){
                    String fullName = bp.getFullname();
                    String[] names = fullName.split(" " );
                    PreparedStatement statement = conn.prepareStatement("UPDATE profiles SET username = ?,email = ?,first_name = ?,last_name = ?,ssn = ?,employment = ?,accesslevel = ?,password = ? WHERE id = ? ");
                    statement.setString(1,bp.getUsername());
                    statement.setString(2,bp.getEmail());
                    statement.setString(3,names[0]);
                    statement.setString(4,names[1]);
                    statement.setString(5,bp.getSsn());
                    statement.setString(6,bp.getEmployment());
                    statement.setInt(7,bp.getUser().getI());
                    statement.setString(8,accounts.getPassword(bp.getUser(),bp.getUsername()));
                    statement.setInt(9,bp.getId());
                    statement.executeUpdate();
                }
                else{
                    String fullName = bp.getFullname();
                    String[] names = fullName.split(" " );
                    PreparedStatement statement = conn.prepareStatement("UPDATE profiles SET username = ?,email = ?,first_name = ?,last_name = ?,ssn = ?,employment = ?,accesslevel = ?,password = ? WHERE id = ? ");
                    statement.setString(1,bp.getUsername());
                    statement.setString(2,bp.getEmail());
                    statement.setString(3,names[0]);
                    statement.setString(4,names[1]);
                    statement.setString(5,bp.getSsn());
                    statement.setString(6,bp.getEmployment());
                    statement.setInt(7,bp.getUser().getI());
                    statement.setString(8,accounts.getPassword(bp.getUser(),bp.getUsername()));
                    statement.setInt(9,bp.getId());
                    statement.executeUpdate();
                    fullName = bp.getFullname2();
                    names = fullName.split(" " );
                    statement = conn.prepareStatement("UPDATE profiles SET username = ?,email = ?,first_name = ?,last_name = ?,ssn = ?,employment = ?,accesslevel = ?,password = ? WHERE id = ? ");
                    statement.setString(1,bp.getUsername());
                    statement.setString(2,bp.getEmail());
                    statement.setString(3,names[0]);
                    statement.setString(4,names[1]);
                    statement.setString(5,bp.getSsn2());
                    statement.setString(6,bp.getEmployment2());
                    statement.setInt(7,bp.getUser().getI());
                    statement.setString(8,accounts.getPassword(bp.getUser(),bp.getUsername()));
                    statement.setInt(9,bp.getId());
                    statement.executeUpdate();
                }
            }
        }
    }
}
