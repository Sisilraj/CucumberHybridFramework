package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class AccountPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public  AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//h2[text()='My Account']")
	private WebElement myAccountTitle;
	
	@FindBy(xpath = "(//input[@name='search'])[1]")
	private WebElement searchBox;
	
	@FindBy(xpath = "//button[contains(@class,'btn btn-default')]")
	private WebElement searchBtn;
	
	public boolean isDisplayMyaccountPage() {
		return elementUtils.visibleTextFromElement(myAccountTitle, 30);
	}
	
	public void enterProduct(String productName) {
		elementUtils.typeTextIntoElement(searchBox, productName, 30);
	}
	
	public ProductPage clickSearchBtn() {
		elementUtils.clickOnElement(searchBtn, 30);
		return new ProductPage(driver);
	}

}
