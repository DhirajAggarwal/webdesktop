package pages;

import utils.Helper;

public class SearchPage extends BasePage {

	Helper helper = new Helper();
	
	String filePathSearchPage = "./src/main/resources/objectRepo/SearchPage.json",
			priceClassName = helper.parseJSONToString("priceClassName", filePathSearchPage),
			hotelClassName  = helper.parseJSONToString("hotelClassName", filePathSearchPage);

	public void isValid() {
		// TODO Auto-generated method stub

	}

	public void clickPriceSortByAscending() {
		helper.findElementByClassName(priceClassName).click();
	}

	public void clickFirstHotel() {
		helper.findElementsByClassName(hotelClassName).get(0).click();
	}
}
