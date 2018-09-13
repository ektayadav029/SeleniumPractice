//********************************************************************************************
//*    Guru99 eCommerce Live Project    
//*    Participant :Ekta Yadav                    
//*                                                                                                                                                       *
//********************************************************************************************
/*  Verify Discount Coupon works correctly
 *
Test Case Description:
1. Go to http://live.guru99.com/
2. Go to Mobile and add IPHONE to cart
3. Enter Coupon Code
4. Verify the discount generated

TestData:  Coupon Code: GURU50
Expected result:
1) Price is discounted by 5%

*/


package guru99;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TestCase9 {
  static WebDriver driver;

	
	@BeforeClass
	  public void beforeClass() {
		  
		   System.setProperty("webdriver.gecko.driver",
					"/Users/EktaYadav/Documents/Softwares/Selenium/resources/geckodriver");
		   
		   driver = new FirefoxDriver();
		   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  }	
	
  @Test
  public void testCase9() {
  
	
	//Step 1. Goto http://live.guru99.com/  
	 driver.get("http://live.guru99.com/");
	   
	//Step 2. Click on MOBILE menu   
	 driver.findElement(By.xpath("//li[@class='level0 nav-1 first']")).click();
	   
	//Step 3. In the list of all mobile , click on ëADD TO CARTí for Sony Xperia mobile
  	 driver.findElement(By.xpath("*//li[@class='item last'][1]//button[@title='Add to Cart']")).click();
  	  
     String nonDiscountedPrice = driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']//tfoot//span[@class='price']")).getText();	    
 
     System.out.println("nonDiscountedPrice" + nonDiscountedPrice);
     
     
  	 driver.findElement(By.id("coupon_code")).sendKeys("GURU50"); 
  	 driver.findElement(By.xpath("//*[@id='discount-coupon-form']//button[@title='Apply']")).click();
     String discountedPrice = driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']//tfoot//span[@class='price']")).getText();	    

	 System.out.println("discountedPrice" + discountedPrice );
	 
	 // Price is not getting calculated properly based on coupon code - problem in the site  
  }


  @AfterClass
  public void afterClass() {
  }

}
