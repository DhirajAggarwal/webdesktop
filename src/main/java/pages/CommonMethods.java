package pages;

public class CommonMethods {

	HomePage homePage = new HomePage();
	SearchPage serachPage = new SearchPage();
	HotelPage hotelPage = new HotelPage();
	BookingConfirmationPage bookingConfirmation = new BookingConfirmationPage();
	ManageBookingPage manageBookingPage = new ManageBookingPage();

	public void logInToOyoRooms(String mobileNumber, String password) {
		homePage.clickOnMyAccounts();
		homePage.clickOnLoginButton();
		homePage.setMobileNumberForLogin(mobileNumber);
		homePage.setPasswordForLogin(password);
		homePage.clickOnLoginSubmitButton();
	}

	public void searchHotels(String location, String checkinDate, String checkoutDate) {
		homePage.setLocation(location);
		homePage.setCheckInDate(checkinDate);
		homePage.setCheckInDate(checkoutDate);
		homePage.clickOnSearchButton();
	}

	public void navigateToHotelPageFromSearchPage() {
		serachPage.clickPriceSortByAscending();
		serachPage.clickFirstHotel();
		hotelPage.clickBookNow();
		hotelPage.clickRequiredId();
	}
	
	public void bookingConfirmationPAHafterLogin() {
		navigateToHotelPageFromSearchPage();
		hotelPage.clickPayAtHotel();
	}

	public void bookingConfirmationPayNow() {
		navigateToHotelPageFromSearchPage();
		hotelPage.clickPayNow();
		hotelPage.clickCreditCard();
	}
	
	public void cancelBooking() {
		manageBookingPage.clickBooking();
		manageBookingPage.clickUpcomingBooking();
		manageBookingPage.clickFirstBooking();
		manageBookingPage.clickCancelBooking();	
	}
	
	public void partialPayment() {
		manageBookingPage.clickBooking();
		manageBookingPage.clickUpcomingBooking();
		manageBookingPage.clickFirstBooking();
		manageBookingPage.clickMakePayment();
		manageBookingPage.setPartialPayment();
		manageBookingPage.clickPayNow();
	}
	
}
