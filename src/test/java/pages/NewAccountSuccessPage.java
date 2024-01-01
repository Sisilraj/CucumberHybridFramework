package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.CommonUtils;
import utility.ElementUtils;

public class NewAccountSuccessPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public  NewAccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	private WebElement successAccMsg;
	
	public boolean getSuccessfullNewAccountMsg() {
		return elementUtils.visibleTextFromElement(successAccMsg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
