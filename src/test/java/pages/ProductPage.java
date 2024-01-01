package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class ProductPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public  ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validSearchProduct; 
	
	@FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
	private WebElement noMatchProduct;
	
	public boolean displayValidProduct() {
		return elementUtils.visibleTextFromElement(validSearchProduct, 30);
	}
	
	public boolean displayNoMatchProductMsg() {
		return elementUtils.visibleTextFromElement(noMatchProduct, 30);
	}

}
