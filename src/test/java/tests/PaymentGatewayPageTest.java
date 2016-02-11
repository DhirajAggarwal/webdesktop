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

	String filePathHardData = "./src/main/resources/data/HardData",
			filePathPaymentGatewayPageTestData = "./src/main/resources/data/PaymentGatewayPageTestData.json",
			loginMobileNumber=helper.parseJSONToString("mobileNumber", filePathHardData),
			loginPassword=helper.parseJSONToString("password", filePathHardData),
			location= helper.parseJSONToString("location", filePathHardData),
			checkinDate= helper.parseJSONToString("checkinDate", filePathHardData),
			checkoutDate= helper.parseJSONToString("checkoutDate", filePathHardData),
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
