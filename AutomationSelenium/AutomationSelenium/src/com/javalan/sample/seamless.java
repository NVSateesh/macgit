package com.javalan.sample;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class seamless {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.ie.driver","D:\\Drivers\\IE\\IEDriverServer_x64_2.30.2\\IEDriverServer.exe");
	  driver = new InternetExplorerDriver();
    baseUrl = "http://certification.seamless.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSeamless() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("memberLogin")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("#loginForm > #username"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("#loginForm > #username")).clear();
    driver.findElement(By.cssSelector("#loginForm > #username")).sendKeys("surya@monocept.com");
    driver.findElement(By.cssSelector("#loginForm > #password")).clear();
    driver.findElement(By.cssSelector("#loginForm > #password")).sendKeys("password");
    driver.findElement(By.cssSelector("h4.button.left > #submitLogin")).click();
    driver.findElement(By.cssSelector("span.select-button")).click();
    driver.findElement(By.cssSelector("li.enterAddressLink")).click();
    driver.findElement(By.name("singleAddressEntry")).clear();
    driver.findElement(By.name("singleAddressEntry")).sendKeys("232 madison ave");
    driver.findElement(By.id("FindFood")).click();
    driver.findElement(By.linkText("Diner 49")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("VendorName"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertEquals("Diner 49", driver.findElement(By.id("VendorName")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
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
