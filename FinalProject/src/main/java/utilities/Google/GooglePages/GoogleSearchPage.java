package utilities.Google.GooglePages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Data.Locators.LocatorsGoogle;
import utilities.webElements.interfaces.GuruWebElements;
import utilities.webElements.GuruWebElementsImplemented;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPage {

    private final GuruWebElements guruWebElements;
    private final By textField;
    private final By webElementList;
    private List<String> webElementListFirstResult;
    private List<String> webElementListSecondResult;

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

    public void setWebElementListFirstResult(List<WebElement> webElementList){
        this.webElementListFirstResult = convertListWebElementToListString(webElementList);
    }

    public void setWebElementListSecondResult(List<WebElement> webElementList){
        this.webElementListSecondResult = convertListWebElementToListString(webElementList);
    }

    public void verifyNoCoincidencesBetweenLists() {
        for (String elementFromFirstList : webElementListFirstResult) {
            for (String elementFromSecondList : webElementListSecondResult) {
                Assert.assertNotEquals("Element found in both lists: " + elementFromFirstList, elementFromFirstList, elementFromSecondList);
            }
        }
    }

    private List<String> convertListWebElementToListString(List<WebElement> webElementList){
        List<String> textList = new ArrayList<>();
        for (WebElement element : webElementList) {
            textList.add(element.getText());
        }
        return textList;
    }

}
