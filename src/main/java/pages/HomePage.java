package pages;

import org.openqa.selenium.Keys;

import utils.Helper;

public class HomePage extends BasePage {

	Helper helper = new Helper();

	String filePathCommonOR = "./src/main/resources/objectRepo/CommonOR.json",
			// MOBILE_NUM = helper.parseJSONToString("mobileNumber",
			// filePathCommonOR),
			// PASSWORD = helper.parseJSONToString("password",
			// filePathCommonOR),
			myAccountCss = helper.parseJSONToString("myAccountCss", filePathCommonOR),
			logInId = helper.parseJSONToString("logInId", filePathCommonOR),
			mobileTextCss = helper.parseJSONToString("mobileTextCss", filePathCommonOR),
			passwordTextCss = helper.parseJSONToString("passwordTextCss", filePathCommonOR),
			submitButtonClassName = helper.parseJSONToString("submitButtonClassName", filePathCommonOR),
			// userNameId = helper.parseJSONToString("userNameId",
			// filePathCommonOR);
			userNameId = helper.parseJSONToString("userNameId", filePathCommonOR),
			locationId = helper.parseJSONToString("locationTextboxId", filePathCommonOR),
			checkInId = helper.parseJSONToString("checkInDateId", filePathCommonOR),
			checkOutId = helper.parseJSONToString("checkOutDateId", filePathCommonOR),
			searchButtonId = helper.parseJSONToString("searchButtonId", filePathCommonOR),
			locationSuggestionsId = helper.parseJSONToString("locationSuggestionId", filePathCommonOR),
			hotelClassName = helper.parseJSONToString("hotelClassName", filePathCommonOR);

	public void isValid() {
		// TODO Auto-generated method stub

	}

	public void clickOnMyAccounts() {
		helper.findElementByCss((myAccountCss)).click();
	}

	public void clickOnLoginButton() {
		helper.findElementById(logInId).click();
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

}
