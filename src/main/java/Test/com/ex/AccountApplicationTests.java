package Test.com.ex;

import com.ex.makingaccount.AccountApplication;
import com.ex.makingaccount.AllApplications;
import org.junit.Assert;
import org.junit.Test;

public class AccountApplicationTests {

    AccountApplication app1 = new AccountApplication("myuser", "user@gmail.com", 1, "Lucas Bourn", "001-10-1010", "Assassin");
    AccountApplication app2 = new AccountApplication("myuser2", "user2@gmail.com", 3, "Ned Flanders", "100-10-1000", "Pastor", "" +
            "Marge Simpson", "009-09-9000", "Lawyer");
    AllApplications apps = AllApplications.getApplications();

    @Test
    public void testGettersAndSetters(){
        Assert.assertTrue(app1.getUsername().equals("myuser"));
        Assert.assertTrue(app1.getFullname().equals("Lucas Bourn"));
        Assert.assertTrue(app2.getEmail().equals("user2@gmail.com"));
        Assert.assertTrue(app2.getEmployment().equals("Pastor"));
        Assert.assertTrue(app1.getSsn().equals("001-10-1010"));
        Assert.assertTrue(app1.getAccountType() == 1);

        app1.setAccountType(2);
        Assert.assertTrue(app1.getAccountType() == 2);
        app1.setFullname("Name Change");
        Assert.assertTrue(app1.getFullname().equals("Name Change"));
        app1.setSsn("000-00-0000");
        Assert.assertTrue(app1.getSsn().equals("000-00-0000"));
        app1.setEmail("new@gmail.com");
        Assert.assertTrue(app1.getEmail().equals("new@gmail.com"));
        app2.setFullname2("Homer Simpson");
        Assert.assertTrue(app2.getFullname2().equals("Homer Simpson"));
        app2.setSsn2("000-00-0000");
        Assert.assertTrue(app2.getSsn2().equals("000-00-0000"));
        app1.setEmployment("Trainer");
        Assert.assertTrue(app1.getEmployment().equals("Trainer"));
    }

    @Test
    public void testAllApplications(){
        apps.enterNewApplication(app1);
        apps.enterNewApplication(app2);
        Assert.assertTrue(apps.getAmount() == 2);
        Assert.assertTrue(apps.extractApplication(0) == app1);
        Assert.assertFalse(apps.extractApplication(1) == app1);
        Assert.assertTrue(apps.extractApplication(1) == app2);
        apps.closeApplication(1);
        Assert.assertTrue(apps.getAmount() == 1);
        apps.closeApplication(0);
        Assert.assertTrue(apps.getAmount() == 0);
    }


}
