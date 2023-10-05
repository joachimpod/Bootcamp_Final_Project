package utilities.Data.Drivers;

import org.openqa.selenium.WebDriver;
import utilities.Data.Drivers.interfaces.DriverChrome;

public abstract class DriverChromeAbstract implements DriverChrome {

	protected WebDriver driver;
	protected final String webDriveChrome = "webdriver.chrome.driver";
	protected final String pathChromeDriver = "./src/main/resources/chromedriver/chromedriver.exe";

	public WebDriver getDriver() {
		return driver;
	}
	
}