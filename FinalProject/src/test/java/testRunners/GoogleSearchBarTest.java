package testRunners;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Data.Drivers.DriverChrome;
import utilities.GoogleActions.GoogleSearchBarActions;

public class GoogleSearchBarTest {

    private DriverChrome driverChrome;
    private GoogleSearchBarActions searchBarActions;

    @BeforeTest
    public void setUp() {
        String webURL = "https://www.google.com/";
        driverChrome = new DriverChrome(webURL);
        searchBarActions = new GoogleSearchBarActions();
        searchBarActions.initDrivers(driverChrome.getDriver());
    }

    @Test
    public void performGoogleSearch() {
        searchBarActions.setWebElementListFirstResult(searchBarActions.selectResults("auto"));
        searchBarActions.clearSearchField();
        searchBarActions.setWebElementListSecondResult(searchBarActions.selectResults("automation"));
        searchBarActions.printFirstAndSecondList();
        searchBarActions.clickFirstImage();
        searchBarActions.verifyText("store.steampowered.com");
    }

    @AfterTest
    public void tearDown() {
        driverChrome.getDriver().quit();
    }
}
