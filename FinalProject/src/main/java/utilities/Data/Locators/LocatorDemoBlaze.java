package utilities.Data.Locators;

import org.openqa.selenium.By;

public enum LocatorDemoBlaze {
    NAME(By.id("name")),
    COUNTRY(By.id("country")),
    CITY(By.id("city")),
    CREDIT_CARD(By.id("card")),
    MONTH(By.id("month")),
    YEAR(By.id("year")),
    SHOP_CART(By.id("cartur")),
    NAVBAR(By.id("nava")),
    ADD_TO_CART_XPATH(By.xpath("//a[contains(text(),'Add to cart')]")),
    PLACE_ORDER_BUTTON_XPATH(By.xpath("//button[contains(text(),'Place Order')]")),
    PURCHASE_BUTTON_XPATH(By.xpath("//button[contains(text(),'Purchase')]")),
    MESSAGE_SUCCESS_XPATH(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]")),
    PLACE_ORDER_DATA_XPATH(By.className("text-muted"));
    private final By by;

    LocatorDemoBlaze(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }

    public static By getByContainsA(String productName) {

        return By.xpath( "//a[contains(text(),'"+productName+"')]");
    }

    public static By getByContainsTD(String productName) {

        return By.xpath( "//td[contains(text(),'"+productName+"')]");
    }
}
