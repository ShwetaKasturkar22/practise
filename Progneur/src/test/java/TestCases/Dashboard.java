package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	
	
	WebDriver driver;
	String HomeTitle ="Dashboard";

	public Dashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css="a[href='#ACCOUNTS']")
	WebElement ACCOUNTS;
	
	
	
	@FindBy(linkText ="Customers")
	WebElement CUSTOMERS;
	
	
	@FindBy(id="logout")
	WebElement LOGOUT;
	
	
	public String HomeTitle() {
		String Title = driver.getTitle();
		return Title;
	}
	
	public boolean verifyDashboardPage() {
		return HomeTitle().equals(HomeTitle);
	}
	
	public void AccountsClick(){
		ACCOUNTS.click();
		}
	
	public void CustomersClick(){
		CUSTOMERS.click();
		}
	
	public void LogOut(){
		LOGOUT.click();
	}
	
	
}
