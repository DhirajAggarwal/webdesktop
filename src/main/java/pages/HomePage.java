package pages;

import utils.Helper;

public class HomePage extends BasePage {

	Helper helper = new Helper();

	String filePathCommonOR = "./src/main/resources/objectRepo/CommonOR.json",
			MOBILE_NUM = helper.parseJSONToString("mobileNumber",filePathCommonOR), 
			PASSWORD = helper.parseJSONToString("password", filePathCommonOR), 
			myAccountCss = helper.parseJSONToString("myAccountCssId", filePathCommonOR),
			logInId = helper.parseJSONToString("logInId", filePathCommonOR),
			mobileTextCss = helper.parseJSONToString("mobileTextCssId",filePathCommonOR), 
			passwordTextCss = helper.parseJSONToString("passwordTextCssId", filePathCommonOR),
			submitButtonClassName = helper.parseJSONToString("submitButtonClassId", filePathCommonOR),
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

}
