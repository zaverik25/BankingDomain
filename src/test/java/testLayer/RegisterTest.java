package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseBDClass;
import pomPackage.PomRegister;
import testdata.ExcelSheet;

public class RegisterTest extends BaseBDClass {

	PomRegister regi;
	int count=1000;
	
	public RegisterTest() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		initiation();
		
		regi=new PomRegister();
		
	
	}
	/*
	 * All the data providers
	 */
	
	  @DataProvider public Object[][] Details(){ 
		  Object
	  result[][]=ExcelSheet.readdata("Registervalid");
	  return result; 
	  }

	  @DataProvider public Object[][] RegINVNo(){ Object
	  result1[][]=ExcelSheet.readdata("RegisterINVno");
	  return result1; 
	  }
	  
	  @DataProvider public Object[][] RegINVSPC(){ Object
		  result2[][]=ExcelSheet.readdata("RegisterINVspchar");
		  return result2; 
		  }
	  @DataProvider public Object[][] RegINVspace(){ Object
		  result3[][]=ExcelSheet.readdata("RegisterINVspace");
		  return result3; 
		  }
	  @DataProvider public Object[][] RegPIN(){
		  Object result4[][]=ExcelSheet.readdata("RegisterPIN");
		  return result4;
	  }
	  @DataProvider public Object[][] RegPNo(){
		  Object result5[][]=ExcelSheet.readdata("RegisterPhoneNo");
		  return result5;
	  }
	  @DataProvider public Object[][] RegSSN(){
		  Object result6[][]=ExcelSheet.readdata("RegisterSSN");
		  return result6;
	  }
	  @DataProvider public Object[][] RegConfirmP() {
		  Object results7[][]=ExcelSheet.readdata("RegisterConfirmPass");
		  return results7;
	  }
		
	
	@Test(priority=1,dataProvider="Details")
	public void Register_valid(String fname, String lname, String address, String city, String state,String zip, String phone, String ssn, String username, String pass, String confirmpass) throws InterruptedException {
		
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
		regi.typeusername(username);
		regi.typepassword(pass);
		regi.typeconfirmpass(confirmpass);
		regi.clickbtn();
		
		Assert.assertEquals(regi.verify(), "Your account was created successfully. You are now logged in.");
		
		screenshots("Registervalid");
		Thread.sleep(3000);
	}
	@Test(priority=2,dataProvider="RegINVNo")
	public void Register_invalidwithNumber(String fname, String lname, String address, String city, String state,String zip, String phone, String ssn, String username, String pass, String confirmpass) throws InterruptedException {
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
		regi.typeusername(username+count);
		regi.typepassword(pass);
		regi.typeconfirmpass(confirmpass);
		Thread.sleep(3000);
		regi.clickbtn();
		screenshots("Registerinvalidwithnumber");
		Assert.assertEquals(false, regi.verifyNotequal(regi.verify()));
		
		Thread.sleep(2000);
		

	}
	@Test (priority=3,dataProvider="RegINVSPC")
	public void Register_invalidwithSpecialCharacter(String fname, String lname, String address, String city, String state,String zip, String phone, String ssn, String username, String pass, String confirmpass) throws InterruptedException {
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
		regi.typeusername(username+count);
		regi.typepassword(pass);
		regi.typeconfirmpass(confirmpass);
		regi.clickbtn();
		screenshots("RegisterinvalidwithSpecialCharacter");
		Assert.assertEquals(false, regi.verifyNotequal(regi.verify()));
		
		Thread.sleep(2000);
		
		
	}
	@Test(priority=4, dataProvider="RegINVspace")
	public void Register_invalidwithSpace(String fname, String lname, String address, String city, String state,String zip, String phone, String ssn, String username, String pass, String confirmpass) throws InterruptedException {
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
		regi.typeusername(username+count);
		regi.typepassword(pass);
		regi.typeconfirmpass(confirmpass);
		regi.clickbtn();
		screenshots("RegisterSpace");
		Assert.assertEquals(false, regi.verifyNotequal(regi.verify()));	
		Thread.sleep(2000);
		
	}
	@Test (priority=5)
	public void Register_invalidEmpty() throws InterruptedException {
		regi.clickRegisterlink();
		Thread.sleep(2000);
		regi.clickbtn();
		Thread.sleep(2000);
		screenshots("RegisterEmptyfields");
		Assert.assertEquals(regi.verifyerror(),regi.errormess());
	}
	@Test (priority=6,dataProvider="RegPIN")
	public void Register_invalidPin(String fname, String lname, String address, String city, String state,String zip, String phone, String ssn, String username, String pass, String confirmpass) throws InterruptedException {
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
		regi.typeusername(username+count);
		regi.typepassword(pass);
		regi.typeconfirmpass(confirmpass);
		regi.clickbtn();
		screenshots("RegisterInvalidPIN");
		Assert.assertEquals(false, regi.verifyNotequal(regi.verify()));	
		Thread.sleep(2000);
		
	}
	
	@Test (priority=7, dataProvider="RegPNo")
	public void Register_invalidPhoneno(String fname, String lname, String address, String city, String state,String zip, String phone, String ssn, String username, String pass, String confirmpass) throws InterruptedException {
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
		regi.typeusername(username+count);
		regi.typepassword(pass);
		regi.typeconfirmpass(confirmpass);
		regi.clickbtn();
		screenshots("RegisterInvalidPhoneNo");
		Assert.assertEquals(false, regi.verifyNotequal(regi.verify()));	
		Thread.sleep(2000);
		
	}
	
	@Test (priority=8, dataProvider="RegSSN")
	public void Register_invalidSSn(String fname, String lname, String address, String city, String state,String zip, String phone, String ssn, String username, String pass, String confirmpass) throws InterruptedException {
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
		regi.typeusername(username+count);
		regi.typepassword(pass);
		regi.typeconfirmpass(confirmpass);
		regi.clickbtn();
		screenshots("RegisterInvalidSSN");
		Assert.assertEquals(false, regi.verifyNotequal(regi.verify()));	
		Thread.sleep(2000);
		
	}
	@Test(priority=9, dataProvider="RegConfirmP")
	public void Register_invalidConfirmpass(String fname, String lname, String address, String city, String state,String zip, String phone, String ssn, String username, String pass, String confirmpass) throws InterruptedException {
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
		regi.typeusername(username+count);
		regi.typepassword(pass);
		regi.typeconfirmpass(confirmpass);
		
		regi.clickbtn();
		Thread.sleep(2000);
		screenshots("RegisterInvalidConfirmpass");
		Assert.assertEquals(true, regi.verifyNotequal(regi.verify()));	
		
		
	}
	
	
	  @AfterMethod public void close() { 
		  count++;
		  driver.close(); }
	 
	
	
	
	
	
	
	
}
