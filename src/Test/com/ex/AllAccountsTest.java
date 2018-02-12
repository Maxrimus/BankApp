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
}
