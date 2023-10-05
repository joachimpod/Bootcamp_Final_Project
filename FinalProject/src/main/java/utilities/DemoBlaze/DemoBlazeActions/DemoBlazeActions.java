package utilities.DemoBlaze.DemoBlazeActions;

import org.openqa.selenium.WebDriver;
import utilities.DemoBlaze.DemoBlazePages.DemoBlazePage;

public class DemoBlazeActions {

        private DemoBlazePage demoBlazePage;

        public DemoBlazeActions(WebDriver driver) {
            initDrivers(driver);
        }

        public void initDrivers(WebDriver driver) {
            demoBlazePage = new DemoBlazePage(driver);
        }
        public void clickProductAndAddToCart(String product) {
            demoBlazePage.clickProductAndAddToCart(product);
        }

        public void clickCategory(String category) {
            demoBlazePage.clickCategory(category);
        }

        public void proceedToCart() {
            demoBlazePage.proceedToCart();
        }

        public void placeOrder(String name, String country, String city, String creditCard, String month, String year) {
            demoBlazePage.placeOrder(name, country, city, creditCard, month, year);
        }

        public String getConfirmationMessage() {
            return demoBlazePage.getConfirmationMessage();
        }
}
