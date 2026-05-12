package com.example.NosFormations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogiciel {
  private WebDriver driver;
  private String baseUrl;
  private Actions action;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  
	  ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		 action = new Actions(driver);  
    baseUrl = "https://www.expertunisie.com/nos-formations/test-logiciels/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testLogiciel() throws Exception {

	  
	   driver.get(baseUrl);
	  verifyTitreFormation();

	 // istqbFoundationPage();
	 istqbgenerativeIAPage();
	  
	  istqbtesteurAgilePage();

  
  // add comment to check CI workflow
  }

private void istqbtesteurAgilePage() {
    
	
	action.moveToElement(driver.findElement(By.xpath("//span[@data-hover=\"ISTQB testeur agile\"]"))).click().perform();
    
    assertEquals("Évènements en mai 2026", driver.findElement(By.xpath("//*[@id=\"Subheader\"]/div/div/h1")).getText());

 System.out.println("test 1111");
 System.out.println("test 222");

 WebElement element1 = driver.findElement(By.xpath("//a[@href='https://www.expertunisie.com/index.php/demander-un-devis/']")
		); 
  element1.click();
  WebElement Particulier = driver.findElement(By.xpath("//*[@id=\"wpcf7-f260-p179-o1\"]/form/p[2]/span/span/span[2]/input"));
  Particulier.click();
  
  
  
  
  
  
  
  // COMMENTAIRE


  
  
  
  
  
}

private void istqbgenerativeIAPage() {
	{
		
		 
	    action.moveToElement(driver.findElement(By.xpath("//span[@data-hover=\"ISTQB générative IA\"]"))).click().perform();
	     
	    assertEquals("ISTQB Generative IA Testing", driver.findElement(By.xpath("//h1[@class='title']")).getText());
	  
	   
	   List<WebElement> elements=  driver.findElements(By.xpath("//div[contains(@class,'question')]"));
	  
	  //p[contains(text(),'issue de cette formation, les participants seront ')]
	   
	       elements.get(0).click();
	   
	      assertTrue(driver.findElement(By.xpath("//div[@class='question active']//p")).getText().contains("IA générative appliquée au test logiciel."));
	  
	     System.out.println(elements.get(0).getText());
	     
	     
	      assertEquals(" Objectifs",elements.get(0).findElement(By.cssSelector("div h2")).getText());
		  
	      elements.get(1).click(); 
	   
	   
	      assertTrue(driver.findElement(By.xpath("//div[@id='Content']/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/p")).getText().contains("➤ Connaissances de base en test logiciel."));
	     assertEquals(" Prérequis",elements.get(1).findElement(By.cssSelector("div h2")).getText());
			
	      elements.get(2).click();   
	    
	      assertEquals("Certification",elements.get(2).findElement(By.cssSelector("div h2")).getText());
	      elements.get(2).click();   

	      elements.get(3).click(); 
	     
	      assertEquals(" Programme",elements.get(3).findElement(By.cssSelector("div h2")).getText());
	      elements.get(3).click(); 

			
	      elements.get(4).click();    
	      assertEquals("FAQ",elements.get(4).findElement(By.cssSelector("div h2")).getText());
			
	   
 }	
}

private void verifyTitreFormation()
 {
	  List<WebElement> images = driver.findElements(By.xpath("//div[@class='image'][1]/following::h4[1]"));
	     action.moveToElement(images.get(0)).click().perform();
	     assertEquals("ISTQB Test Manuel", images.get(0).getText()); 
	     assertEquals("Automatisation Web et Mobile", images.get(1).getText());
	   action.moveToElement(images.get(1)).perform();
	     assertEquals("ISTQB Niveau Avancé", images.get(2).getText());
	  action.moveToElement(images.get(3)).perform();
	  assertEquals("Spécialités",images.get(3).getText());
	     assertEquals("Workshop pratique", images.get(4).getText());
 }
  private void istqbFoundationPage()
 {
	
	 
	    action.moveToElement(driver.findElement(By.xpath("//span[@data-hover='ISTQB niveau foundation']"))).click().perform();
	     
	    assertEquals("ISTQB Niveau Foundation", driver.findElement(By.xpath("//div[@id='Subheader']/div/div/h1")).getText());
	  
	   
	   List<WebElement> elements=  driver.findElements(By.xpath("//div[contains(@class,'question')]"));
	  
	  //p[contains(text(),'issue de cette formation, les participants seront ')]
	   
	       elements.get(0).click();
	   
	      assertTrue(driver.findElement(By.cssSelector("section[aria-labelledby='learning-objectives'] header p")).getText().contains("À l’issue de cette formation, les participants seront capable"));
	  
	     System.out.println(elements.get(0).getText());
	     
	     
	      assertEquals(" Objectifs",elements.get(0).findElement(By.cssSelector("div h2")).getText());
		  
	      elements.get(1).click(); 
	   
	   
	      assertTrue(driver.findElement(By.xpath("//div[@id='Content']/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/p")).getText().contains("➤Le principal prérequis est d’être impliqué"));
	     assertEquals(" Prérequis",elements.get(1).findElement(By.cssSelector("div h2")).getText());
			
	      elements.get(2).click();   
	      assertEquals("Exam Structure – ISTQB® Foundation Level", driver.findElement(By.id("exam-structure-istqb-title")).getText());
	      assertEquals("Certification",elements.get(2).findElement(By.cssSelector("div h2")).getText());
			
	  
	      elements.get(3).click(); 
	     
	      assertTrue(driver.findElement(By.id("programme-istqb-ctfl-title")).getText().contains("Formation ISTQB® Foundation Level"));
	      assertEquals(" Programme",elements.get(3).findElement(By.cssSelector("div h2")).getText());
			
	      elements.get(4).click();    
	      assertEquals("FAQ – Formation ISTQB® Foundation Level (CTFL)", driver.findElement(By.id("faq-istqb-ctfl-pertinent-title")).getText());
	      assertEquals("FAQ",elements.get(4).findElement(By.cssSelector("div h2")).getText());
			
	   
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
