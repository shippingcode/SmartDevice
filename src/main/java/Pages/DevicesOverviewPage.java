package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import WebUtilis.WebDriverUtils;

public class DevicesOverviewPage extends BasePage{

	By devicesMenu = By.id("devices");
	By devicesOverview = By.xpath("//a[text()='Overview']");
	By filter = By.cssSelector("b.icon-filter");
	By openEvents = By.linkText("Show only open events");
	By table = By.name("events:formEvent:search");
	By allrows = By.tagName("tr");
	By cells = By.tagName("td");
	By searchDevice = By.id("search2");
	By SearchButton = By.id("btnSearch");
	By DevicesLocation = By.linkText("Location");
	By tableDevice = By.id("DataTables_Table_0_wrapper");

	protected DevicesOverviewPage(WebDriver driver) {
		super(driver);
	}

	public void searchDevice(String device)
	{   
		WebDriverUtils.clickOnElementWithWait(driver, devicesMenu);
		WebDriverUtils.clickOnElementWithWait(driver, devicesOverview);
		WebDriverUtils.enterTextBox(driver,searchDevice, device);
		WebDriverUtils.clickOnElementWithWait(driver, SearchButton);
		WebElement tableDevice = driver.findElement(By.id("DataTables_Table_0_wrapper"));

		// Now get all the TR elements from the table
		java.util.List<WebElement> allRows = tableDevice.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
			java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells)
				if(cell.getText() == device)
				{
					System.out.println("Device is founs");
				}
				else
				{
					System.out.println("Something is not right");
				}
		}

	}

	public void checkOpenFaults() {

		//Click on show only open events
		WebDriverUtils.clickOnElementWithWait(driver, filter);
		WebDriverUtils.clickOnElementWithWait(driver, openEvents);
		//Find organisation already created in the table of organisations
		WebElement table = driver.findElement(By.name("events:formEvent:search"));

		// Now get all the TR elements from the table
		java.util.List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
			java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells)
				if(cell.getText() =="Not closed")
				{
					System.out.println("Only open events are being displayed");
				}
				else
				{
					System.out.println("Something is not right");
				}
		}
	}

	public DevicesLocationPage returnDevicesLocationPage()

	{
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.isElementDisplayed(driver, DevicesLocation);
		return new DevicesLocationPage(driver);
	}	

}
