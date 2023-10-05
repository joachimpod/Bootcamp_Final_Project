package testRunners;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Data.Drivers.DriverChromeImplemented;
import utilities.Data.Drivers.interfaces.DriverChrome;
import utilities.Google.GoogleActions.GoogleSearchBarActions;

import java.util.List;

public class GoogleSearchBarTest {

    private DriverChrome driverChrome;
    private GoogleSearchBarActions searchBarActions;

    @BeforeTest
    public void setUp() {
        String webURL = "https://www.google.com/";
        driverChrome = new DriverChromeImplemented(webURL);
        searchBarActions = new GoogleSearchBarActions(driverChrome.getDriver());
    }

    @Test
    public void performGoogleSearch() {
        String firstSearch = "auto";
        String secondSearch = "automation";
        String verifyText = "store.steampowered.com";

        List<WebElement> webElementListFirstSearch = searchBarActions.selectResults(firstSearch);
        searchBarActions.setWebElementListFirstResult(webElementListFirstSearch);
        searchBarActions.printResults(webElementListFirstSearch);
        searchBarActions.clearSearchField();

        List<WebElement> webElementListSecondSearch = searchBarActions.selectResults(secondSearch);
        searchBarActions.setWebElementListSecondResult(webElementListSecondSearch);
        searchBarActions.printResults(webElementListSecondSearch);
        searchBarActions.verifyNoCoincidencesBetweenLists();
        searchBarActions.clickFirstImage();
        searchBarActions.verifyText(verifyText);
    }

    @AfterTest
    public void tearDown() {
        driverChrome.getDriver().quit();
    }
}
