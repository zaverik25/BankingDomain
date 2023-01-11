package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseBDClass;
import pomPackage.PomLoanRequest;
import pomPackage.PomLogin;

public class LoanRequestTest extends BaseBDClass {

	PomLoanRequest lp;
	PomLogin log;
	
	public LoanRequestTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		initiation();
		lp=new PomLoanRequest();
		log= new PomLogin();
	}
	@Test
	public void LoanRequest_Validdata() throws InterruptedException {
		log.typeusername("User");
		log.typepassword("pass1234");
		log.clickbutton();
		
		lp.clickrequestloanlink();
		lp.typedetails("700","100");
		Thread.sleep(2000);
		lp.clickbutton();
		Thread.sleep(2000);
		Assert.assertEquals(lp.successmessage(), "Approved");
		screenshots("LoanRequest");
		
	}
	
	@AfterMethod
	public void after() {
		driver.close();
	}
}
