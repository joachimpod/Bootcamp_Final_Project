package utilities.Data.Locators;

import org.openqa.selenium.By;

public enum LocatorDemoBlaze {
    NAME(By.id("name")),
    COUNTRY(By.id("country")),
    CITY(By.id("city")),
    CREDIT_CARD(By.id("card")),
    MONTH(By.id("month")),
    YEAR(By.id("year")),
    SHOPCART(By.id("cartur")),
    NAVBAR(By.id("nava")),
    ADD_TO_CART_XPATH(By.xpath("//a[contains(text(),'Add to cart')]")),
    PLACE_ORDER_BUTTON_XPATH(By.xpath("//button[contains(text(),'Place Order')]")),
    PURCHASE_BUTTON_XPATH(By.xpath("//button[contains(text(),'Purchase')]")),
    MESSAGE_SUCCESS(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]"));
    private final By by;

    LocatorDemoBlaze(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }

    public static By getByContains(String productName) {

        return By.xpath( "//a[contains(text(),'"+productName+"')]");
    }
}
