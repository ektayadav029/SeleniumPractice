package testNGPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testNGAnnotations {
	
	static WebDriver driver;
	
	@BeforeClass
	public static void preCondition() throws Exception {
		System.setProperty("webdriver.gecko.driver",
				"/Users/EktaYadav/Documents/Softwares/Selenium/resources/geckodriver");
		driver = new FirefoxDriver();
   driver.get("http://www.gmail.com");		

	}
	
	@AfterClass
	public static void postCondition() throws Exception {
	
	}
	
	@Test
	
	public void test()
	{
		
	}
	
	

}
