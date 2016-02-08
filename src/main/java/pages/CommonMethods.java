package pages;

import utils.Helper;

public class CommonMethods {

	HomePage homePage = new HomePage();
	SearchPage hotelSerachPage = new SearchPage();
	HotelPage hotelPage = new HotelPage();
	BookingConfirmation bookingConfirmation = new BookingConfirmation();
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

	public String bookingConfirmation() {
		hotelSerachPage.clickPriceSortByAscending();
		hotelSerachPage.clickFirstHotel();
		hotelPage.clickBookNow();
		hotelPage.clickRequiredId();
		hotelPage.clickPayAtHotel();
		return bookingConfirmation.getBookingSuccessMessage();
	}

}
