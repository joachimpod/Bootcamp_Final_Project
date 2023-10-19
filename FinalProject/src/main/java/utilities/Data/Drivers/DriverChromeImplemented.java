package utilities.Data.Drivers;

import org.openqa.selenium.chrome.ChromeDriver;

public class DriverChromeImplemented extends DriversAbstract{


    public DriverChromeImplemented(){
        initDriver();
    }
    private void initDriver(){
        System.setProperty(webDriveChrome, pathChromeDriver);
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
    }
}
