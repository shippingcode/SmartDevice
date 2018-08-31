package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import WebUtilis.WebDriverUtils;

public class DevicesMapPage extends BasePage {
	By Organisation = By.name("organisation");
	By DevicesMenu = By.id("devices");
	By Map = By.xpath("//a[text()='Map']");
	By SearchInput = By.id("search2");
	By SearchButton = By.id("btnSearch");
	By devicesFaults = By.xpath("//a[text()='Faults']");

	public DevicesMapPage(WebDriver driver) {
		super(driver);
	}

	public void searchDeviceMap(String device) {

		WebDriverUtils.clickOnElement(driver, DevicesMenu);
		WebDriverUtils.clickOnElement(driver, Map);
		WebDriverUtils.enterTextBox(driver, SearchInput, device);
		WebDriverUtils.clickOnElement(driver, SearchButton);
	}

	public DevicesFaultsPage returnDevicesFaultsPage()

	{
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.clickOnElementWithWait(driver, devicesFaults);
		return new DevicesFaultsPage(driver);
	}

}
