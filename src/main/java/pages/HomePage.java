package pages;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Helper;

public class HomePage extends BasePage {

	Helper helper = new Helper();

	String filePathCommonOR = "./src/main/resources/objectRepo/CommonOR.json";
	String filePathHomePage = "./src/main/resources/objectRepo/HomePage.json",
			userNameId = helper.parseJSONToString("userNameId", filePathCommonOR),
			locationId = helper.parseJSONToString("locationTextboxId", filePathCommonOR),
			checkInId = helper.parseJSONToString("checkInDateId", filePathCommonOR),
			checkOutId = helper.parseJSONToString("checkOutDateId", filePathCommonOR),
			searchButtonId = helper.parseJSONToString("searchButtonId", filePathCommonOR),
			locationSuggestionsId = helper.parseJSONToString("locationSuggestionId", filePathCommonOR),
			hotelClassName = helper.parseJSONToString("hotelClassName", filePathCommonOR),
			leftFooterClassName = helper.parseJSONToString("leftFooterClassName", filePathCommonOR),
			rightFooterClassName = helper.parseJSONToString("rightFooterClassName", filePathCommonOR),
			oyoLogoClassName = helper.parseJSONToString("oyoLogoClassName", filePathCommonOR),
			oyoTagLineClassName = helper.parseJSONToString("oyoTagLineClassName", filePathCommonOR),
			oyoAppDownloadLinkClassName = helper.parseJSONToString("oyoAppDownloadLinkClassName", filePathCommonOR),
			myAccountLinkText = helper.parseJSONToString("myAccountLinkText", filePathCommonOR),
			oyoHelpIconClassName = helper.parseJSONToString("oyoHelpIconClassName", filePathCommonOR),
			oyoReservationNumberClassName = helper.parseJSONToString("oyoReservationNumberClassName", filePathCommonOR),
			phoneIconClassName = helper.parseJSONToString("phoneIconClassName", filePathCommonOR),
			logInId = helper.parseJSONToString("logInId", filePathCommonOR),
			mobileTextCss = helper.parseJSONToString("mobileTextCss", filePathCommonOR),
			passwordTextCss = helper.parseJSONToString("passwordTextCss", filePathCommonOR),
			loginSubmitButtonClassName = helper.parseJSONToString("submitButtonClassName", filePathCommonOR),
			dealsClassName = helper.parseJSONToString("dealsLinksClassName", filePathHomePage),
			corporateEnquiryFormLabelId = helper.parseJSONToString("corporateEnquiryFormLabelId", filePathHomePage),
			hotelLinksClassName = helper.parseJSONToString("hotelLinksClassName", filePathHomePage),
			megadropdownClassName = helper.parseJSONToString("megadropdownClassName", filePathHomePage),
			corporateNameId = helper.parseJSONToString("corporateNameId", filePathHomePage),
			corporatePhoneId = helper.parseJSONToString("corporatePhoneId", filePathHomePage),
			corporateEmailId = helper.parseJSONToString("corporateEmailId", filePathHomePage),
			corporateEnquiryId = helper.parseJSONToString("corporateEnquiryId", filePathHomePage),
			corporateEnquirySubmitButtonId = helper.parseJSONToString("corporateEnquirySubmitButtonId",
					filePathHomePage),
			corporateEnquirySuccessId = helper.parseJSONToString("corporateEnquirySuccessId", filePathHomePage),
			blankLoginValidationMessageId = helper.parseJSONToString("blankLoginValidationMessageId", filePathCommonOR),
			megaDDLink = helper.parseJSONToString("megaDDLinkText", filePathHomePage),
			viewAllLinkText = helper.parseJSONToString("viewAllLinkText", filePathHomePage),
			allCitiesLinkText = helper.parseJSONToString("allCitiesLinkText", filePathHomePage),
			logoutLinkText =helper.parseJSONToString("logoutLinkText",filePathCommonOR );

	public void isValid() {
		validateHeaderElements();
		validateFooterElements();
		Assert.assertTrue(helper.findElementByClassName(dealsClassName).isDisplayed());
		Assert.assertTrue(helper.findElementById(corporateEnquiryFormLabelId).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(megadropdownClassName).isDisplayed());
		List<WebElement> links = helper.findElementsByClassName(hotelLinksClassName);
 		for (int i = 0; i < links.size(); i++) {
			Assert.assertTrue(links.get(i).isEnabled());
		}
	}

	public String getBlankLoginValidationMessage() {
		helper.waitForElement(helper.locateById(blankLoginValidationMessageId), 5,
				"Blank Login Validation message not displayed");
		String loginValidationMessage = helper.findElementById(blankLoginValidationMessageId).getText();
		return loginValidationMessage;

	}
	public void logoutUser() {
		helper.findElementByLinkText(logoutLinkText).click();
		helper.waitForElement(helper.locateByLinkText(myAccountLinkText), 15, "User not getting logged out");
		
	}
	
	public void hoverOnUserName(String user) {
		WebElement userName = helper.findElementByLinkText(user);
		helper.hoverOnElement(userName);
	}

	public void clickOnMDDViewAllLink() {
		helper.waitForElement(helper.locateByLinkText(viewAllLinkText), 2, "MDD View All Link Not Found");
		helper.findElementByLinkText(viewAllLinkText).click();
	}
	public void clickOnAllCitiesLink() {
		helper.waitForElement(helper.locateByLinkText(allCitiesLinkText), 2, "MDD All Cities Link Not Found");
		helper.findElementByLinkText(allCitiesLinkText).click();
	}
	public void clickOnCorporateEnquiry() {
		helper.findElementById(corporateEnquiryFormLabelId).click();
	}

	public void validateHeaderElements() {
		Assert.assertTrue(helper.findElementByClassName(oyoLogoClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(oyoTagLineClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(oyoAppDownloadLinkClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(oyoHelpIconClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(oyoReservationNumberClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(phoneIconClassName).isDisplayed());
	}

	public void validateFooterElements() {
		Assert.assertTrue(helper.findElementByClassName(leftFooterClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(rightFooterClassName).isDisplayed());
	}

	public void clickOnMyAccounts() {
		helper.waitForElement(helper.locateByLinkText(myAccountLinkText), 3, "My Account Link Not found");
		helper.findElementByLinkText(myAccountLinkText).click();
	}

	public void clickOnLoginButton() {
		helper.findElementById(logInId).click();
	}

	public void fillCorporateForm(String name, String phone, String email, String enquiry) {
		helper.findElementById(corporateNameId).sendKeys(name);
		helper.findElementById(corporatePhoneId).sendKeys(phone);
		helper.findElementById(corporateEmailId).sendKeys(email);
		helper.findElementById(corporateEnquiryId).sendKeys(enquiry);

	}

	public void hoverOnMDDLink() {
		helper.waitForElement(helper.locateByLinkText(megaDDLink), 3, "MDD City Link Not found");
		WebElement mDDLink = helper.findElementByLinkText(megaDDLink);
		helper.hoverOnElement(mDDLink);
	}

	public void setMobileNumberForLogin(String mobileNumber) {
		helper.findElementByCss(mobileTextCss).sendKeys(mobileNumber);
	}

	public void setPasswordForLogin(String password) {
		helper.findElementByCss(passwordTextCss).sendKeys(password);

	}

	public void clickOnLoginSubmitButton() {
		helper.waitForElement(helper.locateByClassName(loginSubmitButtonClassName), 5, "Login Submit button not Found");
		helper.findElementByClassName(loginSubmitButtonClassName).click();

	}

	public String getLoggedInUserName() {
		helper.waitForElement(helper.locateById(userNameId), 5, "Username not visible after Login");
		String userName = helper.findElementById(userNameId).getText();
		return userName;
	}

	public void setLocation(String location) {
		helper.findElementById(locationId).sendKeys(location);
		helper.findElementById(locationId).sendKeys(" ");
		helper.waitForElement(helper.locateById(locationSuggestionsId), 5, "No Suggestions on Search");
		helper.findElementById(locationId).sendKeys(Keys.DOWN);
		helper.findElementById(locationId).sendKeys(Keys.ENTER);
	}

	public String getLocation() {
		String myLocation = helper.findElementById(locationId).getText();
		return myLocation;
	}

	public String getCorporateEnquirySuccessMessage() {
		helper.waitForElement(helper.locateById(corporateEnquirySuccessId), 5,
				"Corporate Success message not Displayed");
		String enquirySuccessMessage = helper.findElementById(corporateEnquirySuccessId).getText();
		return enquirySuccessMessage;
	}

	public void setCheckInDate(String checkInDate) {
		helper.waitForElement(helper.locateByLinkText(checkInDate), 10, "No checkin date displayed");
		helper.findElementByLinkText(checkInDate).click();
	}

	public void setCheckOutDate(String checkOutDate) {
		helper.waitForElement(helper.locateByLinkText(checkOutDate), 10, "No checkout date displayed");
		helper.findElementByLinkText(checkOutDate).click();
	}

	public void setGuestCount() {

	}

	public void setRoomCount() {

	}

	public void getGuestCount() {

	}

	public void getRoomCount() {

	}

	public void clickOnSearchButton() {
		helper.waitForElement(helper.locateById(searchButtonId), 3, "Search Button Not visible");
		helper.findElementById(searchButtonId).click();
		helper.waitForElement(helper.locateByClassName(hotelClassName), 20, "Hotels Not Displayed After Search");
	}

	public void clickOnCorporateEnquirySubmit() {
		helper.findElementById(corporateEnquirySubmitButtonId).click();
		// TODO Auto-generated method stub
	}

}
