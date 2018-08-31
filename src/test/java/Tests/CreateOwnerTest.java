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
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Aila\\" + "eclipse-workspace\\my"
				+ "\\src\\test\\resources\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverUtils.load(driver, URL);
	}

	/**
	 * 
	 * This test go to https://qa.hubeleon.net/
	 * 
	 * Login to application
	 * 
	 * Create owner
	 * 
	 */

	@Test

	public void CreateOwner() {

		objLogin = new LoginPage(driver);
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