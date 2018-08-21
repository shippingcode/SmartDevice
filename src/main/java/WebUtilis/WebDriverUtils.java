package WebUtilis;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Helper class for encapsulating {@link WebDriver} operations.
 * 
 
 *
 */
public class WebDriverUtils {

	public static final long WAIT_20_SECONDS = 20;
	public static final long WAIT_10_SECONDS = 10;
	public static final long WAIT_5_SECONDS = 5;

	public static final long WAIT_1000_MILLISECONDS = 1000;
	public static final long WAIT_1500_MILLISECONDS = 1500;
	public static final long WAIT_2000_MILLISECONDS = 2000;

	public static final String SRC_ATTRIBUTE = "src";

	/**
	 * Enters provided text, if it is not "N/A", into field specified by
	 * locator.
	 * 
	 * @param driver
	 * @param locator
	 * @param text
	 */
	public static void enterTextBox(WebDriver driver, By locator, String text) {
		
			waitUntil(driver, WAIT_10_SECONDS, ExpectedConditions.elementToBeClickable(locator));

			WebElement element = findElement(driver, locator);
			element.clear();
			element.sendKeys(text);
		}


	/**
	 * Selects provided option, if it is not "N/A", in field specified by
	 * locator.
	 * 
	 * @param driver
	 * @param locator
	 * @param text
	 */
	public static void selectDropDown(WebDriver driver, By locator, String option) {
		
			waitUntil(driver, WAIT_10_SECONDS, ExpectedConditions.elementToBeClickable(locator));

			selectVisibleText(driver, locator, option);
		}


	public static void switchToTab(WebDriver driver, int tab) {
		
		try {
			driver.switchTo().window((String) driver.getWindowHandles().toArray()[tab]);
		} catch (NoSuchWindowException e) {
		
			driver.quit();
			throw new WebDriverException(e);
		}
	}

	public static void waitUntil(WebDriver driver, long timeOutInSeconds, ExpectedCondition<?> expectedCondition) {
		try {
			
			new WebDriverWait(driver, timeOutInSeconds).until(expectedCondition);
		} catch (TimeoutException e) {
			
			driver.quit();
			throw new WebDriverException(e);
		}
	}

	public static void explicitWait(WebDriver driver, long millis) {
		try {
		
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			
			driver.quit();
			throw new WebDriverException(e);
		}
	}

	public static void clickOnElement(WebDriver driver, By locator) {
		
		findElement(driver, locator).click();
	}

	public static void clickOnElementWithWait(WebDriver driver, By locator) {
		waitUntil(driver, WAIT_10_SECONDS, ExpectedConditions.elementToBeClickable(locator));

		clickOnElement(driver, locator);
	}

	public static WebElement findElement(WebDriver driver, By locator) {
		try {
			
			return driver.findElement(locator);
		} catch (NoSuchElementException e) {
			
			driver.quit();
			throw new WebDriverException(e);
		}
	}

	public static void selectVisibleText(WebDriver driver, By locator, String option) throws UnexpectedTagNameException, NoSuchElementException {
		try {
			new Select(findElement(driver, locator)).selectByVisibleText(option);
		} catch (WebDriverException e) {
			
			driver.quit();
			throw new WebDriverException(e);
		}
	}

	// @formatter:off
	public static boolean isElementPresent(WebDriver driver, By locator) {
	
		return driver.findElements(locator)
				.stream()
				.findFirst()
				.isPresent();
	}
	// @formatter:on

	// @formatter:off
	public static boolean isElementDisplayed(WebDriver driver, By locator) {
		
		return driver.findElements(locator)
				.stream()
				.filter(WebElement::isDisplayed)
				.findFirst()
				.isPresent();
	}
	// @formatter:on

	// @formatter:off
	public static int getElementCount(WebDriver driver, By locator) {
		
		return driver.findElements(locator)
				.size();
	}
	// @formatter:on

	// @formatter:off
	public static boolean isOptionPresentInSelectBox(WebDriver driver, By locator, String option) {
		
		return new Select(findElement(driver, locator))
				.getOptions()
				.stream()
				.map(WebElement::getText)
				.anyMatch(optionText -> optionText.equals(option));
	}
	// @formatter:on

	public static String getElementText(WebDriver driver, By locator) {
	
		return findElement(driver, locator).getText();
	}

	public static void moveToElement(WebDriver driver, By locator) {
		
		new Actions(driver).moveToElement(findElement(driver, locator)).build().perform();
	}

	public static void switchToDefaultContent(WebDriver driver) {
	
		driver.switchTo().defaultContent();
	}

	public static void load(WebDriver driver, String url) {
		
	
		driver.get(url);
	}

	public static void maximizeWindow(WebDriver driver) {
		
		driver.manage().window().maximize();
	}

	public static void quit(WebDriver driver) {
		
		driver.quit();
	}

	public static String getElementAttributeValue(WebDriver driver, By locator, String attributeName) {
	
		return findElement(driver, locator).getAttribute(attributeName);
	}
}
