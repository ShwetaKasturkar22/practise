package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerAddition {
WebDriver driver;
	
	public CustomerAddition(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/form/button")
	WebElement AddClick;

	@FindBy(css="input[placeholder='First name']")
	WebElement FirstName;
	
	@FindBy(css="input[placeholder='Last name']")
	WebElement LastName;
	
	@FindBy(css="input[placeholder='Email address']")
	WebElement Email;
	
	@FindBy(css="input[placeholder='Password']")
	WebElement Password;
	
	@FindBy(css="input[placeholder='Mobile Number']")
	WebElement MobileNumber;
	
	@FindBy(css="span[class='select2-chosen']")
	WebElement COUNTRYDRP;
	Select select = new Select(COUNTRYDRP);
	
	@FindBy(css="input[name='address1']")
	WebElement Address1;
	
	@FindBy(css="input[name='address2']")
	WebElement Address2;
	
	@FindBy(css="input.checkbox")
	WebElement CheckBx;
	
	@FindBy(className="btn")
	WebElement submit;
	
	public void addCustomerData(String FirstName, String LastName, String Email, String Password, String Mobile, String Add1, String Add2){
		this.FirstName.sendKeys(FirstName);
		this.LastName.sendKeys(LastName);
		this.Email.sendKeys(Email);
		this.Password.sendKeys(Password);
		this.MobileNumber.sendKeys(Mobile);
		select.selectByVisibleText("India");
		this.Address1.sendKeys(Add1);
		this.Address2.sendKeys(Add2);
		this.CheckBx.click();
		submit.click();
	}

}
