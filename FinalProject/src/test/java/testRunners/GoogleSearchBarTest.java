package testRunners;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Data.Drivers.DriverChromeImplemented;
import utilities.Data.Drivers.interfaces.DriverChrome;
import utilities.Google.GoogleActions.GoogleSearchBarActions;

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
        searchBarActions.setWebElementListFirstResult(searchBarActions.selectResults("auto"));
        searchBarActions.clearSearchField();
        searchBarActions.setWebElementListSecondResult(searchBarActions.selectResults("automation"));
        searchBarActions.verifyNoCoincidencesBetweenLists();
        searchBarActions.clickFirstImage();
        searchBarActions.verifyText("store.steampowered.com");
    }

    @AfterTest
    public void tearDown() {
        driverChrome.getDriver().quit();
    }
}
