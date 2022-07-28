package PomClass_Maven;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass_Maven.Util1;

public class ProfilePage extends Util1 {
	
	 WebDriver driver;
	
	@FindBy(xpath="//div[@class='_1ruvv2']")
	private WebElement profileFullName;
	
	@FindBy(xpath="//div[text()='Manage Addresses']")
	private WebElement manageAddressText;
	
	@FindBy(xpath="//div[@class='_1QhEVk']")
	private WebElement addAddressBtn;
	
	@FindBy(xpath="//div[@class='_1lRtwc _1Jqgld']/input")
	private List<WebElement> addressDetails;
	
	@FindBy(xpath="//textarea")
	private WebElement address;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _1JDhFS _1o0c4q _3AWRsL']")
	private WebElement saveAddressBtn;
	
	@FindBy(xpath="//div[@class='_1CeZIA']")
	private List<WebElement> savedAddressCount;
	
	public ProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public boolean getfullProfilename()
	{
		WebElement element = explicitWait(driver, profileFullName);
		
		String fullName = element.getText();
		if(fullName.contains("Madhuri"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clickManageAddressText()
	{
		manageAddressText.click();
		
	}
	
	public void clickAddAddressText()
	{
		addAddressBtn.click();
		
	}
	
	public void fillAddressDetails()
	{
		
		String[] k = {"Harshal", "7766754493", "431001", "Aurangabad"};
		for(int i=0;i<4;i++)
		{
			addressDetails.get(i).sendKeys(k[i]);	
		}
			
	}
	
	public void fillMainAddress()
	{
		address.sendKeys("A-188, Indra, Savarkar chauk, Aurangabad");
		
	}
	
	public void saveAdrress()
	{
		saveAddressBtn.click();
	}
	
	public int savedAddressCount()
	{
		return savedAddressCount.size();
		
	}

}
