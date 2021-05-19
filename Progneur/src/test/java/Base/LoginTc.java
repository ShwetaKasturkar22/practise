package Base;
import java.io.IOException;
import java.util.Properties;

	import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;


	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import TestCases.Dashboard;
import TestCases.Login;


	public class LoginTc extends base{
		
		WebDriver driver;
		static Dashboard dashboard;
		static Login login;
		String UserName1;
		String Password1;
		
		  private static Logger log = Logger.getLogger(LoginTc.class.getName());
	public 	ExtentReports exrep;
	Properties prop;
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
			exrep.setSystemInfo("Tester Name", "Shweta Kasturkar");
		}
		
		@Test(dataProvider="LOginData")
		public void testc(String UserName, String Password) throws IOException
		{
			log.info("Test Execution");
			
			ExtentTest tess = exrep.createTest("Login Tc");
			this.UserName1 = UserName;
			this.Password1 = Password;
			driver= initiate();
			login = new Login(driver);
			dashboard = (Dashboard) login.login(UserName, Password);
	
	}
		@AfterMethod
		public void verifyResult(){
			if(UserName1.equalsIgnoreCase("") && Password1.equalsIgnoreCase("")){
				InValidResult();
			}else{
				ValidResult();
			}

		
		
		}
		public static void InValidResult() {
			// TODO Auto-generated method stub
			log.info( "Login test with Invalid data");
			Assert.assertTrue(login.verifyTitle());
			
		}
		public static void ValidResult(){
			log.info( "Login test with valid data");
			Assert.assertTrue(dashboard.verifyDashboardPage());
		}
		
	
		@AfterSuite
		public void tearDown(){
			exrep.flush();
			dashboard.LogOut();
			driver.close();
		}
		
		
	}

