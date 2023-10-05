package utilities.Google.GooglePages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Data.Locators.LocatorsGoogle;
import utilities.webElements.WebElementsFunctionalityImplemented;
import utilities.webElements.interfaces.WebElementsFunctionality;

import java.util.List;

public class GoogleSearchResultPage {
    private final WebElementsFunctionality webElementsFunctionality;


    public GoogleSearchResultPage(WebDriver driver) {
        webElementsFunctionality = new WebElementsFunctionalityImplemented(driver);
    }

    public void verifyText(String text) {
        WebElement citeElement = getCiteFromFirstResult();
        Assert.assertTrue("Actual text does not contain the expected text", citeElement.getText().contains(text));
    }

    private WebElement getCiteFromFirstResult(){
        WebElement divElement = webElementsFunctionality.findElement(LocatorsGoogle.SEARCH_RESULTS.getBy());
        List<WebElement> webElementList = divElement.findElements(LocatorsGoogle.LIST_OF_ELEMENTS_SEARCH_RESULT.getBy());
        return webElementList.get(0).findElement(LocatorsGoogle.CITE_IN_FIRST_ELEMENT_SEARCH_RESULT.getBy());
    }
}
