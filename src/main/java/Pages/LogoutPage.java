package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import WebUtilis.WebDriverUtils;

public class LogoutPage extends BasePage{

	WebDriver driver;

	private By logout = By.xpath("/html/body/div[1]/div[1]/div/div/nav/div[2]/ul/li[11]/ul/li[2]/a");

	public LogoutPage(WebDriver driver) {

		super(driver);
	}
	
	public void logout () {
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.clickOnElementWithWait(driver, logout);
	}
}