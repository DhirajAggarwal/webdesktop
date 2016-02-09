package pages;

public class CommonMethods {

	HomePage homePage = new HomePage();

	public void logInToOyoRooms(String mobileNumber,String password) {
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
}
