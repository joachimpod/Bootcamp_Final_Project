package utilities.Google.GoogleActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Google.GooglePages.GoogleSearchPage;
import utilities.Google.GooglePages.GoogleSearchResultPage;

import java.util.List;

public class GoogleSearchBarActions {

    private GoogleSearchPage googleSearchPage;
    private GoogleSearchResultPage googleSearchResult;

    public GoogleSearchBarActions(WebDriver driver){
        initDrivers(driver);
    }

    public void initDrivers(WebDriver driver) {
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchResult = new GoogleSearchResultPage(driver);
    }


    public List<WebElement> selectResults(String search) {
        return googleSearchPage.searchAndSelectResults(search);
    }

    public void printResults(List<WebElement> results) {
        googleSearchPage.printList(results);
    }

    public void clearSearchField() {
        googleSearchPage.clearSearchField();
    }

    public void clickFirstImage() {
        googleSearchPage.clickFirstImage();
    }

    public void verifyText(String text) {
        googleSearchResult.verifyText(text);
    }

    public void setWebElementListFirstResult(List<WebElement> webElementList){
        googleSearchPage.setWebElementListFirstResult(webElementList);
    }

    public void setWebElementListSecondResult(List<WebElement> webElementList){
        googleSearchPage.setWebElementListSecondResult(webElementList);
    }

    public void verifyNoCoincidencesBetweenLists() {
        googleSearchPage.verifyNoCoincidencesBetweenLists();
    }

}
