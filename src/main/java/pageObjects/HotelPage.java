package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelPage {

	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "CheckInDate")
	private WebElement checkInDateBox;

	@FindBy(id = "CheckOutDate")
	private WebElement checkOutDateBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	@FindBy(xpath = "//select[@title='Number of rooms']")
	private WebElement roomsSelection;

	@FindBy(xpath = "//select[starts-with(@id,'Adult_')]")
	private WebElement adultsSelection;

	@FindBy(xpath = "//select[starts-with(@id,'Childs_')]")
	private WebElement childsSelection;

	public HotelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickHotelLink() {
		hotelLink.click();
	}

	public void enterLocation(String location) {
		localityTextBox.clear();
		localityTextBox.sendKeys(location);
	}

	public void selectTodaysCheckInDate() {
		checkInDateBox.sendKeys(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		checkInDateBox.sendKeys(Keys.ENTER);
	}

	public void selectCheckInDate(String checkInDate) {
		checkInDateBox.sendKeys(checkInDate);
		checkInDateBox.sendKeys(Keys.ENTER);
	}

	public void selectNextCheckOutDate() {
		checkOutDateBox.click();
		checkOutDateBox.sendKeys(Keys.ENTER);
	}

	public void selectCheckOutDate(String checkOutDate) {
		checkOutDateBox.sendKeys(checkOutDate);
		checkOutDateBox.sendKeys(Keys.ENTER);
	}

	public void selectTravellersInfo(String travellers) {
		new Select(travellerSelection).selectByVisibleText(travellers);
	}

	public void clickSearchHotelButton() {
		searchButton.click();
	}
}
