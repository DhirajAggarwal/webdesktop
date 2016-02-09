package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
			hotelNearByHotelsSectionClassName = helper.parseJSONToString("hotelNearByHotelsSectionClassName", filePathHotelPageOR),
			hotelRoomsCountId = helper.parseJSONToString("hotelRoomsCountId", filePathHotelPageOR),
			bulkBookingMessageId = helper.parseJSONToString("bulkBookingMessageId", filePathHotelPageOR),
			hotelTermsAndConditionsLinkId	= helper.parseJSONToString("hotelTermsAndConditionsLinkId", filePathHotelPageOR);
			
			
	public void isValid() {
		homePage.validateHeaderElements();
		validateHotelPageElements();
		homePage.validateFooterElements();
	}
	
	public void setRoomsCount(String rooms){
		helper.findElementById(hotelRoomsCountId).sendKeys(rooms);
		helper.findElementById(hotelRoomsCountId).sendKeys(Keys.ENTER);
		helper.waitForElement(helper.locateById(hotelTermsAndConditionsLinkId), 5,"Terms and Conditions link not Found");
	}
	
	public String getBulkBookingMessage(){
		String message = helper.findElementById(bulkBookingMessageId).getText();
		return message;
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
