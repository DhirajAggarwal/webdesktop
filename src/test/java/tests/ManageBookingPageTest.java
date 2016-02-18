package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CommonMethods;
import pages.HomePage;
import pages.HotelPage;
import pages.ManageBookingPage;
import pages.PaymentGatewayPage;
import utils.BrowserFactory;

public class ManageBookingPageTest extends BrowserFactory {

	CommonMethods commonMethods = new CommonMethods();
	ManageBookingPage manageBookingPage = new ManageBookingPage();
	HomePage homePage = new HomePage();
	PaymentGatewayPage paymentGatewaypage = new PaymentGatewayPage();
	HotelPage hotelPage = new HotelPage();

	String filePathCommonTestData = "./src/main/resources/data/CommonTestData.json",
			loginMobileNumber = helper.parseJSONToString("mobileNumber", filePathCommonTestData),
			loginPassword = helper.parseJSONToString("password", filePathCommonTestData),
			location = helper.parseJSONToString("location", filePathCommonTestData),
			checkinDate = helper.parseJSONToString("checkinDate", filePathCommonTestData),
			checkoutDate = helper.parseJSONToString("checkoutDate", filePathCommonTestData);
	
	String filePathPaymentGatewayPageTestData = "./src/main/resources/data/PaymentGatewayPageTestData.json",
			creditCardTypeText = helper.parseJSONToString("creditCardTypeText", filePathPaymentGatewayPageTestData);

	String	filePathManageBookingPageTestData = "./src/main/resources/data/ManageBookingPageTestData.json",		
			bookingCancellationMessage = helper.parseJSONToString("bookingCancellationMessage", filePathManageBookingPageTestData),
			amountPartialPayment = helper.parseJSONToString("amountPartialPayment", filePathManageBookingPageTestData);

	
	@BeforeMethod
	public void openURL() {
		helper.openURL();
	}

	//@Test
	public void verifyCancellationOfBooking() {
		commonMethods.logInToOyoRooms(loginMobileNumber, loginPassword);
		homePage.clickUserName();
		commonMethods.cancelBooking();
		Assert.assertEquals(bookingCancellationMessage, manageBookingPage.getCancellationText() );
	}
	
	/*
	 * This Test is making booking after Login and processing 
	 * partial payments.
	*/
	@Test
	public void verifyPartialPayment() {
		commonMethods.logInToOyoRooms(loginMobileNumber, loginPassword);
		commonMethods.searchHotels(location, checkinDate, checkoutDate);
		commonMethods.bookingConfirmationPAHafterLogin();
		homePage.clickUserName();
		commonMethods.partialPayment();
		hotelPage.clickCreditCard();
		Assert.assertEquals(creditCardTypeText, paymentGatewaypage.getCreditCardText());
		Assert.assertEquals(amountPartialPayment, paymentGatewaypage.getAmountToBePaid());
	}

}
