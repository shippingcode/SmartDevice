package Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.LoginPage;
import WebUtilis.WebDriverUtils;

public class LoginTest {

	WebDriver driver;
	LoginPage objLogin;
	DashboardPage objDashboard;
	
	private static final String URL ="https://qa.hubeleon.net/";

	@BeforeTest

	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Aila\\"
				+ "eclipse-workspace\\my"
				+ "\\src\\test\\resources\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverUtils.load(driver, URL);
	}

	/**
	 * 
	 * This test case will login in http://dewa.hubeleon.ae/
	 * 
	 * Login to application
	 * 
	 * Verify the home page using Dashboard message
	 * 
	 */

	@Test
	public void test_Dashboard() {

		// Create Login Page object

		objLogin = new LoginPage(driver);

		// login to application

		objLogin.login();

		// go the next page

		objDashboard = objLogin.returnDashboardPage();
		objDashboard.getDashboard();

	}
}