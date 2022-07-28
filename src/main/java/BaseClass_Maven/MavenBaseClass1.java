package BaseClass_Maven;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import UtilityClass_Maven.Util1;

public class MavenBaseClass1  {
	
	static WebDriver driver = null;
	
	static ExtentHtmlReporter extendReport= null;
	static ExtentReports report= null;
	static ExtentTest test=null;
	
		public static WebDriver getDriver(String browser) throws InterruptedException, IOException
 		{
			System.out.println(driver);
			if(driver==null)
			{
	           if(browser.equals("chrome"))
	            {
	        	   System.out.println("Hello..");
	    	       System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Browsers\\chromedriver.exe");
	    	        driver = new ChromeDriver();
	    	        
	    	        System.out.println("Hello Hello..");
	            }
	           else if(browser.equals("firefox"))
	             {  
	                System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Browsers\\geckodriver.exe");
	                 driver = new FirefoxDriver();
	             }
	    
	            driver.get(Util1.getProperty("url"));
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds( 15));
	            return driver;
		   }
		  else 
		   {
//				System.out.println("in else");
				return driver;
		   }
		}
 		
		public static ExtentHtmlReporter getHtmlReporter()
		{
			if(extendReport == null)
			{
				extendReport = new ExtentHtmlReporter("ExtentReport.html");

			}
				return extendReport;	
			
		}
		
		public static ExtentReports getReports()
		{
			if(report == null)
			{
				report = new ExtentReports();
				report.attachReporter(extendReport);
			}
				return report;	
			
		}
		
		public static ExtentTest getTest(String testName)
		{
			
				test = report.createTest(testName);
				return test;
			
		}
	}


