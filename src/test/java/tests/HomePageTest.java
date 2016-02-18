package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CommonMethods;
import pages.HomePage;
import utils.BrowserFactory;

public class HomePageTest extends BrowserFactory {

	CommonMethods commonMethods = new CommonMethods();
	HomePage homePage = new HomePage();

	String filePathCommonTestData = "./src/main/resources/data/CommonTestData.json",
			loginmobileNumber = helper.parseJSONToString("mobileNumber", filePathCommonTestData),
			loginPassword = helper.parseJSONToString("password", filePathCommonTestData),
			userName = helper.parseJSONToString("userName", filePathCommonTestData),
			location = helper.parseJSONToString("location", filePathCommonTestData),
			checkinDate = helper.parseJSONToString("checkinDate", filePathCommonTestData),
			checkoutDate = helper.parseJSONToString("checkoutDate", filePathCommonTestData),
			blankMobileNumber = helper.parseJSONToString("blankMobileNumber", filePathCommonTestData),
			blankLoginPassword = helper.parseJSONToString("blankLoginPassword", filePathCommonTestData),
			blankValidationMessage = helper.parseJSONToString("blankValidationMessage", filePathCommonTestData);

	String filePathHomePageData = "./src/main/resources/data/HomePageData.json",
			corporateName = helper.parseJSONToString("corporateName", filePathHomePageData),
			corporatePhoneNo = helper.parseJSONToString("corporatePhoneNo", filePathHomePageData),
			corporateEmail = helper.parseJSONToString("corporateEmail", filePathHomePageData),
			corporateEnquiry = helper.parseJSONToString("corporateEnquiry", filePathHomePageData),
			corporateSuccessMessage = helper.parseJSONToString("corporateSuccessMessage", filePathHomePageData);

	@BeforeMethod
	public void openURL() {
		helper.openURL();
	}

	@Test(priority = 0)
	public void isValid() {
		homePage.isValid();
	}

	@Test(priority = 1)
	public void verifySubmissionOfCorporateEnquiry() {
		homePage.clickOnCorporateEnquiry();
		homePage.fillCorporateForm(corporateName, corporatePhoneNo, corporateEmail, corporateEnquiry);
		homePage.clickOnCorporateEnquirySubmit();
		Assert.assertEquals(homePage.getCorporateEnquirySuccessMessage(), corporateSuccessMessage);
	}

	@Test(priority = 2)
	public void verifyBlankLoginValidation() {
		commonMethods.logInToOyoRooms(blankMobileNumber, blankLoginPassword);
		Assert.assertEquals(homePage.getBlankLoginValidationMessage(), blankValidationMessage);
	}

	@Test(priority = 3)
	public void verifySuccessFulLogin() {
		commonMethods.logInToOyoRooms(loginmobileNumber, loginPassword);
		Assert.assertEquals(homePage.getLoggedInUserName(), userName);
		homePage.hoverOnUserName(userName);
		homePage.logoutUser();
	}

	@Test(priority = 4)
	public void verifyHotelsDisplayedOnSearch() {
		/*
		 * Assert in this function is incomplete. So this has been commentedOut.
		 */
		commonMethods.searchHotels(location, checkinDate, checkoutDate);
		// Assert.assertEquals("", userName);
	}

	@Test(priority = 5)
	public void verifyViewAllLinkInMDD() {
		homePage.hoverOnMDDLink();
		homePage.clickOnMDDViewAllLink();
	}

	@Test(priority = 6)
	public void verifyAllCitiesLinkInMDD() {
		homePage.clickOnAllCitiesLink();
	}
}
