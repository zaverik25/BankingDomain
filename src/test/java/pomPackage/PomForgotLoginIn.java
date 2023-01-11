package pomPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseBDClass;

public class PomForgotLoginIn extends BaseBDClass{
	
	/*
	 * public PomForgotLoginIn() { // TODO Auto-generated constructor stub
	 * PageFactory.initElements(driver, this); }
	 */

	//@FindBy(linkText="Forgot login info?")
	WebElement ForgotInfoLink=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/p[1]/a"));
	
	
	
	@FindBy(css="#lookupForm > table")
	WebElement CustomerLookup;//=driver.findElement(By.cssSelector("#lookupForm > table"));
	
	public void typefirst(String fname) {	
		/*
		 * WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(0));
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
		 * "#firstname")));
		 */
		driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(fname);
		}
	public void typelast(String lname) {
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(lname);
	}
	public void typeaddress(String add) {
		driver.findElement(By.xpath("//*[@id=\"address.street\"]")).sendKeys(add);
	}
	public void typecity(String city) {
		driver.findElement(By.xpath("//*[@id=\"address.city\"]")).sendKeys(city);
	}
	public void typestate(String state) {
		driver.findElement(By.xpath("//*[@id=\"address.state\"]")).sendKeys(state);
	}
	public void typezip(String zip) {
		driver.findElement(By.xpath("//*[@id=\"address.zipCode\"]")).sendKeys(zip);
	}
	public void typessn(String ssn) {
		driver.findElement(By.xpath("//*[@id=\"ssn\"]")).sendKeys(ssn);
	}	
	public void clickbutton() { 
		
		driver.findElement(By.xpath("//*[@id=\"lookupForm\"]/table/tbody/tr[8]/td[2]/input")).click();
		}
	
	public void clicklink() { ForgotInfoLink.click();}
	
	public String verifytext() {
		
		 return driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p")).getText();
	}
	
	public String verifyform() {
		
		return driver.getCurrentUrl();
	}
	public String verifyerror() {
		
		return driver.findElement(By.xpath("//*[@id=\"firstName.errors\"]")).getText();
	}
	
	
}
