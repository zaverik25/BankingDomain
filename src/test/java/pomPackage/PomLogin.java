package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseBDClass;

public class PomLogin extends BaseBDClass {

	/*
	 * public PomLogin() { // TODO Auto-generated constructor stub
	 * PageFactory.initElements(driver, this); }
	 */
	WebElement Username=driver.findElement(By.cssSelector("#loginPanel > form > div:nth-child(2) > input"));
	
	WebElement Password=driver.findElement(By.cssSelector("#loginPanel > form > div:nth-child(4) > input"));
	
	WebElement LoginButton= driver.findElement(By.cssSelector("#loginPanel > form > div:nth-child(5) > input"));
	
	@FindBy(css="#leftPanel > h2")
	WebElement AccountServices;
	
	WebElement Errormessage=driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));
	
	public void typeusername(String u) { Username.sendKeys(u); }
	 
	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}
	public void clickbutton() {
		LoginButton.click();
	}
	public String verifytext() {
		
		return driver.getCurrentUrl();
	}
	public String verfiyError() {
		
		return Errormessage.getText();
	}
	
	public String verifylink() {
		
		//driver.get("https://parabank.parasoft.com/parabank/login.htm").findElement(By.xpath("//*[@id=\\\"rightPanel\\\"]/p"));
		//driver.get("https://parabank.parasoft.com/parabank/login.htm");
		String text=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/p")).getText();
		return text;
	}
	
}
