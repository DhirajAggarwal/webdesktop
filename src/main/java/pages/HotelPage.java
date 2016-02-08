package pages;

import org.testng.Assert;

import utils.Helper;

public class HotelPage extends BasePage{
	
	Helper helper = new Helper();
	HomePage homePage = new HomePage();
	
	String filePathCommonOR = "./src/main/resources/objectRepo/CommonOR.json",
			filePathHotelPageOR = "./src/main/resources/objectRepo/HotelPage.json",
			hotelGalleryClassName = helper.parseJSONToString("hotelGalleryClassName",filePathHotelPageOR),
			hotelBookingBlockId = helper.parseJSONToString("hotelBookingBlockId",filePathHotelPageOR),
			hotelLocalityDetailsClassName = helper.parseJSONToString("hotelLocalityDetailsClassName", filePathHotelPageOR),
			hotelAmenitiesSectionClassName = helper.parseJSONToString("hotelAmenitiesSectionClassName", filePathHotelPageOR),
			hotelHouseRulesSectionClassName = helper.parseJSONToString("hotelHouseRulesSectionClassName", filePathHotelPageOR),
			hotelDescriptionSectionClassName = helper.parseJSONToString("hotelDescriptionSectionClassName", filePathHotelPageOR),
			hotelNearByHotelsSectionClassName = helper.parseJSONToString("hotelNearByHotelsSectionClassName", filePathHotelPageOR);
			
	
	
	public void isValid() {
		homePage.validateHeaderElements();
		validateHotelPageElements();
		homePage.validateFooterElements();
	}

	private void validateHotelPageElements() {
		Assert.assertTrue(helper.findElementByClassName(hotelGalleryClassName).isDisplayed());
		Assert.assertTrue(helper.findElementById(hotelBookingBlockId).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(hotelLocalityDetailsClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(hotelAmenitiesSectionClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(hotelHouseRulesSectionClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(hotelDescriptionSectionClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(hotelNearByHotelsSectionClassName).isDisplayed());
	}
}
