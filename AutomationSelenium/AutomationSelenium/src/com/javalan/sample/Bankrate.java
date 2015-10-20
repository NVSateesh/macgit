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
import org.openqa.selenium.support.ui.Select;

public class Bankrate {

	private WebDriver driver;
	  
			
	 	 @Before
	 	  public void invokebrowser() throws Exception {
	 		 
			System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
				
		  driver=new ChromeDriver();
		  
		  driver.get("http://www.bankrate.com/");	
			driver.manage().window().maximize();
			 
	 		
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	 	 
	 	 }
	 	 
		@Test
	 	  public void testactions() throws Exception {
			
			// driver.get("http://www.bankrate.com/");
			
			 Actions a1 = new Actions(driver);
				a1.moveToElement(driver.findElement(By.xpath("//*[@id='brwrap']/nav/ul/li[1]/a"))).build().perform();
				     Thread.sleep(3000);
				     
				     System.out.println("mouse");
				driver.findElement(By.xpath("//*[@id='brwrap']/nav/ul/li[1]/div/ul/li[8]/a")).click();
				
				System.out.println("Hover");
				
			
		}
		@Test
		public void selectDropdown() throws Exception{
			
			driver.get("http://www.bankrate.com/funnel/personal-loans/");
			/* Actions a1 = new Actions(driver);
				a1.moveToElement(driver.findElement(By.xpath("//*[@id='brwrap']/nav/ul/li[9]/a"))).build().perform();
				     Thread.sleep(3000);
				     
				     System.out.println("mouse");
				driver.findElement(By.xpath("//*[@id='brwrap']/nav/ul/li[9]/div/ul/li[6]/a")).click();
				
				System.out.println("Hover");*/
				
			
			Thread.sleep(1000);	
			Select SltBy = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div/form/div[1]/div/div[2]/div[1]/div/button")));
			SltBy.selectByIndex(0);
			
			Select Sltstate = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div/form/div[1]/div/div[2]/div[2]/div/button")));
			Sltstate.selectByIndex(0);
			
			driver.findElement(By.xpath("//div[2]/button")).click();
			Thread.sleep(1000);
		}
		
		@After
		public void quite()
		{
			driver.quit();
		}
}