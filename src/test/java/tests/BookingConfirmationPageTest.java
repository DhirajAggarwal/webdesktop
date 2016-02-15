package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BookingConfirmationPage;
import pages.CommonMethods;
import pages.HomePage;
import pages.HotelPage;
import pages.ManageBookingPage;
import utils.BrowserFactory;

public class BookingConfirmationPageTest extends BrowserFactory {

	CommonMethods commonMethods = new CommonMethods();
	BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
	HomePage homePage = new HomePage();
	ManageBookingPage manageBookingPage = new ManageBookingPage();
	HotelPage hotelPage = new HotelPage();

	String filePathCommonTestData = "./src/main/resources/data/CommonTestData.json",
			loginMobileNumber = helper.parseJSONToString("mobileNumber", filePathCommonTestData),
			loginPassword = helper.parseJSONToString("password", filePathCommonTestData),
			location = helper.parseJSONToString("location", filePathCommonTestData),
			checkinDate = helper.parseJSONToString("checkinDate", filePathCommonTestData),
			checkoutDate = helper.parseJSONToString("checkoutDate", filePathCommonTestData);

	String filePathBookingConfirmationPageTestData = "./src/main/resources/data/BookingConfirmationPageTestData.json",
			filePathManageBookingPageTestData = "./src/main/resources/data/ManageBookingPageTestData.json",
			successfulBookingMessage = helper.parseJSONToString("successfulBookingMessage",
					filePathBookingConfirmationPageTestData),
			bookingCancellationMessage = helper.parseJSONToString("bookingCancellationMessage",
					filePathManageBookingPageTestData);

	String filePathHotelPageData = "./src/main/resources/data/HotelPageData.json",
			guestName = helper.parseJSONToString("guestName", filePathHotelPageData),
			guestMobile = helper.parseJSONToString("guestMobile", filePathHotelPageData),
			emailAddress = helper.parseJSONToString("emailAddress", filePathHotelPageData),
			couponCode = helper.parseJSONToString("couponCode", filePathHotelPageData),
			verificationCode = helper.parseJSONToString("verificationCode", filePathHotelPageData);

	@BeforeMethod
	public void openURL() {
		helper.openURL();
	}

	/*
	 * This Test is Logging In, Making Successful Booking at PAH and finally
	 * Canceling the Booking.
	 */
	@Test
	public void verifySuccessfulBookingPAHafterLoginAndBookingCancellation() throws InterruptedException {
		commonMethods.logInToOyoRooms(loginMobileNumber, loginPassword);
		commonMethods.searchHotels(location, checkinDate, checkoutDate);
		commonMethods.bookingConfirmationPAHafterLogin();
		Assert.assertEquals(successfulBookingMessage, bookingConfirmationPage.getBookingSuccessMessage());
		homePage.clickUserName();
		commonMethods.cancelBooking();
		Assert.assertEquals(bookingCancellationMessage, manageBookingPage.getCancellationText());
	}

	/*
	 * This Test is Searching Hotel, Clicking First Hotel after Sorting, Filling
	 * User details, applying coupon, confirming OTP, Making Successful Booking
	 * at PAH and finally Canceling the Booking.
	 */
	@Test
	public void verifySuccessfulBookingPAHAndBookingCancellation() {
		commonMethods.searchHotels(location, checkinDate, checkoutDate);
		commonMethods.navigateToHotelPageFromSearchPage();
		hotelPage.setGuestDetails(guestName, guestMobile, emailAddress);
		hotelPage.setCoupon(couponCode);
		hotelPage.clickApplyCoupon();
		hotelPage.clickPayAtHotel();
		hotelPage.setVerificationCode(verificationCode);
		hotelPage.clickConfirmAndBook();
		Assert.assertEquals(successfulBookingMessage, bookingConfirmationPage.getBookingSuccessMessage());
		commonMethods.logInToOyoRooms(loginMobileNumber, loginPassword);
		homePage.clickUserName();
		commonMethods.cancelBooking();
		Assert.assertEquals(bookingCancellationMessage, manageBookingPage.getCancellationText());
	}
}
