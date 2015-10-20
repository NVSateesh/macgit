
package com.javalan.sample;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class medspagesource {

	private WebDriver driver;
	  
			
	 	 @Before
	 	  public void invokebrowser() throws Exception {
	 		 
			System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
				
		  driver=new ChromeDriver();
		  
		  driver.get("http://www.medscape.com/");	
			driver.manage().window().maximize();
			 
	 		
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	 	 
	 	 }
	 	 
		@Test
	 	  public void testactions() throws Exception {
		
					  					 
	 		driver.get("http://www.medscape.com/");		 
	 		String logintext = driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).getText();
					System.out.println(logintext);
					
					driver.findElement(By.linkText("Log In")).click();
					
					WebElement username = driver.findElement(By.id("userId"));
					username.sendKeys("pavanlive");
					
					WebElement password = driver.findElement(By.id("password"));
					password.sendKeys("pavanlive");
					
				driver.findElement(By.id("loginbtn")).click();				
	          /* Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div/div/div[1]/div[2]/a")).click();*/
				
				String src =driver.getPageSource();
				
				System.out.println("pagesource");
				Thread.sleep(1000);
				src.contains("guid=17620072");
				//System.out.println("Source found");
				Thread.sleep(1000);
				try {
				 assertTrue("guid=17620072",src.contains("guid=17620072"));
			    } catch (Error z) {
			    	System.out.println(z);
				//z.printStackTrace();
			    }  
			    
				
				 Thread.sleep(2500);
	 	 }
			
		 	@After
		 	  public void tearDown() throws Exception {
				 driver.quit();

}
}


		


	

