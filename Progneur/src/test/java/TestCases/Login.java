package TestCases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.read.excel.ExcelRead;

public class Login {

	
	WebDriver driver;
	Properties prop;
	ExcelRead read = new ExcelRead();
	String GetTitle ="Administator Login";
	
	public Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
	}
	
	@FindBy(css="input[name='email']")
	WebElement EmailId;
	
	@FindBy(css="input[name='password']")
	WebElement Passowrd;
	
	@FindBy(css="button[type='submit']")
	WebElement Click;
	
	public void EmailIdValue(String UserName) {
		EmailId.sendKeys(UserName);
	}

	public void PassowrdValue(String Password) {
		Passowrd.sendKeys(Password);
	}

	public Dashboard ClickButton() {
		Click.click();
		
		
		
		return new Dashboard(driver);
	}

	public String GetTitleAfterLoginIn() {
		String titleDashBoard = driver.getTitle();
		return titleDashBoard;
	}

	public boolean verifyTitle() {
		return GetTitleAfterLoginIn().equals(GetTitle);
	}
	
	public Dashboard login(String userName, String userPassword) {
		EmailIdValue(userName);
		PassowrdValue(userPassword);
		if(userName.isEmpty()){
			Click.click();
		}
		return ClickButton();
	}

}

	
	
	

