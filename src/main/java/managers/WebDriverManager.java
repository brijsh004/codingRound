package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sun.javafx.PlatformUtil;

public class WebDriverManager {
	private WebDriver driver;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	ChromeOptions options;

	private WebDriver createDriver() {
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		setDriverPath();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	public void setDriverPath() {
		if (PlatformUtil.isMac()) {
			System.setProperty(CHROME_DRIVER_PROPERTY, "chromedriver");
		}
		if (PlatformUtil.isWindows()) {
			System.setProperty(CHROME_DRIVER_PROPERTY, "chromedriver.exe");
		}
		if (PlatformUtil.isLinux()) {
			System.setProperty(CHROME_DRIVER_PROPERTY, "chromedriver_linux");
		}
	}

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	public void closeDriver() {
		driver.close();
	}

	public void quitDriver() {
		driver.quit();

	}

}
