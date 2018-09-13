//********************************************************************************************
//*    Guru99 eCommerce Live Project    
//*    Participant : Ekta Yadav                     
//*                                                                                                                                                       *
//********************************************************************************************
/*
Test Scenario:Verify you are able to change or reorder previously added product
 *  Test Data = QTY = 10
Test Steps:
1. Go to http://live.guru99.com/
2. Click on my account link
3. Login in application using previously created credential
4. Click on 'REORDER' link , change QTY & click Update
5. Verify Grand Total is changed
6. Complete Billing & Shipping Information
7. Verify order is generated and note the order number

Expected outcomes:
1) Grand Total is Changed
2) Order number is generated
*/
 
 
 package guru99;
 

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TestCase8 {
	
	static WebDriver driver;
 
  @BeforeClass
  public void beforeClass() {
	  
		 System.setProperty("webdriver.gecko.driver","/Users/EktaYadav/Documents/Softwares/Selenium/resources/geckodriver");  
		 driver = new FirefoxDriver();	
		 
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
		 
  }
  
  @Test
  public void testCase8() {
	  //Step 1. Goto http://live.guru99.com/  
	   driver.get("http://live.guru99.com/");
    // 2. Click on my account link
	   
   // driver.findElement(By.linkText("My Account")).click();
 
	 driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[3]/div/div[4]/ul/li[1]/a")).click();  
	 
	// 3.login with registered credentials
		
			driver.findElement(By.id("email")).sendKeys("testuser1475@yahoo.com");
			driver.findElement(By.id("pass")).sendKeys("testing");
			driver.findElement(By.id("send2")).click();
			
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			 // switching to new window                                                                               
		    for (String handle : driver.getWindowHandles()) {
		    	driver.switchTo().window(handle);
		    	}		
			
   // 4. Click on 'My Orders'
	driver.findElement(By.xpath("//*[@id='my-orders-table']/tbody/tr/td[6]/span/a[2]")).click();
	
   
	String oldTotal = driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']//tfoot//span[@class='price']")).getText();
	System.out.println("Old Total Price =" + oldTotal );

	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		 // switching to new window                                                                               
	    for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}	
	    
	//driver.findElement(By.xpath("//input[@data-cart-item-id='MOB0002']")).clear();		
	//driver.findElement(By.xpath("//input[@data-cart-item-id='MOB0002']")).sendKeys("10");
	
	driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input[@class='input-text qty']")).clear();
	driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input[@class='input-text qty']")).sendKeys("10");

	driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/button")).click();
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 // switching to new window                                                                               
    for (String handle : driver.getWindowHandles()) {
    	driver.switchTo().window(handle);
    	}	
	
	String newTotal = driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']//tfoot//span[@class='price']")).getText();
	System.out.println("New Total Price =" + newTotal);

	if(oldTotal==newTotal)
	{
	 System.out.println("Price is not changed");
	}
	else
	{System.out.println("Price is changed");	
	}	
	
	//Click "Proceed to Checkout"
    
	driver.findElement(By.xpath("//ul[@class='checkout-types bottom']//button[@title='Proceed to Checkout']")).click();
	
	//Rest of them same as testcase 6 for billing /shipping address and order no.check 
	
  }
  
  @AfterClass
  public void afterClass() {
  }

}
