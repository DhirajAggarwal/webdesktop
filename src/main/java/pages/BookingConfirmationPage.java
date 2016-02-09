package pages;

import utils.Helper;

public class BookingConfirmationPage extends BasePage {

	Helper helper = new Helper();
	
	String filePathBookingConfirmationPage = "./src/main/resources/objectRepo/BookingConfirmationPage.json",
			successfulTextClassName = helper.parseJSONToString("successfulTextClassName", filePathBookingConfirmationPage);
	
	public void isValid() {
		// TODO Auto-generated method stub
	}

	public String getBookingSuccessMessage() {
		return helper.findElementByClassName(successfulTextClassName).getText();
	}
	
}
