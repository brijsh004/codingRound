package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightPage {

	@FindBy(linkText = "Flights")
	private WebElement flightLink;

	@FindBy(id = "OneWay")
	private WebElement oneWayRadioButton;

	@FindBy(id = "RoundTrip")
	private WebElement roundTripRadioButton;

	@FindBy(id = "MultiCity")
	private WebElement multiCityRadioButton;

	@FindBy(id = "FromTag")
	private WebElement fromTextBox;

	@FindBy(id = "ToTag")
	private WebElement toTextBox;

	@FindBy(id = "DepartDate")
	private WebElement departDateBox;

	@FindBy(id = "ReturnDate")
	private WebElement returnDateBox;

	@FindBy(id = "Adults")
	private WebElement adultsDropDown;

	@FindBy(id = "Childrens")
	private WebElement childrenDropDown;

	@FindBy(id = "Infants")
	private WebElement infantsDropDown;

	@FindBy(id = "MoreOptionsLink")
	private WebElement moreOptionsLink;

	@FindBy(id = "Class")
	private WebElement travelClassDropDown;

	@FindBy(id = "AirlineAutocomplete")
	private WebElement prefferedAirlineTextBox;

	@FindBy(id = "SearchBtn")
	private WebElement searchButton;

	public FlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickFlightLink() {
		flightLink.click();
	}

	public void selectOneWayRadioButton() {
		oneWayRadioButton.click();
	}

	public void selectRoundTripCheckBox() {
		roundTripRadioButton.click();
	}

	public void selectMultiCityCheckBox() {
		oneWayRadioButton.click();
	}

	public void enterFromCity(String fromCity) {
		fromTextBox.clear();
		fromTextBox.sendKeys(fromCity);
	}

	public void enterToCity(String toCity) {
		toTextBox.clear();
		toTextBox.sendKeys(toCity);
	}

	public void selectTodaysDepartDate() {
		departDateBox.sendKeys(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		departDateBox.sendKeys(Keys.ENTER);
	}

	public void enterDepartDate(String date) {
		departDateBox.sendKeys(date);
		departDateBox.sendKeys(Keys.ENTER);
	}

	public void clickSearchFlightButton() {
		searchButton.submit();
	}

}
