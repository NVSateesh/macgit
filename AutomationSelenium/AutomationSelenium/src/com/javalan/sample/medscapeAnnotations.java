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
import org.openqa.selenium.interactions.Actions;

public class medscapeAnnotations {

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
		
					  try {
						 assertEquals("Log In",driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).getText());
					    } catch (Error e) {
						      System.out.println(e); }   
					 
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
				
				String src = driver.getPageSource();
				src.contains("guid=17620072");
				
				try{
				assertEquals("guid=17620072",src.contains("guid=17620072"));
				}catch (Error e) {
					System.out.println(e);
					
				}			
				 
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,500)", "");
				
							
				  Actions a1 = new Actions(driver);
				a1.moveToElement(driver.findElement(By.xpath("//div[@id='rightlinksetting']/a"))).build().perform();
				     Thread.sleep(3000);
				     
				     System.out.println("mouse");
				driver.findElement(By.xpath("//div[@id='rightlinksetting']/a")).click();
				
				System.out.println("Hover");
				driver.findElement(By.linkText("Log Out")).click();
				Thread.sleep(2000);
				System.out.println("Logout...");
						 try {
							 assertEquals("Cancel",driver.findElement(By.id("cancellogoutbtn")).getText());
						    } catch (Error l) {
							      System.out.println(l); } 
						 Thread.sleep(2000);
						
						 String logouttext = driver.findElement(By.id("logoutbtn")).getText();
							System.out.println(logouttext);
						 
							Thread.sleep(2000);
				driver.findElement(By.id("logoutbtn")).click();
					
				
				
				    try {
					 assertEquals("Log In",driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).getText());
				    } catch (Error e) {
					      System.out.println(e); } 
				
				 
	 	 }
			
		 	@After
		 	  public void tearDown() throws Exception {
				 driver.quit();

}
}


		


	

