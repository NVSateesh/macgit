package com.javalan.sample;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

	public class GMF_PlaceOrder {
		
		static WebDriver driver;

		public static void main(String[] args) throws Exception{		
			
	        //WebDriver driver = new FirefoxDriver();
			
	        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
			
			//System.setProperty("webdriver.chrome.driver", "D:/Selenium/Files/chromedriver_win32/chromedriver.exe");
			
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
			
			Select city = new Select(driver.findElement(By.id("SearchCityId")));
			
			city.selectByVisibleText("Hyderabad");
			
			Select area = new Select(driver.findElement(By.id("SearchLocalityId")));
			
			area.selectByVisibleText("Ameerpet"); //Ameerpet Banjara Hills 
			
			String areaValue = area.getFirstSelectedOption().getText();
			
			driver.findElement(By.id("btnfindrestaurants")).click();
			
			Thread.sleep(1000);
			
			System.out.println(" --------------------------- ");
			
		    int count = driver.findElements(By.xpath("//div[@class='item-box']//h2/a")).size();
			
			System.out.println("Total number of restaurants are displayed under the " + areaValue + " area is: " + count + " those are as below.");
			
			System.out.println(" --------------------------- ");
			
			List<WebElement> restaurantnames = driver.findElements(By.xpath("//div[@class='item-box']//h2/a")); //div[@class='item-box']//a  
			
			Iterator<WebElement> itr = restaurantnames.iterator();
			while(itr.hasNext()) {
			    System.out.println(itr.next().getText());
			}
			
		 System.out.println("--------------------------- ");
		 
				String rstname = driver.findElement(By.xpath("//div[@class='item-box'][1]//a")).getText();

				System.out.println("Selected restaurant name from " + areaValue + " is: "  + rstname);
				
				driver.findElement(By.xpath("//div[@class='item-box'][1]//a")).click(); //div[@class='item-box']//h2/a -- //div[@class='item-box']//a
				
				Thread.sleep(1000);

		      	String rstrnt_menupage = driver.findElement(By.xpath("//div[@class='page-body']//h2")).getText();
		            
		     	Thread.sleep(400);
		      		
		   		System.out.println("Restaurant name in Menu page is : "  + rstrnt_menupage);
		   		
		  System.out.println("--------------------------- ");
		  
		  String source = driver.getPageSource();
		 
		  if ( source.contains("Your Food Cart is empty!"))
		     {		  
            	   String cart_empty = driver.findElement(By.xpath("//div[@class='order-summary-content']")).getText();
            	   System.out.println("Cart Status: "+cart_empty);   
            	   System.out.println(" Order fast :)");
            	   Thread.sleep(1000);
            	   
            	   driver.findElement(By.xpath("//tr[11]/td[4]/input")).click();
            	   
            	   Thread.sleep(1000);
            	   
            	   driver.findElement(By.xpath("//tr[5]/td[4]/input")).click();
            	   
            	   Thread.sleep(1000);
            	   
            	   driver.findElement(By.xpath("//table[@id='dataTables-example']/tbody/tr[4]/td[4]/input")).click();
               }
               else {
       
            	   String other_rst = driver.findElement(By.xpath("//div[@class='order-summary-content']/div")).getText();
            	   
            	   System.out.println("Food items were already selected from other restaurant is: "+ other_rst);
            	   
      /*  String amnt_menu = driver.findElement(By.xpath("//span[@class='product-price order-total']")).getText();
      
        System.out.println("Total order amount in menu page is: " + amnt_menu);*/
       
      }

			   Thread.sleep(6000);
               		  		
			   System.out.println("--------------------------- ");
				  
			   driver.findElement(By.id("checkout")).click();
               
               Thread.sleep(1000);
               
               String checkout = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
               
               System.out.println("Now on "+ checkout+" Page");
               
               Assert.assertEquals("Checkout", checkout);

               Select delvry_adrs = new Select(driver.findElement(By.id("shipping-address-select")));
		
               String selected_adrs = delvry_adrs.getFirstSelectedOption().getText();
               
         	   System.out.println("--------------------------- ");
     		  
               System.out.println("Selected address as: " + selected_adrs);
               
               if (selected_adrs.equalsIgnoreCase("New Address"))
               {   
               delvry_adrs.selectByIndex(0);
               }
        
               System.out.println("--------------------------- ");
     		  
               driver.findElement(By.id("shippingoption_0")).click();
               
               String delvry_method = driver.findElement(By.xpath("//div[@class='method-name']//label")).getText();
      
               System.out.println("Selected delivery method is: "+delvry_method);
               
               System.out.println("--------------------------- ");
               
               driver.findElement(By.id("paymentmethod_0")).click();
               
               String pymnt_method = driver.findElement(By.xpath("//div[@class='payment-details']//label")).getText();
               
               System.out.println("Selected payment method is: "+pymnt_method);
		
               Thread.sleep(1000);
               
               System.out.println("--------------------------- ");
               
               String rstname_chkout = driver.findElement(By.xpath("//div[@class='order-summary-content']//div")).getText();
              
               System.out.println("Total order amount is: " + driver.findElement(By.xpath("//span[@class='product-price order-total']")).getText());
               
               //Assert.assertEquals(amnt_menu,driver.findElement(By.xpath("//span[@class='product-price order-total']")).getText());
              
               System.out.println("--------------------------- ");
               
               System.out.println("Resturant Name in checkout page is : "  + rstname_chkout);
 
               driver.findElement(By.xpath("//input[@value='Confirm']")).click();
              
              Thread.sleep(1000);
              
              System.out.println("--------------------------- ");
              
              String thx_page = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
              
              System.out.println("Now on "+thx_page + " page");
              
              System.out.println("--------------------------- ");
              
              String success_msg = driver.findElement(By.xpath("//div[@class='title']/strong")).getText();
              
              System.out.println("Success message on thank you page is: " +success_msg);
              
              System.out.println("--------------------------- ");
              
              System.out.println("OTP text :" + driver.findElement(By.xpath("//div[@id='otpcodediv']/p")).getText());
              
              System.out.println("--------------------------- ");
              
              String orderno = driver.findElement(By.xpath("//ul[@class='details']/li")).getText();
              
              System.out.println("Order is processed and " + orderno);
              
              Thread.sleep(4000);
              
              System.out.println("--------------------------- ");
                            
          /*  driver.findElement(By.id("otpcode")).sendKeys("123456");
              
              driver.findElement(By.name("//div[@id='otpcodediv']/input[2]")).click(); */
             
 
              System.out.println("Link text is :"+ driver.findElement(By.xpath("//ul[@class='details']//li[2]/a")).getText());
                           
              driver.findElement(By.xpath("//ul[@class='details']//li[2]/a")).click();
              
              List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
              //switch to new tab
              driver.switchTo().window(browserTabs .get(1));
              
              String title1 = driver.getTitle();
              
              System.out.println("--------------------------- ");
              
              System.out.println("Title of the new tab is: " + title1);
              
              System.out.println("Header text on orderdetails page as: " +driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText());
              
              System.out.println("order number in orderdetails page: " + driver.findElement(By.xpath("//div[@class='order-number']/strong")).getText());
          
              driver.close();
              
              System.out.println("--------------------------- ");
              
              driver.switchTo().window(browserTabs.get(0));
              
              String title = driver.getTitle();
              
              System.out.println("Title of the actual tab: " +title);
              
              System.out.println("--------------------------- ");
              
    }
		
	 }