package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Helper;

public class CommonMethods {

	WebDriver driver;
	Helper helper = new Helper();
	
	String	filePathCommonOR 	= "./src/main/resources/objectRepo/CommonOR.json",
			MOBILE_NUM 			= helper.parseJSONToString("mobileNumber", filePathCommonOR),
			PASSWORD 			= helper.parseJSONToString("password", filePathCommonOR),
			myAccountCssId 		= helper.parseJSONToString("myAccountCssId", filePathCommonOR),
			logInId 			= helper.parseJSONToString("logInId", filePathCommonOR),
			mobileTextCssId 	= helper.parseJSONToString("mobileTextCssId", filePathCommonOR),
			passwordTextCssId 	= helper.parseJSONToString("passwordTextCssId", filePathCommonOR),
			submitButtonClassId = helper.parseJSONToString("submitButtonClassId", filePathCommonOR),
			userNameId 			= helper.parseJSONToString("userNameId", filePathCommonOR);
		
	public String logInToOyoRooms(WebDriver driver) {
		driver.findElement(By.cssSelector(myAccountCssId)).click();

		helper.waitForElement(driver, helper.locateById(logInId), 0);
		driver.findElement(By.id(logInId)).click();

		helper.waitForElement(driver, helper.locateByCssSelector(mobileTextCssId), 0);
		driver.findElement(By.cssSelector(mobileTextCssId)).sendKeys(MOBILE_NUM);

		helper.waitForElement(driver, helper.locateByCssSelector(passwordTextCssId), 0);
		driver.findElement(By.cssSelector(passwordTextCssId)).sendKeys(PASSWORD);

		helper.waitForElement(driver, helper.locateByClassId(submitButtonClassId), 1000);
		driver.findElement(By.className(submitButtonClassId)).click();

		helper.waitForElement(driver, helper.locateById(userNameId), 1000);
		return driver.findElement(By.id(userNameId)).getText().toString();
	}

}
