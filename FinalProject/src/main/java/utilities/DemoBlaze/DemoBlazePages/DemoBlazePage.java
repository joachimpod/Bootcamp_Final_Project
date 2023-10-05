package utilities.DemoBlaze.DemoBlazePages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import utilities.Data.Locators.LocatorDemoBlaze;
import utilities.webElements.WebElementsFunctionalityImplemented;
import utilities.webElements.interfaces.WebElementsFunctionality;

import java.util.List;

public class DemoBlazePage {
    private final WebDriver driver;
    private final WebElementsFunctionality webElementsFunctionality;

    public DemoBlazePage(WebDriver driver) {
        this.driver = driver;
        webElementsFunctionality = new WebElementsFunctionalityImplemented(driver);
    }

    public void clickProductAndAddToCart(String product) {
        clickProduct(product);
        addToCart();
        acceptAlert();
        goToNavbar();
    }

    private void clickProduct(String product) {
        webElementsFunctionality.click(LocatorDemoBlaze.getByContains(product));
    }

    private void addToCart() {
        webElementsFunctionality.click(LocatorDemoBlaze.ADD_TO_CART_XPATH.getBy());
        webElementsFunctionality.waitAlert();
    }

    private void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    private void goToNavbar() {
        webElementsFunctionality.click(LocatorDemoBlaze.NAVBAR.getBy());
    }

    public void clickCategory(String category) {
        webElementsFunctionality.click(LocatorDemoBlaze.getByContains(category));
    }

    public void proceedToCart() {
        webElementsFunctionality.click(LocatorDemoBlaze.SHOP_CART.getBy());
    }


    public void placeOrder(String name, String country, String city, String creditCard, String month, String year) {
        clickPlaceOrderButton();
        fillOrderDetails(name, country, city, creditCard, month, year);
        clickPurchaseButton();
    }

    private void clickPlaceOrderButton() {
        webElementsFunctionality.click(LocatorDemoBlaze.PLACE_ORDER_BUTTON_XPATH.getBy());
    }

    private void fillOrderDetails(String name, String country, String city, String creditCard, String month, String year) {
        webElementsFunctionality.type(name, LocatorDemoBlaze.NAME.getBy());
        webElementsFunctionality.type(country, LocatorDemoBlaze.COUNTRY.getBy());
        webElementsFunctionality.type(city, LocatorDemoBlaze.CITY.getBy());
        webElementsFunctionality.type(creditCard, LocatorDemoBlaze.CREDIT_CARD.getBy());
        webElementsFunctionality.type(month, LocatorDemoBlaze.MONTH.getBy());
        webElementsFunctionality.type(year, LocatorDemoBlaze.YEAR.getBy());
    }

    private void clickPurchaseButton() {
        webElementsFunctionality.click(LocatorDemoBlaze.PURCHASE_BUTTON_XPATH.getBy());
    }

    public String getConfirmationMessage() {
        return webElementsFunctionality.findElement(LocatorDemoBlaze.MESSAGE_SUCCESS_XPATH.getBy()).getText();
    }

    public void iShouldSeeTheInTheShopCart(List<String> productsList) {
        for(String product : productsList) {
            Assert.assertNotNull(webElementsFunctionality.findElement(By.xpath("//td[contains(text(),'" + product + "')]")));
        }
    }
}
