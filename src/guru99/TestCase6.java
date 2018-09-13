//********************************************************************************************
//*    Guru99 eCommerce Live Project    
//*    Participant : Ekta Yadav                     
//*                                                                                                                                                       *
//********************************************************************************************
/*
Test Scenario: 
“Verify user is able to purchase product using registered email id"
Test Steps:
1. Go to http://live.guru99.com/
2. Click on my account link
3. Login in application using previously created credential
4. Click on MY WISHLIST link 
5. In next page, Click ADD TO CART link
6. Enter general shipping country, state/province and zip for the shipping cost estimate
7. Click Estimate 
8. Verify Shipping cost generated 
9. Select Shipping Cost, Update Total 
10. Verify shipping cost is added to total 
11. Click "Proceed to Checkout"
12a. Enter Billing Information, and click Continue
12b. Enter Shipping Information, and click Continue
13. In Shipping Method, Click Continue
14. In Payment Information select 'Check/Money Order' radio button. Click Continue
15. Click 'PLACE ORDER' button 
16. Verify Oder is generated. Note the order number

NOTE: PROCEED TO CHECKOUT (step 6 ) was taken out, so as to allow the Estimate button step to get processed. 
      Rest of the steps renumbered accordingly. 
*/

package guru99;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class TestCase6 {
  static WebDriver driver;
	
  @BeforeClass
  public void beforeClass() {
   System.setProperty("webdriver.gecko.driver","/Users/EktaYadav/Documents/Softwares/Selenium/resources/geckodriver");
	   
	 driver = new FirefoxDriver();
	   
 //   System.setProperty("webdriver.chrome.driver","/Users/EktaYadav/Documents/Softwares/Selenium/resources/chromedriver");
//	driver=new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  }
  
  @Test
  public void testCase6() {
 
 //Step 1. Goto http://live.guru99.com/  
	   driver.get("http://live.guru99.com/");
 //   2. Click on my account link
	   
 // driver.findElement(By.linkText("My Account")).click();
   
	driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[3]/div/div[4]/ul/li[1]/a")).click();
	 
	// 3.login with registered credentials
	
		driver.findElement(By.id("email")).sendKeys("testuser1475@yahoo.com");
		driver.findElement(By.id("pass")).sendKeys("testing");
		driver.findElement(By.id("send2")).click();
		
	
    // 4. Click on MY WISHLIST link 
		
	  //  driver.findElement(By.xpath("//div[@class='links']//a[contains(text(),'My Wishlist')]")).click();
	    driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a")).click();
	    

	 // 5. In next page, Click ADD TO CART link
    
	 //   driver.findElement(By.xpath("//*[@id='item_16851']//button[@title='Add to Cart']")).click();
	    driver.findElement(By.xpath("/*[@id='item_16851']/td[5]/div/button")).click();
	    
	    
    
	// 6. Enter general shipping country, state/province and zip for the shipping cost estimate
    

	    Select shipCountry = new Select(driver.findElement(By.id("country")));
	    shipCountry.selectByValue("IN");
	    
	    driver.findElement(By.xpath("//li[@class='shipping-region']/div")).sendKeys("pune");
	    driver.findElement(By.id("postcode")).sendKeys("411027");
	   
	 //7. Click Estimate 
  
	   driver.findElement(By.xpath("//*[@id='shipping-zip-form']//button[@title='Estimate']")).click();
	   
	 //8. Verify Shipping cost generated 
	   
	  driver.findElement(By.id("s_method_flatrate_flatrate")).click();
	   
	  String shippingPrice= driver.findElement(By.id("s_method_flatrate_flatrate")).getText();
	   
	  driver.findElement(By.xpath("//*[@for='s_method_flatrate_flatrate']/span[@class='price']")).getText();
	  
	//  9. Select Shipping Cost, Update Total 
  
	  driver.findElement(By.xpath("//*[@id='co-shipping-method-form']//button[@title='Update Total']")).click();
	  
	  
	  String subTotalPrice = driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tbody/tr[1]//span")).getText();
	
	//  10. Verify shipping cost is added to total 

      String actualTotalPrice = driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']//tfoot//span[@class='price']")).getText();	    
    
	  String expectedTotalPrice = subTotalPrice + shippingPrice;	    
	  assertEquals(actualTotalPrice, expectedTotalPrice); 
	   
	//11. Click "Proceed to Checkout"
     
	  driver.findElement(By.xpath("//ul[@class='checkout-types bottom']//button[@title='Proceed to Checkout']")).click();
	  
	//12a. Enter Billing Information, and click Continue
	  
	  driver.findElement(By.id("billing:firstname")).clear();
	  driver.findElement(By.id("billing:firstname")).sendKeys("");
	  
	  driver.findElement(By.id("billing:lastname")).clear();
	  driver.findElement(By.id("billing:lastname")).sendKeys("");
	  
	  driver.findElement(By.id("billing:street1")).clear();
	  driver.findElement(By.id("billing:street1")).sendKeys("");
	  
	  driver.findElement(By.id("billing:city")).clear();
	  driver.findElement(By.id("billing:city")).sendKeys("");
	  
	 // new Select(driver.findElement(By.id("billing:region_id"))).selectByValue("United States");
	  
	  Select billingState = new Select(driver.findElement(By.id("billing:region_id")));
	  billingState.selectByValue("Florida");
	  
	  driver.findElement(By.id("billing:postcode")).clear();
	  driver.findElement(By.id("billing:postcode")).sendKeys("411047");
	  
	  driver.findElement(By.id("billing:telephone")).click();
	  
	  //Selecting 'Ship to this address'for NO.By default yes is selected.
 	  
	  driver.findElement(By.xpath("//*[@for='billing:use_for_shipping_no']")).click();
	  
	  driver.findElement(By.xpath("//*[@id='billing-buttons-container']/button[@title='Continue']")).click();
	  
	  
	  //12b. Enter Shipping Information, and click Continue

	  driver.findElement(By.id("shipping:firstname")).clear();
	  driver.findElement(By.id("shipping:firstname")).sendKeys("");
	  
	  driver.findElement(By.id("shipping:lastname")).clear();
	  driver.findElement(By.id("shipping:lastname")).sendKeys("");
	  
	  driver.findElement(By.id("shipping:street1")).clear();
	  driver.findElement(By.id("shipping:street1")).sendKeys("");
	  
	  driver.findElement(By.id("shipping:city")).clear();
	  driver.findElement(By.id("shipping:city")).sendKeys("");	  
	  
	  driver.findElement(By.id("shipping:city")).clear();
	  driver.findElement(By.id("shipping:city")).sendKeys("");
	  
	  driver.findElement(By.id("shipping:region")).clear();
	  driver.findElement(By.id("shipping:region")).sendKeys("");
	  
	  driver.findElement(By.id("shipping:postcode")).clear();
	  driver.findElement(By.id("shipping:postcode")).sendKeys("");
	  
	  new Select(driver.findElement(By.id("shipping:country_id"))).selectByValue("IN");
	  
	  driver.findElement(By.id("shipping:telephone")).clear();
	  driver.findElement(By.id("shipping:telephone")).sendKeys("");
	  
	  driver.findElement(By.xpath("//*[@id='shipping-buttons-container']/button[@title='Continue']")).click();
	  
	    // 13. In Shipping Method, Click Continue   

	  driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']")).click();
	  
	  // 14. In Payment Information select 'Check/Money Order' radio button. Click Continue
 
	  driver.findElement(By.xpath("//*[@title='Check / Money order']")).click();
	  
	  driver.findElement(By.xpath("//button[@onclick='payment.save()']")).click();
	  
	    // 15. Click 'PLACE ORDER' button  
	  
	  driver.findElement(By.xpath("//*[@id='review-buttons-container']/button[@title='Place Order']")).click();
	  
	  //Order placed confirmation
	  
	 String orderConfirmation=  driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
	
	 System.out.println("Confirmation of order" +orderConfirmation);
	
	 String orderNo = driver.findElement(By.xpath(".//*[@id='top']/body/div/div/div[2]/div/div/p[1]/a")).getText();
     
	 System.out.println("*** Your order number for your record = " + orderNo);

	 
	   }
  
  
  
	   
  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}
