package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseBDClass;
import pomPackage.PomBillPay;
import pomPackage.PomLogin;
import testdata.ExcelSheet;

public class BillPayTest extends BaseBDClass {

	PomBillPay bill;
	PomLogin log;
	
	public BillPayTest() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		initiation();
		bill= new PomBillPay();
		log= new PomLogin();
	}
	
	@DataProvider
	public Object[][] Details(){
		Object data[][]= ExcelSheet.readdata("Billpayemptyfields");
				return data;
	}
	@Test(dataProvider="Details", priority=1)
	public void BillPay_Emptyfields(String username,String pass,String accno, String verify,String amot ) throws InterruptedException {
		
		Thread.sleep(2000);
		log.typeusername(username);
		log.typepassword(pass);
		log.clickbutton();
		
		bill.clicklink();
		bill.typeaccdetails(accno, verify, amot);
		Thread.sleep(2000);
		bill.clickbutton();
		Thread.sleep(2000);
		String err[]= {"Payee name is required.","Address is required.","City is required.","State is required.","Zip Code is required.","Phone number is required."};
		Assert.assertEquals(bill.errormessages(), err);
		screenshots("BillPayEmptyFields");
	}
	
	@DataProvider
	public Object[][] Details2(){
		Object data1[][]= ExcelSheet.readdata("BillPaySpecialChar");
		return data1;
	}
	@Test(dataProvider="Details2", priority=2)
	public void BillPay_InvalidSpecialCharacter(String username, String pass,String name, String add, String city, String state, String zip, String phone, String accno, String verify, String amot) throws InterruptedException {
		Thread.sleep(2000);
		log.typeusername(username);
		log.typepassword(pass);
		log.clickbutton();
		
		bill.clicklink();
		bill.typecustomerdetails(name, add, city, state, zip, phone);
		Thread.sleep(2000);
		bill.typeaccdetails(accno, verify, amot);
		bill.clickbutton();
		Thread.sleep(2000);
		Assert.assertNotEquals(bill.successmessage(), "Bill Payment to "+name+" in the amount of $"+amot+" from account "+bill.accnotext()+" was successful.");
		screenshots("BillPaySpecialchar");
	}
	@DataProvider
	public Object[][]Invalidnumber(){
		Object data[][]=ExcelSheet.readdata("BillPayNumber");
		return data;
	}
	
	@Test(dataProvider="Invalidnumber",priority=3)
	public void BillPay_InvalidwithNumbers(String username, String pass,String name, String add, String city, String state, String zip, String phone, String accno, String verify, String amot)throws InterruptedException {
		
		Thread.sleep(2000);
		log.typeusername(username);
		log.typepassword(pass);
		log.clickbutton();
		
		bill.clicklink();
		bill.typecustomerdetails(name, add, city, state, zip, phone);
		Thread.sleep(2000);
		bill.typeaccdetails(accno, verify, amot);
		bill.clickbutton();
		Thread.sleep(2000);
		Assert.assertNotEquals(bill.successmessage(), "Bill Payment to "+name+" in the amount of $"+amot+" from account "+bill.accnotext()+" was successful.");
		screenshots("BillPayInvalidNumbers");
		
	}
	
	@DataProvider
	public Object[][] Invalidpinphone(){
		Object data[][]= ExcelSheet.readdata("BillPayPINPHone");
		return data;
	}
	@Test(dataProvider="Invalidpinphone",priority=4)
	public void BillPay_InvalidPinPhoneNumber(String username, String pass,String name, String add, String city, String state, String zip, String phone, String accno, String verify, String amot)throws InterruptedException {
		
		Thread.sleep(2000);
		log.typeusername(username);
		log.typepassword(pass);
		log.clickbutton();
		
		bill.clicklink();
		bill.typecustomerdetails(name, add, city, state, zip, phone);
		Thread.sleep(2000);
		bill.typeaccdetails(accno, verify, amot);
		bill.clickbutton();
		Thread.sleep(2000);
		Assert.assertNotEquals(bill.successmessage(), "Bill Payment to "+name+" in the amount of $"+amot+" from account "+bill.accnotext()+" was successful.");
		screenshots("BillPayinvalidPinandPhoneNUmber");
	}
	
	@DataProvider
	public Object[][] Invalidacc(){
		Object data[][]=ExcelSheet.readdata("BillPayInvalidacc");
		return data;
	}
	@Test(dataProvider="Invalidacc",priority=5)
	public void BillPay_InvalidAccountno(String username, String pass,String name, String add, String city, String state, String zip, String phone, String accno, String verify, String amot)throws InterruptedException {
		
		Thread.sleep(2000);
		log.typeusername(username);
		log.typepassword(pass);
		log.clickbutton();
		
		bill.clicklink();
		bill.typecustomerdetails(name, add, city, state, zip, phone);
		Thread.sleep(2000);
		bill.typeaccdetails(accno, verify, amot);
		bill.clickbutton();
		Thread.sleep(2000);
		Assert.assertEquals(bill.successmessage(),"Bill Payment to "+name+" in the amount of $"+amot+" from account "+bill.accnotext()+" was successful.");
		screenshots("BillPayInvalidaccno");
	}
	
	@AfterMethod
	public void after() {
		driver.close();
	}
	
}
