package pages;

import org.testng.Assert;

import utils.Helper;

public class CityPage extends BasePage {
	Helper helper = new Helper();

	String filePathCommonOR = "./src/main/resources/objectRepo/CommonOR.json",
			filePathSearchPage = "./src/main/resources/objectRepo/SearchPage.json",
			filePathCityPage = "./src/main/resources/objectRepo/CityPage.json",
			locationTextboxElementId = helper.parseJSONToString("locationTextboxId", filePathCommonOR),
			checkInDateElementId = helper.parseJSONToString("checkInDateId", filePathCommonOR),
			checkOutDateElementId = helper.parseJSONToString("checkOutDateId", filePathCommonOR),
			guestCountElementId = helper.parseJSONToString("guestCountId", filePathCommonOR),
			searchButtonElementId = helper.parseJSONToString("searchButtonId", filePathCommonOR),
			sortByRelevanceId = helper.parseJSONToString("sortByRelevanceId", filePathSearchPage),
			sortByPriceCss = helper.parseJSONToString("sortByPriceCss", filePathSearchPage),
			titleClassName = helper.parseJSONToString("titleClassName", filePathCityPage),
			titleDescriptionClassName = helper.parseJSONToString("titleDescriptionClassName", filePathCityPage),
			cityDetailsClassName = helper.parseJSONToString("cityDetailsClassName", filePathCityPage),
			cityNameOnCityPage=helper.parseJSONToString("cityNameOnCityPage", filePathCityPage),
			malaysiaHeader=helper.parseJSONToString("malaysiaHeader", filePathCityPage);
	
	public void isValid() {
		Assert.assertTrue(helper.findElementByClassName(titleClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(titleDescriptionClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(cityDetailsClassName).isDisplayed());
		Assert.assertTrue(helper.findElementById(locationTextboxElementId).isDisplayed());
		Assert.assertTrue(helper.findElementById(checkInDateElementId).isDisplayed());
		Assert.assertTrue(helper.findElementById(checkOutDateElementId).isDisplayed());
		Assert.assertTrue(helper.findElementById(guestCountElementId).isDisplayed());
		Assert.assertTrue(helper.findElementById(searchButtonElementId).isDisplayed());
		Assert.assertTrue(helper.findElementById(sortByRelevanceId).isDisplayed());
		Assert.assertTrue(helper.findElementByCss(sortByPriceCss).isDisplayed());
	}
	
	public String getCityNameInSearch() {
		String cityName=helper.findElementById(cityNameOnCityPage).getAttribute("value");
		return cityName;
		// TODO Auto-generated method stub

	}
	public String getCityPageTitle() {
		String cityName=helper.findElementByClassName(titleClassName).getText();
		return cityName;
		// TODO Auto-generated method stub

	}
	public String getMalaysiaHeader() {
		String malaysiaPageHeader=helper.findElementByClassName(malaysiaHeader).getText();
		return malaysiaPageHeader;
		// TODO Auto-generated method stub

	}

}
