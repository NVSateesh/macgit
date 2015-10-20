package com.javalan.sample;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class GMF_MyAccount {
	
	static WebDriver driver;

		public static void main(String[] args) throws Exception{		
			
	        //WebDriver driver = new FirefoxDriver();
			
	        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
			
		//  System.setProperty("webdriver.chrome.driver", "D:/Selenium/Files/chromedriver_win32/chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			driver.get("http://preview.getmefood.in/");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			Thread.sleep(1000);
			
			String actualResult = driver.findElement(By.xpath("//div[@class='header-top']/div/a/img")).getAttribute("src");
			
			System.out.println("Actual Result is here Logo src tag value: " +actualResult);
					
			String expResult = "http://preview.getmefood.in/Themes/DinerKonnect/Content/img/GMFlogo.png";
			
			Assert.assertEquals(actualResult, expResult);
			
			driver.findElement(By.linkText("Log in")).click();
		
			Thread.sleep(1000);

			System.out.println("On Login page text is : " + driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText());
			
			driver.findElement(By.id("Email")).sendKeys("sateesh@gmf.in");
			
			driver.findElement(By.id("Password")).sendKeys("123456");
			
			driver.findElement(By.xpath("//input[@value='Log In']")).click();
			
			driver.findElement(By.linkText("My account")).click();
		
    	/*  WebElement list1 = driver.findElement(By.xpath("//div[@class='listbox']/"));
		     
		    List<WebElement> rows=list1.findElements(By.tagName("ul"));
		     
		    for(int rnum=0;rnum<rows.size();rnum++)
		    {
           	 System.out.println("Number of rows:"+rows.size());
		     List<WebElement> columns=rows.get(rnum).findElements(By.tagName("li"));  
		     System.out.println("Number of columns:"+columns.size());
		                
		     for(int cnum=0;cnum<columns.size();cnum++)
		     {
		    	
	         System.out.println(columns.get(cnum).getText());
		  
		     }
		     
		     } */
		
			System.out.println("--------------------------");
			
			List <WebElement> listvalues =  driver.findElements(By.xpath("//div[@class='listbox']/ul/li"));
			
			System.out.println("The links available in My Account page: ");
			
			for(WebElement list : listvalues)
			{
				System.out.println(list.getText());
			}
			
			System.out.println("--------------------------");
			
			Thread.sleep(1000);
			
			driver.findElement(By.linkText("Customer info")).click();
			
			Thread.sleep(1000);

// Verifying the values in 'My account - Customer info' tab under My Account page
			
			String MyAccount_CI = driver.findElement(By.xpath("//div[@class='page-title']//h1")).getText();
			
			System.out.println("On " + MyAccount_CI + " Page");
			
			String firstname_text = driver.findElement(By.id("FirstName")).getAttribute("value");
			
			System.out.println("First Name is : "+firstname_text);

            String lastname_text = driver.findElement(By.id("LastName")).getAttribute("value");
			
			System.out.println("Last Name is : "+lastname_text);

            String Email = driver.findElement(By.id("Email")).getAttribute("value");
			
			System.out.println("Email Address is : "+Email);

            String Phone = driver.findElement(By.id("Phone")).getAttribute("value");
			
			System.out.println("Phone Number is : "+Phone);

			System.out.println("--------------------------");
			
//Verifying the values in 'My account -My Tickets' tab under My Account page

			driver.findElement(By.linkText("My tickets")).click();
			
			Thread.sleep(1000);
			
			String MyTickets = driver.findElement(By.xpath("//div[@class='page-title']//h1")).getText();
			
			System.out.println("On " + MyTickets + " Page");
	
			System.out.println("----------------------------");
			
//Verifying the values in 'My account - New ticket' tab under My Account page

			driver.findElement(By.linkText("New ticket")).click();
			
			Thread.sleep(1000);
			
			String New_ticket = driver.findElement(By.xpath("//div[@class='page-title']//h1")).getText();
			
			System.out.println("On " + New_ticket + " Page");
			
	/*      WebElement tickets = driver.findElement(By.xpath("//table[@id='tickettable']"));
		     
		    List<WebElement> rows=tickets.findElements(By.tagName("tr"));
		     
		    for(int rnum=0;rnum<rows.size();rnum++)
		    {

		     List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td")); //label  
		                
		     for(int cnum=0;cnum<columns.size();cnum++)
		     {
		    	 for( WebElement tdvalues : columns){
		    		System.out.println(tdvalues.findElement(By.xpath("./label")).getText());
	         
		    	 System.out.println(columns.get(cnum).getText());
		    	}
		     }
*/			

//Verifying the values in 'My account - Addresses' tab under My Account page

			System.out.println("----------------------------");
			
			driver.findElement(By.linkText("Addresses")).click();
			
			Thread.sleep(1000);
			
			String Address = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
			
			System.out.println("On " + Address + " Page");
			
	  String addnew_button =	driver.findElement(By.xpath("//div[@class='add-button']/input")).getAttribute("value");
		
	  System.out.println("Button name in Addresses page is: " + addnew_button);

//Verifying the values in 'My account - Orders' tab under My Account page

	  System.out.println("----------------------------");
		
		driver.findElement(By.linkText("Orders")).click();
		
		Thread.sleep(1000);
		
		String Orders = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
		
		System.out.println("On " + Orders + " Page");

//Verifying the values in 'My account - Change password' tab under My Account page
		
        System.out.println("----------------------------");
		
		driver.findElement(By.linkText("Change password")).click();
		
		Thread.sleep(1000);
		
		String Change_password = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
		
		System.out.println("On " + Change_password + " Page");
		
		System.out.println("----------------------------");
		
		String  logouttext = driver.findElement(By.linkText("Log out")).getText();
		
		System.out.println(logouttext + " link is displayed");
		
		driver.findElement(By.linkText("Log out")).click();
		
		System.out.println("Logged out and now on Home page of GMF site");
		
	}
  }