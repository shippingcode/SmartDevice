package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import WebUtilis.GenerateData;
import WebUtilis.WebDriverUtils;

public class CreateSystemUserPage extends BasePage{

	GenerateData genData = null;
	String device = GenerateData.generateRandomString(20);
	String firstname = GenerateData.generateRandomString(5);
	String surname = GenerateData.generateRandomString(5);
	String username = GenerateData.generateRandomString(5);
	String phone = GenerateData.generateRandomNumber(10);
	WebDriver driver = null;

	
	private By AddUser = By.xpath("/html/body/div[1]/div[3]/div/div/div/h2/div/a");
	private By FirstName = By.name("firstName");
	private By Name = By.name("surname");
	private By Username = By.name("userName");
	private By Level = By.name("userLevel");
	private By TopOrg = By.cssSelector("div.col-md-6 > select[name='organisation']");
	private By Phone = By.name("phoneNumber");
	private By Email = By.name("emailPrimary");
	private By License = By.name("licenseNumber");
	private By Vehicle = By.name("vehicleType");
	private By Membership = By.name("memType");
	private By SaveUser = By.id("save_assignment");
	private By SearchUser = By.id("search");
	private By SearchButton = By.id("btnSearch");
	private By ResetPassword = By.linkText("Reset password");
	private By UserReset = By.name("user.userId");
	private By ResetButton = By.name("resetPassword");

	public CreateSystemUserPage(WebDriver driver) {
		super(driver);
	}

	// Create system user

	public String CreateSystemUser(String username) {
		// Fill First Name
		WebDriverUtils.clickOnElement(driver, AddUser);
		WebDriverUtils.enterTextBox(driver, FirstName, firstname);
		WebDriverUtils.enterTextBox(driver, Name, surname);
		WebDriverUtils.enterTextBox(driver, Username, username);
		WebDriverUtils.selectDropDown(driver, Level, "Technician");
		WebDriverUtils.selectDropDown(driver, TopOrg, "eConnectCars");
		WebDriverUtils.enterTextBox(driver, Phone, phone);
		WebDriverUtils.enterTextBox(driver, Email, "abogasieru@yahoo.com");
		WebDriverUtils.enterTextBox(driver, License, "123567892");
		WebDriverUtils.enterTextBox(driver, Vehicle, "car");
		WebDriverUtils.selectDropDown(driver, Membership, "Monthly");
		return username;
	}
		
		public void Save(){
		// Press Save Button
			WebDriverUtils.clickOnElement(driver, SaveUser);
			driver.findElement(SaveUser).click();
		}
		public String checkUser_success(String username){
		if (driver.getPageSource().contains("Success! The register was saved/update successfully")) {
			return username;

		} else {
			System.out.println("Something went wrong");
		}
		return username;

	}

	// Search the user created earlier
	public String SearchUser(String username) {
		WebDriverUtils.enterTextBox(driver, SearchUser, username);
		return username;
	}
	
		public void SearchAction(){
			WebDriverUtils.clickOnElement(driver, SearchButton);
			}

	// Reset password
	public void ResetPassword(String username) {
		WebDriverUtils.clickOnElement(driver, ResetPassword);
		WebDriverUtils.enterTextBox(driver, UserReset, username);
	}
	
		public void ResetAction(){
			WebDriverUtils.clickOnElement(driver, ResetButton);
		}
	}


