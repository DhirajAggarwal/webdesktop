package pages;

import org.openqa.selenium.Keys;
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
			requestCallBackTextFieldId = helper.parseJSONToString("requestCallBackTextFieldId", filePathHotelPageOR),
			requestCallBackButtonId	=	helper.parseJSONToString("requestCallBackButtonId", filePathHotelPageOR),
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
