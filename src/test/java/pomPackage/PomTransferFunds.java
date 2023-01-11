package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackage.BaseBDClass;

public class PomTransferFunds extends BaseBDClass {
	PomAccountOverview ac=new PomAccountOverview();
	//String number = ac.accountno().toString();
	
	/*
	 * public PomTransferFunds() { // TODO Auto-generated constructor stub
	 * PageFactory.initElements(driver, this); }
	 */
	public void clicktransferfundslink() {
		driver.findElement(By.linkText("Transfer Funds")).click();
	}
	public void typeamount(String number) {
		driver.findElement(By.id("amount")).sendKeys(number);
		
	}
	public void fromdropdown() {
		Select obj = new Select(driver.findElement(By.id("fromAccountId")));
		obj.selectByIndex(0);
		
		
	}
	public void todropdownvalid() {
		Select obj= new Select(driver.findElement(By.id("toAccountId")));
		obj.selectByIndex(0);
	
		
	}
	public void todropdowninvalid() {
		Select obj=new Select(driver.findElement(By.id("toAccountId")));
		obj.selectByIndex(0);
	}
	
	public String successtext() {
		return driver.findElement(By.cssSelector("#rightPanel > div > div > h1")).getText();
	}
	public void clickbutton() {
		driver.findElement(By.cssSelector("#rightPanel > div > div > form > div:nth-child(4) > input")).click();
		
	}
	public boolean verifysuccess() {
		if((driver.findElement(By.cssSelector("#rightPanel > div > div > h1")).getText())=="Transfer Complete!") {
			return false;
		}
		else
			return true;
	}
	
}
