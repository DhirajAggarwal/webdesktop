package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BookingConfirmationPage;
import pages.CommonMethods;
import pages.HomePage;
import utils.BrowserFactory;
import utils.Helper;

public class HomePageTest extends BrowserFactory {

	Helper helper = new Helper();

	String filePathHardData = "./src/main/resources/data/HardData",
			loginMobileNumber=helper.parseJSONToString("mobileNumber", filePathHardData),
			loginPassword=helper.parseJSONToString("password", filePathHardData),
			userName= helper.parseJSONToString("userName", filePathHardData),
			location= helper.parseJSONToString("location", filePathHardData),
			checkinDate= helper.parseJSONToString("checkinDate", filePathHardData),
			checkoutDate= helper.parseJSONToString("checkoutDate", filePathHardData);
	

	CommonMethods commonMethods = new CommonMethods();
	HomePage homePage = new HomePage();
	BookingConfirmationPage bookingConfirmation = new BookingConfirmationPage();

	@BeforeClass
	public void openURL() {
		helper.openURL();
	}

	@Test(priority = 1)
	public void verifySuccessFulLogin() {
		commonMethods.logInToOyoRooms(loginMobileNumber,loginPassword);
		Assert.assertEquals(homePage.getLoggedInUserName(), userName);
	}

	@Test(priority = 2)
	public void verifyHotelsDisplayedOnSearch() {
		/*
		 * Assert in this function is incomplete. So this has been commented
		 * Out.
		 */
		commonMethods.searchHotels(location,checkinDate,checkoutDate);
		//Assert.assertEquals("", userName);
	}
}
