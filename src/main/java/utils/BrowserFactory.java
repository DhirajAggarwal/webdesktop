package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	WebDriver driver;

	public WebDriver initializeBrowser(String browserType) {
		try {
			driver = setDriver(browserType);
		} catch (Exception e) {
			System.out.println("Error is :" + e.getMessage());
		}
		return driver;
	}

	public WebDriver setDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver();
			break;
		case "firefox":
			driver = initFireFoxDriver();
			break;
		default:
			System.out.println(browserType + " is invalid browser.");
			driver = initFireFoxDriver();
		}
		return driver;
	}

	public WebDriver initFireFoxDriver() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public WebDriver initChromeDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

}
