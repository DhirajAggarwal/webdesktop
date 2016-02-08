package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HotelPage;
import utils.BrowserFactory;
import utils.Helper;

public class HotelPageTest extends BrowserFactory{
	
	Helper helper = new Helper();
	HotelPage hotelPage = new HotelPage();

	@BeforeClass
	public void openURL() {
		helper.openHotelPage("469", "premium", "hotel-vaishali-nagar-jaipur");
	}

	@Test
	public void verifyValidHotelPage(){
		hotelPage.isValid();;
	}
}
