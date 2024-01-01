package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public  HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;	
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	public void clickOnMyaccount() {
		elementUtils.clickOnElement(myAccountDropMenu, 30);
	}
	
	public LoginPage selectLoginOption() {
		elementUtils.clickOnElement(loginOption, 30);
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		elementUtils.clickOnElement(registerOption, 30);	
		return new RegisterPage(driver);
	}

}
