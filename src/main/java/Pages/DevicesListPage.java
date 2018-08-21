package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import WebUtilis.WebDriverUtils;

public class DevicesListPage extends BasePage{
	
	By Organisation = By.name("organisation");
	By DevicesMenu = By.id("devices");
	By List = By.xpath("//a[text()='List']");
	By addDevice = By.id("dev");
	By modalDevice = By.className("modal-dialog");
	By deviceName = By.name("deviceName");
	By makerDevice = By.id("organisationId");
	By equipmentDevice = By.id("equipmentType");
	By orgDE = By.cssSelector("div.col-md-6 > select[name='organisation']");
	By statusDevice = By.name("userAppliedStatusType");
	By latitudineDevice = By.id("latitude");
	By longitudeDevice = By.id("longditude");
	By networkDevice = By.name("networkAddress");
	By offlineDevice = By.name("offlineThresholdMins");
	By installationDevice = By.name("installationDate");
	By expiryDevice = By.name("warrantyExpiry"); 	
	By maintMonths = By.name("maintenanceIntervalOverrideMonths");
	By saveDevice = By.id("save_device");
	By searchDevice = By.id("search2");
	By searchButton = By.id("btnSearch");
	By tableDevice = By.id("table_wrapper");
	By deviceMap = By.xpath("//a[text()='Map']");
			
	public DevicesListPage(WebDriver driver) {
		super(driver);
	}
		public void createDevice(String name, String maker, String model, String owner, String status,
				String latit, String longi, String network, String offline, String installation, String expiry, String instalMonth) {
		
		//WebDriverUtils.selectVisibleText(driver, Organisation, "TEST");
		WebDriverUtils.clickOnElement(driver, DevicesMenu);
		WebDriverUtils.clickOnElement(driver, List);
		WebDriverUtils.clickOnElement(driver, addDevice);
		WebDriverUtils.isElementDisplayed(driver, modalDevice);
		WebDriverUtils.enterTextBox(driver, deviceName, name );
		WebDriverUtils.selectVisibleText(driver, orgDE, "TEST");
		WebDriverUtils.selectVisibleText(driver, statusDevice, "Closed");
		WebDriverUtils.selectVisibleText(driver, makerDevice, "maker12");
		WebDriverUtils.selectVisibleText(driver, equipmentDevice, "model12");
		WebDriverUtils.enterTextBox(driver, latitudineDevice, latit );
		WebDriverUtils.enterTextBox(driver, longitudeDevice, longi );
		WebDriverUtils.enterTextBox(driver, networkDevice, network);
		WebDriverUtils.enterTextBox(driver, offlineDevice, offline);
		WebDriverUtils.enterTextBox(driver, installationDevice, installation);
		WebDriverUtils.enterTextBox(driver, expiryDevice, expiry);
		WebDriverUtils.enterTextBox(driver, maintMonths, instalMonth);
		WebDriverUtils.clickOnElement(driver, saveDevice);

	}
		
		public void searchDevice(String device) {
			
			WebDriverUtils.clickOnElement(driver, searchDevice);	
			WebDriverUtils.clickOnElement(driver, searchButton);
			By table = null;
			@SuppressWarnings("null")
			java.util.List<WebElement> allRows = table.findElements((SearchContext) By.tagName("tr"));
			// And iterate over them, getting the cells
			for (WebElement row : allRows) {
			java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) 
			if(cell.getText()== device);
		 	}
	    	}



	public DevicesMapPage returnDevicesMapPage()
	
	{
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.clickOnElementWithWait(driver, deviceMap);
		return new DevicesMapPage(driver);
	}


	

}
