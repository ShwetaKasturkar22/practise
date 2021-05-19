package Base;

import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import TestCases.CustomerAddition;
import TestCases.Dashboard;
import TestCases.Login;



public class AccountTc extends base{
	
	
private static Logger log = Logger.getLogger(AccountTc.class.getName());
public 	ExtentReports exrep;
Properties prop;
	WebDriver driver;

	Login login;
	Dashboard dashboard;
	CustomerAddition customer;
	
	
	@BeforeTest
	public void exteReport()
	{
		System.out.println(System.getProperty("user.dir"));
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter rep = new ExtentSparkReporter(path);
		rep.config().setDocumentTitle("Progneur Test Case Report");
		rep.config().setReportName("Progneur Assignment");
		 exrep = new ExtentReports();
		exrep.attachReporter(rep);
		exrep.setSystemInfo("Shweta", "kasturkar");
		
log.info("Before Test Account Tc");
	}
	@Test(dataProvider="GetDt", priority=-1)
	public void Log(String uSERNAME, String uSERPass){
		ExtentTest tess = exrep.createTest("ACCOUNTtc");
	
		login = new Login(driver);
		dashboard = login.login(uSERNAME, uSERNAME);
		log.info(" Test Account Tc");
	}
	
	@Test(dataProvider="DataENtry", priority=0)
	public void addCustomer(String Email,String FirstName, String LastName, String Password, String Mobile, String Add1, String Add2){
		dashboard.AccountsClick();
		dashboard.AccountsClick();
		customer = new CustomerAddition(driver);
		customer.addCustomerData( Email, Password,FirstName, LastName, Mobile, Add1, Add2);
		log.info("Entering the data");
	}
	
	@AfterSuite
	public void tearDown(){
		exrep.flush();
		dashboard.LogOut();
		driver.close();
	}
	
}
