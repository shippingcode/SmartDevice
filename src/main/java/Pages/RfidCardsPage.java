package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import WebUtilis.WebDriverUtils;

public class RfidCardsPage extends BasePage{
	
	By RfidCard = By.id("rfid");
	By RfidCardsOverview = By.xpath("//a[text()='RFID Cards Overview']");
	By MotoristMenu = By.xpath("//a[text()='Motorist']");
	By addRfidCard = By.id("actAddCard");
	By typedropdown = By.name("type");
	By tokenInput = By.name("token");
	By infoInput= By.name("info");
	By org1dropdown = By.name("creatorOrganisation");
    By motorist = By.name("user");
    By group = By.name("parentTokenGroup");
    By saveRfidCard = By.id("save_eventrecord");
    By searchRfidCard = By.id("saveRfidCard");
    By searchRfidCardButton = By.id("btnSearch");
	
	

	public RfidCardsPage(WebDriver driver) {
		super(driver);
	}
		
	public void createRfidCard(String rfid, String token, String info){
		WebDriverUtils.clickOnElementWithWait(driver, RfidCard);
		WebDriverUtils.clickOnElementWithWait(driver, RfidCardsOverview);
		WebDriverUtils.clickOnElementWithWait(driver, addRfidCard);
		WebDriverUtils.selectDropDown(driver, typedropdown, "PHONE-NUM");
		WebDriverUtils.enterTextBox(driver, tokenInput, token);
		WebDriverUtils.enterTextBox(driver, infoInput, info);
		WebDriverUtils.selectDropDown(driver, motorist, "Motorist");
		WebDriverUtils.selectDropDown(driver, group, "ASF");
		WebDriverUtils.clickOnElementWithWait(driver, saveRfidCard);

	}
	
	public void searchRfidCard(String rfid){
		WebDriverUtils.enterTextBox(driver, searchRfidCard, rfid);
		WebDriverUtils.clickOnElementWithWait(driver, saveRfidCard);
	
		
	}
	
	public RfidCardsMotoristPage returnRfidCardsMotoristPage()

	{
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.isElementDisplayed(driver, MotoristMenu);
		return new RfidCardsMotoristPage(driver);
	}	
	
	

}
