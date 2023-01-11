package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseBDClass;
import pomPackage.PomLogin;
import pomPackage.PomTransferFunds;
import testdata.ExcelSheet;

public class TransferFundsTest extends BaseBDClass{
	
	
	PomTransferFunds tf;
	PomLogin log;
	
	public TransferFundsTest() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		initiation();
		tf= new PomTransferFunds();
		log = new PomLogin();
	}
	
	@DataProvider
	public Object[][] Details(){
		Object data[][]=ExcelSheet.readdata("TransferValid");
		return data;
	}
	
	@DataProvider
	public Object[][] Details1(){
		Object data1[][]= ExcelSheet.readdata("TransferInvalidAmount");
		return data1;
	}
	@Test (dataProvider="Details",priority=1)
	public void TransferFunds_Valid(String user, String pass,String number) throws InterruptedException {
		
		log.typeusername(user);
		log.typepassword(pass);
		log.clickbutton();
		
		Thread.sleep(3000);
		tf.clicktransferfundslink();
		tf.typeamount(number);
		Thread.sleep(2000);
		tf.fromdropdown();
		tf.todropdownvalid();
		Thread.sleep(2000);
		tf.clickbutton();
		Thread.sleep(2000);
		Assert.assertEquals(tf.successtext(), "Transfer Complete!");
		screenshots("TransferFUndsValiddata");
	}
	@Test (dataProvider="Details",priority=2)
	public void TransferFunds_InvalidToAcc(String user, String pass, String number) throws InterruptedException {
		
		log.typeusername(user);
		log.typepassword(pass);
		log.clickbutton();
		
		Thread.sleep(2000);
		tf.clicktransferfundslink();
		tf.typeamount(number);
		tf.fromdropdown();
		tf.todropdowninvalid();
		Thread.sleep(2000);
		tf.clickbutton();
		Assert.assertEquals(tf.verifysuccess(), false);
		screenshots("TransferFundsInvalidtoAccount");
	}
	
	@Test (dataProvider="Details1",priority=3)
	public void TransferFunds_InvalidAmount(String user, String pass, String number) throws InterruptedException {
		
		log.typeusername(user);
		log.typepassword(pass);
		log.clickbutton();
		
		Thread.sleep(2000);
		tf.clicktransferfundslink();
		tf.typeamount(number);
		tf.fromdropdown();
		tf.todropdownvalid();
		Thread.sleep(2000);
		tf.clickbutton();
		Thread.sleep(3000);
		Assert.assertEquals(tf.verifysuccess(), false);
		screenshots("TransferFundsInvalidamount");
	}
	@AfterMethod
	public void after() {
		driver.close();
	}
	
}
