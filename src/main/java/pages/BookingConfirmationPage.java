package pages;

public class BookingConfirmationPage extends BasePage {
	
	String filePathBookingConfirmationPage = "./src/main/resources/objectRepo/BookingConfirmationPage.json",
			bookingSuccessfulTextClassName = helper.parseJSONToString("bookingSuccessfulTextClassName", filePathBookingConfirmationPage);
	
	public void isValid() {
		// TODO Auto-generated method stub
	}

	public String getBookingSuccessMessage() {
		return helper.findElementByClassName(bookingSuccessfulTextClassName).getText();
	}
	
}
