package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.testng.Assert;
import utilities.Data.Drivers.DriverChromeImplemented;
import utilities.Data.Drivers.interfaces.DriverChrome;
import utilities.DemoBlaze.DemoBlazeActions.DemoBlazeActions;

public class stepDefinitions {

	private DriverChrome driverChrome;
	private DemoBlazeActions webElementInteractions;

	@Given("I am on the shopping website")
	public void iAmOnTheShoppingWebsite() {
		String webURL = "https://www.demoblaze.com/";
		driverChrome = new DriverChromeImplemented(webURL);
		webElementInteractions = new DemoBlazeActions(driverChrome.getDriver());
	}

	@When("I search for {string} and add it to the cart")
	public void iSearchForAndAddItToTheCart(String product) {
		webElementInteractions.clickProductAndAddToCart(product);
	}

	@And("I click in categories {string}")
	public void iClickInCategories(String categories) {
		webElementInteractions.clickCategory(categories);
	}

	@And("I proceed to the cart")
	public void iProceedToTheCart() {
		webElementInteractions.proceedToCart();
	}

	@And("I place the order with {string} and {string} and {string}  and {string}  and {string} and {string}")
	public void iPlaceTheOrderWithAndAndAndAndAnd(String name, String country, String city, String creditCard, String month, String year) {
		webElementInteractions.placeOrder(name, country, city, creditCard, month, year);
	}

	@Then("I should see a confirmation {string}")
	public void iShouldSeeAConfirmation(String message) {
		String confirmationMessage = webElementInteractions.getConfirmationMessage();
		Assert.assertEquals(confirmationMessage, message);
	}

	@After
	public void afterScenario() {
		driverChrome.getDriver().quit();
	}
}
