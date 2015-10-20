package com.javalan.sample;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class PanCardStatus {

	public static void main(String[] args) {

//Setting up the Chrome Browser to invoke
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
// Invoking the Chrome Browser
		
		WebDriver driver=new ChromeDriver();

// Accessing the Site whichever needs to navigated
		
		driver.get("https://tin.tin.nsdl.com/pantan/StatusTrack.html");

// Verifying the Text on the landing page as "Track your PAN/TAN Application Status"
		
		WebElement headerText= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/center/font/b"));
		String textOnPanPage= headerText.getText();
		System.out.println("HeaderText : "+ textOnPanPage);
		
/*  WebElement e2=driver.findElement(By.xpath("//*[@id='main-container']/div[2]/form/table/tbody/tr/td/table/tbody/tr[2]/td[3]/select"));
   e2.click();
 driver.findElements(By.); */
        
// Selecting the Application Type by using the 'SelectByIndex' method. [Value as "PAN - New / Change Request"]
		
		Select appType = new Select(driver.findElement(By.name("ST_SEARCH_TYPE")));
        appType.selectByIndex(1);

 /*	Selecting the Application Type by using the 'SelectByIndex' method. [Value as "PAN - New / Change Request"]
        Select appType = new Select(driver.findElement(By.name("ST_SEARCH_TYPE")));
        appType.selectByValue("P");*/
	
//Entering the Acknowledge Number
//     WebElement ackNumber= driver.findElement(By.name("ST_ACK_NUM"));
//     ackNumber.sendKeys(new String[]{"064019700170451"});
    
     driver.findElement(By.name("ST_ACK_NUM")).sendKeys(new String[]{"064019700170451"});
     
 //Submitting the button   
     driver.findElement(By.name("submit")).click();
    
//Verifying the text on 'TRACK YOUR PAN APPLICATION STATUS' page 
     WebElement e3 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/table/tbody/tr/td/table/tbody/tr[5]/td[3]/font/i/p"));
     String Status=e3.getText();
     System.out.println("Status : " + Status);
    
	}

}
