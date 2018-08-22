package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.FlightPage;
import pageObjects.HomePage;
import pageObjects.HotelPage;
import pageObjects.SignInPage;
import selenium.SeleniumActions;

public class PageObjectManager {

	private WebDriver driver;
	private FlightPage flightPage;
	private HotelPage hotelPage;
	private SignInPage signInPage;
	private HomePage homePage;
	private SeleniumActions seleniumActionsPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HotelPage getHotelPageObject() {
		return (hotelPage == null) ? hotelPage = new HotelPage(driver) : hotelPage;
	}

	public FlightPage getFlightPageObject() {
		return (flightPage == null) ? flightPage = new FlightPage(driver) : flightPage;
	}

	public SignInPage getSignInPageObject() {
		return (signInPage == null) ? signInPage = new SignInPage(driver) : signInPage;
	}

	public HomePage getHomePageObject() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public SeleniumActions getSeleniumActionsPageObject() {
		return (seleniumActionsPage == null) ? seleniumActionsPage = new SeleniumActions(driver) : seleniumActionsPage;
	}

}
