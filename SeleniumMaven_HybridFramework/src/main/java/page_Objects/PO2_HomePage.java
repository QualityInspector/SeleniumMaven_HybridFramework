package page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO2_HomePage 
{
	WebDriver driver;
	public PO2_HomePage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//td[contains(text(),'mngr384522')]") 
	WebElement managerId;
	@FindBy(linkText = "Log out") 
	WebElement logoutBtn;
	
	public WebElement managerIdIdVisibility(){
		
		return managerId;
	}
	
	public WebElement logoutButton(){
		logoutBtn.click();
		return logoutBtn;
	}
	
	
	

}
