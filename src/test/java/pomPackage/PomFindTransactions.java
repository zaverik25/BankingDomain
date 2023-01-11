package pomPackage;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseBDClass;

public class PomFindTransactions extends BaseBDClass  {
	
	/*
	 * public PomFindTransactions() { // TODO Auto-generated constructor stub
	 * PageFactory.initElements(driver, this); }
	 */
	public void clickfindtransactionslink() {
		driver.findElement(By.linkText("Find Transactions")).click();
	}
	public void typetransactionid(String id) {
		System.out.println(BaseBDClass.transactionID);
		driver.findElement(By.id("criteria.transactionId")).sendKeys(id);
	}
	public void clickbyIDbutton() {
		driver.findElement(By.cssSelector("#rightPanel > div > div > form > div:nth-child(5) > button")).click();
	}
	public String successmessage() {
		return driver.findElement(By.cssSelector("#transactionTable > thead > tr > th:nth-child(2)")).getText();
	}
	public void typetransactiondate(String date) {
		driver.findElement(By.id("criteria.onDate")).sendKeys(date);
	}
	public void clickbyDatebutton() {
		driver.findElement(By.cssSelector("#rightPanel > div > div > form > div:nth-child(9) > button")).click();
	}
	
	public void typefromandtodate() {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Calendar cal = Calendar.getInstance();
        Date date = (Date) cal.getTime();
        String todaysdate = dateFormat.format(date);
         System.out.println("Today's date : " + todaysdate);
		driver.findElement(By.id("criteria.fromDate")).sendKeys("04-24-2022");
		driver.findElement(By.id("criteria.toDate")).sendKeys(todaysdate);
	}
	public void clickdaterangeButton() {
		driver.findElement(By.cssSelector("#rightPanel > div > div > form > div:nth-child(13) > button")).click();
	}
	public void typeamount() {
		driver.findElement(By.id("criteria.amount")).sendKeys("100");
		
	}
	public void clickamountButton() {
		driver.findElement(By.cssSelector("#rightPanel > div > div > form > div:nth-child(17) > button")).click();
	}

}
