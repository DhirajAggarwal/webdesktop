package pages;

import utils.Helper;

public class BookingConfirmation extends BasePage {

	Helper helper = new Helper();
	
	String filePathBookingConfirmation = "./src/main/resources/objectRepo/BookingConfirmation.json",
			successfulTextClassName = helper.parseJSONToString("successfulTextClassName", filePathBookingConfirmation);
	
	public void isValid() {
		// TODO Auto-generated method stub
	}

	public String getBookingSuccessMessage() {
		return helper.findElementByClassName(successfulTextClassName).getText();
	}
	
}
