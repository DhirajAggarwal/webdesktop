package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CommonMethods;
import pages.HomePage;
import utils.BrowserFactory;
import utils.Helper;

public class HomePageTest extends BrowserFactory {

	Helper helper = new Helper();

	String filePathHardData = "./src/main/resources/data/HardData",
			userName = helper.parseJSONToString("userName", filePathHardData);

	CommonMethods commonMethods = new CommonMethods();
	HomePage homePage = new HomePage();

	@BeforeClass
	public void openURL() {
		helper.openURL();
	}

	@Test
	public void verifySuccessFulLogin() {
		commonMethods.logInToOyoRooms("9899890123","12345678");
		Assert.assertEquals(homePage.getLoggedInUserName(), userName);
	}
	
	@Test
	public void verifyHotelsDisplayedOnSearch(){
		commonMethods.searchHotels();
		//Assert.assertEquals("", userName);
	}

}
