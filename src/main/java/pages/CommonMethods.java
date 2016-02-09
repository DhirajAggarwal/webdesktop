package pages;

import utils.Helper;

public class CommonMethods {

	HomePage homePage = new HomePage();
	SearchPage serachPage = new SearchPage();
	HotelPage hotelPage = new HotelPage();
	BookingConfirmationPage bookingConfirmation = new BookingConfirmationPage();
	Helper helper = new Helper();

	public void logInToOyoRooms(String mobileNumber, String password) {
		homePage.clickOnMyAccounts();
		homePage.clickOnLoginButton();
		homePage.setMobileNumberForLogin(mobileNumber);
		homePage.setPasswordForLogin(password);
		homePage.clickOnLoginSubmitButton();
	}
	public void searchHotels(String location,String checkinDate,String checkoutDate) {
		homePage.setLocation(location);
		homePage.setCheckInDate(checkinDate);
		homePage.setCheckInDate(checkoutDate);
		homePage.clickOnSearchButton();		
	}

	
	
	public void payAtHotel(){
	}

	public String bookingConfirmation() {
		serachPage.clickPriceSortByAscending();
		serachPage.clickFirstHotel();
		hotelPage.clickBookNow();
		hotelPage.clickRequiredId();
		hotelPage.clickPayAtHotel();
		return bookingConfirmation.getBookingSuccessMessage();


}}
