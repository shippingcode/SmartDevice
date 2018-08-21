package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import WebUtilis.WebDriverUtils;

public class RfidCardsMotoristPage extends BasePage {
	By RfidCards = By.id("rfid");
	By Motorist = By.linkText("Motorist");
	By addMotorist = By.cssSelector("span.icon-plus");
	By nameMotorist = By.name("userName");
	By org1dropdown = By.id("organisationUserRfid");
	By memdropdown = By.name("memType");
	By phone = By.name("phoneNumber");
	By email = By.name("emailPrimary");
	By license = By.name("licenseNumber");
	By vehicle = By.name("vehicleType");
	By saveMotorist = By.id("save_assignment");
	
	By GroupsMenu = By.xpath("//a[text()='Groups']");

	public RfidCardsMotoristPage(WebDriver driver) {
		super(driver);
	}
	
	public void createMotorist (String name, String phoneNo, String emailAddress, String licenseNo, String vehicleType){
		WebDriverUtils.clickOnElementWithWait(driver, RfidCards);
		WebDriverUtils.clickOnElementWithWait(driver, Motorist);
		WebDriverUtils.clickOnElementWithWait(driver, addMotorist);
		WebDriverUtils.enterTextBox(driver, nameMotorist, name );
		WebDriverUtils.selectDropDown(driver, org1dropdown,"TEST");
		WebDriverUtils.selectDropDown(driver, memdropdown,"Annual");
		WebDriverUtils.enterTextBox(driver, phone, phoneNo);
		WebDriverUtils.enterTextBox(driver, email, emailAddress);
		WebDriverUtils.enterTextBox(driver, license, licenseNo);
		WebDriverUtils.enterTextBox(driver, vehicle, vehicleType);
		WebDriverUtils.clickOnElementWithWait(driver, saveMotorist);
		
	}

	public RfidCardsGroupsPage returnRfidCardsGroupsPage()

	{
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.isElementDisplayed(driver, GroupsMenu);
		return new RfidCardsGroupsPage(driver);
	}	
	
	
	
	
}
