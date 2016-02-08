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
			userNameId = helper.parseJSONToString("userNameId",filePathCommonOR),
			locationId =helper.parseJSONToString("locationTextboxId", filePathCommonOR),
			checkInId=helper.parseJSONToString("checkInDateId", filePathCommonOR),
			checkOutId=helper.parseJSONToString("checkOutDateId", filePathCommonOR),
			searchButtonId=helper.parseJSONToString("searchButtonId", filePathCommonOR),
			locationSuggestionsId=helper.parseJSONToString("locationSuggestionId", filePathCommonOR),
			hotelClassName=helper.parseJSONToString("hotelClassName", filePathCommonOR),
			leftFooterClassName = helper.parseJSONToString("leftFooterClassName", filePathCommonOR),
			rightFooterClassName = helper.parseJSONToString("rightFooterClassName", filePathCommonOR),
			oyoLogoClassName = helper.parseJSONToString("oyoLogoClassName",filePathCommonOR),
			oyoTagLineClassName = helper.parseJSONToString("oyoTagLineClassName",filePathCommonOR),
			oyoAppDownloadLinkClassName = helper.parseJSONToString("oyoAppDownloadLinkClassName", filePathCommonOR),
			myAccountCss = helper.parseJSONToString("myAccountCss", filePathCommonOR),
			oyoHelpIconClassName = helper.parseJSONToString("oyoHelpIconClassName", filePathCommonOR),
			oyoReservationNumberClassName = helper.parseJSONToString("oyoReservationNumberClassName", filePathCommonOR),
			phoneIconClassName = helper.parseJSONToString("phoneIconClassName", filePathCommonOR),
			logInId = helper.parseJSONToString("logInId", filePathCommonOR),
			mobileTextCss = helper.parseJSONToString("mobileTextCss", filePathCommonOR),
			passwordTextCss = helper.parseJSONToString("passwordTextCss", filePathCommonOR),
			submitButtonClassName = helper.parseJSONToString("submitButtonClassName", filePathCommonOR),
			dealsClassName = helper.parseJSONToString("dealsLinksClassName", filePathHomePage),
			corporateEnquiryFormLabelId = helper.parseJSONToString("corporateEnquiryFormLabelId", filePathHomePage),
			hotelLinksClassName = helper.parseJSONToString("hotelLinksClassName", filePathHomePage),
			megadropdownClassName = helper.parseJSONToString("megadropdownClassName", filePathHomePage),
			corporateNameId=helper.parseJSONToString("corporateNameId", filePathHomePage),
			corporatePhoneId=helper.parseJSONToString("corporatePhoneId", filePathHomePage),
			corporateEmailId=helper.parseJSONToString("corporateEmailId", filePathHomePage),
			corporateEnquiryId=helper.parseJSONToString("corporateEnquiryId", filePathHomePage),
			corporateEnquirySubmitButtonId=helper.parseJSONToString("corporateEnquirySubmitButtonId", filePathHomePage),
			corporateEnquirySuccessId=helper.parseJSONToString("corporateEnquirySuccessId", filePathHomePage);
	

	public void isValid() {
		validateHeaderElements();
		validateFooterElements();
		Assert.assertTrue(helper.findElementByClassName(dealsClassName).isDisplayed());
		Assert.assertTrue(helper.findElementById(corporateEnquiryId).isDisplayed());
		List<WebElement> links = helper.findElementsByClassName(hotelLinksClassName);
		for (int i = 0; i < links.size(); i++) {
			Assert.assertTrue(links.get(i).isEnabled());
		}
		Assert.assertTrue(helper.findElementByClassName(megadropdownClassName).isDisplayed());
	}

	public void clickOnCorporateEnquiry() {
		helper.findElementById(corporateEnquiryFormLabelId).click();
	}
			
	public void validateHeaderElements(){
		Assert.assertTrue(helper.findElementByClassName(oyoLogoClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(oyoTagLineClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(oyoAppDownloadLinkClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(oyoHelpIconClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(oyoReservationNumberClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(phoneIconClassName).isDisplayed());
	}
	
	public void validateFooterElements(){
		Assert.assertTrue(helper.findElementByClassName(leftFooterClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(rightFooterClassName).isDisplayed());
	}

	public void clickOnMyAccounts() {
		helper.findElementByCss(myAccountCss).click();
	}

	public void clickOnLoginButton() {
		helper.findElementById(logInId).click();
	}

	public void fillCorporateForm(String name,String phone,String email,String enquiry) {
		helper.findElementById(corporateNameId).sendKeys(name);
		helper.findElementById(corporatePhoneId).sendKeys(phone);
		helper.findElementById(corporateEmailId).sendKeys(email);
		helper.findElementById(corporateEnquiryId).sendKeys(enquiry);
		
		
	}

	public void setMobileNumberForLogin(String mobileNumber) {
		helper.findElementByCss(mobileTextCss).sendKeys(mobileNumber);
	}

	public void setPasswordForLogin(String password) {
		helper.findElementByCss(passwordTextCss).sendKeys(password);
		helper.waitForElement(helper.locateByClassName(submitButtonClassName), 5, "Login Submit button not Found");
	}

	public void clickOnLoginSubmitButton() {
		helper.findElementByClassName(submitButtonClassName).click();
		helper.waitForElement(helper.locateById(userNameId), 5, "Username not visible after Login");
	}

	public String getLoggedInUserName() {
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
		helper.waitForElement(helper.locateById(corporateEnquirySuccessId),3, "Corporate Success message not Displayed");
		String enquirySuccessMessage = helper.findElementById(corporateEnquirySuccessId).getText();
		return enquirySuccessMessage;
	}

	public void setCheckInDate(String checkInDate) {
		helper.findElementByLinkText(checkInDate).click();
	}

	public void setCheckOutDate(String checkOutDate) {
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

	public void clickOnCorporateenquirySubmit() {
		helper.findElementById(corporateEnquirySubmitButtonId).click();
		// TODO Auto-generated method stub
		
	}

}
