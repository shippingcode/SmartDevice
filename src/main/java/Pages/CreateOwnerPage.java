package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import WebUtilis.GenerateData;
import WebUtilis.WebDriverUtils;

public class CreateOwnerPage extends BasePage{

	WebDriver driver;
	GenerateData genData = null;
	String owner = GenerateData.generateRandomString(20);
	WebElement OrganisationName = null;

	private By Owner = By.cssSelector("span.icon-link");
	private By Add = By.xpath("/html/body/div[1]/div[2]/div/div/h2/div/a/span");
	private By Modal = By.className("modal-dialog");
	private By OwnerName = By.name("organisationName");
	private By timezone = By.name("timezone");
	private By language = By.name("languageDCC");
	private By locale = By.name("localeDDC");
	private By saveOwner = By.name("save_owner");

	public CreateOwnerPage(WebDriver driver) {
		super(driver);
	}

	public WebElement SelectOrganisation(WebElement OrganisationName) {
		WebDriverUtils.selectDropDown(driver, Owner, "eConnectCars");
		return OrganisationName;
	}

	public String createOwner(String ownername) {
		// Create owner
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.clickOnElementWithWait(driver, Add);
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.isElementDisplayed(driver, Modal);
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.enterTextBox(driver, OwnerName, owner);
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.selectDropDown(driver, timezone, "Europe/Bucharest");
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.selectDropDown(driver, language, "ENGLISH");
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.selectDropDown(driver, locale, "UNITED KINGDOM");
		return ownername;
	}
		public void saveOwner(String ownername){
		// Press Save Button
			WebDriverUtils.explicitWait(driver, 4000);
			WebDriverUtils.clickOnElementWithWait(driver, saveOwner);
		}
		public void checkOwner_success(){
		if (driver.getPageSource().contains("Success! The register was saved/update successfully")) {

			System.out.println("Owner was created with success");
		} else {
			System.out.println("Something went wrong");
		}
		
	}
	
}
