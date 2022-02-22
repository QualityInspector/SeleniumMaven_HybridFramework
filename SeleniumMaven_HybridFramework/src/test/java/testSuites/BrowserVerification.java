package testSuites;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserVerification 
{
	public String projectPath=System.getProperty("user.dir");
	public WebDriver driver;
	
	
	public void openChrome()
	{
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDrivers\\chromedriver.exe");
		
		 driver= new ChromeDriver();
		
	}
	
	public void openFirefox()
	{
		
		System.setProperty("webdriver.gecko.driver", projectPath+"\\BrowserDrivers\\geckodriver.exe");
		
		 driver= new FirefoxDriver();
		
	}
	
	
	public void openEdge()
	{
		
		System.setProperty("webdriver.edge.driver", projectPath+"\\BrowserDrivers\\edgedriver.exe");
		
		 driver= new EdgeDriver();
		
	}
	
	public void openOpera()
	{
		
		System.setProperty("webdriver.opera.driver", projectPath+"\\BrowserDrivers\\operadriver.exe");
		
		 driver= new OperaDriver();
		
	}
	
	public void openIE()
	{
		
		System.setProperty("webdriver.ie.driver", projectPath+"\\BrowserDrivers\\iedriver.exe");
		
		 driver= new InternetExplorerDriver();
		
	}
	
	
	
	
	

	public static void main(String[] args) throws Exception 
	{
		
		BrowserVerification bv= new BrowserVerification();
		
		Scanner scan= new Scanner(System.in);
		System.out.print("Enter Browser name to open :- ");
		String browserName= scan.next();
	
		switch (browserName) {
		case "chrome":
			bv.openChrome();
			break;
		case "firefox":
			bv.openFirefox();
			break;
		case "edge":
			bv.openEdge();
			break;
		case "opera":
			bv.openOpera();
			break;
		case "ie":
			bv.openIE();
			break;

		default:
			System.out.println("Browser name not matches");
			break;
		}
		
		System.out.println("Browser Opened");
		bv.driver.manage().window().maximize();
		
		bv.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		bv.driver.get("https://www.google.com/");
		
		Thread.sleep(4000);
		
		
		bv.driver.close();
		
		
		System.out.println("Browser closed");
		
	}
	
	

}
