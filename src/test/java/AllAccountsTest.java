

import com.ex.AllAccounts;
import com.ex.Main;
import com.ex.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class AllAccountsTest {

    AllAccounts a = AllAccounts.getAccounts();

    @Test
    public void testMakeAllUsers(){
        a.makeAllUsers();
        Assert.assertEquals(a.getCustomerPass().size(),3);
        Assert.assertEquals(a.getEmployeePass().size(), 2);
        Assert.assertEquals(a.getAdminPass().size(), 2);
    }

    @Test
    public void testSingleTon(){
        AllAccounts acc = AllAccounts.getAccounts();
        Assert.assertEquals(acc, a);
    }

    @Test
    public void testDoesAccountExist(){
        a.makeAllUsers();
        Assert.assertTrue(a.doesAccountExist("a"));
    }

    @Test
    public void testDoesAccountExist1(){
        Assert.assertFalse(a.doesAccountExist("a"));
    }

    @Test
    public void testNewUsername(){
        a.newUsername(User.Customer, "hellothere");
        Assert.assertTrue(a.doesUserExist(User.Customer, "hellothere"));
        a.deleteUsername("hellothere");
        Assert.assertFalse(a.doesUserExist(User.Customer, "hellothere"));
    }

    @Test
    public void testNewUsername1(){
        a.newUsername(User.Employee, "hiagain");
        Assert.assertTrue(a.doesUserExist(User.Employee, "hiagain"));
    }

    @Test
    public void testNewUsername2(){
        a.newUsername(User.Admin, "cyal8ter");
        Assert.assertTrue(a.doesUserExist(User.Admin,"cyal8ter"));
    }

    @Test
    public void testNewUsername3(){
        a.newUsername(User.Admin, "");
        Assert.assertTrue(a.doesUserExist(User.Admin,""));
    }

    @Test
    public void testNewUsername4(){
        a.newUsername(User.Customer, null);
        Assert.assertFalse(a.doesUserExist(User.Customer, null));
    }

    @Test
    public void testDeleteAccount(){
        a.createAccount("hello", "world");
        Assert.assertTrue(a.doesAccountExist("hello"));
        a.deleteAccount("hello");
        Assert.assertFalse(a.doesAccountExist("hello"));
    }

    @Test
    public void testGetAdmin(){
        a.makeAllUsers();
        HashSet<String> stuff = a.getAdminUsernames();
        Assert.assertTrue(stuff.size() == 2);
    }

    @Test
    public void testDoesUserExist1(){
        a.makeAllUsers();
        String username = "a";
        User user = User.Customer;
        Assert.assertTrue(a.doesUserExist(user,username));
    }

    @Test
    public void testDoesUserExist2(){
        a.makeAllUsers();
        String username = "calzhe";
        User user = User.Employee;
        Assert.assertTrue(a.doesUserExist(user,username));
    }

    @Test
    public void testDoesUserExist3(){
        a.makeAllUsers();
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
        a.makeAllUsers();
        User user = User.Customer;
        String username = "a";
        String password = "1";
        Assert.assertTrue(a.doesPassMatch(user,username,password));
    }

    @Test
    public void testDoesPassMatch2(){
        a.makeAllUsers();
        User user = User.Employee;
        String username = "calzhe";
        String password = "password";
        Assert.assertTrue(a.doesPassMatch(user,username,password));
    }

    @Test
    public void testDoesPassMatch3(){
        a.makeAllUsers();
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
