package com.javalan.sample;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class METC1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver","D:\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();    
    baseUrl = "http://mobengage.azurewebsites.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMETC1() throws Exception {
    driver.get(baseUrl + "/");
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("MerchantEmail"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("MerchantEmail")).clear();
    driver.findElement(By.id("MerchantEmail")).sendKeys("holi@gmail.com");
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("password");
    driver.findElement(By.id("btn_Login")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Check-In".equals(driver.findElement(By.cssSelector("h3.page-header.text-asbestos")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("PhoneNumber")).clear();
    driver.findElement(By.id("PhoneNumber")).sendKeys("8341990417");
    driver.findElement(By.id("buttonCheckin")).click();
    try {
      assertEquals("Sateesh is checked-in successfully", driver.findElement(By.cssSelector("div.toast-message")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Sateesh".equals(driver.findElement(By.xpath("//table[@id='tableBackGround']/tbody/tr/td[2]")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertEquals("Sateesh", driver.findElement(By.xpath("//table[@id='tableBackGround']/tbody/tr/td[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    String CustomerName = driver.findElement(By.xpath("//table[@id='tableBackGround']/tbody/tr/td[2]")).getText();
    System.out.println("CustomerName is :'" + CustomerName + "'");
    try {
      assertEquals("8341990417", driver.findElement(By.xpath("//table[@id='tableBackGround']/tbody/tr/td[3]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//input[@name='selectCustomerList']")).click();
    new Select(driver.findElement(By.id("feedbackName"))).selectByVisibleText("FB_19_Points");
    driver.findElement(By.cssSelector("option[value=\"10388\"]")).click();
    driver.findElement(By.id("checkoutbtn")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Customer(s) checked out successfully".equals(driver.findElement(By.cssSelector("div.toast-message")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    String tst = driver.findElement(By.cssSelector("div.toast-message")).getText();
    		System.out.println(tst);
    try {
      assertEquals("Customer(s) checked out successfully", driver.findElement(By.cssSelector("div.toast-message")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Logout", driver.findElement(By.id("link_Logout")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("link_Logout")).click();
    String ForgotPassword = driver.findElement(By.id("signup_Link")).getText();
    System.out.println("Forgot Password Link is :'" + ForgotPassword + "'");
    String FP = "FP Variable Value has '" + ForgotPassword + "'";
    System.out.println("'" + FP + "'");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}





