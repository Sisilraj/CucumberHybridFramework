package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.NewAccountSuccessPage;
import pages.RegisterPage;
import utility.CommonUtils;

public class Register {
	
	WebDriver driver;
	private RegisterPage registerPage;
	private NewAccountSuccessPage accountSuccess;
	CommonUtils emailTimestamp = new CommonUtils();
	
	@Given("User navigates to Register account page")
	public void user_navigates_to_register_account_page() {
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyaccount();
		registerPage = homePage.selectRegisterOption();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);	
		
		registerPage.enterFirstname(dataMap.get("firstName"));
		registerPage.enterLastname(dataMap.get("lastName"));
		registerPage.enterEmail(emailTimestamp.getEmailWithTimeStamp());
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
		
	}

	@And("User selects privacy and policy")
	public void user_selects_privacy_and_policy() {
		registerPage.clickPrivacyPolicyOption();
	}

	@And("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		accountSuccess = registerPage.clickContinueBtn();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		Assert.assertTrue(accountSuccess.getSuccessfullNewAccountMsg());
	}

	@And("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		registerPage.clickNewsletterOption();
	}
	
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);	
		
		registerPage.enterFirstname(dataMap.get("firstName"));
		registerPage.enterLastname(dataMap.get("lastName"));
		registerPage.enterEmail(dataMap.get("email"));
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
	}

	@Then("User should get proper warning message about duplicate email")
	public void user_should_get_proper_warning_message_about_duplicate_email() {		
		Assert.assertTrue(registerPage.getDuplicateEmailWarningMsg());
	}

	@When("User do not enter any details into fields")
	public void user_do_not_enter_any_details_into_fields() {
		registerPage.enterFirstname("");
		registerPage.enterLastname("");
		registerPage.enterEmail("");
		registerPage.enterTelephone("");
		registerPage.enterPassword("");
		registerPage.enterConfirmPassword("");
	}

	@Then("User should get proper warning message for every mandatory field")
	public void user_should_get_proper_warning_message_for_every_mandatory_field() {
		Assert.assertTrue(registerPage.getWarningMessageText());
		Assert.assertTrue(registerPage.getFnWarningMessageText());
		Assert.assertTrue(registerPage.getLnWarningMessageText());
		Assert.assertTrue(registerPage.getEmWarningMessageText());
		Assert.assertTrue(registerPage.getTpWarningMessageText());
		Assert.assertTrue(registerPage.getPwWarningMessageText());
	}

}
