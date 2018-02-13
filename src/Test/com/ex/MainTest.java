//package com.ex;
//
//import com.sun.org.apache.xpath.internal.operations.Bool;
//import org.junit.Assert;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class MainTest {
//
//    @Test
//    public void Login1(){
//        Main m = new Main();
//        String expected = "Welcome Joe Tursi";
//        String username = "Maxrimus";
//        String password = "password";
//        Assert.assertEquals(expected,m.Login(username,password));
//    }
//
//    @Test
//    public void Login2(){
//        Main m = new Main();
//        String expected = "Invalid Username or Password. Please Try Again.";
//        String username = "Maxrimus";
//        String password = "passw0rd";
//        Assert.assertEquals(expected,m.Login(username,password));
//    }
//
//    @Test
//    public void Login3(){
//        Main m = new Main();
//        String expected = "Invalid Username or Password. Please Try Again.";
//        String username = "Maxrimus";
//        String password = "password1";
//        Assert.assertEquals(expected,m.Login(username,password));
//    }
//
//    @Test
//    public void Login4(){
//        Main m = new Main();
//        String expected = "Invalid Username or Password. Please Try Again.";
//        String username = "Maxrmus";
//        String password = "password";
//        Assert.assertEquals(expected,m.Login(username,password));
//    }
//
//    @Test
//    public void Login5(){
//        Main m = new Main();
//        String expected = "Invalid Username or Password. Please Try Again.";
//        String username = "";
//        String password = "password";
//        Assert.assertEquals(expected,m.Login(username,password));
//    }
//
//    @Test
//    public void Login6(){
//        Main m = new Main();
//        String expected = "Invalid Username or Password. Please Try Again.";
//        String username = "Maxrmus";
//        String password = "";
//        Assert.assertEquals(expected,m.Login(username,password));
//    }
//
//    @Test
//    public void Login7(){
//        Main m = new Main();
//        String expected = "Invalid Username or Password. Please Try Again.";
//        String username = "";
//        String password = "";
//        Assert.assertEquals(expected,m.Login(username,password));
//    }
//
//    @Test
//    public void LockOut1(){
//        String expected = "Account Locked. Please call the support number.";
//        String username = "Maxrmus";
//        String password = "password";
//        m.Login(username,password);
//        m.Login(username,password);
//        m.Login(username,password);
//        m.Login(username,password);
//        Assert.assertEquals(expected,m.Login(username,password));
//    }
//
//    @Test
//    public void LockOut2(){
//        String expected = "Account Locked. Please call the support number.";
//        String username = "Maxrmus";
//        String password = "password";
//        String username2 = "Mxrimus";
//        m.Login(username,password);
//        m.Login(username,password);
//        m.Login(username,password);
//        m.Login(username,password);
//        m.Login(username2,password);
//        Assert.assertEquals(expected,m.Login(username,password));
//    }
//
//    @Test
//    public void LockOut3(){
//        String expected = "Account Locked. Please call the support number.";
//        String username = "Maxrmus";
//        String password = "password";
//        String username2 = "Maxrimus"
//        m.Login(username,password);
//        m.Login(username,password);
//        m.Login(username,password);
//        m.Login(username,password);
//        m.Login(username2,password);
//        Assert.assertEquals(expected,m.Login(username,password));
//    }
//
//    @Test
//    public void LockOut4(){
//        String expected = "Incorrect Username or Password. Please Try Again.";
//        String username = "Maxrimus";
//        String password = "passw0rd";
//        String password2 = "password";
//        m.Login(username,password);
//        m.Login(username,password);
//        m.Login(username,password);
//        m.Login(username,password);
//        m.Login(username,password2);
//        Assert.assertEquals(expected,m.Login(username,password));
//    }
//
//    @Test
//    public void PassWordResetQuestions1(){
//        String expected = "Reset your password.";
//        String answer1 = "Cat";
//        String answer2 = "McMother";
//        Assert.assertEquals(expected,m.CheckAnswers(answer1,answer2));
//    }
//
//    @Test
//    public void PassWordResetQuestions2(){
//        String expected = "Answer Incorrect.";
//        String answer1 = "Ct";
//        String answer2 = "McMother";
//        Assert.assertEquals(expected,m.CheckAnswers(answer1,answer2));
//    }
//
//    @Test
//    public void PassWordResetQuestions3(){
//        String expected = "Account Locked. Please call the support number.";
//        String answer1 = "Ct";
//        String answer2 = "McMother";
//        m.CheckAnswers(answer1,answer2);
//        m.CheckAnswers(answer1,answer2);
//        Assert.assertEquals(expected,m.CheckAnswers(answer1,answer2));
//    }
//
//    @Test
//    public void PassWordResetQuestions4(){
//        String expected = "Account Locked. Please call the support number.";
//        String answer1 = "";
//        String answer2 = "McMother";
//        m.CheckAnswers(answer1,answer2);
//        m.CheckAnswers(answer1,answer2);
//        Assert.assertEquals(expected,m.CheckAnswers(answer1,answer2));
//    }
//
//    @Test
//    public void PassWordResetQuestions5(){
//        String expected = "Account Locked. Please call the support number.";
//        String answer1 = "Cat";
//        String answer2 = "";
//        m.CheckAnswers(answer1,answer2);
//        m.CheckAnswers(answer1,answer2);
//        Assert.assertEquals(expected,m.CheckAnswers(answer1,answer2));
//    }
//
//    @Test
//    public void PassWordResetQuestions6(){
//        String expected = "Account Locked. Please call the support number.";
//        String answer1 = "";
//        String answer2 = "";
//        m.CheckAnswers(answer1,answer2);
//        m.CheckAnswers(answer1,answer2);
//        Assert.assertEquals(expected,m.CheckAnswers(answer1,answer2));
//    }
//
//    @Test
//    public void PassWordReset1(){
//        Boolean expected = true;
//        String password1 = "wordpass";
//        String password2 = "wordpass";
//        Assert.assertEquals(expected,m.checkPasswords(password1,password2));
//    }
//
//    @Test
//    public void PassWordReset2(){
//        Boolean expected = false;
//        String password1 = "wordpass";
//        String password2 = "wrdpass";
//        Assert.assertEquals(expected,m.checkPasswords(password1,password2));
//    }
//
//    @Test
//    public void PassWordReset3(){
//        Boolean expected = false;
//        String password1 = "";
//        String password2 = "wordpass";
//        Assert.assertEquals(expected,m.checkPasswords(password1,password2));
//    }
//
//    @Test
//    public void PassWordReset4(){
//        Boolean expected = false;
//        String password1 = "wordpass";
//        String password2 = "";
//        Assert.assertEquals(expected,m.checkPasswords(password1,password2));
//    }
//
//    @Test
//    public void PassWordReset5(){
//        Boolean expected = false;
//        String password1 = "";
//        String password2 = "";
//        Assert.assertEquals(expected,m.checkPasswords(password1,password2));
//    }
//
//    @Test
//    public void UserNameAvailable1(){
//        Boolean expected = true;
//        String username = "JimmyN";
//        Assert.assertEquals(expected,m.CheckAvailability(username));
//    }
//
//    @Test
//    public void UserNameAvailable2(){
//        Boolean expected = false;
//        String username = "Maxrimus";
//        Assert.assertEquals(expected,m.CheckAvailability(username));
//    }
//
//    @Test
//    public void UserNameAvailable3(){
//        Boolean expected = false;
//        String username = "";
//        Assert.assertEquals(expected,m.CheckAvailability(username));
//    }
//
//    @Test
//    public void ValidEmail1(){
//        Boolean expected = true;
//        String email = "joe.p.tursi@gmail.com";
//        Assert.assertEquals(expected,m.validateEmail(email));
//    }
//
//    @Test
//    public void ValidEmail2(){
//        Boolean expected = false;
//        String email = "j";
//        Assert.assertEquals(expected,m.validateEmail(email));
//    }
//
//    @Test
//    public void ValidEmail3(){
//        Boolean expected = false;
//        String email = "";
//        Assert.assertEquals(expected,m.validateEmail(email));
//    }
//
//    @Test
//    public void EmailInSystem1(){
//        Boolean expected = false;
//        String email = "john.smith@aol.com";
//        Assert.assertEquals(expected,m.emailInSystem(email));
//    }
//
//    @Test
//    public void EmailInSystem2(){
//        Boolean expected = true;
//        String email = "joe.p.tursi@gmail.com";
//        Assert.assertEquals(expected,m.emailInSystem(email));
//    }
//
//    @Test
//    public void EmailInSystem3(){
//        Boolean expected = true;
//        String email = "";
//        Assert.assertEquals(expected,m.emailInSystem(email));
//    }
//
//    @Test
//    public void passWordStructure1(){
//        Boolean expected = true;
//        String password = "Sghjt;123";
//        Assert.assertEquals(expected,m.checkPassWordStructure(password));
//    }
//
//    @Test
//    public void passWordStructure2(){
//        Boolean expected = false;
//        String password = "sghjt;123";
//        Assert.assertEquals(expected,m.checkPassWordStructure(password));
//    }
//
//    @Test
//    public void passWordStructure3(){
//        Boolean expected = false;
//        String password = "SGHJT;123";
//        Assert.assertEquals(expected,m.checkPassWordStructure(password));
//    }
//
//    @Test
//    public void passWordStructure4(){
//        Boolean expected = false;
//        String password = "Sghjt;lse";
//        Assert.assertEquals(expected,m.checkPassWordStructure(password));
//    }
//
//    @Test
//    public void passWordStructure5(){
//        Boolean expected = false;
//        String password = "Sghjt123";
//        Assert.assertEquals(expected,m.checkPassWordStructure(password));
//    }
//
//    @Test
//    public void passWordStructure6(){
//        Boolean expected = false;
//        String password = "2Ghjt;";
//        Assert.assertEquals(expected,m.checkPassWordStructure(password));
//    }
//
//    @Test
//    public void passWordStructure7(){
//        Boolean expected = false;
//        String password = "Sghjt ;123";
//        Assert.assertEquals(expected,m.checkPassWordStructure(password));
//    }
//
//    @Test
//    public void passWordStructure8(){
//        Boolean expected = false;
//        String password = "";
//        Assert.assertEquals(expected,m.checkPassWordStructure(password));
//    }
//
//    @Test
//    public void nameCheck1(){
//        Boolean expected = true;
//        String name = "Joseph";
//        Assert.assertEquals(expected,m.checkName(name));
//    }
//
//    @Test
//    public void nameCheck2(){
//        Boolean expected = false;
//        String name = "Jos eph";
//        Assert.assertEquals(expected,m.checkName(name));
//    }
//
//    @Test
//    public void nameCheck3(){
//        Boolean expected = false;
//        String name = "Joseph1";
//        Assert.assertEquals(expected,m.checkName(name));
//    }
//
//    @Test
//    public void nameCheck4(){
//        Boolean expected = false;
//        String name = "";
//        Assert.assertEquals(expected,m.checkName(name));
//    }
//
//    @Test
//    public void ssnCheck1(){
//        Boolean expected = true;
//        String ssn = "123-45-6789";
//        Assert.assertEquals(expected,m.checkSSN(ssn));
//    }
//
//    @Test
//    public void ssnCheck2(){
//        Boolean expected = false;
//        String ssn = "123-45-678";
//        Assert.assertEquals(expected,m.checkSSN(ssn));
//    }
//
//    @Test
//    public void ssnCheck3(){
//        Boolean expected = false;
//        String ssn = "123-4-6789";
//        Assert.assertEquals(expected,m.checkSSN(ssn));
//    }
//
//    @Test
//    public void ssnCheck4(){
//        Boolean expected = false;
//        String ssn = "12-45-6789";
//        Assert.assertEquals(expected,m.checkSSN(ssn));
//    }
//
//    @Test
//    public void ssnCheck5(){
//        Boolean expected = false;
//        String ssn = "123-45-67890";
//        Assert.assertEquals(expected,m.checkSSN(ssn));
//    }
//
//    @Test
//    public void ssnCheck6(){
//        Boolean expected = false;
//        String ssn = "";
//        Assert.assertEquals(expected,m.checkSSN(ssn));
//    }
//
//    @Test
//    public void accountCheck1(){
//        Boolean expected = true;
//        String aNumber = "1234-5678-9012";
//        Assert.assertEquals(expected,m.accountConfirm(aNumber));
//    }
//
//    @Test
//    public void accountCheck2(){
//        Boolean expected = false;
//        String aNumber = "123-5678-9012";
//        Assert.assertEquals(expected,m.accountConfirm(aNumber));
//    }
//
//    @Test
//    public void accountCheck3(){
//        Boolean expected = false;
//        String aNumber = "1234-567-9012";
//        Assert.assertEquals(expected,m.accountConfirm(aNumber));
//    }
//
//    @Test
//    public void accountCheck4(){
//        Boolean expected = false;
//        String aNumber = "1234-5678-901";
//        Assert.assertEquals(expected,m.accountConfirm(aNumber));
//    }
//
//    @Test
//    public void accountCheck5(){
//        Boolean expected = false;
//        String aNumber = "";
//        Assert.assertEquals(expected,m.accountConfirm(aNumber));
//    }
//
//    @Test
//    public void cardCheck1(){
//        Boolean expected = true;
//        String cardNumber = "1234-5678-9012-3456";
//        Assert.assertEquals(expected,m.cardConfirm(cardNumber));
//    }
//
//    @Test
//    public void cardCheck2(){
//        Boolean expected = false;
//        String cardNumber = "123-5678-9012-3456";
//        Assert.assertEquals(expected,m.cardConfirm(cardNumber));
//    }
//
//    @Test
//    public void cardCheck3(){
//        Boolean expected = false;
//        String cardNumber = "1234-567-9012-3456";
//        Assert.assertEquals(expected,m.cardConfirm(cardNumber));
//    }
//
//    @Test
//    public void cardCheck4(){
//        Boolean expected = false;
//        String cardNumber = "1234-5678-901-3456";
//        Assert.assertEquals(expected,m.cardConfirm(cardNumber));
//    }
//
//    @Test
//    public void cardCheck5(){
//        Boolean expected = false;
//        String cardNumber = "1234-5678-9012-345";
//        Assert.assertEquals(expected,m.cardConfirm(cardNumber));
//    }
//
//    @Test
//    public void cardCheck6(){
//        Boolean expected = false;
//        String cardNumber = "";
//        Assert.assertEquals(expected,m.cardConfirm(cardNumber));
//    }
//
//    @Test
//    public void accountType1(){
//        String expected = "Confirm Account Type: Checking";
//        int choice = 1;
//        Assert.assertEquals(expected,m.accountType(choice));
//    }
//
//    @Test
//    public void accountType2(){
//        String expected = "Not a valid account type";
//        int choice = 11;
//        Assert.assertEquals(expected,m.accountType(choice));
//    }
//
//    @Test
//    public void accountType3(){
//        String expected = "Not a valid account type";
//        Integer choice = null;
//        Assert.assertEquals(expected,m.accountType(choice));
//    }
//
//    @Test
//    public void AcoountTypeConfirm1(){
//        String expected = "Account Type Confirmed";
//        String confirmation = "Yes";
//        Assert.assertEquals(expected,m.confirmAccountType(confirmation));
//    }
//
//    @Test
//    public void AcoountTypeConfirm2(){
//        String expected = "Account Type Not Confirmed. Please Choose New Account Type.";
//        String confirmation = "No";
//        Assert.assertEquals(expected,m.confirmAccountType(confirmation));
//    }
//
//    @Test
//    public void AcoountTypeConfirm3(){
//        String expected = "Account Type Not Confirmed. Please Choose New Account Type.";
//        String confirmation = "";
//        Assert.assertEquals(expected,m.confirmAccountType(confirmation));
//    }
//
//    @Test
//    public void securityQuestionSelect1(){
//        String expected = "Enter Answer: ";
//        int choice = 1;
//        Assert.assertEquals(expected,m.accountType(choice));
//    }
//
//    @Test
//    public void securityQuestionSelect2(){
//        String expected = "Not a valid number";
//        int choice = 11;
//        Assert.assertEquals(expected,m.accountType(choice));
//    }
//
//    @Test
//    public void securityQuestionSelect3(){
//        String expected = "Not a number";
//        Integer choice = null;
//        Assert.assertEquals(expected,m.accountType(choice));
//    }
//
//    @Test
//    public void SecurityAnswerCheck1(){
//        Boolean expected = true;
//        String answer = "Cranky";
//        Assert.assertEquals(expected,m.checkAnswer(answer));
//    }
//
//    @Test
//    public void SecurityAnswerCheck2(){
//        Boolean expected = false;
//        String answer = "";
//        Assert.assertEquals(expected,m.checkAnswer(answer));
//    }
//
//    @Test
//    public void checkDate1(){
//        Boolean expected = true;
//        String date = "11/02/1994";
//        Assert.assertEquals(expected,m.checkDate(date));
//    }
//
//    @Test
//    public void checkDate2(){
//        Boolean expected = false;
//        String date = "1/02/1994";
//        Assert.assertEquals(expected,m.checkDate(date));
//    }
//
//    @Test
//    public void checkDate3(){
//        Boolean expected = false;
//        String date = "01/2/1994";
//        Assert.assertEquals(expected,m.checkDate(date));
//    }
//
//    @Test
//    public void checkDate4(){
//        Boolean expected = false;
//        String date = "01/02/199";
//        Assert.assertEquals(expected,m.checkDate(date));
//    }
//
//    @Test
//    public void checkDate5(){
//        Boolean expected = false;
//        String date = "";
//        Assert.assertEquals(expected,m.checkDate(date));
//    }
//
//    @Test
//    public void checkAddress1(){
//        Boolean expected = true;
//        String address = "123 fake street";
//        Assert.assertEquals(expected,m.checkAddress(address));
//    }
//
//    @Test
//    public void checkAddress2(){
//        Boolean expected = false;
//        String address = "";
//        Assert.assertEquals(expected,m.checkAddress(address));
//    }
//
//    @Test
//    public void checkCity1(){
//        Boolean expected = true;
//        String city = "Townsville";
//        Assert.assertEquals(expected,m.checkCity(city));
//    }
//
//    @Test
//    public void checkCity2(){
//        Boolean expected = false;
//        String city = "";
//        Assert.assertEquals(expected,m.checkCity(city));
//    }
//
//    @Test
//    public void checkRegion1(){
//        Boolean expected = true;
//        String city = "Statesylvania";
//        Assert.assertEquals(expected,m.checkRegion(city));
//    }
//
//    @Test
//    public void checkRegion2(){
//        Boolean expected = false;
//        String city = "";
//        Assert.assertEquals(expected,m.checkRegion(city));
//    }
//
//    @Test
//    public void checkZIP1(){
//        Boolean expected = true;
//        String zip = "00000";
//        Assert.assertEquals(expected,m.checkZIP(zip));
//    }
//
//    @Test
//    public void checkZIP1(){
//        Boolean expected = false;
//        String zip = "0000a";
//        Assert.assertEquals(expected,m.checkZIP(zip));
//    }
//
//    @Test
//    public void checkZIP1(){
//        Boolean expected = false;
//        String zip = "";
//        Assert.assertEquals(expected,m.checkZIP(zip));
//    }
//
//    @Test
//    public void checkCountry1(){
//        Boolean expected = true;
//        String country = "Countrystan";
//        Assert.assertEquals(expected,m.checkCountry(country));
//    }
//
//    @Test
//    public void checkCountry2(){
//        Boolean expected = false;
//        String country = "";
//        Assert.assertEquals(expected,m.checkCountry(country));
//    }
//
//    @Test
//    public void compareNames1(){
//        Boolean expected = true;
//        String name1 = "Joseph Tursi";
//        String name2 = "Joseph Tursi";
//        Assert.assertEquals(expected,m.compareNames(name1,name2));
//    }
//
//    @Test
//    public void compareNames2(){
//        Boolean expected = false;
//        String name1 = "Joseph";
//        String name2 = "Joseph Tursi";
//        Assert.assertEquals(expected,m.compareNames(name1,name2));
//    }
//
//    @Test
//    public void compareNames3(){
//        Boolean expected = false;
//        String name1 = "Joseph Tursi";
//        String name2 = "Joseph";
//        Assert.assertEquals(expected,m.compareNames(name1,name2));
//    }
//
//    @Test
//    public void compareNames4(){
//        Boolean expected = false;
//        String name1 = "Joseph Turi";
//        String name2 = "Joseph Tursi";
//        Assert.assertEquals(expected,m.compareNames(name1,name2));
//    }
//
//    @Test
//    public void compareNames5(){
//        Boolean expected = false;
//        String name1 = "";
//        String name2 = "";
//        Assert.assertEquals(expected,m.compareNames(name1,name2));
//    }
//
//    @Test
//    public void compareSSN1(){
//        Boolean expected = true;
//        String ssn1 = "123-45-6789";
//        String ssn2 = "123-45-6789";
//        Assert.assertEquals(expected,m.compareNames(ssn1,ssn2));
//    }
//
//    @Test
//    public void compareSSN2(){
//        Boolean expected = false;
//        String name1 = "123-45-6789";
//        String name2 = "123-45-678";
//        Assert.assertEquals(expected,m.compareNames(name1,name2));
//    }
//
//    @Test
//    public void compareSSN3(){
//        Boolean expected = false;
//        String name1 = "";
//        String name2 = "";
//        Assert.assertEquals(expected,m.compareNames(name1,name2));
//    }
//
//    @Test
//    public void compareAddresses1(){
//        Boolean expected = true;
//        String address1 = "123 fake street State Country 12345";
//        String address2 = "123 fake street State Country 12345";
//        Assert.assertEquals(expected,m.compareAddresses(address1,address2));
//    }
//
//    @Test
//    public void compareAddresses2(){
//        Boolean expected = false;
//        String address1 = "123 fake street State Country 1234";
//        String address2 = "123 fake street State Country 12345";
//        Assert.assertEquals(expected,m.compareAddresses(address1,address2));
//    }
//
//    @Test
//    public void compareAddresses3(){
//        Boolean expected = false;
//        String address1 = "";
//        String address2 = "";
//        Assert.assertEquals(expected,m.compareAddresses(address1,address2));
//    }
//
//    @Test
//    public void verifyBusiness1(){
//        Boolean expected = true;
//        String business = "Business";
//        Assert.assertEquals(expected,m.verifyBusiness(business));
//    }
//
//    @Test
//    public void verifyBusiness2(){
//        Boolean expected = false;
//        String business = "";
//        Assert.assertEquals(expected,m.verifyBusiness(business));
//    }
//
//    @Test
//    public void verifyPosition1(){
//        Boolean expected = true;
//        String position = "Cashier";
//        Assert.assertEquals(expected,m.verifyBusiness(position));
//    }
//
//    @Test
//    public void verifyPosition2(){
//        Boolean expected = false;
//        String position = "";
//        Assert.assertEquals(expected,m.verifyBusiness(position));
//    }
//
//    @Test
//    public void verifyEndDate1(){
//        Boolean expected = true;
//        String startDate = "11/02/2016";
//        String endDate = "11/02/2017";
//        Assert.assertEquals(expected,m.verifyEndDate(startDate,endDate));
//    }
//
//    @Test
//    public void verifyEndDate2(){
//        Boolean expected = false;
//        String startDate = "11/02/2017";
//        String endDate = "11/02/2016";
//        Assert.assertEquals(expected,m.verifyEndDate(startDate,endDate));
//    }
//
//    @Test
//    public void verifyEndDate3(){
//        Boolean expected = false;
//        String startDate = "";
//        String endDate = "";
//        Assert.assertEquals(expected,m.verifyEndDate(startDate,endDate));
//    }
//
//    @Test
//    public void verifyPhoneNumber1(){
//        Boolean expected = true;
//        String pNumber = "123-456-7890";
//        Assert.assertEquals(expected,m.verifyPhoneNumber(pNumber));
//    }
//
//    @Test
//    public void verifyPhoneNumber2(){
//        Boolean expected = false;
//        String pNumber = "123-456-789";
//        Assert.assertEquals(expected,m.verifyPhoneNumber(pNumber));
//    }
//
//    @Test
//    public void verifyPhoneNumber3(){
//        Boolean expected = false;
//        String pNumber = "";
//        Assert.assertEquals(expected,m.verifyPhoneNumber(pNumber));
//    }
//
//    @Test
//    public void verifyBusinessEnd1(){
//        String expected = "Enter a new business";
//        String input = "yes";
//        Assert.assertEquals(expected,m.newBusiness(input));
//    }
//
//    @Test
//    public void verifyBusinessEnd2(){
//        String expected = "Credit Check Finished";
//        String input = "no";
//        Assert.assertEquals(expected,m.newBusiness(input));
//    }
//
//    @Test
//    public void verifyBusinessEnd3(){
//        String expected = "Please input either yes or no";
//        String input = "1";
//        Assert.assertEquals(expected,m.newBusiness(input));
//    }
//
//    @Test
//    public void verifyBusinessEnd4(){
//        String expected = "Please input either yes or no";
//        String input = "";
//        Assert.assertEquals(expected,m.newBusiness(input));
//    }
//
//    @Test
//    public void openAccounts1(){
//        String expected = "Opening Accounts Screen";
//        String input = "1";
//        Assert.assertEquals(expected,m.employeeMenu(input));
//    }
//
//    @Test
//    public void openAccounts2(){
//        String expected = "Not a valid selection";
//        String input = "17";
//        Assert.assertEquals(expected,m.employeeMenu(input));
//    }
//
//    @Test
//    public void openAccounts3(){
//        String expected = "Not a valid selection";
//        String input = "";
//        Assert.assertEquals(expected,m.employeeMenu(input));
//    }
//
//    @Test
//    public void openAccount1(){
//        String expected = "Opening Account";
//        String input = "1";
//        Assert.assertEquals(expected,m.employeeMenu(input));
//    }
//
//    @Test
//    public void openAccount2(){
//        String expected = "Not a valid selection";
//        String input = "-1";
//        Assert.assertEquals(expected,m.employeeMenu(input));
//    }
//
//    @Test
//    public void openAccount3(){
//        String expected = "Not a valid selection";
//        String input = "";
//        Assert.assertEquals(expected,m.employeeMenu(input));
//    }
//
//    @Test
//    public void startUnblock1(){
//        String expected = "Unblocking account";
//        String input = "unblock";
//        Assert.assertEquals(expected,m.employeemenu(input));
//    }
//
//    @Test
//    public void startUnblock2(){
//        String expected = "Not a valid input";
//        String input = "unbloc";
//        Assert.assertEquals(expected,m.employeemenu(input));
//    }
//
//    @Test
//    public void startUnblock3(){
//        String expected = "Not a valid input";
//        String input = "";
//        Assert.assertEquals(expected,m.employeemenu(input));
//    }
//
//    @Test
//    public void unlockAccount1(){
//        String expected = "Account unlocked";
//        String username = "Maxrimus";
//        String input = "6789";
//        Assert.assertEquals(expected,m.unlock(username,input));
//    }
//
//    @Test
//    public void unlockAccount2(){
//        String expected = "Account still locked";
//        String username = "Maxrimus";
//        String input = "678";
//        Assert.assertEquals(expected,m.unlock(username,input));
//    }
//
//    @Test
//    public void unlockAccount3(){
//        String expected = "Account still locked";
//        String username = "Maxrimus";
//        String input = "";
//        Assert.assertEquals(expected,m.unlock(username,input));
//    }
//
//    @Test
//    public void openApplications1(){
//        String expected = "Opening Applications Screen";
//        String input = "2";
//        Assert.assertEquals(expected,m.employeeMenu(input));
//    }
//
//    @Test
//    public void openApplication1(){
//        String expected = "Opening Application";
//        String input = "1";
//        Assert.assertEquals(expected,m.employeeMenu(input));
//    }
//
//    @Test
//    public void openApplication2(){
//        String expected = "Not a valid selection";
//        String input = "-1";
//        Assert.assertEquals(expected,m.employeeMenu(input));
//    }
//
//    @Test
//    public void openApplication3(){
//        String expected = "Not a valid selection";
//        String input = "";
//        Assert.assertEquals(expected,m.employeeMenu(input));
//    }
//
//    @Test
//    public void modifyApplication1(){
//        String expected = "Application accepted";
//        String input = "Accept";
//        Assert.assertEquals(expected,m.modifyApplication(input));
//    }
//
//    @Test
//    public void modifyApplication2(){
//        String expected = "Application denied";
//        String input = "Deny";
//        Assert.assertEquals(expected,m.modifyApplication(input));
//    }
//
//    @Test
//    public void modifyApplication3(){
//        String expected = "Invalid Entry";
//        String input = "Accep";
//        Assert.assertEquals(expected,m.modifyApplication(input));
//    }
//
//    @Test
//    public void modifyApplication4(){
//        String expected = "Invalid Entry";
//        String input = "";
//        Assert.assertEquals(expected,m.modifyApplication(input));
//    }
//
//    @Test
//    public void accountAdjustments1(){
//        String expected = "Enter the amount to withdraw.";
//        String input = "withdraw";
//        Assert.assertEquals(expected,m.accountAdjust(input));
//    }
//
//    @Test
//    public void accountAdjustments2(){
//        String expected = "Enter the amount to deposit.";
//        String input = "deposit";
//        Assert.assertEquals(expected,m.accountAdjust(input));
//    }
//
//    @Test
//    public void accountAdjustments3(){
//        String expected = "Enter the account to transfer from.";
//        String input = "transfer";
//        Assert.assertEquals(expected,m.accountAdjust(input));
//    }
//
//    @Test
//    public void accountAdjustments4(){
//        String expected = "Invalid Entry. Please Enter Again.";
//        String input = "withdra";
//        Assert.assertEquals(expected,m.accountAdjust(input));
//    }
//
//    @Test
//    public void accountAdjustments5(){
//        String expected = "Invalid Entry. Please Enter Again.";
//        String input = "";
//        Assert.assertEquals(expected,m.accountAdjust(input));
//    }
//
//    @Test
//    public void testWithdraw1(){
//        String expected = "$500 withdrawn";
//        int input = 500;
//        Assert.assertEquals(expected,m.withdraw(input));
//    }
//
//    @Test
//    public void testWithdraw2(){
//        String expected = "Invalid entry. Please enter a valid amount.";
//        int input = 5000;
//        Assert.assertEquals(expected,m.withdraw(input));
//    }
//
//    @Test
//    public void testWithdraw3(){
//        String expected = "Invalid entry. Please enter a valid amount.";
//        int input = -100;
//        Assert.assertEquals(expected,m.withdraw(input));
//    }
//
//    @Test
//    public void testWithdraw4(){
//        String expected = "Invalid entry. Please enter a valid amount.";
//        Integer input = null;
//        Assert.assertEquals(expected,m.withdraw(input));
//    }
//
//    @Test
//    public void testDeposit1(){
//        String expected = "$500 deposited";
//        int input = 500;
//        Assert.assertEquals(expected,m.deposit(input));
//    }
//
//    @Test
//    public void testDeposit2(){
//        String expected = "Invalid entry. Please enter a valid amount.";
//        int input = 5000;
//        Assert.assertEquals(expected,m.deposit(input));
//    }
//
//    @Test
//    public void testDeposit3(){
//        String expected = "Invalid entry. Please enter a valid amount.";
//        int input = -100;
//        Assert.assertEquals(expected,m.deposit(input));
//    }
//
//    @Test
//    public void testDeposit4(){
//        String expected = "Invalid entry. Please enter a valid amount.";
//        Integer input = null;
//        Assert.assertEquals(expected,m.deposit(input));
//    }
//
//    @Test
//    public void testTransfer1(){
//        String expected = "$500 transfern";
//        int input = 500;
//        String account1 = "1234-5678-9012";
//        String account2 = "2109-8765-4321";
//        Assert.assertEquals(expected,m.transfer(input, account1, account2));
//    }
//
//    @Test
//    public void testTransfer2(){
//        String expected = "Invalid entry. Please enter a valid amount.";
//        int input = 5000;
//        String account1 = "1234-5678-9012";
//        String account2 = "2109-8765-4321";
//        Assert.assertEquals(expected,m.transfer(input, account1, account2));
//    }
//
//    @Test
//    public void testTransfer3(){
//        String expected = "Invalid entry. Please enter a valid amount.";
//        int input = -100;
//        String account1 = "1234-5678-9012";
//        String account2 = "2109-8765-4321";
//        Assert.assertEquals(expected,m.transfer(input, account1, account2));
//    }
//
//    @Test
//    public void testTransfer4(){
//        String expected = "Invalid entry. Please enter a valid amount.";
//        Integer input = null;
//        String account1 = "1234-5678-9012";
//        String account2 = "2109-8765-4321";
//        Assert.assertEquals(expected,m.transfer(input, account1, account2));
//    }
//
//    @Test
//    public void testTransfer5(){
//        String expected = "Invalid Account. Please select valid account.";
//        int input = 500;
//        String account1 = "1234-5678-901";
//        String account2 = "2109-8765-4321";
//        Assert.assertEquals(expected,m.transfer(input, account1, account2));
//    }
//
//    @Test
//    public void testTransfer6(){
//        String expected = "Invalid Account. Please select valid account.";
//        int input = 500;
//        String account1 = "1234-5678-9012";
//        String account2 = "2109-8765-432";
//        Assert.assertEquals(expected,m.transfer(input, account1, account2));
//    }
//
//    @Test
//    public void testTransfer7(){
//        String expected = "Invalid Account. Please select valid account.";
//        int input = 500;
//        String account1 = "1234-5678-902";
//        String account2 = "2109-8765-432";
//        Assert.assertEquals(expected,m.transfer(input, account1, account2));
//    }
//
//    @Test
//    public void testTransfer8(){
//        String expected = "Invalid Account. Please select valid account.";
//        int input = 500;
//        String account1 = "";
//        String account2 = "2109-8765-4321";
//        Assert.assertEquals(expected,m.transfer(input, account1, account2));
//    }
//
//    @Test
//    public void testTransfer9(){
//        String expected = "Invalid Account. Please select valid account.";
//        int input = 500;
//        String account1 = "1234-5678-9012";
//        String account2 = "";
//        Assert.assertEquals(expected,m.transfer(input, account1, account2));
//    }
//
//    @Test
//    public void testTransfer10(){
//        String expected = "Invalid Account. Please select valid account.";
//        int input = 500;
//        String account1 = "";
//        String account2 = "";
//        Assert.assertEquals(expected,m.transfer(input, account1, account2));
//    }
//
//    @Test
//    public void testCancel1(){
//        String expected = "Account Cancelled";
//        String reason = "Default";
//        String confirm = "Yes";
//        Assert.assertEquals(expected,m.cancelAccount(reason,confirm));
//    }
//
//    @Test
//    public void testCancel2(){
//        String expected = "Account Cancelled";
//        String reason = "";
//        String confirm = "Yes";
//        Assert.assertEquals(expected,m.cancelAccount(reason,confirm));
//    }
//
//    @Test
//    public void testCancel3(){
//        String expected = "Account Not Cancelled";
//        String reason = "Default";
//        String confirm = "No";
//        Assert.assertEquals(expected,m.cancelAccount(reason,confirm));
//    }
//
//    @Test
//    public void testCancel4(){
//        String expected = "Account Not Cancelled";
//        String reason = "";
//        String confirm = "No";
//        Assert.assertEquals(expected,m.cancelAccount(reason,confirm));
//    }
//
//    @Test
//    public void testCancel5(){
//        String expected = "Invalid Input. Account Cancelled";
//        String reason = "Default";
//        String confirm = "g";
//        Assert.assertEquals(expected,m.cancelAccount(reason,confirm));
//    }
//
//    @Test
//    public void testCancel6(){
//        String expected = "Invalid Input. Account Cancelled";
//        String reason = "";
//        String confirm = "g";
//        Assert.assertEquals(expected,m.cancelAccount(reason,confirm));
//    }
//
//    @Test
//    public void testCancel7(){
//        String expected = "Invalid Input. Account Cancelled";
//        String reason = "Default";
//        String confirm = "";
//        Assert.assertEquals(expected,m.cancelAccount(reason,confirm));
//    }
//
//    @Test
//    public void testCancel8(){
//        String expected = "Invalid Input. Account Cancelled";
//        String reason = "";
//        String confirm = "";
//        Assert.assertEquals(expected,m.cancelAccount(reason,confirm));
//    }
//}