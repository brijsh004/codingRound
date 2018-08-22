package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	@FindBy(id = "email")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "signInButton")
	private WebElement signInButon;

	@FindBy(linkText = "I forgot my password")
	private WebElement forgotPasswordLink;

	@FindBy(id = "signuplink")
	private WebElement signUpLink;

	@FindBy(partialLinkText = "Facebook")
	private WebElement signInWithFacebook;

	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void enterPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void clickSignInButton() {
		signInButon.submit();
	}

	public void clickSignUpLink() {
		signUpLink.click();
	}

	public void clickForgotPasswordLink() {
		forgotPasswordLink.click();
	}

	public void clickSignInWithFacebookLink() {
		signInWithFacebook.click();
	}
}
