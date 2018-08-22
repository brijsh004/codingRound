package unitTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import managers.PageObjectManager;
import managers.WebDriverManager;

public class SignInTest {

	private WebDriverManager driverManager;
	private PageObjectManager pageObject;

	@BeforeTest
	public void setUp() {
		driverManager = new WebDriverManager();
		pageObject = new PageObjectManager(driverManager.getDriver());

	}

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		pageObject.getSeleniumActionsPageObject().navigateToURL("https://www.cleartrip.com/");

		// click user account icon in the home page
		pageObject.getHomePageObject().clickUserAccountLink();

		pageObject.getHomePageObject().clickSignInButton();

		// switching to frame and click sign-in button
		pageObject.getSeleniumActionsPageObject().switchToFrameByNameOrId("modal_window");
		pageObject.getSignInPageObject().clickSignInButton();

		// checking the expected errors
		String errors1 = pageObject.getSeleniumActionsPageObject().getElement(By.id("errors1")).getText();
		Assert.assertTrue(errors1.contains("There were errors in your submission"));

		// close the browser
		driverManager.quitDriver();
	}

}
