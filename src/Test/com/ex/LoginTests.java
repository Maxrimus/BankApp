package com.ex;

import org.junit.Assert;
import org.junit.Test;

public class LoginTests {

    Login l = new Login(User.Employee);

    @Test
    public void testLogin1(){
        String username = "calzhe";
        String password = "password";
        Assert.assertTrue(l.login(username, password));
    }

    @Test
    public void testLogin2(){
        String username = "calzhe";
        String password = "pssword";
        Assert.assertFalse(l.login(username, password));
    }

    @Test
    public void testLogin3(){
        String username = "calzh";
        String password = "password";
        Assert.assertFalse(l.login(username, password));
    }

    @Test
    public void testLogin4(){
        String username = "calzhe";
        String password = "";
        Assert.assertFalse(l.login(username, password));
    }

    @Test
    public void testLogin5(){
        String username = "";
        String password = "password";
        Assert.assertFalse(l.login(username, password));
    }

    @Test
    public void testLogin6(){
        String username = "";
        String password = "";
        Assert.assertFalse(l.login(username, password));
    }
}
