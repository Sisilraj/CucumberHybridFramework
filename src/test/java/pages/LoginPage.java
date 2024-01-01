package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public  LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//div[contains(@class,'alert alert-danger')]")
	private WebElement warningFieldMsg;
	
	public void enterEmail(String emailText) {
		elementUtils.typeTextIntoElement(emailField, emailText, 30);
	}
	
	public void enterPassword(String passwordText) {
		elementUtils.typeTextIntoElement(passwordField, passwordText, 30);
	}
	
	public AccountPage clickLogin() {
		elementUtils.clickOnElement(loginBtn, 30);
		return new AccountPage(driver);
	}
	
	public boolean getWarningFieldMsg() {
		return elementUtils.visibleTextFromElement(warningFieldMsg, 30);
	}

}
