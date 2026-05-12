package com.example.NosFormations;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class IA {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testIA() throws Exception {
    driver.get("https://www.expertunisie.com/formation-a4q-automatisation-selenium/");
    driver.findElement(By.xpath("//li[@id='menu-item-142']/a/span")).click();
    driver.get("https://www.expertunisie.com/");
    driver.findElement(By.xpath("//li[@id='menu-item-212']/a/span")).click();
    driver.findElement(By.xpath("//li[@id='menu-item-12716']/a/span")).click();
    driver.findElement(By.xpath("//div[@id='Subheader']/div/div/h1")).click();
    try {
      assertEquals("Intelligence Artificielle", driver.findElement(By.xpath("//div[@id='Subheader']/div/div/h1")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//div[@id='Content']/div/div/div/div/div/div/div/div/div/div/h4")).click();
    try {
      assertEquals("Fondamentaux", driver.findElement(By.xpath("//div[@id='Content']/div/div/div/div/div/div/div/div/div/div/h4")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//div[@id='Content']/div/div/div/div/div/div/div/div[2]/div/div/h4")).click();
    try {
      assertEquals("Gouvernance & IA Responsable", driver.findElement(By.xpath("//div[@id='Content']/div/div/div/div/div/div/div/div[2]/div/div/h4")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//div[@id='Content']/div/div/div/div/div/div/div/div[3]/div/div/h4")).click();
    try {
      assertEquals("Ingénierie IA & MLOps", driver.findElement(By.xpath("//div[@id='Content']/div/div/div/div/div/div/div/div[3]/div/div/h4")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//div[@id='Content']/div/div/div/div/div/div/div/div[4]/div/div/h4")).click();
    try {
      assertEquals("IA appliquée aux métiers", driver.findElement(By.xpath("//div[@id='Content']/div/div/div/div/div/div/div/div[4]/div/div/h4")).getText());
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
