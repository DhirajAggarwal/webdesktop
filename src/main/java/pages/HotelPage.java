package pages;

import utils.Helper;

public class HotelPage extends BasePage {
	
Helper helper = new Helper();
	
	String filePathHotelPage = "./src/main/resources/objectRepo/HotelPage.json",
			bookNowId = helper.parseJSONToString("bookNowId", filePathHotelPage),
			payAtHotelId  = helper.parseJSONToString("payAtHotelId", filePathHotelPage),
	requiredIdClassName   = helper.parseJSONToString("requiredIdClassName", filePathHotelPage);
	
	public void isValid() {

	}

	public void clickBookNow() {
		helper.findElementById(bookNowId).click();
	}

	public void clickRequiredId() {
		if( helper.findElementByClassName(requiredIdClassName)!= null){
			helper.findElementByClassName(requiredIdClassName).click();
		}
	}

	public void setCoupon() {

	}

	public void clickApplyCoupon() {

	}

	public void setVerificationCode() {

	}

	public void clickConfirmAndBook() {

	}

	public void clickPayAtHotel() {
		helper.findElementById(payAtHotelId).click();
	}
}
