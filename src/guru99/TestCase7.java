/********************************************************************************************
//*    Guru99 eCommerce Live Project    
//*    Participant : Ekta Yadav                     
//*                                                                                                                                                       *
//********************************************************************************************
/*
Test Scenario: 
 Verify that you will be able to save previously placed order as a pdf file.  
Test Steps:
1.Go to http://live.guru99.com/
2.Click on My Account link
3.Login in application using previously created credential 
4.Click on 'My Orders'
5.Click on 'View Order'
6.Verify the previously created order is displayed in 'RECENT ORDERS' table and status is Pending
7.Click on 'Print Order' link
8.Click 'Change...' link and a popup will be opened as 'Select a destination' , select 'Save as PDF' link.
9.Click on 'Save' button and save the file in some location.
10.Verify Order is saved as PDF
*/

package guru99;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TestCase7 {
	 static WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() {
		
		 System.setProperty("webdriver.gecko.driver","/Users/EktaYadav/Documents/Softwares/Selenium/resources/geckodriver");  
		 driver = new FirefoxDriver();	
		 
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
		 
	  }  	
	
  @Test
  public void testCase7() {
	
	 //Step 1. Goto http://live.guru99.com/  
	   driver.get("http://live.guru99.com/");
     // 2. Click on my account link
	   
    // driver.findElement(By.linkText("My Account")).click();
  
	   driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[3]/div/div[4]/ul/li[1]/a")).click();
	 
	// 3.login with registered credentials
	
		driver.findElement(By.id("email")).sendKeys("testuser1475@yahoo.com");
		driver.findElement(By.id("pass")).sendKeys("testing");
		driver.findElement(By.id("send2")).click();
	  
    // 4. Click on 'View Order'
	driver.findElement(By.xpath("//*[@id='my-orders-table']/tbody/tr/td[6]/span/a[1]")).click();
	
	// 5. Click on Print Order	
	driver.findElement(By.xpath("//a[@class='link-print']")).click();
	

	
	 String windowHandles = driver.getWindowHandles().toString(); 
	 
	 for (int i=0;i<windowHandles.length();i++)
	 {
		 System.out.println("values:" +i+" data value:" + windowHandles);
	 }
		
		driver.switchTo().window("2147483656");
		
		driver.findElement(By.name("Cancel")).click();
	
  }
 
  

  @AfterClass
  public void afterClass() {
  }

}
