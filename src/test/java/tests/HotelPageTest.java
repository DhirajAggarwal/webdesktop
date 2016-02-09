package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
			bulkBookingMessageExpected = helper.parseJSONToString("bulkBookingMessageExpected", filePathHotelPageData);
	

	@BeforeClass
	public void openURL() {
		helper.openHotelPage(hotelId, hotelType, hotelName);
	}

	@Test
	public void verifyValidHotelPage(){
		hotelPage.isValid();;
	}
	
	@Test
	public void verifyBulkBookingMessage(){
		hotelPage.setRoomsCount(roomsCount);
		String bulkBookingMessageActual = hotelPage.getBulkBookingMessage();
		Assert.assertEquals(bulkBookingMessageActual, bulkBookingMessageExpected);
	}
}
