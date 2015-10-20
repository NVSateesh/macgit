package com.javalan.sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DK {
	String str ="Sateesh";
	public WebDriver driver;
	
	
	 public void signin(){
		 
		 String str = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div[1]")).getText();
	 
	System.out.println("Signin Text is displayed :" + str);
	
/*WebElement signin = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div[1]"));
	String vText= signin.getText();
	System.out.println("Signin Text is displayed :" + vText);*/
	}
	
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
//Invoking Browser of Chrome
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		
//Accessing Azure web site fo DinerKonnect
		driver.get("http://mobengage.azurewebsites.net/");
		
//Verifying the SigIN text on Login page of DinerKonnect

		DK d = new DK();
		d.signin();
		
		
//Logging in with valid credentials in "DinerKonnect-LogIn" page
		
		//Entering Email Address
		driver.findElement(By.id("MerchantEmail")).sendKeys(new String[]{"holi@gmail.com"});
		
//Entering Password
	    driver.findElement(By.id("Password")).sendKeys(new String[]{"password"});
	    
//Clicking the LogIn button
        driver.findElement(By.id("btn_Login")).click();
        
//Verifying the CheckIn text on DinerKonnect Landing page
        WebElement chkIn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/h3"));
        String checkIn = chkIn.getText();
		System.out.println("CheckIn Text is verified on Konnect Page : " + checkIn);
		

//Verifying the LogOut text on DinerKonnect Landing page
		WebElement lo = driver.findElement(By.id("link_Logout"));
		 String logout =lo.getText();
		System.out.println("Logout Link is verified  on Konnect Page : " + logout);
		

//Verifying the check in and checkout functioanlity in Konnect Page
		
    //Checking In the PhoneNumber of a Customer
		 driver.findElement(By.id("PhoneNumber")).sendKeys(new String[]{"7207723141"});
		 
   //Clicking on CheckIn button
		 driver.findElement(By.id("buttonCheckin")).click();
		 
		 String sucstext = driver.findElement(By.cssSelector("div.toast-message")).getText();
 		System.out.println(sucstext);
		
				 
 		driver.findElement(By.id("PhoneNumber")).sendKeys(new String[]{"7207723141"});
		 
 	   //Clicking on CheckIn button
 			 driver.findElement(By.id("buttonCheckin")).click();
 			 
 			 String errortext = driver.findElement(By.cssSelector("div.toast-message")).getText();
 	 		System.out.println(errortext);
 	 		
	    //Checking Out the PhoneNumber of a Customer
		 
		 WebElement mnum = driver.findElement(By.xpath("//*[@id='tableBackGround']/tbody/tr/td[3]")); 
	     String PhnNum  = mnum.getText();
		 System.out.println("PhoneNumber : "+ PhnNum);
		 
		 
		 driver.findElement(By.xpath("//*[@id='tableBackGround']/tbody/tr/td[1]/input")).click();
		 
		 new Select(driver.findElement(By.id("feedbackName"))).selectByValue("10388");
		 
		 //WebElement FB = driver.findElement(By.id("feedbackName")).click();
		
		 
		 driver.findElement(By.id("checkoutbtn")).click();
		 
		 String chktext = driver.findElement(By.cssSelector("div.toast-message")).getText();
	 		System.out.println(chktext);
		 
		 Thread.sleep(1000);		 
		
		//Clicking on LogOut Link on Konnect page
			WebElement logoutlink = driver.findElement(By.id("link_Logout"));
			logoutlink.click();
			Thread.sleep(4000);
			
			System.out.println("LogOut event done");
	
/*			WebElement signin1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div[1]"));
			String vText1= signin1.getText();
			System.out.println("Signin Text is displayed :" + vText1);
*/
			d.signin();
			//System.out.println("Signin Text is displayed :" + vText);
			driver.close();
	}



}




