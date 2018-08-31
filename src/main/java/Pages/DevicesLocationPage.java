package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import WebUtilis.WebDriverUtils;

public class DevicesLocationPage extends BasePage {

	By devicesMenu = By.id("devices");
	By devicesLocation = By.xpath("//a[text()='Location']");
	By devicesMapLocation = By.xpath("//a[text()='Map Location']");
	By searchLocation = By.id("search");
	By searchLocationButton = By.id("btnSearch");
	By openLocation = By.cssSelector("span.icon-search");

	public DevicesLocationPage(WebDriver driver) {
		super(driver);
	}

	public void searchLocation(String location) {
		WebDriverUtils.clickOnElementWithWait(driver, devicesMenu);
		WebDriverUtils.clickOnElementWithWait(driver, devicesLocation);
		WebDriverUtils.enterTextBox(driver, searchLocation, location);
		WebDriverUtils.clickOnElementWithWait(driver, searchLocationButton);
		WebDriverUtils.clickOnElementWithWait(driver, openLocation);

	}

	public DevicesMapLocationPage returnDevicesMapLocationPage()

	{
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.isElementDisplayed(driver, devicesMapLocation);
		return new DevicesMapLocationPage(driver);
	}

}
