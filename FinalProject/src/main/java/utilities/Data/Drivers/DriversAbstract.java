package utilities.Data.Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.Data.Drivers.interfaces.Drivers;

public abstract class DriversAbstract implements Drivers {

	protected WebDriver driver;
	protected final String webDriveChrome = "webdriver.chrome.driver";
	protected final String pathChromeDriver = "./src/main/resources/chromedriver/chromedriver.exe";



	public WebDriver getDriver() {
		return driver;
	}


	public void setIncognito() {
		driver.quit();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
	}

	public void setWebURL(String webURL){
		driver.manage().window().maximize();
		driver.get(webURL);
	}
	
}