package testLayer;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseBDClass;
import pomPackage.PomLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseBDClass {

	PomLogin login;
	
	public LoginTest() {
		super();
	}
	
	
	@BeforeMethod
	public void initsetup() {
		initiation();
		login= new PomLogin();
	}
	
	
	@DataProvider
	public Object[][] Details(){
		Object data[][]=ExcelSheet.readdata("LoginValid");
		return data;
	}
	
	@DataProvider
	public Object[][] Details1(){
		Object data1[][]=ExcelSheet.readdata("LoginInvalidPass");
		return data1;
	}
	
	
	@DataProvider
	public Object[][] Details2(){
		
		Object data2[][]=ExcelSheet.readdata("LoginInvalidIDpass");
		return data2;
	}
	
	
	@Test (dataProvider="Details", groups= {"LogInSuccess"})
	public void Login_valid(String user, String pass) throws InterruptedException {
		
		
		login.typeusername(user);
		
		Thread.sleep(2000);
		login.typepassword(pass);
		login.clickbutton();
		Thread.sleep(2000);
		
		Assert.assertEquals(login.verifytext(), "https://parabank.parasoft.com/parabank/overview.htm");
		screenshots("Loginvalid");
	}
	
	@Test
	public void Login_InvalidEmptyInput() throws InterruptedException {
		
		login.clickbutton();
		Thread.sleep(2000);
		Assert.assertEquals(login.verifylink(),"Please enter a username and password.");
		
		
		screenshots("LoginINvalidEmpty");
	}
	
	@Test (dataProvider="Details1")
	public void Login_InvalidPassword(String username, String password) throws InterruptedException {
		
		login.typeusername(username);
		login.typepassword(password);
		Thread.sleep(2000);
		login.clickbutton();
		Assert.assertEquals(login.verifylink(), "The username and password could not be verified.");
		screenshots("LoginINvalidPassword");
	}
	
	@Test(dataProvider="Details2")
	public void Login_InvalidUnregisteredIdpass(String username, String password) throws InterruptedException {
		
		login.typeusername(username);
		login.typepassword(password);
		Thread.sleep(2000);
		login.clickbutton();
		Assert.assertEquals(login.verifylink(), "The username and password could not be verified.");
		screenshots("LoginINvalidUnregistered");
		
	}
	@AfterMethod
	public void close() { driver.close();}
}
