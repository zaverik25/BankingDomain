package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseBDClass;
import pomPackage.PomAccountOverview;
import pomPackage.PomFindTransactions;
import pomPackage.PomLogin;

public class FindTransactionsTest extends BaseBDClass {

	PomFindTransactions tf;
	PomLogin log;
	PomAccountOverview ac;
	
	public FindTransactionsTest() {
		super();
	}
	@BeforeMethod
	 public void initsetup() {
		 initiation();
		 tf= new PomFindTransactions();
		 log= new PomLogin();
		 ac= new PomAccountOverview();
	 }
	 @Test(priority=1)
	public void FindTransactions_ID() throws InterruptedException {
		log.typeusername("User");
		log.typepassword("pass1234");
		log.clickbutton();
		Thread.sleep(2000);
		ac.clickaccountoverviewlink();
		String id=ac.findtransactionID();
		
		tf.clickfindtransactionslink();
		tf.typetransactionid(id);
		tf.clickbyIDbutton();
		Thread.sleep(2000);
		Assert.assertEquals(tf.successmessage(), "Transaction");
		screenshots("FindTransactionsId");
		
		
	}
	 @Test(priority=2)
	 public void FindTransactions_Date() throws InterruptedException {
		 log.typeusername("User");
			log.typepassword("pass1234");
			log.clickbutton();
			Thread.sleep(2000);
			ac.clickaccountoverviewlink();
			String date=ac.findtransactionDate();
			
			tf.clickfindtransactionslink();
			tf.typetransactiondate(date);
			tf.clickbyDatebutton();
			Thread.sleep(2000);
			Assert.assertEquals(tf.successmessage(), "Transaction");
			screenshots("FindTransactionsDate");
			
	 }
	 @Test(priority=3)
	 public void FindTransactions_Daterange() throws InterruptedException {
		 log.typeusername("User");
			log.typepassword("pass1234");
			log.clickbutton();
			Thread.sleep(2000);
			tf.clickfindtransactionslink();
			tf.typefromandtodate();
			tf.clickdaterangeButton();
			Thread.sleep(2000);
			Assert.assertEquals(tf.successmessage(), "Transaction");
			screenshots("FindTransactionsDateRange");
		 
	 }
	 @Test(priority=4)
	 public void FindTransactions_Amount() throws InterruptedException {
		 log.typeusername("User");
			log.typepassword("pass1234");
			log.clickbutton();
			Thread.sleep(2000);
			tf.clickfindtransactionslink();
			tf.typeamount();
			tf.clickamountButton();
			Thread.sleep(2000);
			Assert.assertEquals(tf.successmessage(), "Transaction");
			screenshots("FindTransactionsAmount");
	 }
	 @AfterMethod
	 public void after() {
		 driver.close();
	 }
	 
}
