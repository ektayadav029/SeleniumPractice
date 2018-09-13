//********************************************************************************************
//*    Guru99 eCommerce Live Project    
//*    Author      : Ekta Yadav                    
//********************************************************************************************

/*
 * Test Scenario: 
“Verify that cost of product in list page and details page are equal”.  */
/*      
TestCase 2:
1. Goto http://live.guru99.com/
2. Click on MOBILE menu
3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
4. Click on Sony Xperia mobile
5. Read the Sony Xperia mobile from detail page. Product value in list and details page should be equal ($100). 
*/

package guru99;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TestCase2 {
	static WebDriver driver;

  @BeforeClass
  public void preCondition() {
	  
	   System.setProperty("webdriver.gecko.driver",
				"/Users/EktaYadav/Documents/Softwares/Selenium/resources/geckodriver");
	   
	   driver = new FirefoxDriver();
	   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	   
	  
  }
  
  @Test
  public void testCase2() {
	//Step 1. Goto http://live.guru99.com/  
	   driver.get("http://live.guru99.com/");
	   
	//Step 2. Click on MOBILE menu   
		 driver.findElement(By.xpath("//li[@class='level0 nav-1 first']")).click();

	//Step 3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
	
		 String mobileActualPrice = driver.findElement(By.xpath("//*[@id='product-price-1']/span[@class='price']")).getText();	 
		 String expectedPrice ="$100.00";
	     assertEquals(expectedPrice, mobileActualPrice);	 
	     
   //Step 4. Click on Sony Xperia mobile

	   driver.findElement(By.xpath("//a[@title='Sony Xperia']")).click();
	   
  //Step 5. Read the Sony Xperia mobile from detail page. 
	   //Product value in list and details page should be equal ($100). 
	   
	   String mobilPriceOnDetailScreen = driver.findElement(By.xpath("//*[@id='product-price-1']/span[@class='price']")).getText();
	   
	     assertEquals(mobileActualPrice,mobilPriceOnDetailScreen);	 

		 
  }
  @AfterClass
  public void postCondition() {
	  
	  driver.close();
  }

}
