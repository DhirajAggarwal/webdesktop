package utils;

import org.openqa.selenium.WebDriver;

public class BaseUtils extends BrowserFactory {

	private static String filePathConfigOR = "./src/main/resources/config/config.json";;
	static Helper helper = new Helper();
	static String oyoRoomsURL = null;

	public static void launchBrowser(WebDriver driver, boolean visit) {
		oyoRoomsURL = helper.parseJSONToString("OyoRoomsURL", filePathConfigOR);

		if (visit == true) {

			driver.get(oyoRoomsURL);
		}
	}
}
