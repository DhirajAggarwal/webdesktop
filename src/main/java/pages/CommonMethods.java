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
	
	public void searchHotels() {
		homePage.setLocation("Delhi");
		homePage.setCheckInDate("23");
		homePage.setCheckInDate("24");
		homePage.clickOnSearchButton();		
	}
	
	public void payAtHotel(){
		
	}
}
