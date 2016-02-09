package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CommonMethods;
import pages.HomePage;
import utils.BrowserFactory;
import utils.Helper;

public class HomePageTest extends BrowserFactory {

	Helper helper = new Helper();

	String filePathHardData = "./src/main/resources/data/HardData";
	String	filePathHomePageData = "./src/main/resources/data/HomePageData.json",
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

	@BeforeMethod
	public void openURL() {
		helper.openURL();
	}

	@Test(priority=0)
	public void isValid() {
		homePage.isValid();
	}

	@Test(priority=2)
	public void verifySubmissionOfCorporateEnquiry() {
		homePage.clickOnCorporateEnquiry();
		homePage.fillCorporateForm(corporateName,corporatePhoneNo,corporateEmail,corporateEnquiry);
		homePage.clickOnCorporateEnquirySubmit();
		Assert.assertEquals(homePage.getCorporateEnquirySuccessMessage(),corporateSuccessMessage);
	}
	@Test(priority=1)
	public void verifySuccessFulLogin() {
		commonMethods.logInToOyoRooms(loginmobileNumber, loginpassword);
		Assert.assertEquals(homePage.getLoggedInUserName(), userName);
	}
	
	@Test(priority=3)
	public void verifyHotelsDisplayedOnSearch() {
		commonMethods.searchHotels(location, checkinDate, checkoutDate);
		// Assert.assertEquals("", userName);
	}

}
