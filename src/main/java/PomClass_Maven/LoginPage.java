package PomClass_Maven;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass_Maven.Util1;

public class LoginPage extends Util1{
	
WebDriver driver;
	
	//WebElement
	

      @FindBy(xpath="//input[@class='_2IX_2- VJZDxU']") 
      private WebElement emailId;

      @FindBy(xpath="//input[@type='password']") 
      private WebElement password;
      
     @FindBy(xpath="(//button[@type='submit'])[2]") 
     private WebElement loginBtn;


    public LoginPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
     	this.driver = driver;	
   } 



    public void eid() throws IOException
      {
	     emailId.sendKeys(getProperty("username"));
      }

    public void pwd() throws IOException
      {
          password.sendKeys(getProperty("password"));	
      }

    public void clickbtn()
      {
           loginBtn.click();
      }


}
