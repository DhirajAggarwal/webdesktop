package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CommonMethods;
import pages.PaymentGatewayPage;
import utils.BrowserFactory;

public class PaymentGatewayPageTest extends BrowserFactory {

	CommonMethods commonMethods = new CommonMethods();
	PaymentGatewayPage paymentGatewaypage = new PaymentGatewayPage();

	String filePathCommonTestData = "./src/main/resources/data/CommonTestData.json",
			loginMobileNumber=helper.parseJSONToString("mobileNumber", filePathCommonTestData),
			loginPassword=helper.parseJSONToString("password", filePathCommonTestData),
			location= helper.parseJSONToString("location", filePathCommonTestData),
			checkinDate= helper.parseJSONToString("checkinDate", filePathCommonTestData),
			checkoutDate= helper.parseJSONToString("checkoutDate", filePathCommonTestData);
	
	String filePathPaymentGatewayPageTestData = "./src/main/resources/data/PaymentGatewayPageTestData.json",
			creditCardTypeText = helper.parseJSONToString("creditCardTypeText", filePathPaymentGatewayPageTestData);

	@BeforeMethod
	public void openURL() {
		helper.openURL();
	}

	@Test
	public void verifyCreditCardPayment() {
		commonMethods.logInToOyoRooms(loginMobileNumber,loginPassword);
		commonMethods.searchHotels(location,checkinDate,checkoutDate);
		commonMethods.bookingConfirmationPayNow();
		/*
		 * Below code is to make Successful Booking and assert it. Currently
		 * this is commented, so it doesn't make unnecessary bookings. This will
		 * be uncommented as cancelBooking() is ready.
		 */
		 Assert.assertEquals(creditCardTypeText, paymentGatewaypage.getCreditCardText());
		}

}
