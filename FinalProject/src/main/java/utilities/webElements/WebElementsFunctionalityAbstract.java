package utilities.webElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import utilities.webElements.interfaces.WebElementsFunctionality;

import java.util.List;

public abstract class  WebElementsFunctionalityAbstract implements WebElementsFunctionality {
    protected Wait<WebDriver> wait;
    protected WebDriver driver;

	public void type(String text, By locator) {
		waits(locator);
		for (char c : text.toCharArray()) {
			findElement(locator).sendKeys(String.valueOf(c));
		}
	}

	public void click(By locator) {
		waits(locator);
		findElement(locator).click();
	}

	public WebElement findElement(By locator) {
		waits(locator);
		return driver.findElement(locator);
	}

	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	public void waits(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
	}

}
