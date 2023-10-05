package utilities.GoogleActions;

import org.openqa.selenium.WebElement;
import utilities.Data.Drivers.DriverChrome;

import java.util.List;

public class GoogleSearchBarActions {

    private DriverChrome driverChrome;
    private GoogleSearchPage googleSearchPage;
    private GoogleSearchResult googleSearchResult;
    private List<WebElement> webElementListFirstResult;
    private List<WebElement> webElementListSecondResult;

    public void initDrivers() {
        String webURL = "https://www.google.com/";
        driverChrome = new DriverChrome(webURL);
        googleSearchPage = new GoogleSearchPage(driverChrome.getDriver());
        googleSearchResult = new GoogleSearchResult(driverChrome.getDriver());
    }

    public List<WebElement> selectResults(String search) {
        List<WebElement> webElementList = googleSearchPage.searchAndSelectResults(search);
        googleSearchPage.printList(webElementList);
        return webElementList;
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

    public void closeDriver() {
        driverChrome.getDriver().quit();
    }

    public void printFirstAndSecondList(){
        System.out.println("First list:");
        googleSearchPage.printList(webElementListFirstResult);
        System.out.println("Second list:");
        googleSearchPage.printList(webElementListSecondResult);

    }

    public void setWebElementListFirstResult(List<WebElement> webElementList){
        this.webElementListFirstResult = webElementList;
    }
    public void setWebElementListSecondResult(List<WebElement> webElementList){
        this.webElementListSecondResult = webElementList;
    }
}
