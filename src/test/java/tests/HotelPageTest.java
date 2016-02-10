package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HotelPage;
import utils.BrowserFactory;
import utils.Helper;

public class HotelPageTest extends BrowserFactory{
	
	Helper helper = new Helper();
	HotelPage hotelPage = new HotelPage();
	
	String filePathHotelPageData = "./src/main/resources/data/HotelPageData.json",
			hotelId	= helper.parseJSONToString("hotelId", filePathHotelPageData),
			hotelType	= helper.parseJSONToString("hotelType", filePathHotelPageData),
			hotelName	= helper.parseJSONToString("hotelName", filePathHotelPageData),
			roomsCount	= helper.parseJSONToString("roomsCount", filePathHotelPageData),
			bulkBookingMessageExpected = helper.parseJSONToString("bulkBookingMessageExpected", filePathHotelPageData),
			phoneNumberForRequestCallback = helper.parseJSONToString("phoneNumberForRequestCallback", filePathHotelPageData),
			confirmationMsgOnRequestCallbackExpected = helper.parseJSONToString("confirmationMsgOnRequestCallbackExpected", filePathHotelPageData);
	

	@BeforeMethod
	public void openURL() {
		helper.openHotelPage(hotelId, hotelType, hotelName);
	}

	@Test(priority=0)
	public void verifyValidHotelPage(){
		hotelPage.isValid();
	}
	
	@Test(priority=1)
	public void verifyBulkBookingMessage(){
		hotelPage.setRoomsCount(roomsCount);
		String bulkBookingMessageActual = hotelPage.getBulkBookingMessage();
		Assert.assertEquals(bulkBookingMessageActual, bulkBookingMessageExpected);
	}
	
	@Test(priority=2)
	public void verifyMessageOnRequestCallback(){
		hotelPage.setRoomsCount(roomsCount);
		hotelPage.setNumberForRequestCallBack(phoneNumberForRequestCallback);
		String confirmationMsgOnRequestCallbackActual = hotelPage.clickOnRequestCallBackButtonAndReturnMessage();
		Assert.assertEquals(confirmationMsgOnRequestCallbackActual, confirmationMsgOnRequestCallbackExpected);
	}
}
