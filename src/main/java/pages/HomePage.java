package pages;

import utils.Helper;

public class HomePage extends BasePage {

	Helper helper = new Helper();

	String filePathCommonOR = "./src/main/resources/objectRepo/CommonOR.json",
			MOBILE_NUM = helper.parseJSONToString("mobileNumber",filePathCommonOR), 
			PASSWORD = helper.parseJSONToString("password", filePathCommonOR), 
			myAccountCss = helper.parseJSONToString("myAccountCss", filePathCommonOR),
			logInId = helper.parseJSONToString("logInId", filePathCommonOR),
			mobileTextCss = helper.parseJSONToString("mobileTextCss",filePathCommonOR), 
			passwordTextCss = helper.parseJSONToString("passwordTextCss", filePathCommonOR),
			submitButtonClassName = helper.parseJSONToString("submitButtonClassName", filePathCommonOR),
			userNameId = helper.parseJSONToString("userNameId",filePathCommonOR);

	public void isValid() {
		// TODO Auto-generated method stub

	}

	public void clickOnMyAccounts() {
		helper.findElementByCss((myAccountCss)).click();
	}

	public void clickOnLoginButton() {
		helper.findElementById(logInId).click();
	}

	public void setMobileNumberForLogin() {
		helper.findElementByCss(mobileTextCss).sendKeys(MOBILE_NUM);
	}

	public void setPasswordForLogin() {
		helper.findElementByCss(passwordTextCss).sendKeys(PASSWORD);
		helper.waitForElement(helper.locateByClassId(submitButtonClassName), 5);
	}

	public void clickOnLoginSubmitButton() {
		helper.findElementByClassName(submitButtonClassName).click();
		helper.waitForElement(helper.locateById(userNameId), 5);
	}

	public String getLoggedInUserName() {
		String userName = helper.findElementById(userNameId).getText().toString();
		return userName;
	}
	
	public void setLocation() {
		
	}
	
	public void setCheckInDate() {
		
	}
	
	public void setCheckOutDate() {
		
	}
	
	public void setGuestCount(){
		
	}
	
	public void clickOnSearchSubmitButton(){
		
	}
	

}
