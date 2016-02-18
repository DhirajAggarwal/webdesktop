package utils;

import static utils.BrowserFactory.driver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Helper {

	Object obj = null;

	String filePathScreenShot = "./src/main/resources/screenshots";
	private static String fileSeperator = System.getProperty("file.separator");
	private static String filePathConfig = "./src/main/resources/config/config.json";
	String URL, customURL;

	public void openURL(boolean visit, String URL) {
		if (visit == true) {
			driver.get(URL);
		}
	}

	public void openURL() {
		
		
		URL = parseJSONToString("oyoRoomsURL", filePathConfig);
		driver.get(URL);
	}
	
	public void openHotelPage(String hotelId, String hotelType, String hotelName){
		URL = parseJSONToString("oyoRoomsURL", filePathConfig);
		customURL = URL + hotelId + "-" + hotelType + "-" + hotelName;
		driver.get(customURL);
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
	public void hoverOnElement(WebElement ele){
		Actions action=new Actions(driver);
		action.moveToElement(ele).perform();
	}
	
	public void waitForElement(By locator, int timeOut, String message) {
		try {
			WebDriverWait wait = null;
			wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
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
	
	public List<WebElement> findElementsById(String element) {
		return driver.findElements(By.id(element));
	}

	public WebElement findElementByClassName(String element) {
		waitForElement(locateByClassName(element), 10, element.toString() + " not found");
		return driver.findElement(By.className(element));
	}

	public WebElement findElementByTagName(String element) {
		return driver.findElement(By.tagName(element));
	}
	public List<WebElement> findElementsByTagName(String element) {
		return driver.findElements(By.tagName(element));
	}

	public WebElement findElementByXpath(String element) {
		return driver.findElement(By.xpath(element));
	}

	public WebElement findElementByCss(String element) {
		return driver.findElement(By.cssSelector(element));
	}
	public List<WebElement> findElementsByCss(String element) {
		return driver.findElements(By.cssSelector(element));
	}

	public WebElement findElementByLinkText(String element) {
		return driver.findElement(By.linkText(element));
	}
	public List<WebElement> findElementsByLinkText(String element) {
		return driver.findElements(By.linkText(element));
	}

	public WebElement findElementByPartialLinkText(String element) {
		return driver.findElement(By.partialLinkText(element));
	}

	public List<WebElement> findElementsByClassName(String element) {
		return driver.findElements(By.className(element));
	}
	
	public boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } 
	    catch (NoSuchElementException e) {
	      return false;
	    }
	}
	
	public int getCurrentMonth() {
		Calendar cal = Calendar.getInstance();
		int monthInInteger = cal.get(Calendar.MONTH);
		int currentMonth = monthInInteger + 1;
		return currentMonth;
	}
	
	public void takeScreenShot(String methodName) {
		
		// getting current date and time into string Ex: Thu Feb 18 18:13:38 IST 2016
		Date currentDate = new Date();
		String currentDateAndTime = currentDate.toString();
		System.out.println("date and time in string format......"+currentDateAndTime);
		
		// splitting the date string Ex: "Thu Feb 18 18" out of "Thu Feb 18 18:13:38 IST 2016"
		String[] dateFolder = currentDateAndTime.split(":");
		
		System.out.println();
		String newFolderName = filePathScreenShot + fileSeperator + dateFolder[0] + fileSeperator;
		
		File targetFolder = new File(newFolderName);
		if (!targetFolder.exists()) {
			System.out.println("File created " + targetFolder);
			targetFolder.mkdir();
		}
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File targetFile = new File(newFolderName + methodName + ".png");
		
		// The below method will save the screen shot with test method name
		try {
			FileUtils.copyFile(scrFile, targetFile);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
