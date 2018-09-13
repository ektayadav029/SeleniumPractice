package concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DateTimePicker {
 
	static WebDriver driver;
	
	  @BeforeClass
	  
	  public static void preCondition() throws Exception {
	   System.setProperty("webdriver.gecko.driver","/Users/EktaYadav/Documents/Softwares/Selenium/resources/geckodriver");
	   driver = new FirefoxDriver();

	  // System.setProperty("webdriver.chrome.driver","/Users/EktaYadav/Documents/Softwares/Selenium/resources/chromedriver");
	  //driver = new ChromeDriver();
	   
	  driver.get("http://demos.telerik.com/kendo-ui/datetimepicker/index");		
	   
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  }
	
	@Test
  public void f() {
		
		driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_dateview']")).click();
  }
	
	
}
