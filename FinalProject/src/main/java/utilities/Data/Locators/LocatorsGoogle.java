package utilities.Data.Locators;

import org.openqa.selenium.By;

public enum LocatorsGoogle {
    TEXT_FIELD(By.xpath("//textarea[@id='APjFqb']")),
    WEB_ELEMENT_LIST(By.xpath("//li[@jsaction='click:.CLIENT;mouseover:.CLIENT']")),
    FIRST_ELEMENT_SEARCH(By.xpath("//body/div[@id='main']/div[@id='cnt']/div[@id='rcnt']/div[@id='center_col']/div[@id='res']/div[@id='search']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/a[1]/div[1]/div[1]/div[1]/cite[1]"));

    private final By by;

    LocatorsGoogle(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }
}
