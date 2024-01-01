package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.ProductPage;

public class Search {
	
	WebDriver driver;
	private AccountPage accountPage;
	private ProductPage productPage;
	
	@Given("User open the application")
	public void user_open_the_application() {
		driver = DriverFactory.getDriver();
	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String validProduct) {
		accountPage = new AccountPage(driver);
		accountPage.enterProduct(validProduct);
	}

	@And("User click on search button")
	public void user_click_on_search_button() {
		productPage = accountPage.clickSearchBtn();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		Assert.assertTrue(productPage.displayValidProduct());
	}

	@When("User enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProduct) {
		accountPage = new AccountPage(driver);
		accountPage.enterProduct(invalidProduct);
	}

	@Then("User should get a message about no products matching")
	public void user_should_get_a_message_about_no_products_matching() {
		productPage = new ProductPage(driver);
		Assert.assertTrue(productPage.displayNoMatchProductMsg());
	}

	@When("User do not enters any products into search box field")
	public void user_do_not_enters_any_products_into_search_box_field() {
		accountPage = new AccountPage(driver);
		accountPage.enterProduct("");
	}

}
