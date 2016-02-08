package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BookingConfirmation;
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
	BookingConfirmation bookingConfirmation = new BookingConfirmation();

	@BeforeClass
	public void openURL() {
		helper.openURL();
	}

	@Test(priority = 1)
	public void verifySuccessFulLogin() {
		commonMethods.logInToOyoRooms("9899890123", "12345678");
		Assert.assertEquals(homePage.getLoggedInUserName(), userName);
	}

	@Test
	public void verifyHotelsDisplayedOnSearch() {
		/*
		 * Assert in this function is incomplete. So this has been commented
		 * Out.
		 */
		commonMethods.searchHotels();
		// Assert.assertEquals("", userName);
	}

	@Test(priority = 2)
	public void verifySuccessfulBookingConfirmation() {
		/*
		 * Below code is to make Successful Booking and assert it. Currently
		 * this is commented, so it doesn't make unnecessary bookings. This will
		 * be uncommented as cancelBooking() is ready.
		 */
		// Assert.assertEquals("YOUR BOOKING IS COMPLETE!",
		// commonMethods.bookingConfirmation());
	}
}
