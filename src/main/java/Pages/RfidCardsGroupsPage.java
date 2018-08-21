package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import WebUtilis.WebDriverUtils;

public class RfidCardsGroupsPage extends BasePage{
	By RfidCards = By.id("rfid");
	By Groups = By.linkText("Groups");
	By addGroup = By.cssSelector("span.icon-plus");
	By nameGroup = By.name("groupName");
	By org = By.cssSelector("div.uniform > select[name='organisation']");
	By clearingHouseparticip = By.name("div.uniform > select[name='organisation']");
	By saveGroup = By.id("div.uniform > select[name='organisation']");
	By UseMenu = By.id("topmenu_use");

	public RfidCardsGroupsPage(WebDriver driver) {
		super(driver);
	
	}
	
	
	public void createGroups(String name){
		WebDriverUtils.clickOnElementWithWait(driver, RfidCards);
		WebDriverUtils.clickOnElementWithWait(driver, Groups);
		WebDriverUtils.clickOnElementWithWait(driver, addGroup);
		WebDriverUtils.enterTextBox(driver, nameGroup, name );
		WebDriverUtils.selectDropDown(driver, org,"TEST");
		WebDriverUtils.clickOnElement(driver, clearingHouseparticip);
		WebDriverUtils.clickOnElementWithWait(driver, saveGroup);
		}

	
	public RfidCardsGroupsPage returnRfidCardsGroupsPage()

	{
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.isElementDisplayed(driver, UseMenu);
		return new RfidCardsGroupsPage(driver);
	}	
	
	
}
