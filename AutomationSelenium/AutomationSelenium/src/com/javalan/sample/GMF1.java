//package com.javalan.sample;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.util.Iterator;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//import org.apache.commons.io.FileUtils;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
////import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
//
//public class GMF1{
//	
//	static WebDriver driver;
//
//	public static void main(String[] args) throws Exception{		
//		
//         // WebDriver driver = new FirefoxDriver();
//		//  IMPORTANT URL
//       //   https://www.linkedin.com/pulse/20140625063731-153509697-selenium-real-time-interview-questions
//		
//        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
//		//System.setProperty("webdriver.chrome.driver", "D:/Selenium/Files/chromedriver_win32/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		
//		driver.get("http://preview.getmefood.in/");
//		
//		driver.manage().window().maximize();
//		
//		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//		
//		Thread.sleep(1000);
//		
//		String actualResult = driver.findElement(By.xpath("//div[@class='header-top']/div/a/img")).getAttribute("src");
//		
//		System.out.println("Actual Result is here Logo src tag value: " +actualResult);
//				
//		String expResult = "http://preview.getmefood.in/Themes/DinerKonnect/Content/img/GMFlogo.png";
//		//try{
//		Assert.assertEquals(actualResult, expResult);
//		//} catch (Error e) { 
//			//VerificationException.
//			//}
//		driver.findElement(By.linkText("Log in")).click();
//	
//		Thread.sleep(1000);
//
//		System.out.println("On Login page text is : " + driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText());
//		
//		driver.findElement(By.id("Email")).sendKeys("sateesh@gmf.in");
//		
//		driver.findElement(By.id("Password")).sendKeys("123456");
//		
//        //  boolean buttonPresence = driver.findElement(By.xpath("//input[@value='Log In")).isDisplayed();
//          
//          boolean buttonSelected = driver.findElement(By.id("RememberMe")).isSelected();
//          
//          System.out.println(buttonSelected);
//          
//          //boolean searchIconEnabled = driver.findElement(By.xpath("//input[@value='Log In")).isEnabled();
//		
//		driver.findElement(By.xpath("//input[@value='Log In']")).click();
//		
//		Select city = new Select(driver.findElement(By.id("SearchCityId")));
//		
//		//city.selectByIndex(0);
//		
//		city.selectByVisibleText("Hyderabad");
//		
//			
//		// To Print all area values
//		/*WebElement allareas = driver.findElement(By.id("SearchLocalityId"));
//		List <WebElement> areavalue1 = allareas.findElements(By.tagName("option"));
//		int areavaluescount = areavalue1.size();
//		for(int i=0 ; i <areavaluescount; i++)
//		{
//			String area_values = areavalue1.get(i).getText();
//			System.out.println(area_values);
//		}*/
//			
//		// To select 1 area from the Locality drop down
//		
//		Select area = new Select(driver.findElement(By.id("SearchLocalityId")));
//		area.selectByVisibleText("Ameerpet"); //Ameerpet Banjara Hills 
//		
//		String areaValue = area.getFirstSelectedOption().getText();
//		
//		driver.findElement(By.id("btnfindrestaurants")).click();
//		
//		Thread.sleep(1000);
//		
//		System.out.println(" --------------------------- ");
//		
//	    int count = driver.findElements(By.xpath("//div[@class='item-box']//h2/a")).size();
//		
//		System.out.println("Total number of restaurants are displayed under the " + areaValue + " area is: " + count + " those are as below.");
//		
//		System.out.println(" --------------------------- ");
//		
//		List<WebElement> restaurantnames = driver.findElements(By.xpath("//div[@class='item-box']//h2/a")); //div[@class='item-box']//a  
//		
//		Iterator<WebElement> itr = restaurantnames.iterator();
//		while(itr.hasNext()) {
//		    System.out.println(itr.next().getText());
//		}
//		
//		 System.out.println("--------------------------- ");
//		 
//		 HSSFWorkbook workbook = new HSSFWorkbook();
//	     HSSFSheet sheet = workbook.createSheet("GMF_Output");
//	     //Create a new row in current sheet
//	     Row row = sheet.createRow(0);
//	     
//	     Cell cell = row.createCell(0);
//	     //Set value to new value
//	     cell.setCellValue("Restaurant Name in " + areaValue);
//	     
//	     cell = row.createCell(1);
//	     //Set value to new value
//	     
//	     cell.setCellValue("Restaurant Name in Menu page/Error Message");
//	    
//	     cell = row.createCell(2);
//	     //Set value to new value
//	     cell.setCellValue("Comments");
//		
//		// Successful verification of Restaurant in Menupage
//
//		for(int i=1;i<=count ; i++){
//		
//			Thread.sleep(1000);
//		
//		String rstname = driver.findElement(By.xpath("//div[@class='item-box']["+i+"]//a")).getText();
//
//		driver.findElement(By.xpath("//div[@class='item-box']["+i+"]//a")).click(); //div[@class='item-box']//h2/a -- //div[@class='item-box']//a
//		
//		Thread.sleep(1000);
//		
//		String source = driver.getPageSource();
//		
//		if (source.contains("No products available for this restaurant.")){ 
//			
//			//String pagenotfound = driver.findElement(By.xpath("//div[@class='page not-found-page']//h1")).getText();
//			
//			File error_screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//           FileUtils.copyFile(error_screenshot,new File("d:\\GMF_OP\\error_at restaurant menu page.png"));
//           
//			String noproudcts = driver.findElement(By.xpath("//div[@class='page-body']/div")).getText();
//			
//			//System.out.println("PagenotFound error in the Menu page is : "  + pagenotfound);
//			
//			 System.out.println("Error message on Menu page of " + rstname + " is " + " ' " +noproudcts + " ' ");
//			
//	     	 System.out.println(noproudcts +" message is displayed when hit Restaurant : " + rstname + " from " + areaValue + " area");
//			
//	     	 System.out.println("--------------------------- "); 
//	     	
//	     	 row = sheet.createRow(i);
//
//	         cell = row.createCell(0);
//	        
//	         cell.setCellValue(rstname); // cell.setCellValue(columns.get(cnum).getText());
//
//	         cell = row.createCell(1);
//	         
//	         cell.setCellValue(noproudcts +" message is displayed when hit Restaurant : " + rstname + " from " + areaValue + " area");
//	         
//	         FileOutputStream out = new FileOutputStream(new File("d:\\GMF_OP\\gmfoutput2.xls"));
//	         workbook.write(out);
//	         workbook.close();  
//	        
//           } else {
//
//        	   Thread.sleep(1000);
//      		String rstrnt_menupage = driver.findElement(By.xpath("//div[@class='page-body']//h2")).getText();
//            
//      		Thread.sleep(400);
//      		
//      		System.out.println("Restaurant name in Menu page is : "  + rstrnt_menupage);
//      		  			 
//		     row = sheet.createRow(i);
//
//	         cell = row.createCell(0);
//	         
//	         cell.setCellValue(rstname); //"Restaurant name in Menu page is : "  + rstrnt_menupage)     
//      		
//      		Thread.sleep(800);
//		
//		    Assert.assertEquals(rstrnt_menupage, rstname);
//		
//		    System.out.println(rstrnt_menupage +" Restaurant is verified successfully on menu page");
//		    
//	         cell = row.createCell(1);
//
//	         cell.setCellValue(rstrnt_menupage + " Restaurant is verified successfully on menu page");
//	         
//
//	         FileOutputStream out = new FileOutputStream(new File("d:\\GMF_OP\\gmfoutput2.xls"));
//	         workbook.write(out);
//	         workbook.close();
//
//		    System.out.println("--------------------------- ");
//		}
//				
//		Thread.sleep(400);
//        
//		driver.navigate().back();
//		
//		}
//		
//		System.out.println("Verified all the restaurants in "+areaValue+" area. And exported the data to excel file, please refer to the same.");
//		
//		driver.close();
//	}
//
//
// }
