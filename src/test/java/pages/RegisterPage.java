package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class RegisterPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public  RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id = "input-firstname")
	private WebElement fname;
	
	@FindBy(id = "input-lastname")
	private WebElement lname;
	
	@FindBy(id = "input-email")
	private WebElement e_mail;
	
	@FindBy(id = "input-telephone")
	private WebElement telephone;
	
	@FindBy(id = "input-password")
	private WebElement password;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "(//input[@name='newsletter'])[1]")
	private WebElement subscribeYes;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicy;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueBtn;
	
	@FindBy(xpath = "(//div[@id='account-register']//div)[1]")
	private WebElement duplicateWarningMsg;
	
	@FindBy(xpath = "//div[text()='Warning: You must agree to the Privacy Policy!']")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement firstNameWarning;
	
	@FindBy(xpath = "//div[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement lastNameWarning;
	
	@FindBy(xpath = "//input[@type='email']/following-sibling::div[1]")
	private WebElement emailWarning;
	
	@FindBy(xpath = "//input[@placeholder='Telephone']/following-sibling::div[1]")
	private WebElement telephoneWarning;
	
	@FindBy(xpath = "//input[@placeholder='Password']/following-sibling::div[1]")
	private WebElement passwordWarning;	
	
	public void enterFirstname(String firstName) {
		elementUtils.typeTextIntoElement(fname, firstName, 30);
	}
	
	public void enterLastname(String lastName) {
		elementUtils.typeTextIntoElement(lname, lastName, 30);
	}
	
	public void enterEmail(String emailText) {
		elementUtils.typeTextIntoElement(e_mail, emailText, 30);
	}
	
	public void enterTelephone(String telephoneText) {
		elementUtils.typeTextIntoElement(telephone, telephoneText, 30);
	}
	
	public void enterPassword(String passwordText) {
		elementUtils.typeTextIntoElement(password, passwordText, 30);
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		elementUtils.typeTextIntoElement(confirmPassword, confirmPasswordText, 30);
	}
	
	public void clickNewsletterOption() {
		elementUtils.clickOnElement(subscribeYes, 30);
	}
	
	public void clickPrivacyPolicyOption() {
		elementUtils.clickOnElement(privacyPolicy, 30);
	}
	
	public NewAccountSuccessPage clickContinueBtn() {
		elementUtils.clickOnElement(continueBtn, 30);
		return new NewAccountSuccessPage(driver);
	}
	
	public boolean getDuplicateEmailWarningMsg() {
		return elementUtils.visibleTextFromElement(duplicateWarningMsg, 30);
	}
	
	public boolean getWarningMessageText() {
		return elementUtils.visibleTextFromElement(privacyPolicyWarning, 30);
	}
	
	public boolean getFnWarningMessageText() {
		return elementUtils.visibleTextFromElement(firstNameWarning, 30);
	}
	
	public boolean getLnWarningMessageText() {
		return elementUtils.visibleTextFromElement(lastNameWarning, 30);
	}
	
	public boolean getEmWarningMessageText() {
		return elementUtils.visibleTextFromElement(emailWarning, 30);
	}
	
	public boolean getTpWarningMessageText() {
		return elementUtils.visibleTextFromElement(telephoneWarning, 30);
	}
	
	public boolean getPwWarningMessageText() {
		return elementUtils.visibleTextFromElement(passwordWarning, 30);
	}

}
