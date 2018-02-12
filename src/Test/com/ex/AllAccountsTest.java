package com.ex;

import org.junit.Assert;
import org.junit.Test;

public class AllAccountsTest {

    AllAccounts a = AllAccounts.getAccounts();

    @Test
    public void testDoesUserExist1(){
        String username = "a";
        User user = User.Customer;
        Assert.assertTrue(a.doesUserExist(user,username));
    }

    @Test
    public void testDoesUserExist2(){
        String username = "calzhe";
        User user = User.Employee;
        Assert.assertTrue(a.doesUserExist(user,username));
    }

    @Test
    public void testDoesUserExist3(){
        String username = "august";
        User user = User.Admin;
        Assert.assertTrue(a.doesUserExist(user,username));
    }

    @Test
    public void testDoesUserExist4(){
        String username = "a";
        User user = User.Employee;
        Assert.assertFalse(a.doesUserExist(user,username));
    }

    @Test
    public void testDoesUserExist5(){
        String username = "calzhe";
        User user = User.Admin;
        Assert.assertFalse(a.doesUserExist(user,username));
    }

    @Test
    public void testDoesUserExist6(){
        String username = "august";
        User user = User.Customer;
        Assert.assertFalse(a.doesUserExist(user,username));
    }

    @Test
    public void testDoesUserExist7(){
        String username = "d";
        User user = User.Customer;
        Assert.assertFalse(a.doesUserExist(user,username));
    }

    @Test
    public void testDoesUserExist8(){
        String username = "calzeh";
        User user = User.Employee;
        Assert.assertFalse(a.doesUserExist(user,username));
    }

    @Test
    public void testDoesUserExist9(){
        String username = "aaugust";
        User user = User.Admin;
        Assert.assertFalse(a.doesUserExist(user,username));
    }

    @Test
    public void testDoesUserExist10(){
        String username = "";
        User user = User.Customer;
        Assert.assertFalse(a.doesUserExist(user,username));
    }

    @Test
    public void testDoesUserExist11(){
        String username = "";
        User user = User.Employee;
        Assert.assertFalse(a.doesUserExist(user,username));
    }

    @Test
    public void testDoesUserExist12(){
        String username = "";
        User user = User.Admin;
        Assert.assertFalse(a.doesUserExist(user,username));
    }

    @Test
    public void testDoesPassMatch1(){
        User user = User.Customer;
        String username = "a";
        String password = "1";
        Assert.assertTrue(a.doesPassMatch(user,username,password));
    }

    @Test
    public void testDoesPassMatch2(){
        User user = User.Employee;
        String username = "calzhe";
        String password = "password";
        Assert.assertTrue(a.doesPassMatch(user,username,password));
    }

    @Test
    public void testDoesPassMatch3(){
        User user = User.Admin;
        String username = "august";
        String password = "password";
        Assert.assertTrue(a.doesPassMatch(user,username,password));
    }

    @Test
    public void testDoesPassMatch4(){
        User user = User.Employee;
        String username = "a";
        String password = "1";
        Assert.assertFalse(a.doesPassMatch(user,username,password));
    }

    @Test
    public void testDoesPassMatch5(){
        User user = User.Admin;
        String username = "calzhe";
        String password = "password";
        Assert.assertFalse(a.doesPassMatch(user,username,password));
    }

    @Test
    public void testDoesPassMatch6(){
        User user = User.Customer;
        String username = "august";
        String password = "password";
        Assert.assertFalse(a.doesPassMatch(user,username,password));
    }

    @Test
    public void testDoesPassMatch7(){
        User user = User.Customer;
        String username = "a";
        String password = "2";
        Assert.assertFalse(a.doesPassMatch(user,username,password));
    }

    @Test
    public void testDoesPassMatch8(){
        User user = User.Employee;
        String username = "calzhe";
        String password = "pssword";
        Assert.assertFalse(a.doesPassMatch(user,username,password));
    }

    @Test
    public void testDoesPassMatch9(){
        User user = User.Admin;
        String username = "august";
        String password = "pssword";
        Assert.assertFalse(a.doesPassMatch(user,username,password));
    }

    @Test
    public void testDoesPassMatch10(){
        User user = User.Admin;
        String username = "august";
        String password = "";
        Assert.assertFalse(a.doesPassMatch(user,username,password));
    }

    @Test
    public void testDoesPassMatch11(){
        User user = User.Admin;
        String username = "";
        String password = "password";
        Assert.assertFalse(a.doesPassMatch(user,username,password));
    }

    @Test
    public void testDoesPassMatch12(){
        User user = User.Admin;
        String username = "";
        String password = "";
        Assert.assertFalse(a.doesPassMatch(user,username,password));
    }
}
