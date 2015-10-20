package com.javalan.sample;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Orbitz {
	
	private WebDriver driver;
	
	@Before 
	
	public void invoke(){
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
	 driver = new ChromeDriver();
		
		driver.get("http://www.orbitz.com/");
					driver.manage().window().maximize();
				
			//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			}
	
	@Test
	public void actions() throws Exception
	{
		
		driver.get("http://www.orbitz.com/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='products']/div/fieldset/div[2]/label[1]/span")).click();
	
		
		System.out.println("test");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='search']/div[1]/div/fieldset/label[2]/span")).click();
		System.out.println("test1");
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("ar.ow.leaveSlice.orig.key")).click();
		driver.findElement(By.name("ar.ow.leaveSlice.orig.key")).clear();
		driver.findElement(By.name("ar.ow.leaveSlice.orig.key")).sendKeys("NYC");
		
		Thread.sleep(1000);
		System.out.println("test2");
		driver.findElement(By.name("ar.ow.leaveSlice.dest.key")).click();
		driver.findElement(By.name("ar.ow.leaveSlice.dest.key")).clear();
		driver.findElement(By.name("ar.ow.leaveSlice.dest.key")).sendKeys("LAX");
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("ar.ow.leaveSlice.date")).click();
		driver.findElement(By.name("ar.ow.leaveSlice.date")).clear();
		driver.findElement(By.name("ar.ow.leaveSlice.date")).sendKeys("03/22/15");
		
		//Thread.sleep(5000);
		
		driver.findElement(By.name("search")).click();	
		Thread.sleep(5500);
		
		String src = driver.findElement(By.xpath("//*[@id='preMatrix']/div[4]/div[2]/span")).getText();
		System.out.println(src);
			
	}
	
	@After
	public void close(){
		driver.quit();
	}
	
	

}
