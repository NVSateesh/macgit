package Training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DinerKonnect {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
//Invoking Browser of Chrome
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
//Accessing Azure web site fo DinerKonnect
		driver.get("http://mobengage.azurewebsites.net/");
		
		
		// Image verification (Pending)
		
/*	WebElement image=driver.findElement(By.xpath("/html/body/div[2]/nav/div/a/img"));
		String img=image.getText();
		String img=image.
		System.out.println("Image text :" +img);  */
		
		
	
//Verifying the SigIN text on Login page of DinerKonnect
		WebElement signin = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div[1]"));
		String vText= signin.getText();
		System.out.println("Signin Text is displayed :" + vText);
//Logging in with valid credentials in "DinerKonnect-LogIn" page
		
		//Entering Email Address
		WebElement tagname = driver.findElement(By.tagName("MerchantEmail"));
		System.out.println(tagname);
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
		 Thread.sleep(1000);
		
//		WebElement chkin = driver.findElement(By.xpath("//input[@id='warning']"));
	 
//		 Alert al = driver.switchTo().alert();
//		 System.out.println("CheckIn user's Name :" + al.getText());
//		 String chkinmsg = chkin.getText();
//		 System.out.println("CheckIn user's Name : " + chkinmsg );
		 
		// boolean b = driver.getPageSource().contains("Sati is checked-in successfully");
		 
		 //assertTrue(b);

		 
	    //Checking Out the PhoneNumber of a Customer
		 
		 WebElement mnum = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[4]/div/form/div/div[1]/table/tbody/tr[2]/td[3]")); 
	     String PhnNum  = mnum.getText();
		 System.out.println("PhoneNumber : "+ PhnNum);
		 
		 
		 driver.findElement(By.xpath("/html/body/div[2]/div/div/div[4]/div/form/div/div[1]/table/tbody/tr[2]/td[1]/input")).click();
		 
		 new Select(driver.findElement(By.id("feedbackName"))).selectByValue("10417");
		 
		 //WebElement FB = driver.findElement(By.id("feedbackName")).click();
		
		 
		 driver.findElement(By.id("checkoutbtn")).click(); 
		 
		 Thread.sleep(10000);
		 WebElement checkout = driver.findElement(By.id("success"));
		 String chkoutmsg = checkout.getText();
		 System.out.println("CheckOut user's Name : " + chkoutmsg );
		 

	/* // Find the checkbox or radio button element by Name
		 
		 List oCheckBox = driver.findElements(By.xpath("/html/body/div[2]/div/div/div[4]/div/form/div/div[1]/table"));
		  
		 // This will tell you the number of checkboxes are present
		  
		 int iSize = oCheckBox.size();
		 System.out.println(iSize);
		  
		 // Start the loop from first checkbox to last checkbox
		  
		 for(int i=0; i < iSize ; i++ ){
		  
		 // Store the checkbox name to the string variable, using 'Value' attribute
		  
		String sValue = ((WebElement) oCheckBox.get(i)).getAttribute("value");
		  
		 // Select the checkbox it the value of the checkbox is same what you are looking for
		  
		if (sValue.equalsIgnoreCase("0b78031f-5793-417d-8ce6-1b67f815832f;Nv Sateesh;91;7207723141;F@gmail.com;873625649324163;1;1/23/2015 5:21:00 PM")){
		  
		 ((WebElement) oCheckBox.get(i)).click();
		  
		 // This will take the execution out of for loop
		  
		 break;
		  
		 }
		  
		 } */
		 
		 
		 
//		 driver.findElement(By.id("PhoneNumber")).sendKeys(new String[]{"7207723141"});		 
		
		//Clicking on LogOut Link on Konnect page
		lo.click();
		
		

	}

}




