package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CommonMethods;
import utils.BaseUtils;
import utils.BrowserFactory;
import utils.Helper;

public class HomePageTest extends BaseUtils {

	static WebDriver driver;

	static BrowserFactory browserFactory = new BrowserFactory();
	Helper helper = new Helper();
	CommonMethods commonMethods = new CommonMethods();

	String filePathHardData, filePathConfig, userName, browserType;

	@BeforeClass
	public void beforeClass() {
		filePathConfig = "./src/main/resources/config/config.json";
		browserType = helper.parseJSONToString("browserType", filePathConfig);
		driver = browserFactory.initializeBrowser(browserType);
		BaseUtils.launchBrowser(driver, true);
		filePathHardData = "./src/main/resources/data/HardData";
		userName = helper.parseJSONToString("userName", filePathHardData);
	}

	@Test
	public void testLogInToOyoRooms() {
		Assert.assertEquals(userName, commonMethods.logInToOyoRooms(driver));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
