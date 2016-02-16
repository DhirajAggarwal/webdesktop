package pages;

import org.testng.Assert;

import utils.Helper;

public class OyosInKerela extends BasePage {
		
	Helper helper = new Helper();
	
	String filePathDealsPage = "./src/main/resources/objectRepo/DealsPage.json",
			discountClassName = helper.parseJSONToString("discountClassName", filePathDealsPage);
	public void isValid() {
		Assert.assertTrue(helper.findElementByClassName(discountClassName).isDisplayed());
	}
	public String getDealName() {
		
		String deal=helper.findElementByClassName(discountClassName).getText();
		return deal;
	}
	

}
