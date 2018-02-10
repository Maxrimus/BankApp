package com.ex;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void Login1(){
        Main m = new Main();
        String expected = "Welcome Joe Tursi";
        String username = "Maxrimus";
        String password = "password";
        Assert.assertEquals(expected,m.Login(username,password));
    }

    @Test
    public void Login2(){
        Main m = new Main();
        String expected = "Invalid Username or Password. Please Try Again.";
        String username = "Maxrimus";
        String password = "passw0rd";
        Assert.assertEquals(expected,m.Login(username,password));
    }

    @Test
    public void Login3(){
        Main m = new Main();
        String expected = "Invalid Username or Password. Please Try Again.";
        String username = "Maxrimus";
        String password = "password1";
        Assert.assertEquals(expected,m.Login(username,password));
    }

    @Test
    public void Login4(){
        Main m = new Main();
        String expected = "Invalid Username or Password. Please Try Again.";
        String username = "Maxrmus";
        String password = "password";
        Assert.assertEquals(expected,m.Login(username,password));
    }

    @Test
    public void Login5(){
        Main m = new Main();
        String expected = "Invalid Username or Password. Please Try Again.";
        String username = "";
        String password = "password";
        Assert.assertEquals(expected,m.Login(username,password));
    }

    @Test
    public void Login6(){
        Main m = new Main();
        String expected = "Invalid Username or Password. Please Try Again.";
        String username = "Maxrmus";
        String password = "";
        Assert.assertEquals(expected,m.Login(username,password));
    }

    @Test
    public void Login7(){
        Main m = new Main();
        String expected = "Invalid Username or Password. Please Try Again.";
        String username = "";
        String password = "";
        Assert.assertEquals(expected,m.Login(username,password));
    }

    @Test
    public void LockOut1(){
        String expected = "Account Locked. Please call the support number.";
        String username = "Maxrmus";
        String password = "password";
        m.Login(username,password);
        m.Login(username,password);
        m.Login(username,password);
        m.Login(username,password);
        Assert.assertEquals(expected,m.Login(username,password));
    }

    @Test
    public void LockOut2(){
        String expected = "Account Locked. Please call the support number.";
        String username = "Maxrmus";
        String password = "password";
        String username2 = "Mxrimus";
        m.Login(username,password);
        m.Login(username,password);
        m.Login(username,password);
        m.Login(username,password);
        m.Login(username2,password);
        Assert.assertEquals(expected,m.Login(username,password));
    }

    @Test
    public void LockOut3(){
        String expected = "Account Locked. Please call the support number.";
        String username = "Maxrmus";
        String password = "password";
        String username2 = "Maxrimus"
        m.Login(username,password);
        m.Login(username,password);
        m.Login(username,password);
        m.Login(username,password);
        m.Login(username2,password);
        Assert.assertEquals(expected,m.Login(username,password));
    }

    @Test
    public void LockOut4(){
        String expected = "Incorrect Username or Password. Please Try Again.";
        String username = "Maxrimus";
        String password = "passw0rd";
        String password2 = "password";
        m.Login(username,password);
        m.Login(username,password);
        m.Login(username,password);
        m.Login(username,password);
        m.Login(username,password2);
        Assert.assertEquals(expected,m.Login(username,password));
    }

    @Test
    public void PassWordResetQuestions1(){
        String expected = "Reset your password.";
        String answer1 = "Cat";
        String answer2 = "McMother";
        Assert.assertEquals(expected,m.CheckAnswers(answer1,answer2));
    }

    @Test
    public void PassWordResetQuestions2(){
        String expected = "Answer Incorrect.";
        String answer1 = "Ct";
        String answer2 = "McMother";
        Assert.assertEquals(expected,m.CheckAnswers(answer1,answer2));
    }

    @Test
    public void PassWordResetQuestions3(){
        String expected = "Account Locked. Please call the support number.";
        String answer1 = "Ct";
        String answer2 = "McMother";
        m.CheckAnswers(answer1,answer2);
        m.CheckAnswers(answer1,answer2);
        Assert.assertEquals(expected,m.CheckAnswers(answer1,answer2));
    }

    @Test
    public void PassWordResetQuestions4(){
        String expected = "Account Locked. Please call the support number.";
        String answer1 = "";
        String answer2 = "McMother";
        m.CheckAnswers(answer1,answer2);
        m.CheckAnswers(answer1,answer2);
        Assert.assertEquals(expected,m.CheckAnswers(answer1,answer2));
    }

    @Test
    public void PassWordResetQuestions5(){
        String expected = "Account Locked. Please call the support number.";
        String answer1 = "Cat";
        String answer2 = "";
        m.CheckAnswers(answer1,answer2);
        m.CheckAnswers(answer1,answer2);
        Assert.assertEquals(expected,m.CheckAnswers(answer1,answer2));
    }

    @Test
    public void PassWordResetQuestions6(){
        String expected = "Account Locked. Please call the support number.";
        String answer1 = "";
        String answer2 = "";
        m.CheckAnswers(answer1,answer2);
        m.CheckAnswers(answer1,answer2);
        Assert.assertEquals(expected,m.CheckAnswers(answer1,answer2));
    }

    @Test
    public void PassWordReset1(){
        Boolean expected = true;
        String password1 = "wordpass";
        String password2 = "wordpass";
        Assert.assertEquals(expected,m.checkPasswords(password1,password2));
    }

    @Test
    public void PassWordReset2(){
        Boolean expected = false;
        String password1 = "wordpass";
        String password2 = "wrdpass";
        Assert.assertEquals(expected,m.checkPasswords(password1,password2));
    }

    @Test
    public void PassWordReset3(){
        Boolean expected = false;
        String password1 = "";
        String password2 = "wordpass";
        Assert.assertEquals(expected,m.checkPasswords(password1,password2));
    }

    @Test
    public void PassWordReset4(){
        Boolean expected = false;
        String password1 = "wordpass";
        String password2 = "";
        Assert.assertEquals(expected,m.checkPasswords(password1,password2));
    }

    @Test
    public void PassWordReset5(){
        Boolean expected = false;
        String password1 = "";
        String password2 = "";
        Assert.assertEquals(expected,m.checkPasswords(password1,password2));
    }

    @Test
    public void UserNameAvailable1(){
        Boolean expected = true;
        String username = "JimmyN";
        Assert.assertEquals(expected,m.CheckAvailability(username));
    }

    @Test
    public void UserNameAvailable2(){
        Boolean expected = false;
        String username = "Maxrimus";
        Assert.assertEquals(expected,m.CheckAvailability(username));
    }

    @Test
    public void UserNameAvailable3(){
        Boolean expected = false;
        String username = "";
        Assert.assertEquals(expected,m.CheckAvailability(username));
    }

    @Test
    public void ValidEmail1(){
        Boolean expected = true;
        String email = "joe.p.tursi@gmail.com";
        Assert.assertEquals(expected,m.validateEmail(email));
    }

    @Test
    public void ValidEmail2(){
        Boolean expected = false;
        String email = "j";
        Assert.assertEquals(expected,m.validateEmail(email));
    }

    @Test
    public void ValidEmail3(){
        Boolean expected = false;
        String email = "";
        Assert.assertEquals(expected,m.validateEmail(email));
    }

    @Test
    public void EmailInSystem1(){
        Boolean expected = false;
        String email = "john.smith@aol.com";
        Assert.assertEquals(expected,m.emailInSystem(email));
    }

    @Test
    public void EmailInSystem2(){
        Boolean expected = true;
        String email = "joe.p.tursi@gmail.com";
        Assert.assertEquals(expected,m.emailInSystem(email));
    }

    @Test
    public void EmailInSystem3(){
        Boolean expected = true;
        String email = "";
        Assert.assertEquals(expected,m.emailInSystem(email));
    }

    @Test
    public void passWordStructure1(){
        Boolean expected = true;
        String password = "Sghjt;123";
        Assert.assertEquals(expected,m.checkPassWordStructure(password));
    }

    @Test
    public void passWordStructure2(){
        Boolean expected = false;
        String password = "sghjt;123";
        Assert.assertEquals(expected,m.checkPassWordStructure(password));
    }

    @Test
    public void passWordStructure3(){
        Boolean expected = false;
        String password = "SGHJT;123";
        Assert.assertEquals(expected,m.checkPassWordStructure(password));
    }

    @Test
    public void passWordStructure4(){
        Boolean expected = false;
        String password = "Sghjt;lse";
        Assert.assertEquals(expected,m.checkPassWordStructure(password));
    }

    @Test
    public void passWordStructure5(){
        Boolean expected = false;
        String password = "Sghjt123";
        Assert.assertEquals(expected,m.checkPassWordStructure(password));
    }

    @Test
    public void passWordStructure6(){
        Boolean expected = false;
        String password = "2Ghjt;";
        Assert.assertEquals(expected,m.checkPassWordStructure(password));
    }

    @Test
    public void passWordStructure7(){
        Boolean expected = false;
        String password = "Sghjt ;123";
        Assert.assertEquals(expected,m.checkPassWordStructure(password));
    }

    @Test
    public void passWordStructure8(){
        Boolean expected = false;
        String password = "";
        Assert.assertEquals(expected,m.checkPassWordStructure(password));
    }

    @Test
    public void nameCheck1(){
        Boolean expected = true;
        String name = "Joseph";
        Assert.assertEquals(expected,m.checkName(name));
    }

    @Test
    public void nameCheck2(){
        Boolean expected = false;
        String name = "Jos eph";
        Assert.assertEquals(expected,m.checkName(name));
    }

    @Test
    public void nameCheck3(){
        Boolean expected = false;
        String name = "Joseph1";
        Assert.assertEquals(expected,m.checkName(name));
    }

    @Test
    public void nameCheck4(){
        Boolean expected = false;
        String name = "";
        Assert.assertEquals(expected,m.checkName(name));
    }

    @Test
    public void ssnCheck1(){
        Boolean expected = true;
        String ssn = "123-45-6789";
        Assert.assertEquals(expected,m.checkSSN(ssn));
    }

    @Test
    public void ssnCheck2(){
        Boolean expected = false;
        String ssn = "123-45-678";
        Assert.assertEquals(expected,m.checkSSN(ssn));
    }

    @Test
    public void ssnCheck3(){
        Boolean expected = false;
        String ssn = "123-4-6789";
        Assert.assertEquals(expected,m.checkSSN(ssn));
    }

    @Test
    public void ssnCheck4(){
        Boolean expected = false;
        String ssn = "12-45-6789";
        Assert.assertEquals(expected,m.checkSSN(ssn));
    }

    @Test
    public void ssnCheck5(){
        Boolean expected = false;
        String ssn = "123-45-67890";
        Assert.assertEquals(expected,m.checkSSN(ssn));
    }

    @Test
    public void ssnCheck6(){
        Boolean expected = false;
        String ssn = "";
        Assert.assertEquals(expected,m.checkSSN(ssn));
    }
}