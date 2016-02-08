package utils;

import static utils.BrowserFactory.driver;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

	Object obj = null;

	private static String filePathConfig = "./src/main/resources/config/config.json";
	String URL;

	public void openURL(boolean visit, String URL) {
		if (visit == true) {
			driver.get(URL);
		}
	}

	public void openURL() {
		URL = parseJSONToString("oyoRoomsURL", filePathConfig);
			driver.get(URL);	
	}

	public String parseJSONToString(String keyVal, String filePath) {
		JSONParser parser = new JSONParser();
		try {
			obj = parser.parse(new FileReader(filePath));
		} catch (IOException | ParseException e) {
			e.getMessage();
		}
		JSONObject jsonObj = (JSONObject) obj;
		return (String) jsonObj.get(keyVal);
	}

	public void waitForElement(By locator, int timeOut,String message) {
		try{
		WebDriverWait wait = null;
		wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		catch(Exception e)
		{
			System.out.println(message);
		}
	}

	public By locateById(String element) {
		return By.id(element);
	}

	public By locateByClassName(String element) {
		return By.className(element);
	}

	public By locateByCssSelector(String element) {
		return By.cssSelector(element);
	}

	public By locateByLinkText(String element) {
		return By.linkText(element);
	}

	public By locateByName(String element) {
		return By.name(element);
	}

	public By locateByPartialLinkText(String element) {
		return By.partialLinkText(element);
	}

	public By locateByXpath(String element) {
		return By.xpath(element);
	}

	public WebElement findElementById(String element) {
		return driver.findElement(By.id(element));
	}

	public WebElement findElementByClassName(String element) {
		waitForElement(locateByClassName(element), 10, element.toString() + " not found");
		return driver.findElement(By.className(element));
	}

	public WebElement findElementByTagName(String element) {
		return driver.findElement(By.tagName(element));
	}

	public WebElement findElementByXpath(String element) {
		return driver.findElement(By.xpath(element));
	}

	public WebElement findElementByCss(String element) {
		return driver.findElement(By.cssSelector(element));
	}

	public WebElement findElementByLinkText(String element) {
		return driver.findElement(By.linkText(element));
	}

	public WebElement findElementByPartialLinkText(String element) {
		return driver.findElement(By.partialLinkText(element));
	}

	public List<WebElement> findElementsByClassName(String element) {
		List<WebElement> elements = driver.findElements(By.className(element));
		return elements;
	}
}
