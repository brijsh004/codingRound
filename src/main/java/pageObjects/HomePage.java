package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(id = "userAccountLink")
	private WebElement userAccountLink;

	@FindBy(id = "SignIn")
	private WebElement signInButton;

	@FindBy(linkText = "Register")
	private WebElement registerLink;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickUserAccountLink() {
		userAccountLink.click();
	}

	public void clickSignInButton() {
		signInButton.click();
	}

	public void clickRegistrationLink() {
		registerLink.click();
	}
}
