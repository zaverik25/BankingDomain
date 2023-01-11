package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseBDClass;
import pomPackage.PomAccountOverview;
import pomPackage.PomLogin;
import testdata.ExcelSheet;


public class AccountOverviewTest extends BaseBDClass{

	PomAccountOverview account;
	PomLogin logt;
	public AccountOverviewTest() {
		super();
	}
	
	
	@BeforeMethod
	public void initsetup() {
		initiation();
		account= new PomAccountOverview();
		logt=new PomLogin();
		
	}
	
	@DataProvider
	public Object[][] Details(){
		Object data[][]=ExcelSheet.readdata("LoginValid");
		return data;
	}
	
	
	@Test (dataProvider="Details")
	public void AccountOverview_verifyLink(String user, String pass) throws InterruptedException {
		
		
		logt.typeusername(user);
		logt.typepassword(pass);
		logt.clickbutton();
		
		account.clickaccountoverviewlink();
		account.clickaccountno();
		Thread.sleep(2000);
		screenshots("AccOverviewVerify");
		Assert.assertEquals(account.returntext(), "Account Details");
		
		account.clickaccountoverviewlink();
		//account.findtransactionID();
		
	}
	@AfterMethod
	public void close() { driver.close();}
}
	

