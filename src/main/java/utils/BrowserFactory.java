package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BrowserFactory {

	static WebDriver driver;
	String filePathHardData, filePathConfig, browserType;
	Helper helper = new Helper();

	@BeforeClass
	public WebDriver initializeBrowser() {
		filePathConfig = "./src/main/resources/config/config.json";
		browserType = helper.parseJSONToString("browserType", filePathConfig);
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
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver initChromeDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
