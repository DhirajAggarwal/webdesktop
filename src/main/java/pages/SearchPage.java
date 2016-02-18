package pages;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import utils.Helper;

public class SearchPage extends BasePage {

	Helper helper = new Helper();
	HomePage homePage = new HomePage();
	
	String filePathCommonOR = "./src/main/resources/objectRepo/CommonOR.json",
			locationTextboxElementId = helper.parseJSONToString("locationTextboxId", filePathCommonOR),
			checkInDateElementId = helper.parseJSONToString("checkInDateId", filePathCommonOR),
			checkOutDateElementId = helper.parseJSONToString("checkOutDateId", filePathCommonOR),
			guestCountElementId = helper.parseJSONToString("guestCountId", filePathCommonOR),
			searchButtonElementId = helper.parseJSONToString("searchButtonId", filePathCommonOR);

	
	String filePathSearchPage = "./src/main/resources/objectRepo/SearchPage.json",
			priceClassName = helper.parseJSONToString("priceClassName", filePathSearchPage),
			hotelClassName  = helper.parseJSONToString("hotelClassName", filePathSearchPage),
			hotelNameCss = helper.parseJSONToString("hotelNameCss",filePathSearchPage),
			searchLocalityId = helper.parseJSONToString("searchLocalityId", filePathSearchPage),
			sortByRelevanceId = helper.parseJSONToString("sortByRelevanceId", filePathSearchPage),
			sortByDistanceId = helper.parseJSONToString("sortByDistanceId", filePathSearchPage),
			sortByPriceCss = helper.parseJSONToString("sortByPriceCss", filePathSearchPage),
			distanceFilter = helper.parseJSONToString("distanceFilter", filePathSearchPage),
			firstHotelSnippetCss = helper.parseJSONToString("firstHotelSnippetCss", filePathSearchPage),
			tagId=helper.parseJSONToString("tagId", filePathSearchPage);
			//localityNameOnCityPage=helper.parseJSONToString("localityNameOnCityPage", filePathSearchPage);

	String filePathHotelPage = "./src/main/resources/objectRepo/HotelPage.json",
			hotelName  = helper.parseJSONToString("hotelNameId", filePathHotelPage);

	/**
	 * Validate Header, Footer as well as Search Page specific element presence
	 */
	public void isValid() {
		homePage.validateHeaderElements();
		validateSearchPageElements();
		homePage.validateFooterElements();
	}

	/**
	 * Validate Search Page elements presence
	 */
	private void validateSearchPageElements() {
		
		/* Search bar validation on Search Page */
		Assert.assertTrue(helper.findElementById(locationTextboxElementId).isDisplayed());
		Assert.assertTrue(helper.findElementById(checkInDateElementId).isDisplayed());
		Assert.assertTrue(helper.findElementById(checkOutDateElementId).isDisplayed());
		Assert.assertTrue(helper.findElementById(guestCountElementId).isDisplayed());
		Assert.assertTrue(helper.findElementById(searchButtonElementId).isDisplayed());
		Assert.assertTrue(helper.findElementById(searchLocalityId).isDisplayed());
		Assert.assertTrue(helper.findElementById(sortByRelevanceId).isDisplayed());
		Assert.assertTrue(helper.findElementByCss(sortByPriceCss).isDisplayed());
		Assert.assertTrue(helper.findElementById(sortByDistanceId).isDisplayed());
		//Assert.assertTrue(helper.findElementByCss(distanceFilter).isDisplayed());
			
	}
	public String getlocalityNameInSearch() {
		String localityName=helper.findElementById(locationTextboxElementId).getAttribute("value");
		return localityName;
		// TODO Auto-generated method stub

	}
	
	/**
	 * Search hotel by locality
	 * 
	 * @param locality : Locality to be search
	 */
	public void searchByLocality(String locality) {
		//TODO: use it in test to search for locality
		//helper.findElementByCss(searchLocalityId).sendKeys(locality);
		//helper.findElementByCss(searchLocalityId).sendKeys(Keys.ENTER);
	}

	/**
	 * Click for sort by Relevance
	 */
	public void clickOnSortByRelevance() {
		helper.findElementById(sortByRelevanceId).click();
		//TODO: Use Assert for verifying the relevance sorting
	}
	
	
	/**
	 * Click for sort by Distance
	 */
	public void clickOnSortByDistance() {
		helper.findElementById(sortByDistanceId).click();	
	}
	
	public String getTagName() {
		helper.waitForElement(helper.locateById(tagId), 15, "Tag not Found On Search Page");
		String tagName=helper.findElementById(tagId).getText();
		return tagName;
		
	}
	
	
	public void clickPriceSortByAscending() {
		helper.findElementByClassName(priceClassName).click();
		
	}

	/**
	 * Click always on First Hotel in the list
	 */
	public String clickFirstHotel() {
		String hotelName = helper.findElementByCss(hotelNameCss).getText();
		helper.findElementsByClassName(hotelClassName).get(0).click();
		return hotelName;
	}
	
	/**
	 * @return : Return the Hotel Name from the Hotel Page
	 */
	public String getHotelName() {
		return helper.findElementById(hotelName).getText();
	}
	
}
