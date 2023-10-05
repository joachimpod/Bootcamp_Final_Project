package utilities.Google.GooglePages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Data.Locators.LocatorsGoogle;
import utilities.webElements.interfaces.GuruWebElements;
import utilities.webElements.GuruWebElementsImplemented;

import java.util.List;

public class GoogleSearchResultPage {
    private final GuruWebElements guruWebElements;


    public GoogleSearchResultPage(WebDriver driver) {
        guruWebElements = new GuruWebElementsImplemented(driver);
    }

    public void verifyText(String text) {
        WebElement citeElement = getCiteFromFirstResult();
        Assert.assertTrue("Actual text does not contain the expected text", citeElement.getText().contains(text));
    }

    private WebElement getCiteFromFirstResult(){
        WebElement divElement = guruWebElements.findElement(LocatorsGoogle.SEARCH_RESULTS.getBy());
        List<WebElement> elements = divElement.findElements(LocatorsGoogle.FIRST_ELEMENT_SEARCH_RESULT.getBy());
        return elements.get(0).findElement(LocatorsGoogle.CITE_IN_FIRST_ELEMENT_SEARCH_RESULT.getBy());
    }
}
