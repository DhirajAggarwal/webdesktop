package pages;

import utils.Helper;

public class SearchPage extends BasePage {

	Helper helper = new Helper();
	
	String filePathHotelSearchPage = "./src/main/resources/objectRepo/HotelSearchPage.json",
			priceClassName = helper.parseJSONToString("priceClassName", filePathHotelSearchPage),
			hotelClassName  = helper.parseJSONToString("hotelClassName", filePathHotelSearchPage);

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
