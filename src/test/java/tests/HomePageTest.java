package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest {

	WebDriver driver = new FirefoxDriver();

	@BeforeClass
	public void beforeClass() {
		driver.get("http://www.oyorooms.com");
	}

	@Test
	public void foo() {
		}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
