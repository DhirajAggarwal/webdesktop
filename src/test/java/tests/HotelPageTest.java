package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HotelPage;
import utils.BrowserFactory;

public class HotelPageTest extends BrowserFactory{
	
	HotelPage hotelPage = new HotelPage();

	@BeforeMethod
	public void openURL() {
		helper.openHotelPage("469", "premium", "hotel-vaishali-nagar-jaipur");
	}

	@Test
	public void verifyValidHotelPage(){
		hotelPage.isValid();
	}
}
