package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class Login {
	
	WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private AccountPage accountPage;
	
	@Given("User has navigated to login page")
	public void user_has_navigated_to_login_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyaccount();
		loginPage = homePage.selectLoginOption();
	}	

	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailText) {
		loginPage.enterEmail(emailText);
	}

	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordText) {
		loginPage.enterPassword(passwordText);
	}

	@And("User click on Login button")
	public void user_click_on_login_button() {
		accountPage = loginPage.clickLogin();
	}

	@Then("User should get succesfully logged in")
	public void user_should_get_succesfully_logged_in() {
		Assert.assertTrue(accountPage.isDisplayMyaccountPage());
	}
	
	@When("^User enters invalid email address (.+) into email field$")
	public void user_enters_invalid_email_address_into_email_field(String wrongEmailText) {
		loginPage.enterEmail(wrongEmailText);
	}

	@And("^User enters invalid password (.+) into password field$")
	public void user_enters_invalid_password_into_password_field(String wrongPasswordText) {
		loginPage.enterPassword(wrongPasswordText);
	}

	@Then("User should get proper warning message about credentials mismatch")
	public void user_should_get_proper_warning_message_about_credentials_mismatch() {
		Assert.assertTrue(loginPage.getWarningFieldMsg());
	}

	@When("User do not enter email address into email field")
	public void user_do_not_enter_email_address_into_email_field() {
		loginPage.enterEmail("");
	}

	@When("User do not enter password into password field")
	public void user_do_not_enter_password_into_password_field() {
		loginPage.enterPassword("");
	}

}
