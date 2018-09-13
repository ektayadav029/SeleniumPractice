//********************************************************************************************
//*    Guru99 eCommerce Live Project    
//*    Author      : Ekta Yadav                    
//********************************************************************************************

/*
 * Test Scenario: 
 “Verify that all products are sorted by name”
 */

/* TestCase 1  

Step 1. Goto http://live.guru99.com/
Step 2. Verify Title of the page
Step 3. Click on ëMOBILEí menu
Step 4. Verify Title of the page
Step 5. In the list of all mobile , select SORT BY dropdown as name
Step 6. Verify all products are sorted by name
*/
package guru99;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class TestCase1 {
	
	static WebDriver driver;
 
  @BeforeClass
	  
  public static void preCondition() throws Exception {
   System.setProperty("webdriver.gecko.driver","/Users/EktaYadav/Documents/Softwares/Selenium/resources/geckodriver");
   driver = new FirefoxDriver();


  // System.setProperty("webdriver.chrome.driver","/Users/EktaYadav/Documents/Softwares/Selenium/resources/chromedriver");
  //driver = new ChromeDriver();
   
   // Step 1:Goto http://live.guru99.com/

 //  driver.get("http://live.guru99.com/");		
   driver.navigate().to("http://live.guru99.com/");
 // driver.get("http://www.google.com"); 
   
  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
   
  }
  
  @Test
  public void test() {
	  
	  //Step 2.Verify Title of the page
	  String homePageTittle =driver.findElement(By.xpath("//*[@id='top']/*//h2")).getText();
	  System.out.println( "printing homePageTittle :" + homePageTittle );  
	  assertEquals("THIS IS DEMO SITE FOR   ",homePageTittle );
	  
	 //Step 3. Click on ëMOBILEí menu
	  
	 driver.findElement(By.xpath("//li[@class='level0 nav-1 first']")).click();
	//  driver.findElement(By.linkText("mobile")).click();
	  
	//Step 4. Verify Title of the page

	  String mobilePageTittle= driver.findElement(By.xpath("//div[@class='page-title category-title']/h1")).getText();
	  System.out.println("printing mobilePageTittle :" + mobilePageTittle);
	  assertEquals("MOBILE", mobilePageTittle);
	  
	  
	//  Step 5. In the list of all mobile , select SORT By dropdown as name
	  
	  Select sortBySelect = new Select(driver.findElement(By.xpath("//select[@title='Sort By']")));
	  sortBySelect.selectByVisibleText("Name");
	  
	//  Step 6. Verify all products are sorted by name
	  
	  TakesScreenshot scrShot = ((TakesScreenshot)driver);
	  File srcFile=scrShot.getScreenshotAs(OutputType.FILE); 
	   String png = ("/Users/EktaYadav/Downloads/"+ "1" +".png");
	   try {
		FileUtils.copyFile(srcFile, new File(png));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  

	  
  }
  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }

}
