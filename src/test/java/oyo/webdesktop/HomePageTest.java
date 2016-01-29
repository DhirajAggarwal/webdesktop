package oyo.webdesktop;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class HomePageTest {
	
	WebDriver driver= new FirefoxDriver();
	JSONParser parser=new JSONParser();
  
  @BeforeClass
  public void beforeClass() {
	  driver.get("http://www.oyorooms.com");
  }
  
  @Test
  public void foo() throws ParseException, IOException{
	   Object obj= parser.parse(new FileReader("./src/config/default.json"));
	   JSONObject jsonObj=(JSONObject) obj;
	   System.out.println((String) jsonObj.get("BrowserType"));
  }

  @AfterClass
  public void afterClass() {
  }

}
