package utilities.Data.Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverChrome{

	protected WebDriver driver;
	protected final String webDriveChrome = "webdriver.chrome.driver";
	protected final String pathChromeDriver = "./src/main/resources/chromedriver/chromedriver.exe";

	public DriverChrome(String webURL){
		initDriver(webURL);
	}

	private void initDriver(String webURL){
		System.setProperty(webDriveChrome, pathChromeDriver);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(webURL);
	}
	public WebDriver getDriver() {
		return driver;
	}
	
}