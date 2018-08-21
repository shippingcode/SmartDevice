package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import WebUtilis.WebDriverUtils;

public class DevicesReportPage extends BasePage{
	
	By devicesMenu = By.id("devices");
	By devicesReport = By.xpath("//a[text()='Report']");
	By devicesLastCommunication = By.xpath("//a[text()='Last Communication']");
	By rfidMenu = By.id("rfid");
	
	

	public DevicesReportPage(WebDriver driver) {
		super(driver);
	}
	
	public void lastCommunication(){
		WebDriverUtils.clickOnElementWithWait(driver, devicesMenu);
		WebDriverUtils.clickOnElementWithWait(driver, devicesReport);
		WebDriverUtils.clickOnElementWithWait(driver, devicesLastCommunication);
		
	}
	
	public RfidCardsPage returnRfidCardsPage()

	{
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.isElementDisplayed(driver, rfidMenu);
		return new RfidCardsPage(driver);
	}	
	
}
