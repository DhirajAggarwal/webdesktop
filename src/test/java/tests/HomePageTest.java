package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BookingConfirmationPage;
import pages.CommonMethods;
import pages.HomePage;
import utils.BrowserFactory;
import utils.Helper;

public class HomePageTest extends BrowserFactory {

	Helper helper = new Helper();

	String filePathHardData = "./src/main/resources/data/HardData",
			filePathHomePageData = "./src/main/resources/data/HomePageData.json",
			loginmobileNumber = helper.parseJSONToString("mobileNumber", filePathHardData),
			loginpassword = helper.parseJSONToString("password", filePathHardData),
			userName = helper.parseJSONToString("userName", filePathHardData),
			location = helper.parseJSONToString("location", filePathHardData),
			checkinDate = helper.parseJSONToString("checkinDate", filePathHardData),
			checkoutDate = helper.parseJSONToString("checkoutDate", filePathHardData),
			corporateName = helper.parseJSONToString("corporateName", filePathHomePageData),
			corporatePhoneNo = helper.parseJSONToString("corporatePhoneNo", filePathHomePageData),
			corporateEmail = helper.parseJSONToString("corporateEmail", filePathHomePageData),
			corporateEnquiry = helper.parseJSONToString("corporateEnquiry", filePathHomePageData),
			corporateSuccessMessage = helper.parseJSONToString("corporateSuccessMessage", filePathHomePageData);

	CommonMethods commonMethods = new CommonMethods();
	HomePage homePage = new HomePage();
	BookingConfirmationPage bookingConfirmation = new BookingConfirmationPage();

	@BeforeClass
	public void openURL() {
		helper.openURL();
	}

	@Test
	public void isValid() {
		homePage.isValid();
	}

	@Test
	public void verifySuccessFulLogin() {
		commonMethods.logInToOyoRooms(loginmobileNumber, loginpassword);
		Assert.assertEquals(homePage.getLoggedInUserName(), userName);
	}

	@Test
	public void verifySubmissionOfCorporateEnquiry() {
		homePage.clickOnCorporateEnquiry();
		homePage.fillCorporateForm(corporateName,corporatePhoneNo,corporateEmail,corporateEnquiry);
		homePage.clickOnCorporateenquirySubmit();
		Assert.assertEquals(homePage.getCorporateEnquirySuccessMessage(),corporateSuccessMessage);
		

	}

	@Test
	public void verifyHotelsDisplayedOnSearch() {
		/*
		 * Assert in this function is incomplete. So this has been commented
		 * Out.
		 */
		commonMethods.searchHotels(location, checkinDate, checkoutDate);
		// Assert.assertEquals("", userName);
	}
}
