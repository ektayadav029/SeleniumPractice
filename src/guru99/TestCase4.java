//********************************************************************************************
//*    Guru99 eCommerce Live Project    
//*    Participant : Ekta Yadav                     
//*                                                                                                                                                       *
//********************************************************************************************
/**/
/*
Test Scenario: 
“Verify that you are able to compare two product”
*/

/*
Test Steps:
1. Goto http://live.guru99.com/
2. Click on ëMOBILEí menu
3. In mobile products list , click on ëAdd To Compareí for 2 mobiles (Sony Xperia & Iphone)
4. Click on ëCOMPAREí button. A popup window opens
5. Verify the pop-up window and check that the products are reflected in it
   Heading "COMPARE PRODUCTS" with selected products in it.
6. Close the Popup Windows
*/


package guru99;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class TestCase4 {
 
	static WebDriver driver;
	 
	  @BeforeClass
	  public void preCondition() {
		  
		   System.setProperty("webdriver.gecko.driver",
					"/Users/EktaYadav/Documents/Softwares/Selenium/resources/geckodriver");
		   
		   driver = new FirefoxDriver();
		   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  }

  @Test
  public void testCase4() {
		//Step 1. Goto http://live.guru99.com/  
	   driver.get("http://live.guru99.com/");
	   
	//Step 2. Click on MOBILE menu   
	   driver.findElement(By.xpath("//li[@class='level0 nav-1 first']")).click();
	   
	//Step 3.In mobile products list , click on ëAdd To Compareí for 2 mobiles (Sony Xperia & Iphone)
	   	  
	String productNameMain1= driver.findElement(By.xpath("//h2[@class='product-name']/a[@title='Sony Xperia']")).getText();
	System.out.println("productNameMain1: " +productNameMain1);

	 driver.findElement(By.xpath("//li[@class='item last'][1]//ul[@class='add-to-links']/li/a[@class='link-compare']")).click();

	 try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 String productNameMain2= driver.findElement(By.xpath("//h2[@class='product-name']/a[@title='IPhone']")).getText();
	 System.out.println("productNameMain2: " + productNameMain2);
	 driver.findElement(By.xpath("//li[@class='item last'][2]//ul[@class='add-to-links']/li/a[@class='link-compare']")).click();
 
//Step 4. Click on ëCOMPAREí button. A popup window opens
	
	 driver.findElement(By.xpath("//button[@title='Compare']")).click();
/*	 
     String data = driver.getWindowHandles().toString();

 for (int i=0;i<data.length();i++)
 {
	 System.out.println("values:" +i+" data value:" + data);
 }
	*/
	driver.switchTo().window("2147483655");
/*	 
	  for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
	    	
	    	*/
//Step 5. Verify the pop-up window and check that the products are reflected in it
//	   Heading "COMPARE PRODUCTS" with selected products in it.
	System.out.println("page title :" + driver.findElement(By.xpath("//div[@class='page-title title-buttons']/h1")).getText());
	
	String productNamePopUp1 =driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();
	System.out.println("productNamePopUp1: " +productNamePopUp1);
	
	String productNamePopUp2 =driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
	System.out.println("productNamePopUp2: " +productNamePopUp2);

	assertEquals(productNameMain1, productNamePopUp1);
	
	assertEquals(productNameMain2, productNamePopUp2);
	
// Step6. Close the Popup Window
	driver.findElement(By.xpath("//button[@title='Close Window']")).click();
	
    String data = driver.getWindowHandles().toString();

 for (int i=0;i<data.length();i++)
 {
	 System.out.println("values:" +i+" data value:" + data);
 }
  }
  
  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }

}
