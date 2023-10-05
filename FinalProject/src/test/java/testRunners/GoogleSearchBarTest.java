package testRunners;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.GoogleActions.GoogleSearchBarActions;

public class GoogleSearchBarTest {

    private GoogleSearchBarActions searchBarActions;

    @BeforeTest
    public void setUp() {
        searchBarActions = new GoogleSearchBarActions();
        searchBarActions.initDrivers();
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
        searchBarActions.closeDriver();
    }
}
