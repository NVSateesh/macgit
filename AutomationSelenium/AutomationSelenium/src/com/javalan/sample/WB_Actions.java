package com.javalan.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class WB_Actions {
	
	public static void main(String[] args) {

		System.setProperty("webdriver.ie.driver","D:\\Drivers\\IE\\IEDriverServer_x64_2.30.2\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		driver.get("http://www.gmail.com");
		WebElement element=driver.findElement(By.xpath("//*[@id='link-signup']"));
		String x=element.getText();
		System.out.println(x);
		element.click();
		String x1=driver.getTitle();
		System.out.println(x1);
		


		/*WebDriver browser = new FirefoxDriver();
	
		browser.get("http://www.google.com");
		browser.manage().window().maximize();*/
}


}


	

