package pages;

import org.testng.Assert;

public class HotelPage extends BasePage {
	
	HomePage homePage = new HomePage();

	
	protected String filePathHotelPage = "./src/main/resources/objectRepo/HotelPage.json",
			bookNowId = helper.parseJSONToString("bookNowId", filePathHotelPage),
			payAtHotelId  = helper.parseJSONToString("payAtHotelId", filePathHotelPage),
			payNowId  = helper.parseJSONToString("payNowId", filePathHotelPage),
			creditCardClassName  = helper.parseJSONToString("creditCardClassName", filePathHotelPage),
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
	
	public void clickPayNow() {
		helper.findElementById(payNowId).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickCreditCard() {
		helper.findElementByClassName(creditCardClassName).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
