package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackage.BaseBDClass;

public class PomOpenNewAcc extends BaseBDClass {
	
	/*
	 * public PomOpenNewAcc() { // TODO Auto-generated constructor stub
	 * PageFactory.initElements(driver, this); }
	 */

	public void clickOPenNewAcclink() {
		driver.findElement(By.linkText("Open New Account")).click();
	}
	
	public void selectdropdown() throws InterruptedException {
		Select obj= new Select(driver.findElement(By.id("type")));
		obj.selectByVisibleText("CHECKING");
		Thread.sleep(2000);
		obj.selectByVisibleText("SAVINGS");
	}
	
	public void selectacc() {
		Select obj=new Select(driver.findElement(By.id("fromAccountId")));
		obj.selectByIndex(0);
	}
	
	public void clickbutton() {
		driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input")).click();
	}
	public String verifytext() {
		return driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]")).getText();
		
	}
	
}
