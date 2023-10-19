package testRunners;

import org.testng.annotations.*;
import utilities.Data.Drivers.DriverChromeImplemented;
import utilities.Data.Drivers.interfaces.Drivers;
import utilities.Google.GooglePages.GoogleSearchPage;
import utilities.Google.GooglePages.GoogleSearchResultPage;

public class GoogleSearchBarTest {

    private Drivers driverChrome;
    private GoogleSearchPage googleSearchPage;

    @BeforeMethod
    public void setUp() {
        String webURL = "https://www.google.com/";
        driverChrome = new DriverChromeImplemented();
        driverChrome.setWebURL(webURL);
        googleSearchPage = new GoogleSearchPage(driverChrome.getDriver());
    }

    @Test
    public void performGoogleSearch() {
        String firstSearch = "auto";
        String secondSearch = "automation";
        String verifyText = "store.steampowered.com";

        googleSearchPage.searchAndSelectResults(firstSearch);
        googleSearchPage.clearSearchField();

        googleSearchPage.searchAndSelectResults(secondSearch);
        googleSearchPage.verifyNoCoincidencesBetweenLists();

        GoogleSearchResultPage googleSearchResultPage = googleSearchPage.clickFirstImage();
        googleSearchResultPage.verifyText(verifyText);
    }

    @AfterMethod
    public void tearDown() {
        driverChrome.getDriver().quit();
    }
}
