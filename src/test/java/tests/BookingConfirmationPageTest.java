package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CommonMethods;
import utils.BrowserFactory;
import utils.Helper;

public class BookingConfirmationPageTest extends BrowserFactory{
  
	Helper helper = new Helper();
	CommonMethods commonMethods = new CommonMethods();
	
	String filePathHardData = "./src/main/resources/data/HardData",
			filePathBookingConfirmationPage = "./src/main/resources/objectRepo/BookingConfirmationPage.json",
			loginMobileNumber=helper.parseJSONToString("mobileNumber", filePathHardData),
			loginPassword=helper.parseJSONToString("password", filePathHardData),
			location= helper.parseJSONToString("location", filePathHardData),
			checkinDate= helper.parseJSONToString("checkinDate", filePathHardData),
			checkoutDate= helper.parseJSONToString("checkoutDate", filePathHardData),
			successfulBookingMessage = helper.parseJSONToString("successfulBookingMessage", filePathBookingConfirmationPage);

	
	@BeforeClass
	public void openURL() {
		helper.openURL();
	}
	
	@Test(priority = 1)
	public void verifySuccessfulBookingConfirmation() {
		commonMethods.logInToOyoRooms(loginMobileNumber,loginPassword);
		commonMethods.searchHotels(location,checkinDate,checkoutDate);
		/*
		 * Below code is to make Successful Booking and assert it. Currently
		 * this is commented, so it doesn't make unnecessary bookings. This will
		 * be uncommented as cancelBooking() is ready.
		 */
		 //Assert.assertEquals(commonMethods.bookingConfirmation(), successfulBookingMessage);
	}
}
