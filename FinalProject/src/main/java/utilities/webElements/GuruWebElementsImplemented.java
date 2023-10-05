package utilities.webElements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GuruWebElementsImplemented extends GuruWebElementsAbstract {

	public GuruWebElementsImplemented(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

}
