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
	loginmobileNumber=helper.parseJSONToString("mobileNumber", filePathHardData),
	loginpassword=helper.parseJSONToString("password", filePathHardData),
	userName= helper.parseJSONToString("userName", filePathHardData),
	location= helper.parseJSONToString("location", filePathHardData),
	checkinDate= helper.parseJSONToString("checkinDate", filePathHardData),
	checkoutDate= helper.parseJSONToString("checkoutDate", filePathHardData);
	

	CommonMethods commonMethods = new CommonMethods();
	HomePage homePage = new HomePage();

	@BeforeClass
	public void openURL() {
		helper.openURL();
	}

	@Test
	public void verifySuccessFulLogin() {
		commonMethods.logInToOyoRooms(loginmobileNumber,loginpassword);
		Assert.assertEquals(homePage.getLoggedInUserName(), userName);
	}
	
	@Test
	public void verifyHotelsDisplayedOnSearch(){
		commonMethods.searchHotels(location,checkinDate,checkoutDate);
		//Assert.assertEquals("", userName);
	}

}
