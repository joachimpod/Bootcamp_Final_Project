package utilities.Data.Locators;

import org.openqa.selenium.By;

public enum LocatorsGoogle {
    TEXT_FIELD(By.xpath("//textarea[@id='APjFqb']")),
    WEB_ELEMENT_LIST(By.xpath("//li[@jsaction='click:.CLIENT;mouseover:.CLIENT']")),
    LIST_OF_ELEMENTS_SEARCH_RESULT(By.cssSelector(".TzHB6b.cLjAic.K7khPe")),
    CITE_IN_FIRST_ELEMENT_SEARCH_RESULT(By.cssSelector("cite.qLRx3b.tjvcx.GvPZzd.cHaqb")),
    SEARCH_RESULTS(By.id("kp-wp-tab-overview"));
    private final By by;

    LocatorsGoogle(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }
}
