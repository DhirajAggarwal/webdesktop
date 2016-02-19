package utils;

import java.net.InetAddress;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BrowserFactory {

	static RemoteWebDriver driver;
	String filePathConfig, browserType;
	protected Helper helper = new Helper();

	@BeforeSuite
	public RemoteWebDriver initializeBrowser() {
		filePathConfig = "./src/main/resources/config/config.json";
		browserType = helper.parseJSONToString("browserType", filePathConfig);
		try {
			driver = setDriver(browserType);
		} catch (Exception e) {
			System.out.println("Error is :" + e.getMessage());
		}
		return driver;
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
	}

	public RemoteWebDriver setDriver(String browserType) throws Exception {
		try {
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

		} catch (Exception ex) {
			System.out.println("OYOWeb: " + ex.getMessage());
		}

		return driver;
	}

	public RemoteWebDriver initFireFoxDriver() throws Exception {
		String nodeUrl1 = "http://";
		String nodeip = "";
		String nodeUrl2 = "/wd/hub";
		String nodeUrl = "";
		String ipAddress = "saurabhthemenace:9a9c95fb-a726-4958-9dba-34d265d15b71@ondemand.saucelabs.com:80";
		String port1 = ":4444";
		String publicipAddress = "124.124.44.49";
		// String publicipAddress = "10.10.1.148";

		try {
			DesiredCapabilities Dcp = new DesiredCapabilities();

			Dcp = DesiredCapabilities.firefox();

			Dcp.setBrowserName("firefox");

			Dcp.setPlatform(Platform.ANY);

			InetAddress inet = InetAddress.getByName(publicipAddress);

			if (inet.isReachable(5000)) {
				nodeip = publicipAddress;
				nodeUrl = nodeUrl1 + nodeip + port1 + nodeUrl2;
			} else {
				nodeip = ipAddress;
				nodeUrl = nodeUrl1 + nodeip + nodeUrl2;
			}
			// driver = new RemoteWebDriver(new URL(nodeUrl), Dcp);
			// Uncomment below section for running on local
			driver = new FirefoxDriver();

			driver.manage().window().maximize();
			// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		} catch (Exception ex) {
			System.out.println("OYOWeb: " + ex.getMessage());
		}
		return driver;
	}

	public RemoteWebDriver initChromeDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
}