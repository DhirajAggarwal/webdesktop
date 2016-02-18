package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CommonMethods;
import pages.HomePage;
import pages.SearchPage;
import utils.BrowserFactory;
import utils.Helper;

public class SearchPageTest extends BrowserFactory {

	Helper helper = new Helper();
	CommonMethods commonMethod = new CommonMethods();
	SearchPage searchPage =  new SearchPage();
	
	String filePathCommonTestData = "./src/main/resources/data/CommonTestData.json",
	locality = helper.parseJSONToString("locality", filePathCommonTestData),
	checkInDate = helper.parseJSONToString("checkinDate", filePathCommonTestData),
	checkOutDate = helper.parseJSONToString("checkoutDate", filePathCommonTestData);

	CommonMethods commonMethods = new CommonMethods();
	HomePage homePage = new HomePage();

	@BeforeMethod
	public void openUrlAndSearchHotel() {
		helper.openURL();
		// go to Search page by searching locality
		commonMethods.searchHotels(locality, checkInDate, checkOutDate);
	}

	@Test
	public void verifySearchPageElement(){
		searchPage.isValid();
	}
	
}
