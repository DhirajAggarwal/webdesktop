package pages;

import org.openqa.selenium.Keys;
import org.testng.Assert;

public class HotelPage extends BasePage {

	HomePage homePage = new HomePage();

	protected String filePathHotelPage = "./src/main/resources/objectRepo/HotelPage.json",
			bookNowId = helper.parseJSONToString("bookNowId", filePathHotelPage),
			payAtHotelId = helper.parseJSONToString("payAtHotelId", filePathHotelPage),
			payNowId = helper.parseJSONToString("payNowId", filePathHotelPage),
			creditCardClassName = helper.parseJSONToString("creditCardClassName", filePathHotelPage),
			requiredId = helper.parseJSONToString("requiredId", filePathHotelPage),
			hotelGalleryClassName = helper.parseJSONToString("hotelGalleryClassName", filePathHotelPage),
			hotelBookingBlockId = helper.parseJSONToString("hotelBookingBlockId", filePathHotelPage),
			hotelLocalityDetailsClassName = helper.parseJSONToString("hotelLocalityDetailsClassName",
					filePathHotelPage),
			hotelAmenitiesSectionClassName = helper.parseJSONToString("hotelAmenitiesSectionClassName",
					filePathHotelPage),
			hotelHouseRulesSectionClassName = helper.parseJSONToString("hotelHouseRulesSectionClassName",
					filePathHotelPage),
			hotelDescriptionSectionClassName = helper.parseJSONToString("hotelDescriptionSectionClassName",
					filePathHotelPage),
			hotelNearByHotelsSectionClassName = helper.parseJSONToString("hotelNearByHotelsSectionClassName",
					filePathHotelPage),
			hotelRoomsCountId = helper.parseJSONToString("hotelRoomsCountId", filePathHotelPage),
			bulkBookingMessageId = helper.parseJSONToString("bulkBookingMessageId", filePathHotelPage),
			requestCallBackTextFieldId = helper.parseJSONToString("requestCallBackTextFieldId", filePathHotelPage),
			requestCallBackButtonId = helper.parseJSONToString("requestCallBackButtonId", filePathHotelPage),
			guestNameId = helper.parseJSONToString("guestNameId", filePathHotelPage),
			guestMobileNumberId = helper.parseJSONToString("guestMobileNumberId", filePathHotelPage),
			guestEmailAddressId = helper.parseJSONToString("guestEmailAddressId", filePathHotelPage),
			couponQuestionId = helper.parseJSONToString("couponQuestionId", filePathHotelPage),
			discountCouponTextBoxId = helper.parseJSONToString("discountCouponTextBoxId", filePathHotelPage),
			couponApplyButtonId = helper.parseJSONToString("couponApplyButtonId", filePathHotelPage),
			otpFieldId = helper.parseJSONToString("otpFieldId", filePathHotelPage),
			confirmAndBookId = helper.parseJSONToString("confirmAndBookId", filePathHotelPage),
			confirmationMessageOnRequestCallBackId = helper.parseJSONToString("confirmationMessageOnRequestCallBackId",
					filePathHotelPage),
			hotelTermsAndConditionsLinkId = helper.parseJSONToString("hotelTermsAndConditionsLinkId",
					filePathHotelPage);

	public void isValid() {
		homePage.validateHeaderElements();
		validateHotelPageElements();
		homePage.validateFooterElements();
	}

	public void setRoomsCount(String rooms) {
		helper.findElementById(hotelRoomsCountId).sendKeys(rooms);
		helper.findElementById(hotelRoomsCountId).sendKeys(Keys.ENTER);
		helper.waitForElement(helper.locateById(hotelTermsAndConditionsLinkId), 5,
				"Terms and Conditions link not Found");
	}

	public String getBulkBookingMessage() {
		String message = helper.findElementById(bulkBookingMessageId).getText();
		return message;
	}

	public void setNumberForRequestCallBack(String phoneNumber) {
		helper.waitForElement(helper.locateById(requestCallBackButtonId), 4, "Request CallBack Button not displayed");
		helper.findElementById(requestCallBackTextFieldId).sendKeys(phoneNumber);
	}

	public String clickOnRequestCallBackButtonAndReturnMessage() {
		helper.findElementById(requestCallBackButtonId).click();
		helper.waitForElement(helper.locateById(confirmationMessageOnRequestCallBackId), 5,
				"Confirmation message not yet displayed");
		String confirmationMsg = helper.findElementById(confirmationMessageOnRequestCallBackId).getText();
		return confirmationMsg;
	}

	public void clickBookNow() {
		helper.findElementById(bookNowId).click();
	}

	public void setGuestDetails(String guestName, String guestMobile, String emailAddress) {
		helper.findElementById(guestNameId).clear();
		helper.findElementById(guestNameId).sendKeys(guestName);
		helper.findElementById(guestMobileNumberId).clear();
		helper.findElementById(guestMobileNumberId).sendKeys(guestMobile);
		helper.findElementById(guestEmailAddressId).clear();
		helper.findElementById(guestEmailAddressId).sendKeys(emailAddress);
	}

	public void clickRequiredId() {
		if (helper.findElementById(requiredId) != null) {
			helper.findElementById(requiredId).click();
		}
	}

	public void setCoupon(String couponCode) {
		helper.findElementById(couponQuestionId).click();
		helper.findElementById(discountCouponTextBoxId).sendKeys(couponCode);
	}

	public void clickApplyCoupon() {
		helper.findElementById(couponApplyButtonId).click();
	}

	public void setVerificationCode(String OTP) {
		helper.waitForElement(helper.locateById(otpFieldId), 5, "OTP field not displayed");
		helper.findElementById(otpFieldId).sendKeys(OTP);
	}

	public void clickConfirmAndBook() {
		helper.findElementById(confirmAndBookId).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickPayAtHotel() {
		helper.findElementById(payAtHotelId).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickPayNow() {
		helper.findElementById(payNowId).click();
	}

	public void clickCreditCard() {
		helper.findElementByClassName(creditCardClassName).click();
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
