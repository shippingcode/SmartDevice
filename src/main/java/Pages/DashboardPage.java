package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import WebUtilis.WebDriverUtils;

public class DashboardPage extends BasePage{
	//WebDriver driver;

	//By togle = By.cssSelector("span.icon-chevron-down");
/*	By maker = By.cssSelector("icon-user");
	By Newmaker = By.xpath("//*[@id='id15']/div[2]/div/div[3]/button[2]");
	By makerName = By.xpath("//*[@id='id7']/div[2]/div/div[2]/div[2]/div[1]/input");
	By makerType = By.name("equipmentTypeName");
	By makerModel = By.name("equipmentTypeModel");
	By maintenanceLocator = By.name("maintenanceIntervalMonths");
	By protocolL = By.name("protocol");
	By addMaker = By.name("addConnector");
	By connNameL = By.name("connectorEquipmentRelationships:0:localConnectorLocation");
	By sonnType = By.name("connectorEquipmentRelationships:0:connectorType");
	By connNo = By.name("connectorEquipmentRelationships:0:localConnectorId");
	By saveMaker = By.name("save_make");*/
	By devices_menu = By.id("devices"); 
	private By Dashboard = By.id("topmenu_dashboard");

	protected DashboardPage(WebDriver driver) {
		super(driver);
		
	}
/*	public void createMaker(String name, String type, String model, String maintenance, String protocol, String connName, String connType, String connNumber) {
		//WebDriverUtils.clickOnElement(driver, togle);
		WebDriverUtils.clickOnElement(driver, maker);
		WebDriverUtils.clickOnElement(driver, Newmaker);
		WebDriverUtils.enterTextBox(driver, makerName, name);
		WebDriverUtils.enterTextBox(driver, makerType, type );
		WebDriverUtils.enterTextBox(driver, makerModel, model );
		WebDriverUtils.enterTextBox(driver, maintenanceLocator, maintenance);
		WebDriverUtils.enterTextBox(driver, protocolL, protocol);
		WebDriverUtils.clickOnElement(driver, addMaker);
		WebDriverUtils.enterTextBox(driver, connNameL, connName);
		WebDriverUtils.enterTextBox(driver, sonnType, connType);
		WebDriverUtils.enterTextBox(driver, connNo, connNumber);
		WebDriverUtils.clickOnElement(driver, saveMaker);

	} */
	
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
