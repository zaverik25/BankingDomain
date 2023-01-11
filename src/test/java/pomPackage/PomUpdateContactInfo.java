package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseBDClass;

public class PomUpdateContactInfo extends BaseBDClass {
	String data[]= new String[7];
	String comparedata[];
	/*
	 * public PomUpdateContactInfo() { PageFactory.initElements(driver,this); }
	 */

	public void clickupdateinfolink() {
		driver.findElement(By.linkText("Update Contact Info")).click();
	}
	public void typedetails(String fname, String lname, String add, String city, String state, String zip, String phone) {
		driver.findElement(By.id("customer.firstName")).sendKeys(fname);
		driver.findElement(By.id("customer.lastName")).sendKeys(lname);
		driver.findElement(By.id("customer.address.street")).sendKeys(add);
		driver.findElement(By.id("customer.address.city")).sendKeys(city);
		driver.findElement(By.id("customer.address.state")).sendKeys(state);
		driver.findElement(By.id("customer.address.zipCode")).sendKeys(zip);
		driver.findElement(By.id("customer.phoneNumber")).sendKeys(phone);
		
		
	}
	public boolean getdetails() {
		/*
		 * data[0]=driver.findElement(By.id("customer.firstName")).getText();
		 * data[1]=driver.findElement(By.id("customer.lastName")).getText();
		 * data[2]=driver.findElement(By.id("customer.address.street")).getText();
		 * data[3]=driver.findElement(By.id("customer.address.city")).getText();
		 * data[4]=driver.findElement(By.id("customer.address.state")).getText();
		 * data[5]=driver.findElement(By.id("customer.address.zipCode")).getText();
		 * data[6]=driver.findElement(By.id("customer.phoneNumber")).getText(); int c=0;
		 * for(int i=0;i<7;i++) { if(data[i]==exisitingdata[i]) {c++;} } if(c==7) {
		 * return true;} else { return false; }
		 */
		System.out.println(driver.findElement(By.id("customer.firstName")).getText());
		if(driver.findElement(By.id("customer.firstName")).getText().equals("Khushi")) {
			return true;
		}
		else return false;
	}
	public void clickbutton() {
		driver.findElement(By.cssSelector("#rightPanel > div > div > form > table > tbody > tr:nth-child(8) > td:nth-child(2) > input")).click();
	}
	
	public String success() {
		return driver.findElement(By.cssSelector("#rightPanel > div > div > p")).getText();
	}
}
