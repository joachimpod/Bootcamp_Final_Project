package utilities.Google.GooglePages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Data.Locators.LocatorsGoogle;
import utilities.webElements.WebElementsFunctionalityImplemented;
import utilities.webElements.interfaces.WebElementsFunctionality;

import java.util.*;

public class GoogleSearchPage {

    private final WebElementsFunctionality WebElementsFunctionality;
    private final By textField;
    private final By webElementList;
    private List<String> webElementListFirstResult;
    private List<String> webElementListSecondResult;

    public GoogleSearchPage(WebDriver driver) {
        WebElementsFunctionality = new WebElementsFunctionalityImplemented(driver);
        textField = LocatorsGoogle.TEXT_FIELD.getBy();
        webElementList = LocatorsGoogle.WEB_ELEMENT_LIST.getBy();
    }

    public void searchAndSelectResults(String search) {
        WebElementsFunctionality.type(search, textField);
        WebElementsFunctionality.waits(webElementList);
        List<WebElement> webElementListAux = WebElementsFunctionality.findElements(webElementList);
        fillTheWebElementsLists(webElementListAux);
        printList(webElementListAux);
    }

    private void fillTheWebElementsLists(List<WebElement> webElementList){
        if(webElementListFirstResult == null){
            setWebElementListFirstResult(webElementList);
        }
        else {
            setWebElementListSecondResult(webElementList);
        }
    }

    public void clearSearchField() {
        WebElementsFunctionality.findElement(textField).clear();
    }

    public void printList(List<WebElement> listOfElements) {
        for (WebElement option : listOfElements) {
            System.out.println(option.getText());
        }
        System.out.println();
    }

    public GoogleSearchResultPage clickFirstImage() {
        List<WebElement> webElementListAlternative = WebElementsFunctionality.findElements(webElementList);
        for (WebElement element : webElementListAlternative) {
            if (!element.findElements(By.cssSelector("[data-src]")).isEmpty()) {
                element.click();
                return new GoogleSearchResultPage(WebElementsFunctionality.getDriver());
            }
        }
        return new GoogleSearchResultPage(WebElementsFunctionality.getDriver());
    }

    public void setWebElementListFirstResult(List<WebElement> webElementList){
        this.webElementListFirstResult = convertListWebElementToListString(webElementList);
    }

    public void setWebElementListSecondResult(List<WebElement> webElementList){
        this.webElementListSecondResult = convertListWebElementToListString(webElementList);
    }

    private List<String> convertListWebElementToListString(List<WebElement> webElementList){
        List<String> textList = new ArrayList<>();
        for (WebElement element : webElementList) {
            textList.add(element.getText());
        }
        return textList;
    }

    public void verifyNoCoincidencesBetweenLists() {
        boolean anyMatch = webElementListFirstResult.stream().noneMatch(
                firstElement -> webElementListSecondResult.contains(firstElement)
        );
        Assert.assertTrue("Element found in both lists.",anyMatch);
    }

}
