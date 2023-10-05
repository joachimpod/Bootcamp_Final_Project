package utilities.Data.Drivers;

import org.openqa.selenium.chrome.ChromeDriver;

public class DriverChromeImplemented extends DriverChromeAbstract{


    public DriverChromeImplemented(String webURL){
        initDriver(webURL);
    }
    private void initDriver(String webURL){
        System.setProperty(webDriveChrome, pathChromeDriver);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(webURL);
    }
}
