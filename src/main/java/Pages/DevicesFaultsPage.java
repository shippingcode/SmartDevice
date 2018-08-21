package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import WebUtilis.WebDriverUtils;

public class DevicesFaultsPage extends BasePage{
	
	By DevicesMenu = By.id("devices");
	By Faults = By.xpath("//a[text()='Faults']");
	By SearchDeviceFaults = By.name("search");
	By StartDate = By.name("start");
	By EndDate = By.name("end");
	By calendarStart = By.cssSelector("span.ui-icon.ui-icon-circle-triangle-w");
	By datePicker = By.linkText("1");
	By doneButton = By.xpath("//button[@type='button'])[4]");
	By filterButton = By.id("searchEvents");
	By openFaults = By.cssSelector("span.icon-search");
	By modalOpenFaults = By.className("modal-content");
	By seeDeviceButton = By.name("panelEventDetail:deviceLink");
	By statusDevice = By.id("statusDevice");
	

	protected DevicesFaultsPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void searchFaults(String device, String start, String end) {
	
	WebDriverUtils.clickOnElement(driver, DevicesMenu);
	WebDriverUtils.clickOnElement(driver, Faults);
	WebDriverUtils.enterTextBox(driver, SearchDeviceFaults, device);
	WebDriverUtils.clickOnElement(driver, StartDate);
	WebDriverUtils.clickOnElement(driver, calendarStart);
	WebDriverUtils.clickOnElement(driver, datePicker);
	WebDriverUtils.clickOnElement(driver, doneButton);
	WebDriverUtils.clickOnElement(driver, EndDate);
	WebDriverUtils.clickOnElement(driver, datePicker);
	WebDriverUtils.clickOnElement(driver, doneButton);
	WebDriverUtils.clickOnElement(driver, filterButton);
	WebDriverUtils.clickOnElement(driver, openFaults);
	WebDriverUtils.isElementDisplayed(driver, modalOpenFaults);
	WebDriverUtils.clickOnElement(driver, seeDeviceButton);

	}
	
public DevicesStatusPage returnDevicesStatusPage()
	
	{
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.isElementDisplayed(driver, statusDevice);
		return new DevicesStatusPage(driver);
	}
	

}
