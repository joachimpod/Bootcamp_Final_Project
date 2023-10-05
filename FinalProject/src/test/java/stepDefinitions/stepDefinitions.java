package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import utilities.Data.Drivers.DriverChrome;
import utilities.webElements.interfaces.GuruWebElements;
import utilities.webElements.google.GuruWebElementsImplemented;

public class stepDefinitions {

	private DriverChrome driverChrome;
	private String webURL = "https://www.demoblaze.com/";
	private GuruWebElements guruWebElements;

	@Given("I am on the shopping website")
	public void iAmOnTheShoppingWebsite() {
		driverChrome = new DriverChrome(webURL);
		guruWebElements = new GuruWebElementsImplemented(driverChrome.getDriver());
	}

	@And("I search for {string} and add it to the cart")
	public void iSearchForAndAddItToTheCart(String product) {

	}

	@And("I proceed to the cart")
	public void iProceedToTheCart() {

	}

	@And("I review the cart items")
	public void iReviewTheCartItems() {

	}


	@When("I place the order with {string} and {string} and {string}  and {string}  and {string} and {string}")
	public void iPlaceTheOrderWithAndAndAndAndAnd(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {

	}

	@Then("I should see a confirmation {string}")
	public void iShouldSeeAConfirmation(String arg0) {

	}

	@After
	public void afterScenario() {
		driverChrome.getDriver().quit();
	}

}
