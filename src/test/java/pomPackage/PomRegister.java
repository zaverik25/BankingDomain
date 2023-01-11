package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseBDClass;

public class PomRegister extends BaseBDClass {

	public static String data[]= new String[7];
	
	@FindBy(linkText="Register") 
	WebElement Registerlink; // Register link on homepage
	
	@FindBy(id="customer.firstName")
	WebElement FirstName; //First name in Registration form
	
	@FindBy(id="customer.lastName")
	WebElement LastName; // Last name in Registration form
	
	@FindBy(id="customer.address.street")
	WebElement Address; //Address in Registration form
	
	@FindBy(id="customer.address.city")
	WebElement City; // City in Registration form
	
	@FindBy(id="customer.address.state")
	WebElement State;
	
	@FindBy(id="customer.address.zipCode")
	WebElement ZipCode; // ZipCode in Registration form
	
	@FindBy(id="customer.phoneNumber")
	WebElement PhoneNo; //Phone number in Registration form
	
	@FindBy(id="customer.ssn")
	WebElement SSN; // SSn in Registration form
	
	@FindBy(id="customer.username")
	WebElement Username; // Username in Registration form
	
	@FindBy(id="customer.password")
	WebElement Password; //Password in Registration form
	
	@FindBy(id="repeatedPassword")
	WebElement ConfirmPass; // Confirm password in Registration form
	
	@FindBy(css="#customerForm > table > tbody > tr:nth-child(13) > td:nth-child(2) > input")
	WebElement Registerbutton; //Register button in Registration form
	
	@FindBy(css="#rightPanel > p")
	WebElement Welcome;
	
	/*
	 * All the references for the error fields are below
	 */
	@FindBy(id="customer.firstName.errors")
	WebElement Errorfname; // Error message for first name
	
	@FindBy(id="customer.lastName.errors")
	WebElement Errorlname;
	
	@FindBy(id="customer.address.street.errors")
	WebElement Erroradd;
	
	@FindBy(id="customer.address.city.errors")
	WebElement ErrorCity;
	
	@FindBy(id="customer.address.state.errors")
	WebElement ErrorState;
	
	@FindBy(id="customer.address.zipCode.errors")
	WebElement ErrorZip;
	
	@FindBy(css="#customerForm > table > tbody > tr:nth-child(7) > td:nth-child(3)")
	WebElement ErrorPhoneno;
	
	@FindBy(id="customer.ssn.errors")
	WebElement ErrorSSN;
	
	@FindBy(id="customer.username.errors")
	WebElement Errorusername;
	
	@FindBy(id="customer.password.errors")
	WebElement Errorpassword;
	
	@FindBy(id="repeatedPassword.errors")
	WebElement Errorconfirmpass;
	
	
	//Initiate page elements
	public PomRegister() {
		PageFactory.initElements(driver, this);
	}
	
	//Clicks on register link on homepage
	public void clickRegisterlink() {
		Registerlink.click();
	}
	
	//Types first name
	public void typefname(String fname) {
		FirstName.sendKeys(fname);
	}
	
	//types last name
	public void typelname(String lname) {
		LastName.sendKeys(lname);
	}
	
	//types address
	public void typeaddress(String address) {
		Address.sendKeys(address);
	}
	
	//types city
	public void typecity(String city) {
		City.sendKeys(city);
	}
	
	public void typestate(String state) {
		State.sendKeys(state);
	}
	
	//types zipcode
	public void typezipcode(String zip) {
		ZipCode.sendKeys(zip);
	}
	//types phone number
	public void typephone(String phoneNo) {
		PhoneNo.sendKeys(phoneNo);
	}
	
	//types ssn
	public void typessn(String ssn) {
		SSN.sendKeys(ssn);
	}
	
	//types username
	public void typeusername(String username) {
		Username.sendKeys(username);
	}
	
	//types password
	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}
	
	//types confirm password
	public void typeconfirmpass(String conpass) {
		ConfirmPass.sendKeys(conpass);
	}
	
	//Clicks on Register button
	public void clickbtn() {
		Registerbutton.click();
	}
	
	//Gets the text from the welcome page
	public String verify() {
		 return Welcome.getText();
	}
	public void gatherdata(String fname, String lname, String add, String city, String state, String zip, String phone) {
		data[0]=fname;
		data[1]=lname;
		data[2]=add;
		data[3]=city;
		data[4]=state;
		data[5]=zip;
		data[6]=phone;
		
	}
	public String[] returndata() {
		return data;
	}
	
	public boolean verifyNotequal(String message) {
		int i=message.compareTo("Your account was created successfully. You are now logged in."); 
		if(i==1) {	
		return false;}
		else {
			return true;
		}
	}
	
	public String[] verifyerror() {
		String errormessage[]=new String[11];
		errormessage[0]=Errorfname.getText();
		errormessage[1]=Errorlname.getText();
		errormessage[2]=Erroradd.getText();
		errormessage[3]=ErrorCity.getText();
		errormessage[4]=ErrorState.getText();
		errormessage[5]=ErrorZip.getText();
		errormessage[6]=ErrorPhoneno.getText();
		errormessage[7]=ErrorSSN.getText();
		errormessage[8]=Errorusername.getText();
		errormessage[9]=Errorpassword.getText();
		errormessage[10]=Errorconfirmpass.getText();
		return errormessage;
	
	}
	public String[] errormess() {
		String message[]=new String[11];
		message[0]="First name is required.";
		message[1]="Last name is required.";
		message[2]="Address is required.";
		message[3]="City is required.";
		message[4]="State is required.";
		message[5]="Zip Code is required.";
		message[6]="Phone number is required.";
		message[7]="SSN is required.";
		message[8]="Username is required.";
		message[9]="Password is required.";
		message[10]="Confirm Password is required.";
		
		return message;
			
	}
	
	
	
	
}
