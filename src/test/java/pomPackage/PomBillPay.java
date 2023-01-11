package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackage.BaseBDClass;

public class PomBillPay extends BaseBDClass{
	
	/*
	 * public PomBillPay() { // TODO Auto-generated constructor stub
	 * PageFactory.initElements(driver, this); }
	 */
	
	public void clicklink() {
		driver.findElement(By.linkText("Bill Pay")).click();
	}
	
	public void typecustomerdetails(String name, String add, String city, String state, String zip, String phone) {
		
		driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[1]/td[2]/input")).sendKeys(name);
		driver.findElement(By.cssSelector("#rightPanel > div > div:nth-child(1) > form > table > tbody > tr:nth-child(2) > td:nth-child(2) > input")).sendKeys(add);
		driver.findElement(By.cssSelector("#rightPanel > div > div:nth-child(1) > form > table > tbody > tr:nth-child(3) > td:nth-child(2) > input")).sendKeys(city);
		driver.findElement(By.cssSelector("#rightPanel > div > div:nth-child(1) > form > table > tbody > tr:nth-child(4) > td:nth-child(2) > input")).sendKeys(state);
		driver.findElement(By.cssSelector("#rightPanel > div > div:nth-child(1) > form > table > tbody > tr:nth-child(5) > td:nth-child(2) > input")).sendKeys(zip);
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/form/table/tbody/tr[6]/td[2]/input")).sendKeys(phone);
	
		
	}
	
	
	  public void typeaccdetails(String accno, String verify, String amot) {
	  
		  driver.findElement(By.cssSelector("#rightPanel > div > div:nth-child(1) > form > table > tbody > tr:nth-child(8) > td:nth-child(2) > input")).sendKeys(accno);
		  driver.findElement(By.cssSelector("#rightPanel > div > div:nth-child(1) > form > table > tbody > tr:nth-child(9) > td:nth-child(2) > input")).sendKeys(verify);
		  driver.findElement(By.cssSelector("#rightPanel > div > div:nth-child(1) > form > table > tbody > tr:nth-child(11) > td:nth-child(2) > input")).sendKeys(amot);
		  //accountno.sendKeys(accno); verifyacc.sendKeys(verify); amount.sendKeys(amot);
	  }
	  
	  public void fromaccdropdown() { 
		  Select obj= new Select(driver.findElement(By.cssSelector("#rightPanel > div > div:nth-child(1) > form > table > tbody > tr:nth-child(13) > td:nth-child(2) > select")));
	  obj.selectByIndex(0);
	  }
	  public String accnotext() {
		  Select obj= new Select(driver.findElement(By.cssSelector("#rightPanel > div > div:nth-child(1) > form > table > tbody > tr:nth-child(13) > td:nth-child(2) > select")));
		  return obj.getFirstSelectedOption().toString();
	  }
	 
	public void clickbutton() {
		driver.findElement(By.cssSelector("#rightPanel > div > div:nth-child(1) > form > table > tbody > tr:nth-child(14) > td:nth-child(2) > input")).click();
	}
	public String[] errormessages(){
		String mssg[] = new String[6];
		mssg[0]=driver.findElement(By.cssSelector("#rightPanel > div > div:nth-child(1) > form > table > tbody > tr:nth-child(1) > td:nth-child(3)")).getText();
		mssg[1]=driver.findElement(By.cssSelector("#rightPanel > div > div:nth-child(1) > form > table > tbody > tr:nth-child(2) > td:nth-child(3)")).getText();
		mssg[2]=driver.findElement(By.cssSelector("#rightPanel > div > div:nth-child(1) > form > table > tbody > tr:nth-child(3) > td:nth-child(3)")).getText();
		mssg[3]=driver.findElement(By.cssSelector("#rightPanel > div > div:nth-child(1) > form > table > tbody > tr:nth-child(4) > td:nth-child(3)")).getText();
		mssg[4]=driver.findElement(By.cssSelector("#rightPanel > div > div:nth-child(1) > form > table > tbody > tr:nth-child(5) > td:nth-child(3)")).getText();
		mssg[5]=driver.findElement(By.cssSelector("#rightPanel > div > div:nth-child(1) > form > table > tbody > tr:nth-child(6) > td:nth-child(3)")).getText();
		return mssg;
	}
	public String successmessage() {
		return driver.findElement(By.cssSelector("#rightPanel > div > div:nth-child(2) > p:nth-child(2)")).getText();
	}
	
}
