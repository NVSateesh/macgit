package com.javalan.sample;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class medscape {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		//Invoking Browser of Chrome
				WebDriver driver=new FirefoxDriver();
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
								

				driver.get("http://www.medscape.com/");
			
				
				 try {
					 assertEquals("Log In",driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).getText());
				    } catch (Error e) {
					      System.out.println(e); }
				 
				 String logintext = driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).getText();
				System.out.println(logintext);
				
				driver.findElement(By.linkText("Log In")).click();
				
				WebElement username = driver.findElement(By.id("userId"));
				username.sendKeys("pavanlive");
				
				WebElement password = driver.findElement(By.id("password"));
				password.sendKeys("pavanlive");
				
			driver.findElement(By.id("loginbtn")).click();
			
					
			driver.findElement(By.xpath("//div[@id='rightlinksetting']/a")).click();
					driver.findElement(By.linkText("Log Out")).click();
					
					 try {
						 assertEquals("Confirm Log Out",driver.findElement(By.id("logoutbtn")).getAttribute("value"));
					    } catch (Error e) {
						      System.out.println(e); }
					 
					 String logouttext = driver.findElement(By.id("logoutbtn")).getAttribute("value");
						System.out.println(logouttext);
					 
			driver.findElement(By.id("logoutbtn")).click();
				
			
			 try {
				 assertEquals("Log In",driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).getText());
			    } catch (Error e) {
				      System.out.println(e); }
			 
			 driver.close();
	}

	
}
