package TestClass_Maven;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClass_Maven.MavenBaseClass1;
import PomClass_Maven.HomePage;
import PomClass_Maven.LoginPage;


@Listeners(ListenerClasses.Listener1.class)

public class Verifyuserlogin {

	static WebDriver driver;
	LoginPage lp;
	
	ExtentHtmlReporter ExtendReport;
	
	ExtentReports report;
	
	ExtentTest test;
	
	
	
	@BeforeClass
	public void beforeClass() throws InterruptedException, IOException
	{

		ExtendReport = MavenBaseClass1.getHtmlReporter();
		report = MavenBaseClass1.getReports();
		test = MavenBaseClass1.getTest("Verifyuserlogin");	
		driver = MavenBaseClass1.getDriver("chrome");
	}

	@BeforeMethod
	public void beforeMethod()
	{
	    lp = new LoginPage(driver);
	}
	
	@Test
	public void VerifyUserLogin() throws IOException, InterruptedException
	{
		lp.eid();
		lp.pwd();
		lp.clickbtn();
		
		HomePage hp = new HomePage(driver);	
		Assert.assertTrue(hp.getProfileName());

	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()== ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName() +"Test passed");		
		}
		
		else
		{
			String path = lp.getScreenShot(driver,result.getName());
			test.log(Status.FAIL, result.getName() +"Test failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		
	}
	
	@AfterClass
	public void afterClass()
	{
		report.flush();	
	}
	
	}
	
	