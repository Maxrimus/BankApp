//
//
//import com.ex.User;
//import com.ex.accprofile.BankAccount;
//import com.ex.accprofile.BankProfile;
//import org.junit.Assert;
//import org.junit.Test;
//
//public class BankAccProfileTests {
//
//    //String username, String email, String fullname, String ssn, String employment, int id, User user
//    private BankProfile prof = new BankProfile("hello", "h@gmail.com","Hello World", "100-10-1000", "Programmer", 1, User.Customer);
//    //String username, String email, String fullname, String ssn, String employment,
//    //                       String fullname2, String ssn2, String employment2, int id, User user
//    private BankProfile prof2 = new BankProfile("hello2", "h2@gmail.com", "My World", "100-00-1010", "Nothing","" +
//            "Her World", "111-11-1111", "Something", 2, User.Customer);
//
//    //String username, String accountNumber, double startingBalance, Integer accountType, int id
//    private BankAccount acc = new BankAccount("hello","0", 0.0, 0, 1);
//    private BankAccount acc2 = new BankAccount("hello2","1", 0, 0, 2);
//
//    @Test
//    public void testProfGetters(){
//        Assert.assertTrue(prof.getUsername().equals("hello"));
//        Assert.assertTrue(prof.getEmail().equals("h@gmail.com"));
//        Assert.assertTrue(prof.getEmployment().equals("Programmer"));
//        Assert.assertFalse(prof.getEmployment2().equals("Nothing"));
//        Assert.assertFalse(prof2.getEmployment2().equals("Nothing"));
//        Assert.assertTrue(prof.getSsn().equals("100-10-1000"));
//        Assert.assertTrue(prof2.getSsn2().equals("111-11-1111"));
//        Assert.assertFalse(prof.getSsn2().equals("100-00-1010"));
//    }
//
//    @Test
//    public void testAccGetters(){
//        Assert.assertTrue(acc.getUsername().equals("hello"));
//        Assert.assertTrue(acc.getAccountNumber().equals("1"));
//        Assert.assertTrue(acc.getNumOfAccounts() == 1);
//        Assert.assertTrue(acc2.getNumOfAccounts() == 1);
//        Assert.assertTrue(acc.getAccountBalance(BankAccount.AccountTypes.CHECKING) == 0 );
//        Assert.assertTrue(acc.getAccountTypeList().size() == 1);
//    }
//
//    @Test
//    public void testAddAccount(){
//        acc.addAccountType(BankAccount.AccountTypes.SAVINGS);
//        Assert.assertTrue(acc.getNumOfAccounts() == 2);
//        Assert.assertTrue(acc.getAccountTypeList().size() == 2);
//        Assert.assertTrue(acc.getAccountTypeList().get(0) == BankAccount.AccountTypes.CHECKING);
//        Assert.assertTrue(acc.getAccountTypeList().get(1) == BankAccount.AccountTypes.SAVINGS);
//    }
//
//    @Test
//    public void testDepositMoney(){
//        acc.depositMoney(BankAccount.AccountTypes.CHECKING, 10.15);
//        Assert.assertTrue(acc.getAccountBalance(BankAccount.AccountTypes.CHECKING) == 10.15);
//    }
//
//    @Test
//    public void testWithdrawMoney(){
//        acc.depositMoney(BankAccount.AccountTypes.CHECKING, 10.15);
//        acc.withdrawMoney(BankAccount.AccountTypes.CHECKING, 5.10);
//        Assert.assertTrue("The actual amount"+ acc.getAccountBalance(BankAccount.AccountTypes.CHECKING),acc.getAccountBalance(BankAccount.AccountTypes.CHECKING) >= 5.05);
//    }
//
//    @Test
//    public void testDoesAccountTypeExist(){
//        acc.addAccountType(BankAccount.AccountTypes.SAVINGS);
//        Assert.assertTrue(acc.doesAccountTypeExist(BankAccount.AccountTypes.SAVINGS));
//        Assert.assertTrue(acc.doesAccountTypeExist(BankAccount.AccountTypes.CHECKING));
//    }
//
//}
