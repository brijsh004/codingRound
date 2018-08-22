package unitTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import managers.PageObjectManager;
import managers.WebDriverManager;
import utils.Utility;

public class FlightBookingTest {

	private WebDriverManager driverManager;
	private PageObjectManager pageObject;

	@BeforeTest
	public void setUp() {
		driverManager = new WebDriverManager();
		pageObject = new PageObjectManager(driverManager.getDriver());

	}

	@Test
	public void testThatResultsAppearForAOneWayJourney() {

		pageObject.getSeleniumActionsPageObject().navigateToURL("https://www.cleartrip.com/");

		pageObject.getFlightPageObject().selectOneWayRadioButton();

		pageObject.getFlightPageObject().enterFromCity("Bangalore");

		// wait for the element for 5 seconds and then click the element
		pageObject.getSeleniumActionsPageObject().waitForElement(5, By.xpath("//ul[@id='ui-id-1']"));
		pageObject.getSeleniumActionsPageObject().getElementsList(By.xpath("//ul[@id='ui-id-1']/li")).get(0).click();

		pageObject.getFlightPageObject().enterToCity("Delhi");

		// wait for the element for 5 seconds and then click the element
		pageObject.getSeleniumActionsPageObject().waitForElement(5, By.xpath("//ul[@id='ui-id-2']"));
		pageObject.getSeleniumActionsPageObject().getElementsList(By.xpath("//ul[@id='ui-id-2']/li")).get(0).click();

		// select today's date
		pageObject.getFlightPageObject().selectTodaysDepartDate();

		pageObject.getFlightPageObject().clickSearchFlightButton();

		// wait for 3 seconds to see the actions after clicking search button
		Utility.getInstance().waitFor(3);

		// checking the results page is displayed or not
		Assert.assertTrue(pageObject.getSeleniumActionsPageObject().isElementDisplayed(
				pageObject.getSeleniumActionsPageObject().getElement(By.className("searchSummary"))));

		// close the browser
		driverManager.quitDriver();

	}

}
