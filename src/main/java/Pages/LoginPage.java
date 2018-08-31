package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import WebUtilis.WebDriverUtils;

public class LoginPage extends BasePage {

	private By DEWAuser = By.name("username");
	private By DEWApassword = By.name("password");
	private By login = By.xpath("//input[@value='Log In']");
	private By topmenu_dashboard = By.id ("topmenu_dashboard");
	private static final String USERNAME ="eConnect.support";
	private static final String PASSWORD = "Pa66w0rd1.";
	private By Owner = By.cssSelector("span.icon-link");
	private By Device = By.id("devices");
	private By DeviceList = By.xpath("/html/body/div[1]/div[1]/div/div/nav/div[2]/ul/li[3]/ul/li[1]/a");
	private By Overview = By.xpath("/html/body/div[1]/div[1]/div/div/nav/div[2]/ul/li[7]/ul/li[1]/a");
	private By SystemUser = By.xpath("/html/body/div[1]/div[1]/div/div/nav/div[2]/ul/li[7]/ul/li[5]/a");
	private By user = By.xpath("//*[@id=\"menu_collapse\"]/ul/li[11]/a/span");
	

	public LoginPage(WebDriver driver) {

		super(driver);
	}

	public LoginPage login() {
		WebDriverUtils.enterTextBox(driver, DEWAuser, USERNAME);
		WebDriverUtils.enterTextBox(driver, DEWApassword,PASSWORD );
		WebDriverUtils.clickOnElementWithWait(driver, login);
		return new LoginPage(driver);

	}

	public DashboardPage returnDashboardPage()
	{
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.getElementText(driver,topmenu_dashboard);
		return new DashboardPage(driver);
	}
	public CreateOwnerPage returnCreateOwnerPage()
	{
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.clickOnElementWithWait(driver, Owner);
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.clickOnElementWithWait(driver,Overview);
		return new CreateOwnerPage(driver);
	}
	
	public CreateDevicePage returnCreateDevicePage()
	{
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.clickOnElementWithWait(driver, Device);
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.clickOnElementWithWait(driver, DeviceList);
		return new CreateDevicePage(driver);
	}
	
	public CreateSystemUserPage returnCreateSystemUserPage()
	{
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.clickOnElementWithWait(driver, Owner);
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.clickOnElementWithWait(driver,SystemUser);
		return new CreateSystemUserPage(driver);
	}
	
	public LogoutPage returnLogoutPage()
	{
		WebDriverUtils.explicitWait(driver, 4000);
		WebDriverUtils.clickOnElementWithWait(driver, user);
		return new LogoutPage(driver);
	}

	
}