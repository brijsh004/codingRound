package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumActions {

	private WebDriver driver;
	private WebDriverWait driverWait;

	public SeleniumActions(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToURL(String url) {
		driver.get(url);
	}

	public String getCurrentPageURL() {
		return driver.getCurrentUrl();
	}

	public void clearTextBox(WebElement element) {
		element.clear();
	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public List<WebElement> getElementsList(By by) {
		return driver.findElements(by);
	}

	public WebElement getElement(By by) {
		return driver.findElement(by);
	}

	public void waitForElement(int wait, By by) {
		driverWait = new WebDriverWait(driver, wait);
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void switchToFrameByNameOrId(String frameId) {
		driver.switchTo().frame(frameId);
	}
}
