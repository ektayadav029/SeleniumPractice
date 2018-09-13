//********************************************************************************************
//*    Guru99 eCommerce Live Project    
//*    Participant : Ekta Yadav                     
//*                                                                                                                                                       *
//********************************************************************************************
/*
Test Scenario: 
“Verify you can create account in E-commerce site and can share wishlist to other people using email” 
*/
/*      
Test Steps:
1. Go to http://live.guru99.com/
2. Click on my account link
3. Click Create an Account link and fill New User information except Email ID
4. Click Register
5. Verify Registration is done. Expected account registration done.
6. Go to TV menu
7. Add product in your wish list - use product - LG LCD
8. Click SHARE WISHLIST 
9. In next page enter Email and a message and click SHARE WISHLIST
10.Check wishlist is shared. Expected wishlist shared successfully. 

*/
package guru99;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TestCase5 {
	static WebDriver driver;
	
  @BeforeClass
  public void beforeClass() {
	 System.setProperty("webdriver.gecko.driver","/Users/EktaYadav/Documents/Softwares/Selenium/resources/geckodriver");
	   
	 driver = new FirefoxDriver();
	   
//	System.setProperty("webdriver.chrome.driver","/Users/EktaYadav/Documents/Softwares/Selenium/resources/chromedriver");
	//driver=new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  
  }

  @Test
  public void test() {
	  
 //Step 1. Goto http://live.guru99.com/  
	   driver.get("http://live.guru99.com/");
 //   2. Click on my account link
	   
 // driver.findElement(By.linkText("My Account")).click();
    
	driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[3]/div/div[4]/ul/li[1]/a")).click();
			   
//	driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
	
	String firstName="Meow";
	String lastName="Yadav";
/*
 * 3. Click Create an Account link and fill New User information except Email ID
   4. Click Register 
register as new user
	driver.findElement(By.id("firstname")).sendKeys("Meow");
	driver.findElement(By.id("lastname")).sendKeys("Yadav");
	driver.findElement(By.id("email_address")).sendKeys("testuser1475@yahoo.com");
	driver.findElement(By.id("password")).sendKeys("testing");
	driver.findElement(By.id("confirmation")).sendKeys("testing");

	driver.findElement(By.xpath("//button[@title='Register']")).click();
	
	*/
	
// login with registered credentials
	
	driver.findElement(By.id("email")).sendKeys("testuser1475@yahoo.com");
	driver.findElement(By.id("pass")).sendKeys("testing");
	driver.findElement(By.id("send2")).click();
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
    // 5. Verify Registration is done. Expected account registration done.

	String actWelcomeTxt =driver.findElement(By.xpath("//p[@class='welcome-msg']")).getText();	
	String expWelcomeTxt ="WELCOME, "+ firstName.toUpperCase() +" " +lastName.toUpperCase()+ "!";
	
	assertEquals(actWelcomeTxt, expWelcomeTxt);
    
	// 6. Go to TV menu	    

	driver.findElement(By.xpath("//li[@class='level0 nav-2 last']")).click();

	// 7. Add product in your wish list - use product - LG LCD	    
	
	driver.findElement(By.xpath("//li[@class='item last'][1]//ul//a[@class='link-wishlist']")).click();
   
	// 8. Click SHARE WISHLIST 

	driver.findElement(By.name("save_and_share")).click();
	
    // 9. In next page enter Email and a message and click SHARE WISHLIST

	driver.findElement(By.id("email_address")).sendKeys("ektayadav029@gmail.com");
	driver.findElement(By.id("message")).sendKeys("sharing my wishlist");
    driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
   
    //Step 10.Check wishlist is shared. Expected wishlist shared successfully. 

    String actMessage =driver.findElement(By.xpath("//li[@class='success-msg']/ul/li/span")).getText();
    
    assertEquals("Your Wishlist has been shared.", actMessage);
    
    
  }

  @AfterClass
  public void afterClass() {
  }

}
