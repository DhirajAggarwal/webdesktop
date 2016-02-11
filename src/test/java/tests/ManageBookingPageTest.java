package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CommonMethods;
import pages.HomePage;
import pages.ManageBookingPage;
import pages.PaymentGatewayPage;
import utils.BrowserFactory;

public class ManageBookingPageTest extends BrowserFactory {

	CommonMethods commonMethods = new CommonMethods();
	ManageBookingPage manageBookingPage = new ManageBookingPage();
	HomePage homePage = new HomePage();
	PaymentGatewayPage paymentGatewaypage = new PaymentGatewayPage();

	String filePathHardData = "./src/main/resources/data/HardData",
			filePathPaymentGatewayPageTestData = "./src/main/resources/data/PaymentGatewayPageTestData.json",
			filePathManageBookingPageTestData = "./src/main/resources/data/ManageBookingPageTestData.json",
			loginMobileNumber = helper.parseJSONToString("mobileNumber", filePathHardData),
			loginPassword = helper.parseJSONToString("password", filePathHardData),
			location = helper.parseJSONToString("location", filePathHardData),
			checkinDate = helper.parseJSONToString("checkinDate", filePathHardData),
			checkoutDate = helper.parseJSONToString("checkoutDate", filePathHardData), 
			bookingCancellationMessage = helper.parseJSONToString("bookingCancellationMessage", filePathManageBookingPageTestData),
			creditCardTypeText = helper.parseJSONToString("creditCardTypeText", filePathPaymentGatewayPageTestData),
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
	 * This Test is making booking and processing 
	 * partial payments.
	*/
	@Test
	public void verifyPartialPayment() {
		commonMethods.logInToOyoRooms(loginMobileNumber, loginPassword);
		commonMethods.searchHotels(location, checkinDate, checkoutDate);
		commonMethods.bookingConfirmationPAH();
		homePage.clickUserName();
		commonMethods.partialPayment();
		Assert.assertEquals(creditCardTypeText, paymentGatewaypage.getCreditCardText());
		Assert.assertEquals(amountPartialPayment, paymentGatewaypage.getAmountToBePaid());
	}

}
