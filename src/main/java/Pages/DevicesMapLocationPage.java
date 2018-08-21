package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import WebUtilis.WebDriverUtils;

public class DevicesMapLocationPage extends BasePage {
	By devicesMenu = By.id("devices");
	By devicesReport = By.xpath("//a[text()='Report']");





	public DevicesMapLocationPage(WebDriver driver) {
		super(driver);
	}

	public void MapLocation() {
		WebDriverUtils.clickOnElementWithWait(driver, devicesMenu);
		WebDriverUtils.clickOnElementWithWait(driver, devicesReport);
	}

	public DevicesReportPage returnDevicesReportPage()

	{
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.isElementDisplayed(driver, devicesReport);
		return new DevicesReportPage(driver);
	}	

}
