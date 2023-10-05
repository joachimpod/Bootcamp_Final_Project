package utilities.DemoBlaze.DemoBlazePages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import utilities.Data.Locators.LocatorDemoBlaze;
import utilities.webElements.GuruWebElementsImplemented;
import utilities.webElements.interfaces.GuruWebElements;

import java.util.List;

public class DemoBlazePage {
    private final WebDriver driver;
    private final GuruWebElements guruWebElements;

    public DemoBlazePage(WebDriver driver) {
        this.driver = driver;
        guruWebElements = new GuruWebElementsImplemented(driver);
    }

    public void clickProductAndAddToCart(String product) {
        guruWebElements.click(LocatorDemoBlaze.getByContains(product));
        guruWebElements.click(LocatorDemoBlaze.ADD_TO_CART_XPATH.getBy());
        guruWebElements.waitAlert();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        guruWebElements.click(LocatorDemoBlaze.NAVBAR.getBy());
    }

    public void clickCategory(String category) {
        guruWebElements.click(LocatorDemoBlaze.getByContains(category));
    }

    public void proceedToCart() {
        guruWebElements.click(LocatorDemoBlaze.SHOPCART.getBy());
    }

    public void placeOrder(String name, String country, String city, String creditCard, String month, String year) {
        guruWebElements.click(LocatorDemoBlaze.PLACE_ORDER_BUTTON_XPATH.getBy());
        guruWebElements.type(name, LocatorDemoBlaze.NAME.getBy());
        guruWebElements.type(country, LocatorDemoBlaze.COUNTRY.getBy());
        guruWebElements.type(city, LocatorDemoBlaze.CITY.getBy());
        guruWebElements.type(creditCard, LocatorDemoBlaze.CREDIT_CARD.getBy());
        guruWebElements.type(month, LocatorDemoBlaze.MONTH.getBy());
        guruWebElements.type(year, LocatorDemoBlaze.YEAR.getBy());
        guruWebElements.click(LocatorDemoBlaze.PURCHASE_BUTTON_XPATH.getBy());
    }

    public String getConfirmationMessage() {
        return guruWebElements.findElement(LocatorDemoBlaze.MESSAGE_SUCCESS.getBy()).getText();
    }

    public void iShouldSeeTheInTheShopCart(List<String> productsList) {
        for(String product : productsList) {
            Assert.assertNotNull(guruWebElements.findElement(By.xpath("//td[contains(text(),'" + product + "')]")));
        }
    }
}
