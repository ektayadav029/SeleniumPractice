//********************************************************************************************
//*    Guru99 eCommerce Live Project    
//*    Participant : Ekta Yadav                     
//*                                                                                                                                                       *
//********************************************************************************************
/*
 * Test Scenario: 
 “Verify that you cannot add more product in cart than the product available in store”
 */
/*      
Test Steps:
1. Goto http://live.guru99.com/
2. Click on ëMOBILEí menu
3. In the list of all mobile , click on ëADD TO CARTí for Sony Xperia mobile
4. Change ëQTYí value to 1000 and click ëUPDATEí button. Expected that an error is displayed 
   "The requested quantity for "Sony Xperia" is not available.
5. Verify the error message
6. Then click on ëEMPTY CARTí link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
7. Verify cart is empty
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

public class TestCase3 {
	
	static WebDriver driver;
 
  @BeforeClass
  public void preCondition() {
	  
	   System.setProperty("webdriver.gecko.driver",
				"/Users/EktaYadav/Documents/Softwares/Selenium/resources/geckodriver");
	   
	   driver = new FirefoxDriver();
	   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  }
  
  @Test
  public void testCase3() {
	  
	//Step 1. Goto http://live.guru99.com/  
	   driver.get("http://live.guru99.com/");
	   
	//Step 2. Click on MOBILE menu   
	   driver.findElement(By.xpath("//li[@class='level0 nav-1 first']")).click();
	   
	//Step 3. In the list of all mobile , click on ëADD TO CARTí for Sony Xperia mobile
   	  driver.findElement(By.xpath("*//li[@class='item last'][1]//button[@title='Add to Cart']")).click();
	  
	//  driver.findElement(By.xpath(".//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button")).click(); 
   //Step 4. Change QTY value to 1000 and click ëUPDATEí button. Expected that an error is displayed 
	//   "The requested quantity for "Sony Xperia" is not available.
	  driver.findElement(By.xpath("//tr[@class='first last odd']//input[@class='input-text qty']")).clear(); 
	  driver.findElement(By.xpath("//tr[@class='first last odd']//input[@class='input-text qty']")).sendKeys("1000");
	  
	 // driver.findElement(By.xpath("//tr[@class='first last odd']//button[@class='button btn-update']")).click();
	 driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/button")).click();
	 
   //Step 5. Verify the error message
	  
	if(driver.findElement(By.xpath("//p[@class='item-msg error']")).isDisplayed())
		
	{
	String errMessage=driver.findElement(By.xpath("//p[@class='item-msg error']")).getText();
	
	assertEquals(errMessage, "* The maximum quantity allowed for purchase is 500.");
	}
	else
	{
		System.out.println("No error");
		
	}
  //Step 6. Then click on ëEMPTY CARTí link in the footer of list of all mobiles. 
	//A message "SHOPPING CART IS EMPTY" is shown.
	
    driver.findElement(By.xpath("//*[@id='empty_cart_button']")).click();
    
  //Step  7. Verify cart is empty
       
    String cartEmptyMsg =driver.findElement(By.xpath("//div[@class='cart-empty']/p[1]")).getText();  
    try
    {
    assertEquals(cartEmptyMsg, "You have no items in your shopping cart.");
    }catch (Exception e) {
		e.printStackTrace();
	}
		
  }
  
  
  @AfterClass
  public void postCondition() {
	  
	  driver.quit();
  }

}
