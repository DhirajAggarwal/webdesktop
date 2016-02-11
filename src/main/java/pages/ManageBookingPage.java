package pages;

public class ManageBookingPage extends BasePage {
	
	protected String filePathManageBookingPage = "./src/main/resources/objectRepo/ManageBookingPage.json",
			filePathManageBookingPageTestData = "./src/main/resources/data/ManageBookingPageTestData.json",
			bookingLinkClassName = helper.parseJSONToString("bookingLinkClassName", filePathManageBookingPage),
			upcomingBookingListId = helper.parseJSONToString("upcomingBookingListId", filePathManageBookingPage),
			viewDetailClassName = helper.parseJSONToString("viewDetailClassName", filePathManageBookingPage),
			cancelBookingButtonId = helper.parseJSONToString("cancelBookingButtonId", filePathManageBookingPage),
			bookingIdClassName = helper.parseJSONToString("bookingIdClassName", filePathManageBookingPage),
			bookingCancellatioTextClassName = helper.parseJSONToString("bookingCancellatioTextClassName", filePathManageBookingPage),
			makePartialPaymentId = helper.parseJSONToString("makePartialPaymentId", filePathManageBookingPage),
			partialPaymentTextBoxClassName	=	helper.parseJSONToString("partialPaymentTextBoxClassName", filePathManageBookingPage),
			amountPartialPayment = helper.parseJSONToString("amountPartialPayment", filePathManageBookingPageTestData),
			payNowId = helper.parseJSONToString("payNowId", filePathManageBookingPage);

	public void isValid() {
		// TODO Auto-generated method stub

	}

	public void clickManageBooking() {

	}

	public void setBookingId() {

	}

	public void setMobileNumber() {

	}

	public void clickSubmit() {

	}

	public void clickBooking() {
		helper.findElementsByClassName(bookingLinkClassName).get(1).click();
	}

	public void clickUpcomingBooking() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		helper.findElementById(upcomingBookingListId).click();
	}

	public void clickFirstBooking() {
		helper.findElementByClassName(viewDetailClassName).click();
	}
	
	public String getFirstBookingId() {
		return helper.findElementByClassName(bookingIdClassName).getText();
	}

	public void clickMakePayment() {
		helper.findElementById(makePartialPaymentId).click();
	}
	
	public void setPartialPayment() {
		helper.findElementByClassName(partialPaymentTextBoxClassName).clear();
		helper.findElementByClassName(partialPaymentTextBoxClassName).sendKeys(amountPartialPayment);
	}
	
	public void clickPayNow() {
		helper.findElementById(payNowId).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void clickCancelBooking() {
		helper.findElementById(cancelBookingButtonId).click();
	}

	public String getCancellationText() {
		return helper.findElementByClassName(bookingCancellatioTextClassName).getText();
	}
}
