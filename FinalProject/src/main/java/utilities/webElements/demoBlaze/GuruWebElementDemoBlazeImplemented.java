package utilities.webElements.demoBlaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GuruWebElementDemoBlazeImplemented extends GuruWebElementsAbstractDemoBlaze{

    public GuruWebElementDemoBlazeImplemented(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

}
