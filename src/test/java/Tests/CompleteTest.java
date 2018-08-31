package Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.CreateDevicePage;
import Pages.CreateOwnerPage;
import Pages.CreateSystemUserPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.LogoutPage;
import WebUtilis.WebDriverUtils;

public class CompleteTest {
	private static final String DEVICENAME = null;
	private static final String URL = "https://qa.hubeleon.net/";
	private static final String OWNER = null;
	private static final String username = null;

	LoginPage objLogin;
	CreateDevicePage objCreateDevice;
	LogoutPage objLogout;
	DashboardPage objDashboard;
	CreateOwnerPage objOwner;
	CreateSystemUserPage objSystemUser;

	WebDriver driver;

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
	 * This test go to http://dewa.hubeleon.ae/
	 * 
	 * Login to application
	 * 
	 * Create device
	 * 
	 */

	@Test
	public void Complete() {
		objLogin = new LoginPage(driver);
		// login to application
		objLogin.login();
		objDashboard = objLogin.returnDashboardPage();

		// Verify Dashboard

		Assert.assertTrue(objDashboard.getDashboard().contains("DASHBOARD"));
		objCreateDevice = objLogin.returnCreateDevicePage();

		// Call device creation
		objCreateDevice.createDevice(DEVICENAME);
		// Call owner
		objOwner = objLogin.returnCreateOwnerPage();
		objOwner.createOwner(OWNER);

		// Call system user
		objSystemUser = objLogin.returnCreateSystemUserPage();
		objSystemUser.CreateSystemUser(username);
		objSystemUser.checkUser_success(username);
		objSystemUser.SearchUser(username);
		objSystemUser.ResetPassword(username);
		objSystemUser.ResetAction();

		// Logout
		objLogout = objLogin.returnLogoutPage();
		objLogout.logout();

	}
}
