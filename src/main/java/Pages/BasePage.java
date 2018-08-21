package Pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;

import WebUtilis.WebDriverUtils;




/**
 * Base class which contains common properties and methods which can be reused
 * in all other pages by extending this one.
 * 

 */
public abstract class BasePage {

	

	public static final String TIME_STAMP_FORMAT = "ddHHmmssSS";

	public WebDriver driver;

	protected BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void load(String url) {
		
	}

	public void load(String device, String url) {
		
		WebDriverUtils.load(driver, url);
		
		}



	protected String getOrderNumber(String orderPrefix) {
		return orderPrefix.concat(getTimeStamp(TIME_STAMP_FORMAT));
	}

	private String getTimeStamp(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}

	public void quit() {
		WebDriverUtils.quit(driver);
	}
}
