package utilities.Google.GooglePages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Data.Locators.LocatorsGoogle;
import utilities.webElements.WebElementsFunctionalityImplemented;
import utilities.webElements.interfaces.WebElementsFunctionality;

public class GoogleSearchResultPage {
    private final WebElementsFunctionality webElementsFunctionality;

    public GoogleSearchResultPage(WebDriver driver) {
        webElementsFunctionality = new WebElementsFunctionalityImplemented(driver);
    }

    public void verifyText(String text) {
        WebElement citeElement = getCiteFromFirstResult();
        Assert.assertTrue("Actual text does not contain the expected text", citeElement.getText().contains(text));
    }

    private WebElement getCiteFromFirstResult() {
        WebElement divElement = webElementsFunctionality.findElement(LocatorsGoogle.SEARCH_RESULTS.getBy());
        return divElement.findElement(LocatorsGoogle.CITE_IN_FIRST_ELEMENT_SEARCH_RESULT.getBy());
    }
}
