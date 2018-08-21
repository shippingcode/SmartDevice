package Tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.DashboardPage;
import Pages.DevicesListPage;
import Pages.DevicesMapPage;
import Pages.LoginPage;
import WebUtilis.WebDriverUtils;



public class Flow {

	WebDriver driver;
	LoginPage objLogin;
    DashboardPage objDahboardPage; 
	DevicesListPage objDeviceListPage;
	DevicesMapPage objDeviceMapPage;
	public static String URL = "https://qa.hubeleon.net/";
	
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
	 * 
	 * Verify login page title
	 * 
	 * Login to application
	 * 
	 * 
	 * 
	 */

	@Test

	public void DashboardTest() {

	
		objLogin = new LoginPage(driver);
		
		objLogin.login();
		objDahboardPage = objLogin.returnDashboardPage();
		objDeviceListPage = objDahboardPage.returnDevicesListPage();
		objDeviceListPage.createDevice("BLA", "TEST", "Closed", "maker12", "model12" ,"1", "1", "13.8","12", "12/11/2010", "12/12/2018", "12");
		objDeviceListPage.searchDevice("BLA");
		objDeviceMapPage = objDeviceListPage.returnDevicesMapPage();
	
		//objDeviceListPage.searchDevice("WERWR");
	//	objDashboardPage.createMaker("23333", "t333ype", "333", "12", "12", "werewr", "4444", "23");
		
		}
	
	
	
}