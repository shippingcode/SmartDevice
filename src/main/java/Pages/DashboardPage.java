
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import WebUtilis.WebDriverUtils;

public class DashboardPage extends BasePage {
	By devices_menu = By.id("devices");
	private By Dashboard = By.id("topmenu_dashboard");

	protected DashboardPage(WebDriver driver) {
		super(driver);
	}

	public String getDashboard() {

		return driver.findElement(Dashboard).getText();
	}

	public DevicesListPage returnDevicesListPage()

	{
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.getElementText(driver, devices_menu);
		return new DevicesListPage(driver);
	}

}
