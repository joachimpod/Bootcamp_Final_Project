package utilities.webElements.interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public interface WebElementsFunctionality {

	void type(String text, By locator);
	WebElement findElement(By locator);
	void click(By locator);
	void waits(By locator);
	List<WebElement> findElements(By locator);
	void waitAlert();
	WebDriver getDriver();
}
