package pages;

public class CommonMethods {

	HomePage homePage = new HomePage();

	public void logInToOyoRooms() {
		homePage.clickOnMyAccounts();
		homePage.clickOnLoginButton();
		homePage.setMobileNumberForLogin();
		homePage.setPasswordForLogin();
		homePage.clickOnLoginSubmitButton();
	}
}
