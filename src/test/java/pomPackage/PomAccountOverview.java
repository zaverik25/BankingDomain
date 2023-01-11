package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseBDClass;
import testLayer.LoginTest;

public class PomAccountOverview extends BaseBDClass {
	
	
	/*
	 * public PomAccountOverview() { PageFactory.initElements(driver, this); }
	 */
	
	public void clickaccountoverviewlink() {
		driver.findElement(By.linkText("Accounts Overview")).click();
	}
	
	public void clickaccountno() {
		BaseBDClass.accno=driver.findElement(By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a")).getText();
		driver.findElement(By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a")).click();
	}
	public String findtransactionID() {
		driver.findElement(By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a")).click();
		driver.findElement(By.linkText("Funds Transfer Sent")).click();
		BaseBDClass.transactionID=driver.findElement(By.cssSelector("#rightPanel > table > tbody > tr:nth-child(1) > td:nth-child(2)")).getText();
		System.out.println(BaseBDClass.transactionID);
		return BaseBDClass.transactionID;
	}
	public String findtransactionDate() {
		driver.findElement(By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a")).click();
		BaseBDClass.transactiondate=driver.findElement(By.cssSelector("#transactionTable > tbody > tr:nth-child(1) > td:nth-child(1)")).getText();
		return BaseBDClass.transactiondate;
	}
	
	public String currentpage() {
		return driver.getCurrentUrl();
	}
	public String accountno() {
		 return driver.findElement(By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a")).getText();
	}
	public String returntext() { // Success message
		return driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1")).getText();
	}
}
