package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseBDClass;
import pomPackage.PomLogin;
import pomPackage.PomOpenNewAcc;
import testdata.ExcelSheet;

public class OpenNewAccTest extends BaseBDClass {

	PomOpenNewAcc opennew;
	PomLogin log;
	
	public OpenNewAccTest() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		initiation();
		opennew=new PomOpenNewAcc();
		log= new PomLogin();
	}
	
	@DataProvider
	public Object[][] Details(){
		Object data[][]=ExcelSheet.readdata("LoginValid");
		return data;
	}
	
	@Test (dataProvider="Details")
	public void OpenNewAcc_CreateAcc(String user, String pass) throws InterruptedException {
		
		log.typeusername(user);
		log.typepassword(pass);
		log.clickbutton();
		Thread.sleep(2000);
		opennew.clickOPenNewAcclink();
		opennew.selectdropdown();
		opennew.selectacc();
		opennew.clickbutton();
		Thread.sleep(2000);
		Assert.assertEquals(opennew.verifytext(), "Congratulations, your account is now open.");
		screenshots("OpenNewAccount");
	}
	
	@AfterMethod()
	public void after() {
		driver.close();
	}
	
}
