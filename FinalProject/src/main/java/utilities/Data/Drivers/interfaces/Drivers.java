package utilities.Data.Drivers.interfaces;

import org.openqa.selenium.WebDriver;

public interface Drivers {
    WebDriver getDriver();
    void setIncognito();
    void setWebURL(String webURL);

}
