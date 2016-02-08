package pages;

import org.testng.Assert;

import utils.Helper;

public class HotelPage extends BasePage{
	
	Helper helper = new Helper();
	String filePathCommonOR = "./src/main/resources/objectRepo/CommonOR.json",
			filePathHotelPageOR = "./src/main/resources/objectRepo/HotelPage.json",
			oyoLogoClassName = helper.parseJSONToString("oyoLogoClassName",filePathCommonOR),
			oyoTagLineClassName = helper.parseJSONToString("oyoTagLineClassName",filePathCommonOR),
			oyoAppDownloadLinkClassName = helper.parseJSONToString("oyoAppDownloadLinkClassName", filePathCommonOR),
			myAccountCss = helper.parseJSONToString("myAccountCss", filePathCommonOR),
			oyoHelpIconClassName = helper.parseJSONToString("oyoHelpIconClassName", filePathCommonOR),
			oyoReservationNumberClassName = helper.parseJSONToString("oyoReservationNumberClassName", filePathCommonOR),
			phoneIconClassName = helper.parseJSONToString("phoneIconClassName", filePathCommonOR),
			hotelGalleryClassName = helper.parseJSONToString("hotelGalleryClassName",filePathHotelPageOR),
			hotelBookingBlockId = helper.parseJSONToString("hotelBookingBlockId",filePathHotelPageOR),
			hotelLocalityDetailsClassName = helper.parseJSONToString("hotelLocalityDetailsClassName", filePathHotelPageOR),
			hotelAmenitiesSectionClassName = helper.parseJSONToString("hotelAmenitiesSectionClassName", filePathHotelPageOR),
			hotelHouseRulesSectionClassName = helper.parseJSONToString("hotelHouseRulesSectionClassName", filePathHotelPageOR),
			hotelDescriptionSectionClassName = helper.parseJSONToString("hotelDescriptionSectionClassName", filePathHotelPageOR),
			hotelNearByHotelsSectionClassName = helper.parseJSONToString("hotelNearByHotelsSectionClassName", filePathHotelPageOR),
			leftFooterClassName = helper.parseJSONToString("leftFooterClassName", filePathCommonOR),
			rightFooterClassName = helper.parseJSONToString("rightFooterClassName", filePathCommonOR);
	
	
	public void isValid() {
		Assert.assertTrue(helper.findElementByClassName(oyoLogoClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(oyoTagLineClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(oyoAppDownloadLinkClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByCss(myAccountCss).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(oyoHelpIconClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(oyoReservationNumberClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(phoneIconClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(hotelGalleryClassName).isDisplayed());
		Assert.assertTrue(helper.findElementById(hotelBookingBlockId).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(hotelLocalityDetailsClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(hotelAmenitiesSectionClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(hotelHouseRulesSectionClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(hotelDescriptionSectionClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(hotelNearByHotelsSectionClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(leftFooterClassName).isDisplayed());
		Assert.assertTrue(helper.findElementByClassName(rightFooterClassName).isDisplayed());
	}
}
