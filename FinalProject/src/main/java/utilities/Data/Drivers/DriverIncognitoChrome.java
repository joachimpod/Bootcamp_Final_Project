package utilities.Data.Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverIncognitoChrome{

    protected WebDriver driver;
    protected final String webDriveChrome = "webdriver.chrome.driver";
    protected final String pathChromeDriver = "./src/main/resources/chromedriver/chromedriver.exe";

    public DriverIncognitoChrome(String webURL) {
        initDriver(webURL);
    }


    private void initDriver(String webURL){
        System.setProperty(webDriveChrome, pathChromeDriver);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(webURL);
    }

    public WebDriver getDriver() {
        return driver;
    }

}
