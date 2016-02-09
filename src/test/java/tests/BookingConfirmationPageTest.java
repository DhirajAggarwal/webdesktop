package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CommonMethods;
import pages.HomePage;
import utils.BrowserFactory;
import utils.Helper;

public class BookingConfirmationPageTest extends BrowserFactory{
  
	Helper helper = new Helper();
	HomePage homePage = new HomePage();
	CommonMethods commonMethods = new CommonMethods();
	
	String filePathHardData = "./src/main/resources/data/HardData",
			filePathBookingConfirmationPage = "./src/main/resources/objectRepo/BookingConfirmationPage.json",
			loginMobileNumber=helper.parseJSONToString("mobileNumber", filePathHardData),
			loginPassword=helper.parseJSONToString("password", filePathHardData),
			location= helper.parseJSONToString("location", filePathHardData),
			checkinDate= helper.parseJSONToString("checkinDate", filePathHardData),
			checkoutDate= helper.parseJSONToString("checkoutDate", filePathHardData),
			successfulBookingMessage = helper.parseJSONToString("successfulBookingMessage", filePathBookingConfirmationPage),
			userName = helper.parseJSONToString("userName", filePathHardData);

	
	@BeforeClass
	public void openURL() {
		helper.openURL();
	}
	
	@Test(priority = 0)
	public void verifySuccessfulBookingConfirmation() {
		commonMethods.logInToOyoRooms(loginMobileNumber,loginPassword);
		commonMethods.searchHotels(location,checkinDate,checkoutDate);
		homePage.hoverOnUserName(userName);
		homePage.logoutUser();
		/*
		 * Below code is to make Successful Booking and assert it. Currently
		 * this is commented, so it doesn't make unnecessary bookings. This will
		 * be uncommented as cancelBooking() is ready.
		 */
		 //Assert.assertEquals(commonMethods.bookingConfirmation(), successfulBookingMessage);
	}
}
