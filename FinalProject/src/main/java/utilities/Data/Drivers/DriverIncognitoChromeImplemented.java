package utilities.Data.Drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverIncognitoChromeImplemented extends DriverChromeAbstract{

    public DriverIncognitoChromeImplemented(String webURL) {
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

}
