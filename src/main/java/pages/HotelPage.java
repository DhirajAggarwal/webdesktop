package pages;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import utils.Helper;

public class HotelPage extends BasePage {
	
	Helper helper = new Helper();
	HomePage homePage = new HomePage();

	
	String 	filePathCommonOR = "./src/main/resources/objectRepo/CommonOR.json",
			filePathHotelPageOR = "./src/main/resources/objectRepo/HotelPage.json",
			bookNowId = helper.parseJSONToString("bookNowId", filePathHotelPageOR),
			payAtHotelId  = helper.parseJSONToString("payAtHotelId", filePathHotelPageOR),
			requiredIdClassName   = helper.parseJSONToString("requiredIdClassName", filePathHotelPageOR),
			hotelGalleryClassName = helper.parseJSONToString("hotelGalleryClassName",filePathHotelPageOR),
			hotelBookingBlockId = helper.parseJSONToString("hotelBookingBlockId",filePathHotelPageOR),
			hotelLocalityDetailsClassName = helper.parseJSONToString("hotelLocalityDetailsClassName", filePathHotelPageOR),
			hotelAmenitiesSectionClassName = helper.parseJSONToString("hotelAmenitiesSectionClassName", filePathHotelPageOR),
			hotelHouseRulesSectionClassName = helper.parseJSONToString("hotelHouseRulesSectionClassName", filePathHotelPageOR),
			hotelDescriptionSectionClassName = helper.parseJSONToString("hotelDescriptionSectionClassName", filePathHotelPageOR),
			hotelNearByHotelsSectionClassName = helper.parseJSONToString("hotelNearByHotelsSectionClassName", filePathHotelPageOR),
			hotelRoomsCountId = helper.parseJSONToString("hotelRoomsCountId", filePathHotelPageOR),
			bulkBookingMessageId = helper.parseJSONToString("bulkBookingMessageId", filePathHotelPageOR),
			requestCallBackTextFieldId = helper.parseJSONToString("requestCallBackTextFieldId", filePathHotelPageOR),
			requestCallBackButtonId	=	helper.parseJSONToString("requestCallBackButtonId", filePathHotelPageOR),
			guestNameId = helper.parseJSONToString("guestNameId", filePathHotelPageOR),
			guestMobileNumber = helper.parseJSONToString("guestMobileNumber", filePathHotelPageOR),
			guestEmailAddress = helper.parseJSONToString("guestEmailAddress", filePathHotelPageOR),
			confirmationMessageOnRequestCallBackId = helper.parseJSONToString("confirmationMessageOnRequestCallBackId", filePathHotelPageOR),
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
	
	public void setNumberForRequestCallBack(String phoneNumber){
		helper.waitForElement(helper.locateById(requestCallBackButtonId), 4, "Request CallBack Button not displayed");
		helper.findElementById(requestCallBackTextFieldId).sendKeys(phoneNumber);
	}
	
	public String clickOnRequestCallBackButtonAndReturnMessage(){
		helper.findElementById(requestCallBackButtonId).click();
		helper.waitForElement(helper.locateById(confirmationMessageOnRequestCallBackId), 5, "Confirmation message not yet displayed");
		String confirmationMsg = helper.findElementById(confirmationMessageOnRequestCallBackId).getText();
		return confirmationMsg;
	}

	public void clickBookNow() {
		helper.findElementById(bookNowId).click();
	}
	
	public void setGuestDetails(String guestName, String guestMobile, String emailAddress){
		helper.findElementById(guestNameId).clear();
		helper.findElementById(guestNameId).sendKeys(guestName);
		helper.findElementById(guestMobileNumber).clear();
		helper.findElementById(guestMobileNumber).sendKeys(guestMobile);
		helper.findElementById(guestEmailAddress).clear();
		helper.findElementById(guestEmailAddress).sendKeys(emailAddress);
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
