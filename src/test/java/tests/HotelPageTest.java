package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.HotelPage;
import utils.BrowserFactory;
import utils.Helper;

public class HotelPageTest extends BrowserFactory{
	
	Helper helper = new Helper();
	HotelPage hotelPage = new HotelPage();
	HomePage homePage = new HomePage();
	
	String filePathHotelPageData = "./src/main/resources/data/HotelPageData.json",
			hotelId	= helper.parseJSONToString("hotelId", filePathHotelPageData),
			hotelType	= helper.parseJSONToString("hotelType", filePathHotelPageData),
			hotelName	= helper.parseJSONToString("hotelName", filePathHotelPageData),
			roomsCount	= helper.parseJSONToString("roomsCount", filePathHotelPageData),
			bulkBookingMessageExpected = helper.parseJSONToString("bulkBookingMessageExpected", filePathHotelPageData),
			phoneNumberForRequestCallback = helper.parseJSONToString("phoneNumberForRequestCallback", filePathHotelPageData),
			confirmationMsgOnRequestCallbackExpected = helper.parseJSONToString("confirmationMsgOnRequestCallbackExpected", filePathHotelPageData),
			testBudgetHotelId = helper.parseJSONToString("testBudgetHotelId", filePathHotelPageData),
			testBudgetHotelType = helper.parseJSONToString("testBudgetHotelType", filePathHotelPageData),
			testBudgetHotelName = helper.parseJSONToString("testBudgetHotelName", filePathHotelPageData),
			checkInDateLimitedAvailability = helper.parseJSONToString("checkInDateLimitedAvailability", filePathHotelPageData),
			checkInMonthLimitedAvailability = helper.parseJSONToString("checkInMonthLimitedAvailability", filePathHotelPageData),
			checkOutDateLimitedAvailability = helper.parseJSONToString("checkOutDateLimitedAvailability", filePathHotelPageData),
			roomsCountLimitedAvailability = helper.parseJSONToString("roomsCountLimitedAvailability", filePathHotelPageData),
			limitedAvailabilityMsgExpected = helper.parseJSONToString("limitedAvailabilityMsgExpected", filePathHotelPageData);
	
	int checkInMonthLimitedAvailabilityInt = Integer.parseInt(checkInMonthLimitedAvailability);

	@BeforeMethod
	public void openURL() {
		helper.openHotelPage(hotelId, hotelType, hotelName);
	}

	@Test
	public void verifyValidHotelPage(){
		hotelPage.isValid();
	}
	
	@Test
	public void verifyBulkBookingMessage(){
		hotelPage.setRoomsCount(roomsCount);
		String bulkBookingMessageActual = hotelPage.getBulkBookingMessage();
		Assert.assertEquals(bulkBookingMessageActual, bulkBookingMessageExpected);
	}
	
	@Test
	public void verifyMessageOnRequestCallback(){
		hotelPage.setRoomsCount(roomsCount);
		hotelPage.setNumberForRequestCallBack(phoneNumberForRequestCallback);
		String confirmationMsgOnRequestCallbackActual = hotelPage.clickOnRequestCallBackButtonAndReturnMessage();
		Assert.assertEquals(confirmationMsgOnRequestCallbackActual, confirmationMsgOnRequestCallbackExpected);
	}
	
	@Test
	public void verifyMessageOnLimitedAvailabiltyOfRooms(){
		helper.openHotelPage(testBudgetHotelId, testBudgetHotelType, testBudgetHotelName);
		homePage.setCheckInDate(checkInDateLimitedAvailability, checkInMonthLimitedAvailabilityInt);
		homePage.setCheckOutDate(checkOutDateLimitedAvailability);
		hotelPage.setRoomsCount(roomsCountLimitedAvailability);
		String limitedAvailabilityMsgActual = hotelPage.getLimitedAvailabilityMessage();
		Assert.assertEquals(limitedAvailabilityMsgActual, limitedAvailabilityMsgExpected);
	}
	
	/* This is just a dummy test to verify the methods I have added in Hotel Page. I am not deleting this since I will need it next time. 
	 * Will delete once Dhiraj will use these methods in any test.
	@Test
	public void vtest(){
		hotelPage.clickBookNow();
		hotelPage.setGuestDetails("s", "0000089876", "g@gmail.com");
		hotelPage.clickRequiredId();
		hotelPage.setCoupon("oyo30");
		hotelPage.clickApplyCoupon();
		hotelPage.clickPayAtHotel();
		hotelPage.setVerificationCode("098765");
		hotelPage.clickConfirmAndBook();
	}*/
}
