package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackage.BaseBDClass;

public class PomLoanRequest extends BaseBDClass{

	/*
	 * public PomLoanRequest() { PageFactory.initElements(driver, this); }
	 */
	
	public void clickrequestloanlink() {
		driver.findElement(By.linkText("Request Loan")).click();
	}
	public void typedetails(String amount, String down) {
		driver.findElement(By.id("amount")).sendKeys(amount);;
		driver.findElement(By.id("downPayment")).sendKeys(down);
		Select fromdropdown= new Select(driver.findElement(By.id("fromAccountId")));
		fromdropdown.selectByIndex(0);
	}
	public void clickbutton() {
		driver.findElement(By.cssSelector("#rightPanel > div > div > form > table > tbody > tr:nth-child(4) > td:nth-child(2) > input")).click();
	}
	public String successmessage() {
		return driver.findElement(By.cssSelector("#loanStatus")).getText();
	}
}
