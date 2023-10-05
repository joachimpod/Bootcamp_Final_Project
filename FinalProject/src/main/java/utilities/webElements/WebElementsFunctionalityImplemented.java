package utilities.webElements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementsFunctionalityImplemented extends WebElementsFunctionalityAbstract {

	public WebElementsFunctionalityImplemented(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

}
