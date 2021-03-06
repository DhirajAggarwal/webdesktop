package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BasePage {

	String filePathCommonOR = "./src/main/resources/objectRepo/CommonOR.json",
			userNameClassName = helper.parseJSONToString("userNameClassName", filePathCommonOR),
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
			heartCanvas = helper.parseJSONToString("heartCanvas", filePathCommonOR),
			logoutLinkText = helper.parseJSONToString("logoutLinkText", filePathCommonOR),
			blankLoginValidationMessageId = helper.parseJSONToString("blankLoginValidationMessageId", filePathCommonOR),
			loginSubmitButtonClassName = helper.parseJSONToString("submitButtonClassName", filePathCommonOR);
			
	String filePathHomePage = "./src/main/resources/objectRepo/HomePage.json",
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
			viewAllCollectionNameClassName = helper.parseJSONToString("viewAllCollectionNameClassName", filePathHomePage),
			corporateEnquirySuccessId = helper.parseJSONToString("corporateEnquirySuccessId", filePathHomePage),
			megaDDLink = helper.parseJSONToString("megaDDLinkText", filePathHomePage),
			viewAllLinkText = helper.parseJSONToString("viewAllLinkText", filePathHomePage),
			allCitiesLinkText = helper.parseJSONToString("allCitiesLinkText", filePathHomePage),
			nowInMalaysiaLinkText=helper.parseJSONToString("nowInMalaysiaLinkText",filePathHomePage ),
			megaDDlocationCss=helper.parseJSONToString("megaDDlocationCss", filePathHomePage),
			dealsLinksClassName = helper.parseJSONToString("dealsLinksClassName", filePathHomePage),
			cancelLoginId = helper.parseJSONToString("cancelLoginId", filePathHomePage);

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
		//helper.waitForElement(helper.locateByLinkText(myAccountLinkText), 15, "User not getting logged out");
	}

	public void hoverOnUserName(String user) {
		WebElement userName = helper.findElementByLinkText(user);
		helper.hoverOnElement(userName);
	}

	public void clickOnMDDViewAllLink() {
		helper.waitForElement(helper.locateByLinkText(viewAllLinkText), 2, "MDD View All Link Not Found");
		List<WebElement> viewAll=helper.findElementsByLinkText(viewAllLinkText);
		viewAll.get(1).click();		
	}

	public void clickOnAllCitiesLink() {
		helper.waitForElement(helper.locateByLinkText(allCitiesLinkText), 2, "MDD All Cities Link Not Found");
		helper.findElementByLinkText(allCitiesLinkText).click();
	}

	public void clickOnCorporateEnquiry() {
		helper.findElementById(corporateEnquiryFormLabelId).click();
	}

	public void clickOnCityLink() {
		helper.findElementByLinkText(megaDDLink).click();
	}

	public void clickOnFirstDealLink() {
		List<WebElement> dealsLink = helper.findElementsByClassName(dealsLinksClassName);
		dealsLink.get(0).click();
	}

	public void clickOnOyosInMalaysiaLink() {
		List<WebElement> malaysiaLink = helper.findElementsByClassName(hotelLinksClassName);
		malaysiaLink.get(0).click();
	}

	public void clickOnOyosAtHillsLink() {
		List<WebElement> hillsLink = helper.findElementsByClassName(hotelLinksClassName);
		hillsLink.get(1).click();

	}

	public void clickOnOyosInKeralaLink() {
		List<WebElement> KerelaLink = helper.findElementsByClassName(hotelLinksClassName);
		KerelaLink.get(2).click();

	}
	
	public void clickOnMddLocation(String location){
		helper.findElementByLinkText(location).click();
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
		//helper.waitForElement(helper.locateByLinkText(myAccountLinkText), 8, "My Account Link Not found");
		helper.findElementByLinkText(myAccountLinkText).click();
	}

	public void clickOnLoginButton() {
		helper.findElementById(logInId).click();
	}

	public void clickCancelLoginWindow() {
		helper.findElementById(cancelLoginId);
	}
	
	public void fillCorporateForm(String name, String phone, String email, String enquiry) {
		helper.findElementById(corporateNameId).sendKeys(name);
		helper.findElementById(corporatePhoneId).sendKeys(phone);
		helper.findElementById(corporateEmailId).sendKeys(email);
		helper.findElementById(corporateEnquiryId).sendKeys(enquiry);

	}

	public void hoverOnMDDLink() {
		//helper.waitForElement(helper.locateByLinkText(megaDDLink), 3, "MDD City Link Not found");
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
		helper.findElementByClassName(loginSubmitButtonClassName).click();
	}

	public void clickUserName() {
		helper.hoverOnElement(helper.findElementByClassName(userNameClassName));
	}
	
	public String getLoggedInUserName() {
		//helper.waitForElement(helper.locateById(userNameClassName), 5, "Username not visible after Login");
		String userName = helper.findElementByClassName(userNameClassName).getText();
		return userName;
	}

	public String getFirstCollectionName() {
		//helper.waitForElement(helper.locateByClassName(viewAllCollectionNameClassName), 15, "Collection Name Not visible");
		List<WebElement> collectionName = helper.findElementsByClassName(viewAllCollectionNameClassName);
		String collection=collectionName.get(1).getText();
		return collection;
	}

	public void setLocation(String location) {
		helper.findElementById(locationId).clear();
		helper.findElementById(locationId).sendKeys(location);
		helper.findElementById(locationId).sendKeys(" ");
		//helper.waitForElement(helper.locateById(locationSuggestionsId), 5, "No Suggestions on Search");
	/*	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		helper.findElementById(locationId).sendKeys(Keys.DOWN);
		helper.findElementById(locationId).sendKeys(Keys.ENTER);*/
	}

	public String getLocation() {
		String myLocation = helper.findElementById(locationId).getText();
		return myLocation;
	}

	public String getCorporateEnquirySuccessMessage() {
		//helper.waitForElement(helper.locateById(corporateEnquirySuccessId), 5, "Corporate Success message not Displayed");
		String enquirySuccessMessage = helper.findElementById(corporateEnquirySuccessId).getText();
		return enquirySuccessMessage;
	}

	public void setCheckInDate(String date, int month) {
		int monthCounter = 0;
		int currentMonth = helper.getCurrentMonth();
		if(month>=currentMonth){
			monthCounter = month - currentMonth;
		}
		helper.findElementById(checkInId).click();
		//helper.waitForElement(helper.locateByLinkText(date), 6, "No checkin date displayed");
		for(int i=1; i<=monthCounter; i++){
		helper.waitForElement(By.linkText("Next"), 3, "Calendar Next Link Not Working");
		helper.findElementByLinkText("Next").click();
		}
		helper.findElementByLinkText(date).click();
	}

	public void setCheckOutDate(String checkOutDate) {
		helper.findElementById(checkOutId).click();
		//helper.waitForElement(helper.locateByLinkText(checkOutDate), 10, "No checkout date displayed");
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
		//helper.waitForElement(helper.locateById(searchButtonId), 3, "Search Button Not visible");
		helper.findElementById(searchButtonId).click();
		//helper.waitForElement(helper.locateByClassName(hotelClassName), 20, "Hotels Not Displayed After Search");
	}

	public void clickOnCorporateEnquirySubmit() {
		helper.findElementById(corporateEnquirySubmitButtonId).click();
		// TODO Auto-generated method stub
	}

	public void clickOnNowInMalaysiaLink() {
		helper.findElementByLinkText(nowInMalaysiaLinkText).click();	
	}

	public String getFirstLocationName(String location) {
		//helper.waitForElement(helper.locateByLinkText(location),30, "Location Not Visible");
		String locationName=helper.findElementByLinkText(location).getText();
		return locationName;
	}

}
