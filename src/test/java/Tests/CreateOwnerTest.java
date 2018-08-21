package Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.CreateOwnerPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.LogoutPage;
import WebUtilis.WebDriverUtils;

public class CreateOwnerTest {

	private static final String OWNER = null;
	private static final String URL = "https://qa.hubeleon.net/";

	WebDriver driver;
	LoginPage objLogin;
	CreateOwnerPage objOwner;
	LogoutPage objLogout;
	DashboardPage objDashboard;

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
	 * This test go to http://dewa.hubeleon.ae/
	 * 
	 * Verify login page title as DEWA
	 * 
	 * Login to application
	 * 
	 * Create device
	 * 
	 */

	@Test

	public void CreateOwner() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objLogin = new LoginPage(new FirefoxDriver());
		WebDriverUtils.load(objLogin.driver, URL);
		driver.manage().window().maximize();

		// login to application
		objLogin.login();
		objDashboard = objLogin.returnDashboardPage();

		// Verify Dashboard
		Assert.assertTrue(objDashboard.getDashboard().contains("DASHBOARD"));
		objOwner = objLogin.returnCreateOwnerPage();

		// Call device creation
		objOwner.createOwner(OWNER);
		objOwner.saveOwner(OWNER);
		objOwner.checkOwner_success();

		// Logout
		objLogout = objLogin.returnLogoutPage();
		}

}