package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.CreateSystemUserPage;
import Pages.LoginPage;
import Pages.LogoutPage;
import WebUtilis.WebDriverUtils;

public class CreateSystemUserTest {

	private static final String URL = "https://qa.hubeleon.net/";
	private static final String username = null;

	LoginPage objLogin;
	LogoutPage objLogout;

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
	 * This test go to https://qa.hubeleon.net/
	 * 
	 * Login to application
	 * 
	 * Create system user
	 * 
	 */

	@Test
	public void CreateSystemUser() {
		objLogin = new LoginPage(driver);
		// login to application

		objLogin.login();

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
