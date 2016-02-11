package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BookingConfirmationPage;
import pages.CommonMethods;
import pages.HomePage;
import pages.ManageBookingPage;
import utils.BrowserFactory;

public class BookingConfirmationPageTest extends BrowserFactory {

	CommonMethods commonMethods = new CommonMethods();
	BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
	HomePage homePage = new HomePage();
	ManageBookingPage manageBookingPage = new ManageBookingPage();

	String filePathHardData = "./src/main/resources/data/HardData",
			filePathBookingConfirmationPageTestData = "./src/main/resources/data/BookingConfirmationPageTestData.json",
			filePathManageBookingPageTestData = "./src/main/resources/data/ManageBookingPageTestData.json",
			loginMobileNumber = helper.parseJSONToString("mobileNumber", filePathHardData),
			loginPassword = helper.parseJSONToString("password", filePathHardData),
			location = helper.parseJSONToString("location", filePathHardData),
			checkinDate = helper.parseJSONToString("checkinDate", filePathHardData),
			checkoutDate = helper.parseJSONToString("checkoutDate", filePathHardData),
			successfulBookingMessage = helper.parseJSONToString("successfulBookingMessage",
					filePathBookingConfirmationPageTestData),
			bookingCancellationMessage = helper.parseJSONToString("bookingCancellationMessage",
					filePathManageBookingPageTestData);

	@BeforeMethod
	public void openURL() {
		helper.openURL();
	}

	/*
	 * This Test is Logging In, Making Successful Booking at PAH and finally
	 * Canceling the Booking.
	 */
	@Test
	public void verifySuccessfulBookingPAHafterLoginAndBookingCancellation() {
		commonMethods.logInToOyoRooms(loginMobileNumber, loginPassword);
		commonMethods.searchHotels(location, checkinDate, checkoutDate);
		commonMethods.bookingConfirmationPAH();
		Assert.assertEquals(successfulBookingMessage, bookingConfirmationPage.getBookingSuccessMessage());
		homePage.clickUserName();
		commonMethods.cancelBooking();
		Assert.assertEquals(bookingCancellationMessage, manageBookingPage.getCancellationText());
	}
}
