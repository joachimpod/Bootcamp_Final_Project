package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import utilities.Data.Drivers.DriverChrome;
import utilities.Data.Locators.LocatorDemoBlaze;
import utilities.webElements.demoBlaze.GuruWebElementDemoBlazeImplemented;
import utilities.webElements.interfaces.GuruWebElements;

public class stepDefinitions {

	private DriverChrome driverChrome;
	private GuruWebElements guruWebElements;

	@Given("I am on the shopping website")
	public void iAmOnTheShoppingWebsite() {
		String webURL = "https://www.demoblaze.com/";
		driverChrome = new DriverChrome(webURL);
		guruWebElements = new GuruWebElementDemoBlazeImplemented(driverChrome.getDriver());
	}

	@And("I search for {string} and add it to the cart")
	public void iSearchForAndAddItToTheCart(String product) {
		guruWebElements.click(LocatorDemoBlaze.getByContains(product));
		guruWebElements.click(LocatorDemoBlaze.ADD_TO_CART_XPATH.getBy());
		guruWebElements.waitAlert();
		Alert alert = driverChrome.getDriver().switchTo().alert();
		alert.accept();
		guruWebElements.click(LocatorDemoBlaze.NAVBAR.getBy());
	}

	@And("I click in categories {string}")
	public void iClickInCategories(String categories) {
		guruWebElements.click(LocatorDemoBlaze.getByContains(categories));
	}

	@And("I proceed to the cart")
	public void iProceedToTheCart() {
		guruWebElements.click(LocatorDemoBlaze.SHOPCART.getBy());
	}


	@When("I place the order with {string} and {string} and {string}  and {string}  and {string} and {string}")
	public void iPlaceTheOrderWithAndAndAndAndAnd(String name, String country, String city, String creditCard, String month, String year) {
		guruWebElements.click(LocatorDemoBlaze.PLACE_ORDER_BUTTON_XPATH.getBy());
		guruWebElements.waits(LocatorDemoBlaze.NAME.getBy());
		guruWebElements.type(name,LocatorDemoBlaze.NAME.getBy());
		guruWebElements.type(country,LocatorDemoBlaze.COUNTRY.getBy());
		guruWebElements.type(city,LocatorDemoBlaze.CITY.getBy());
		guruWebElements.type(creditCard,LocatorDemoBlaze.CREDIT_CARD.getBy());
		guruWebElements.type(month,LocatorDemoBlaze.MONTH.getBy());
		guruWebElements.type(year,LocatorDemoBlaze.YEAR.getBy());
		guruWebElements.click(LocatorDemoBlaze.PURCHASE_BUTTON_XPATH.getBy());
	}

	@Then("I should see a confirmation {string}")
	public void iShouldSeeAConfirmation(String message) {
		System.out.println(guruWebElements.findElement(LocatorDemoBlaze.MESSAGE_SUCCESS.getBy()).getText().equals(message));
	}

	@After
	public void afterScenario() {
		driverChrome.getDriver().quit();
	}
}
