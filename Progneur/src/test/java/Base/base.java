package Base;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;


import com.read.excel.ExcelRead;

	public class base {
		
		WebDriver driver;
		public WebDriver initiate() throws IOException
		{
			
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream("src\\test\\java\\resources\\Config.properties");
			prop.load(fis);
			
			String BrowserName = prop.getProperty("browser");
			
			if (BrowserName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","src\\test\\java\\resources\\chromedriver.exe");
				driver= new ChromeDriver();	
			}
			
			
			else
			{
				System.out.println("no Browser");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();
			return driver;	
		}
		
	
	@DataProvider
	public Object[][] LOginData() throws IOException, jxl.read.biff.BiffException {
		return ExcelRead.readData("Sheet1");
	}
	@DataProvider
	public Object[][] GetDt(){
		return new Object[][]{
			   new Object[] {"admin@phptravels.com", "demoadmin"}
		};
	}
	
	@DataProvider
	public Object[][] DataENtry() throws IOException, jxl.read.biff.BiffException {
		return ExcelRead.readData("Sheet2");
	}
	}



