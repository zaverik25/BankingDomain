package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseBDClass;
import pomPackage.PomLogin;
import pomPackage.PomRegister;
import pomPackage.PomUpdateContactInfo;
import testdata.ExcelSheet;

public class UpdateContactInfoTest extends BaseBDClass{

	PomUpdateContactInfo up;
	PomLogin log;
	PomRegister regi;
	
	public UpdateContactInfoTest() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();
		up=new PomUpdateContactInfo();
		log= new PomLogin();
		regi= new PomRegister();
	}
	
	@DataProvider public Object[][] Details(){ 
		  Object
	  result[][]=ExcelSheet.readdata("Registervalid");
	  return result; 
	  }
	@Test (dataProvider="Details")
	public void UpdateContactInfo_Verifypopulatedata(String fname, String lname, String address, String city, String state,String zip, String phone, String ssn, String username, String pass, String confirmpass) throws InterruptedException {
		
		regi.clickRegisterlink();
		Thread.sleep(3000);
		
		regi.typefname(fname);
		regi.typelname(lname);
		regi.typeaddress(address);
		regi.typecity(city);
		regi.typestate(state);
		regi.typezipcode(zip);
		regi.typephone(phone);
		regi.typessn(ssn);
		regi.typeusername("UserNEW");
		regi.typepassword(pass);
		regi.typeconfirmpass(confirmpass);
		regi.gatherdata(fname, lname, address, city, state, zip, phone);
		regi.clickbtn();
		
		
		up.clickupdateinfolink();
		//System.out.println(up.getdetails());
		boolean re=up.getdetails();
		Thread.sleep(2000);
		Assert.assertEquals(re, true);
		screenshots("UpdateInfoVerify");
		
		
	}
	@Test (dataProvider="Details")
	public void UpdateContactInfo_Updatedata(String fname, String lname, String address, String city, String state,String zip, String phone, String ssn, String username, String pass, String confirmpass) throws InterruptedException {
		
		regi.clickRegisterlink();
		Thread.sleep(3000);
		
		regi.typefname(fname);
		regi.typelname(lname);
		regi.typeaddress(address);
		regi.typecity(city);
		regi.typestate(state);
		regi.typezipcode(zip);
		regi.typephone(phone);
		regi.typessn(ssn);
		regi.typeusername("Usernew");
		regi.typepassword(pass);
		regi.typeconfirmpass(confirmpass);
		regi.gatherdata(fname, lname, address, city, state, zip, phone);
		regi.clickbtn();
		up.clickupdateinfolink();
		up.typedetails("hey", "these", "are the", "new", "details", "123456", "0987654321");
		up.clickbutton();
		Thread.sleep(2000);
		screenshots("UpdateInfoupdate");
		Assert.assertEquals(up.success(), "Your updated address and phone number have been added to the system.");
		
	}
	@AfterMethod
	public void after() {
		driver.close();
	}
	
	
}
