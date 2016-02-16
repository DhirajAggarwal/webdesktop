package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CommonMethods;
import pages.HomePage;
import pages.SearchPage;
import pages.AllCities;
import pages.CityPage;
import pages.DealsPage;
import pages.OyosAtHills;
import pages.OyosInKerela;
import utils.BrowserFactory;
import utils.Helper;

public class HomePageTest extends BrowserFactory {

	Helper helper = new Helper();
	CommonMethods commonMethods = new CommonMethods();
	HomePage homePage = new HomePage();
	SearchPage searchPage =  new SearchPage();
	AllCities allCities = new AllCities();
	CityPage cityPage =new CityPage();
	DealsPage dealsPage = new DealsPage();
	OyosAtHills hillsPage =new OyosAtHills();
	OyosInKerela kerelaPage =new OyosInKerela();
	

	String filePathCommonTestData = "./src/main/resources/data/CommonTestData.json";
	String filePathHomePageData = "./src/main/resources/data/HomePageData.json",

			loginmobileNumber = helper.parseJSONToString("mobileNumber", filePathCommonTestData),
			loginPassword = helper.parseJSONToString("password", filePathCommonTestData),
			userName = helper.parseJSONToString("userName", filePathCommonTestData),
			location = helper.parseJSONToString("location", filePathCommonTestData),
			checkinDate = helper.parseJSONToString("checkinDate", filePathCommonTestData),
			checkoutDate = helper.parseJSONToString("checkoutDate", filePathCommonTestData),
			corporateName = helper.parseJSONToString("corporateName", filePathHomePageData),
			corporatePhoneNo = helper.parseJSONToString("corporatePhoneNo", filePathHomePageData),
			corporateEmail = helper.parseJSONToString("corporateEmail", filePathHomePageData),
			corporateEnquiry = helper.parseJSONToString("corporateEnquiry", filePathHomePageData),
			corporateSuccessMessage = helper.parseJSONToString("corporateSuccessMessage", filePathHomePageData),
			blankMobileNumber = helper.parseJSONToString("blankMobileNumber", filePathCommonTestData),
			blankLoginPassword = helper.parseJSONToString("blankLoginPassword", filePathCommonTestData),
			blankValidationMessage = helper.parseJSONToString("blankValidationMessage", filePathCommonTestData),
			hillsDealName= helper.parseJSONToString("hillsDealName", filePathHomePageData),
			malaysiaCityName=helper.parseJSONToString("malaysiaCityName", filePathHomePageData),
			kerelaDealName=helper.parseJSONToString("kerelaDealName", filePathHomePageData),
			cityPageTitle=helper.parseJSONToString("cityPageTitle", filePathHomePageData);

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
	 commonMethods.searchHotels(location, checkinDate, checkoutDate);
	 searchPage.isValid();
	 }
	 @Test(priority = 11)
		public void verifyCityLinkInMDD() {
			homePage.clickOnCityLink();
			cityPage.isValid();	
		}
/*	@Test(priority = 5)
	public void verifyViewAllLinkInMDD() {
		homePage.hoverOnMDDLink();
		String collectionName=homePage.getFirstCollectionName();
		homePage.clickOnMDDViewAllLink();
		String tagName=searchPage.getTagName();
		Assert.assertEquals(collectionName,tagName);
}*/

	@Test(priority = 6)
	public void verifyAllCitiesLinkInMDD() {
		homePage.clickOnAllCitiesLink();
		allCities.isValid();
	}
	
	@Test(priority = 7)
	public void verifyDealsLink() {
		homePage.clickOnFirstDealLink();
		dealsPage.isValid();
	}
	@Test(priority = 8)
	public void verifyMalaysiaLink() {
		homePage.clickOnOyosInMalaysiaLink();
		cityPage.isValid();
		Assert.assertEquals(cityPageTitle,cityPage.getCityPageTitle());
		//Assert.assertEquals(malaysiaCityName,cityPage.getCityNameInSearch());
		
	}
	@Test(priority = 9)
	public void verifyOyosAtHillsLink() {
		homePage.clickOnOyosAtHillsLink();
		hillsPage.isValid();
		Assert.assertEquals(hillsDealName,hillsPage.getDealName());
	}
	@Test(priority = 10)
	public void verifyKeralsLink() {
		homePage.clickOnOyosInKeralaLink();
		kerelaPage.isValid();
		Assert.assertEquals(kerelaDealName,kerelaPage.getDealName());
	}
}
