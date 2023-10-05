package utilities.GoogleActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Data.Locators.LocatorsGoogle;
import utilities.webElements.interfaces.GuruWebElements;
import utilities.webElements.google.GuruWebElementsImplemented;

import java.util.List;

public class GoogleSearchPage {

    private final GuruWebElements guruWebElements;
    private final By textField;
    private final By webElementList;

    public GoogleSearchPage(WebDriver driver) {
        guruWebElements = new GuruWebElementsImplemented(driver);
        textField = LocatorsGoogle.TEXT_FIELD.getBy();
        webElementList = LocatorsGoogle.WEB_ELEMENT_LIST.getBy();
    }

    public List<WebElement> searchAndSelectResults(String search) {
        guruWebElements.type(search, textField);
        guruWebElements.waits(webElementList);
        return guruWebElements.findElements(webElementList);
    }

    public void clearSearchField() {
        guruWebElements.findElement(textField).clear();
    }

    public void printList(List<WebElement> listOfElements) {
        for (WebElement option : listOfElements) {
            System.out.println(option.getText());
        }
        System.out.println();
    }

    public void clickFirstImage() {
        List<WebElement> webElementListAlternative = guruWebElements.findElements(webElementList);
        for (WebElement element : webElementListAlternative) {
            if (element.findElements(By.cssSelector("[data-src]")).size() > 0) {
                element.click();
                break;
            }
        }
    }

}
