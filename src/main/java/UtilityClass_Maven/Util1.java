package UtilityClass_Maven;


import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util1 {

	
	public static String getProperty(String key) throws IOException
	{
		
		FileInputStream file = new FileInputStream("configuration\\config.properties");
		Properties p= new Properties();
		p.load(file);
		
		String Property = p.getProperty(key);
		return Property;
		
	}
	
  public static WebElement explicitWait(WebDriver driver, WebElement element)
	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
		return element1;
	}
	
 
	
    public static void moveToElement(WebDriver driver, WebElement element)
    {
    	Actions act = new Actions(driver);
    	act.moveToElement(element).perform();
    }
	
    public static void moveMouse(WebDriver driver)
    {
    	Actions act = new Actions(driver);
    	act.moveByOffset(20, 20).click().build().perform();
    	
    }
	
    public static String getScreenShot(WebDriver driver, String sName) throws IOException
    {
    	TakesScreenshot ts1 = (TakesScreenshot)driver;
    	File source = ts1.getScreenshotAs(OutputType.FILE);
    	String path = "Screenshot\\"+sName+".png";
    	File dest = new File(path);
    	FileHandler.copy(source, dest);	
    	return path;
    }


}
