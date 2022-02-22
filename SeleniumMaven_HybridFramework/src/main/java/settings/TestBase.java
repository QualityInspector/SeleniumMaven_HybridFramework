package settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class TestBase {
	

	public String projectPath = System.getProperty("user.dir");
	public WebDriver driver;
	public String browserName;

	
	public WebDriver browserSettings() 
	{

		File file = new File(projectPath + "\\src\\main\\resources\\utilities\\GlobalProperties.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {

			e.printStackTrace();
		}

		browserName = prop.getProperty("Browser").toLowerCase();
		System.out.println("getting the browser name : " + browserName);

		if (browserName.equals("firefox"))
			browserName = "gecko";

		System.setProperty("webdriver." + browserName + ".driver",
				projectPath + "\\BrowserDrivers\\" + browserName + "driver.exe");
		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "gecko":
			driver = new FirefoxDriver();
			break;
		case "opera":
			driver = new OperaDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Browser Doesn't match for given input");
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String url = prop.getProperty("URL");
		driver.get(url); 
		

		return driver;

	}
	
	
	public void acceptAlert(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		
		alert.accept();
		
		
		
	}
	
	
	
	
	
	

}
