package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import WebUtilis.GenerateData;
import WebUtilis.WebDriverUtils;

public class CreateDevicePage extends BasePage{

	WebDriver driver;
	GenerateData genData = null;
	String device = GenerateData.generateRandomString(20);
	WebElement OrganisationName = null;

	private By Device = By.id("devices");
	private By Organisation = By.name("organisation");
	private By ListMenu = By.xpath("/html/body/div[1]/div[1]/div/div/nav/div[2]/ul/li[3]/ul/li[1]/a");
	private By AddDevice = By.xpath("/html/body/div[1]/div[2]/div/div/h2/div");
	private By Modal = By.xpath("/html/body/div[1]/div[4]/div/form/div[2]/div/div[2]");
	private By DeviceName = By.name("deviceName");
	private By maker = By.id("organisationId");
	private By model = By.id("equipmentType");
	private By selectOrg = By.cssSelector("div.col-md-6 > select[name='organisation']");
	private By status = By.name("userAppliedStatusType");
	private By latitude = By.id("latitude");
	private By longitude = By.id("longditude");
	private By networkaddress = By.name("networkAddress");
	private By threshold = By.name("offlineThresholdMins");
	private By saveDevice = By.name("save_device");

	public CreateDevicePage(WebDriver driver) {
		super(driver);
	}

	// Create device
	public WebElement selectOrganisation(WebElement Organisation1) {
		WebDriverUtils.selectDropDown(driver, Organisation, "eConnectCars");
		return Organisation1;
				}

	public String createDevice(String Devicename)

	{
		// Go to Device->List
		
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.clickOnElementWithWait(driver, AddDevice);
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.isElementDisplayed(driver, Modal);
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.enterTextBox(driver, DeviceName, device);
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.selectDropDown(driver, maker, "maker12");
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.selectDropDown(driver, model, "model12");
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.selectDropDown(driver, selectOrg, "eConnectCars");
		WebDriverUtils.selectDropDown(driver, status, "Closed");
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.enterTextBox(driver, latitude, "44.440391");
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.enterTextBox(driver, longitude, "26.101965");
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.enterTextBox(driver, networkaddress, "192.168.100.3");
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.enterTextBox(driver, threshold, "15");
		return Devicename;
	}

		public void saveDevice(String Devicename){
		// Press Save
			WebDriverUtils.explicitWait(driver, 4000);
			WebDriverUtils.clickOnElementWithWait(driver, saveDevice);
		}
       public void checkDevice_success(String Devicename){
		if (driver.getPageSource().contains("Success! The register was saved/update successfully")) {

			
		} else {
			System.out.println("Something went wrong");

		            }
               }

			}