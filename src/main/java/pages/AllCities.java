package pages;

import org.testng.Assert;
import utils.Helper;

public class AllCities extends BasePage {
	
	
		Helper helper = new Helper();
		
		String filePathAllCitiesPage = "./src/main/resources/objectRepo/AllCities.json",
		headingClassName = helper.parseJSONToString("headingClassName", filePathAllCitiesPage);

		public void isValid() {
		
			Assert.assertEquals(getTheHeader().startsWith("We are now in ") && getTheHeader().endsWith(" cities across India"),true);
		}
		
		public String getTheHeader()
		{
			String header=helper.findElementByClassName(headingClassName).getText();
			return header;
		}

}
