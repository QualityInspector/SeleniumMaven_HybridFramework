package page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class PO1_LoginPage 
{
	WebDriver driver;
	public PO1_LoginPage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath = "//input[@name='uid']") 
	WebElement userId;
	@FindBy(xpath = "//input[@name='password']") 
	WebElement password;
	@FindBy(name="btnLogin") 
	WebElement loginBtn;
	@FindBy(name = "btnReset") 
	WebElement resetBtn;
	
	
	
	public WebElement userIdTextbox(String uID){
		userId.sendKeys(uID);
		return userId;
	}
	
	public WebElement passwordTextbox(String pwd){
		password.sendKeys(pwd);
		return password;
	}
	
	public WebElement loginButton(){
		loginBtn.click();
		return loginBtn;
	}
	
	public WebElement resetButton()
	{
		resetBtn.click();
		return resetBtn;
	}
	
	
	
	
	

}
