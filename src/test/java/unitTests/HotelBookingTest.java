package unitTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import managers.PageObjectManager;
import managers.WebDriverManager;
import utils.Utility;

public class HotelBookingTest {

	private WebDriverManager driverManager;
	private PageObjectManager pageObject;

	@BeforeTest
	public void setUp() {
		driverManager = new WebDriverManager();
		pageObject = new PageObjectManager(driverManager.getDriver());

	}

	@Test
	public void shouldBeAbleToSearchForHotels() {

		pageObject.getSeleniumActionsPageObject().navigateToURL("https://www.cleartrip.com/");

		// click hotel link
		pageObject.getHotelPageObject().clickHotelLink();

		pageObject.getHotelPageObject().enterLocation("Indiranagar, Bangalore");

		// wait for the element for 5 seconds and then click the element
		pageObject.getSeleniumActionsPageObject().waitForElement(5, By.xpath("//ul[@id='ui-id-1']"));
		pageObject.getSeleniumActionsPageObject().getElementsList(By.xpath("//ul[@id='ui-id-1']/li[@class='list']"))
				.get(0).click();

		// select today's date
		pageObject.getHotelPageObject().selectTodaysCheckInDate();

		// select next to today's date, i.e, tommorow's date
		pageObject.getHotelPageObject().selectNextCheckOutDate();

		pageObject.getHotelPageObject().selectTravellersInfo("1 room, 2 adults");

		pageObject.getHotelPageObject().clickSearchHotelButton();

		// wait for 3 seconds to see the actions after clicking search button
		Utility.getInstance().waitFor(3);

		// checking the results page is displayed or not
		Assert.assertTrue(pageObject.getSeleniumActionsPageObject().isElementDisplayed(
				pageObject.getSeleniumActionsPageObject().getElement(By.className("searchSummary"))));

		// close the browser
		driverManager.quitDriver();

	}

}
