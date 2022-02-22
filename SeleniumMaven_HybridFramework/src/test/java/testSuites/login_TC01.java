package testSuites;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page_Objects.PO1_LoginPage;
import page_Objects.PO2_HomePage;
import settings.TestBase;

public class login_TC01 extends TestBase {

	//   mngr384522   hybAqUq
	
	WebDriver driver;
	TestBase base = new TestBase();

	@BeforeTest
	public void openBrowser() {
		driver = base.browserSettings();

	}

	@Test
	public void loginPositive() throws InterruptedException {
		PO1_LoginPage loginPage = new PO1_LoginPage(driver);

		loginPage.userIdTextbox("mngr384522");
		loginPage.passwordTextbox("hybAqUq");
		loginPage.loginButton();

		Thread.sleep(5000);

		PO2_HomePage homePage = new PO2_HomePage(driver);

		if (homePage.managerIdIdVisibility().isDisplayed()) {
			System.out.println("Login Successful for +ve TC");
			homePage.logoutButton();
			acceptAlert(driver);
			System.out.println("Alert accepted after clicking login button");
		} else {
			System.out.println("Login FAILED for +ve TC");
			acceptAlert(driver);
			System.out.println("Alert accepted after failed TC");
		}

	}

	@AfterTest
	public void closeBrowser() {

		driver.close();

		System.out.println("Browser Closed");
	}

}
