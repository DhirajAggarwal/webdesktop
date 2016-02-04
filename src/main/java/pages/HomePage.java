package pages;

import utils.Helper;

public class HomePage extends BasePage {

	Helper helper = new Helper();

	String filePathCommonOR = "./src/main/resources/objectRepo/CommonOR.json",
			MOBILE_NUM = helper.parseJSONToString("mobileNumber",
					filePathCommonOR), PASSWORD = helper.parseJSONToString(
					"password", filePathCommonOR), myAccountCssId = helper
					.parseJSONToString("myAccountCssId", filePathCommonOR),
			logInId = helper.parseJSONToString("logInId", filePathCommonOR),
			mobileTextCssId = helper.parseJSONToString("mobileTextCssId",
					filePathCommonOR), passwordTextCssId = helper
					.parseJSONToString("passwordTextCssId", filePathCommonOR),
			submitButtonClassId = helper.parseJSONToString(
					"submitButtonClassId", filePathCommonOR),
			userNameId = helper.parseJSONToString("userNameId",
					filePathCommonOR);

	public void isValid() {
		// TODO Auto-generated method stub

	}

	public void clickOnMyAccounts() {
		helper.findElementByCss((myAccountCssId)).click();
	}

	public void clickOnLoginButton() {
		helper.findElementById(logInId).click();
	}

	public void setMobileNumberForLogin() {
		helper.findElementByCss(mobileTextCssId).sendKeys(MOBILE_NUM);
	}

	public void setPasswordForLogin() {
		helper.findElementByCss(passwordTextCssId).sendKeys(PASSWORD);
		helper.waitForElement(helper.locateByClassId(submitButtonClassId), 5);
	}

	public void clickOnLoginSubmitButton() {
		helper.findElementByClassName(submitButtonClassId).click();
		helper.waitForElement(helper.locateById(userNameId), 5);

	}

	public String getLoggedInUserName() {
		String userName = helper.findElementById(userNameId).getText().toString();
		return userName;

	}

}
