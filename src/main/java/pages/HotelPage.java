package pages;

import org.testng.Assert;

import utils.Helper;

public class HotelPage extends BasePage {
	
	Helper helper = new Helper();
	HomePage homePage = new HomePage();

	
	String filePathHotelPage = "./src/main/resources/objectRepo/HotelPage.json",
			bookNowId = helper.parseJSONToString("bookNowId", filePathHotelPage),
			payAtHotelId  = helper.parseJSONToString("payAtHotelId", filePathHotelPage),
			requiredIdClassName   = helper.parseJSONToString("requiredIdClassName", filePathHotelPage),
			hotelGalleryClassName = helper.parseJSONToString("hotelGalleryClassName",filePathHotelPage),
			hotelBookingBlockId = helper.parseJSONToString("hotelBookingBlockId",filePathHotelPage),
			hotelLocalityDetailsClassName = helper.parseJSONToString("hotelLocalityDetailsClassName", filePathHotelPage),
			hotelAmenitiesSectionClassName = helper.parseJSONToString("hotelAmenitiesSectionClassName", filePathHotelPage),
			hotelHouseRulesSectionClassName = helper.parseJSONToString("hotelHouseRulesSectionClassName", filePathHotelPage),
			hotelDescriptionSectionClassName = helper.parseJSONToString("hotelDescriptionSectionClassName", filePathHotelPage),
			hotelNearByHotelsSectionClassName = helper.parseJSONToString("hotelNearByHotelsSectionClassName", filePathHotelPage);
			
	
	
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

	public void clickBookNow() {
		helper.findElementById(bookNowId).click();
	}

	public void clickRequiredId() {
		if( helper.findElementByClassName(requiredIdClassName)!= null){
			helper.findElementByClassName(requiredIdClassName).click();
		}
	}

	public void setCoupon() {

	}

	public void clickApplyCoupon() {

	}

	public void setVerificationCode() {

	}

	public void clickConfirmAndBook() {

	}

	public void clickPayAtHotel() {
		helper.findElementById(payAtHotelId).click();
	}
}
