package utilities.GoogleActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Data.Locators.LocatorsGoogle;
import utilities.webElements.interfaces.GuruWebElements;
import utilities.webElements.google.GuruWebElementsImplemented;

public class GoogleSearchResult {
    private final GuruWebElements guruWebElements;
    private final By firstElementSearch;


    public GoogleSearchResult(WebDriver driver) {
        guruWebElements = new GuruWebElementsImplemented(driver);
        firstElementSearch = LocatorsGoogle.FIRST_ELEMENT_SEARCH.getBy();
    }

    public void verifyText(String text) {
        WebElement resultWebElementsList = guruWebElements.findElement(firstElementSearch);
        System.out.println(resultWebElementsList.getText().contains(text));
    }
}
