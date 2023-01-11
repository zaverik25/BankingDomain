package testLayer;

import java.time.Duration;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseBDClass;
import pomPackage.PomForgotLoginIn;
import testdata.ExcelSheet;

public class ForgotInfoTest extends BaseBDClass{

	PomForgotLoginIn forgotinfo;
	
	public ForgotInfoTest() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		initiation();
		forgotinfo= new PomForgotLoginIn();
	}
	
	@DataProvider
	public Object[][] Details(){
		Object data[][]= ExcelSheet.readdata("ForgotInfoValid");
				return data;
	}
	
	@DataProvider
	public Object[][] Details2(){
		Object data2[][]=ExcelSheet.readdata("ForgotInfoInvalid");
		return data2;
	}
	@Test (priority=1)
	public void ForgotLogin_Formvisible() throws InterruptedException {
		
		Thread.sleep(2000);
		forgotinfo.clicklink();
		Thread.sleep(2000);
		Cookie cookie= driver.manage().getCookieNamed("JSESSIONID");
		String s=cookie.getValue();
		screenshots("ForgotLoginFormvisible");
		Assert.assertEquals(forgotinfo.verifyform(), "https://parabank.parasoft.com/parabank/lookup.htm;"+"jsessionid="+s);
		Thread.sleep(2000);
	}
	@Test (dataProvider="Details",priority=2)
	public void ForgotLogin_Valid(String fname, String lname, String add, String city, String state,String zip, String ssn) throws InterruptedException {
		
		forgotinfo.clicklink();
		Thread.sleep(3000);
		
		forgotinfo.typefirst(fname); 
		forgotinfo.typelast(lname);
		Thread.sleep(2000);
		  forgotinfo.typeaddress(add); forgotinfo.typecity(city);
		  forgotinfo.typestate(state); forgotinfo.typezip(zip);
		  forgotinfo.typessn(ssn); forgotinfo.clickbutton();
		  Thread.sleep(2000);
		  
		  Assert.assertEquals(forgotinfo.verifytext(),
		  "Your login information was located successfully. You are now logged in.");
		  screenshots("ForgotLoginValidData");
		 
	}
	
	@Test(priority=3)
	public void ForgotLogin_InvalidEmptyFields() throws InterruptedException {
		
		forgotinfo.clicklink();
		Thread.sleep(2000);
		forgotinfo.clickbutton();
		Thread.sleep(2000);
		Assert.assertEquals(forgotinfo.verifyerror(), "First name is required.");
		screenshots("ForgotLoginInvalidEmptyFields");
	}
	
	@Test (dataProvider="Details2", priority=4)
	public void ForgotLogin_Unregisterd(String fname, String lname, String add, String city, String state,String zip, String ssn) throws InterruptedException {
		
		forgotinfo.clicklink();
		Thread.sleep(3000);
		
		forgotinfo.typefirst(fname); 
		forgotinfo.typelast(lname);
		Thread.sleep(2000);
		  forgotinfo.typeaddress(add); forgotinfo.typecity(city);
		  forgotinfo.typestate(state); forgotinfo.typezip(zip);
		  forgotinfo.typessn(ssn); forgotinfo.clickbutton();
		  Thread.sleep(2000);
		Assert.assertEquals(forgotinfo.verifytext(), "The customer information provided could not be found.");
		screenshots("ForgotLoginUnregistereddata");  
	}
	
	
	@AfterMethod
	public void after() {
		driver.close();
	}
	
}
