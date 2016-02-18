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
	
	String filePathCommonTestData = "./src/main/resources/data/CommonTestData.json",
			filePathBookingConfirmationPage = "./src/main/resources/objectRepo/BookingConfirmationPage.json",
			loginMobileNumber=helper.parseJSONToString("mobileNumber", filePathCommonTestData),
			loginPassword=helper.parseJSONToString("password", filePathCommonTestData),
			location= helper.parseJSONToString("location", filePathCommonTestData),
			checkinDate= helper.parseJSONToString("checkinDate", filePathCommonTestData),
			checkoutDate= helper.parseJSONToString("checkoutDate", filePathCommonTestData),
			successfulBookingMessage = helper.parseJSONToString("successfulBookingMessage", filePathBookingConfirmationPage),
			userName = helper.parseJSONToString("userName", filePathCommonTestData);

	
	@BeforeClass
	public void openURL() {
		helper.openURL();
	}
	
	@Test 
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
