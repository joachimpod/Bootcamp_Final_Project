package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.testng.Assert;
import utilities.Data.Drivers.DriverChromeImplemented;
import utilities.Data.Drivers.interfaces.Drivers;
import utilities.DemoBlaze.DemoBlazeActions.DemoBlazeActions;

import java.util.List;

public class DemoBlazeStepDefinitions {

	private Drivers driverChrome;
	private DemoBlazeActions webElementInteractions;

	@Given("I am on the shopping website")
	public void iAmOnTheShoppingWebsite() {
		String webURL = "https://www.demoblaze.com/";
		driverChrome = new DriverChromeImplemented();
		driverChrome.setWebURL(webURL);
		webElementInteractions = new DemoBlazeActions(driverChrome.getDriver());
	}

	@Given("I search for {string} and add it to the cart")
	public void iSearchForAndAddItToTheCart(String product) {
		webElementInteractions.clickProductAndAddToCart(product);
	}

	@Given("I click in categories {string}")
	public void iClickInCategories(String categories) {
		webElementInteractions.clickCategory(categories);
	}

	@Given("I proceed to the cart")
	public void iProceedToTheCart() {
		webElementInteractions.proceedToCart();
	}

	@Given("I search for multiple {string} and add it to the cart")
	public void iSearchForMultipleAndAddItToTheCart(String products) {
		List<String> productsList = List.of(products.split(","));
		for(String product : productsList){
			webElementInteractions.clickProductAndAddToCart(product);
		}
	}

	@Given("I should see the {string} in the shop cart")
	public void iShouldSeeTheInTheShopCart(String products) {
		List<String> productsList = List.of(products.split(","));
		webElementInteractions.iShouldSeeTheInTheShopCart(productsList);
	}

	@When("I place the order with {string} and {string} and {string}  and {string}  and {string} and {string}")
	public void iPlaceTheOrderWithAndAndAndAndAnd(String name, String country, String city, String creditCard, String month, String year) {
		webElementInteractions.placeOrder(name, country, city, creditCard, month, year);
	}

	@Then("I should see a confirmation {string}")
	public void iShouldSeeAConfirmation(String message) {
		String confirmationMessage = webElementInteractions.getConfirmationMessage();
		Assert.assertEquals(confirmationMessage, message);
	}

	@Then("I check if the data its correct with {string} and {string}")
	public void iCheckIfTheDataItsCorrectWithAnd(String name,String creditCard) {
		webElementInteractions.iCheckIfTheDataItsCorrectWithAnd(name, creditCard);
	}

	@After
	public void afterScenario() {
		driverChrome.getDriver().quit();
	}


}
