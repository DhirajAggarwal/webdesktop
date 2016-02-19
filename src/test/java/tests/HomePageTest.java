package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AllCities;
import pages.CityPage;
import pages.CommonMethods;
import pages.DealsPage;
import pages.HomePage;
import pages.OyosAtHills;
import pages.OyosInKerela;
import pages.SearchPage;
import utils.BrowserFactory;

public class HomePageTest extends BrowserFactory {

	CommonMethods commonMethods = new CommonMethods();
	HomePage homePage = new HomePage();
	SearchPage searchPage = new SearchPage();
	AllCities allCities = new AllCities();
	CityPage cityPage = new CityPage();
	DealsPage dealsPage = new DealsPage();
	OyosAtHills hillsPage = new OyosAtHills();
	OyosInKerela kerelaPage = new OyosInKerela();

	String filePathCommonTestData = "./src/main/resources/data/CommonTestData.json",
			loginmobileNumber = helper.parseJSONToString("mobileNumber", filePathCommonTestData),
			loginPassword = helper.parseJSONToString("password", filePathCommonTestData),
			userName = helper.parseJSONToString("userName", filePathCommonTestData),
			location = helper.parseJSONToString("location", filePathCommonTestData),
			checkinDate = helper.parseJSONToString("checkinDate", filePathCommonTestData),
			checkInMonth = helper.parseJSONToString("checkInMonth", filePathCommonTestData),
			checkoutDate = helper.parseJSONToString("checkoutDate", filePathCommonTestData),
			blankMobileNumber = helper.parseJSONToString("blankMobileNumber", filePathCommonTestData),
			blankLoginPassword = helper.parseJSONToString("blankLoginPassword", filePathCommonTestData),
			blankValidationMessage = helper.parseJSONToString("blankValidationMessage", filePathCommonTestData);

	String filePathHomePageData = "./src/main/resources/data/HomePageData.json",
			corporateName = helper.parseJSONToString("corporateName", filePathHomePageData),
			corporatePhoneNo = helper.parseJSONToString("corporatePhoneNo", filePathHomePageData),
			corporateEmail = helper.parseJSONToString("corporateEmail", filePathHomePageData),
			corporateEnquiry = helper.parseJSONToString("corporateEnquiry", filePathHomePageData),
			corporateSuccessMessage = helper.parseJSONToString("corporateSuccessMessage", filePathHomePageData),
			hillsDealName = helper.parseJSONToString("hillsDealName", filePathHomePageData),
			malaysiaCityName = helper.parseJSONToString("malaysiaCityName", filePathHomePageData),
			kerelaDealName = helper.parseJSONToString("kerelaDealName", filePathHomePageData),
			cityPageTitle = helper.parseJSONToString("cityPageTitle", filePathHomePageData),
			malaysiaHeader = helper.parseJSONToString("malaysiaHeader", filePathHomePageData),
			megaDDlocationLinkText = helper.parseJSONToString("megaDDlocationLinkText", filePathHomePageData),
			megaDDcityLinkText = helper.parseJSONToString("megaDDcityLinkText", filePathHomePageData);

	int checkInMonthInt = Integer.parseInt(checkInMonth); //why Conversion? why not take int from json?

	@BeforeMethod
	public void openURL() {
		helper.openURL();
	}

	@Test
	public void isValid() {
		homePage.isValid();
	}

	@Test
	public void verifySubmissionOfCorporateEnquiry() {
		homePage.clickOnCorporateEnquiry();
		homePage.fillCorporateForm(corporateName, corporatePhoneNo, corporateEmail, corporateEnquiry);
		homePage.clickOnCorporateEnquirySubmit();
		Assert.assertEquals(homePage.getCorporateEnquirySuccessMessage(), corporateSuccessMessage);
	}

	@Test
	public void verifyBlankLoginValidation() {
		commonMethods.logInToOyoRooms(blankMobileNumber, blankLoginPassword);
		Assert.assertEquals(homePage.getBlankLoginValidationMessage(), blankValidationMessage);
	}

	@Test
	public void verifySuccessFulLogin() {
		commonMethods.logInToOyoRooms(loginmobileNumber, loginPassword);
		Assert.assertEquals(homePage.getLoggedInUserName(), userName);
		homePage.hoverOnUserName(userName);
		homePage.logoutUser();
	}

	@Test
	public void verifyHotelsDisplayedOnSearch() {
		commonMethods.searchHotels(location, checkinDate, checkInMonthInt, checkoutDate);
		cityPage.isValid();
	}

	@Test
	public void verifyCityLinkInMDD() {
		homePage.clickOnCityLink();
		cityPage.isValid();
	}

	@Test
	public void verifyViewAllLinkInMDD() {
		homePage.hoverOnMDDLink();
		String collectionName = homePage.getFirstCollectionName();
		homePage.clickOnMDDViewAllLink();
		String tagName = searchPage.getTagName();
		Assert.assertEquals(collectionName, tagName);
	}

	@Test
	public void verifyLocationLinkInMDD() {
		homePage.hoverOnMDDLink();
		String locationName = homePage.getFirstLocationName(megaDDlocationLinkText); //Where locationName is used?
		homePage.clickOnMddLocation(megaDDlocationLinkText);
		Assert.assertEquals(megaDDlocationLinkText + ", " + megaDDcityLinkText + ", India", //Remove hardcoded values
				searchPage.getlocalityNameInSearch());
		searchPage.isValid();
	}

	@Test
	public void verifyAllCitiesLinkInMDD() {
		homePage.clickOnAllCitiesLink();
		allCities.isValid();
	}

	@Test
	public void verifyDealsLink() {
		homePage.clickOnFirstDealLink();
		dealsPage.isValid();
	}

	@Test
	public void verifyMalaysiaLink() {
		homePage.clickOnOyosInMalaysiaLink();
		cityPage.isValid();
		Assert.assertEquals(cityPageTitle, cityPage.getCityPageTitle());
		Assert.assertEquals(malaysiaCityName, cityPage.getCityNameInSearch());
		Assert.assertEquals(malaysiaHeader, cityPage.getMalaysiaHeader());
	}

	@Test
	public void verifyOyosAtHillsLink() {
		homePage.clickOnOyosAtHillsLink();
		hillsPage.isValid();
		Assert.assertEquals(hillsDealName, hillsPage.getDealName());
	}

	@Test
	public void verifyKeralaLink() {
		homePage.clickOnOyosInKeralaLink();
		kerelaPage.isValid();
		Assert.assertEquals(kerelaDealName, kerelaPage.getDealName());
	}

	@Test
	public void verifyNowInMalaysiaLink() {
		homePage.clickOnNowInMalaysiaLink();
		cityPage.isValid();
		Assert.assertEquals(cityPageTitle, cityPage.getCityPageTitle());
		Assert.assertEquals(malaysiaCityName, cityPage.getCityNameInSearch());
		Assert.assertEquals(malaysiaHeader, cityPage.getMalaysiaHeader());
	}

}
