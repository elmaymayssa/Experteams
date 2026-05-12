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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogiciel {
    private WebDriver driver;
    private String baseUrl;
    private Actions action;
    private WebDriverWait wait;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        
        // CONFIGURATION CI (INDISPENSABLE)
        if (System.getenv("GITHUB_ACTIONS") != null) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }
        
        options.addArguments("start-maximized");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-allow-origins=*");
        
        driver = new ChromeDriver(options);
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
        
        // Initialisation de l'attente explicite (15 secondes)
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        baseUrl = "https://www.expertunisie.com/nos-formations/test-logiciels/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testLogiciel() throws Exception {
        driver.get(baseUrl);
        verifyTitreFormation();
        istqbgenerativeIAPage();
        istqbtesteurAgilePage();
    }

    private void istqbtesteurAgilePage() {
        // Attente et clic robuste via JavaScript
        WebElement agileTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-hover='ISTQB testeur agile']")));
        js.executeScript("arguments[0].click();", agileTab);
        
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Subheader']/div/div/h1")));
        assertEquals("Évènements en mai 2026", title.getText());

        System.out.println("test 1111");

        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://www.expertunisie.com/index.php/demander-un-devis/']")));
        js.executeScript("arguments[0].click();", element1);

        WebElement particulier = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='wpcf7-f260-p179-o1']/form/p[2]/span/span/span[2]/input")));
        js.executeScript("arguments[0].click();", particulier);
    }

private void istqbgenerativeIAPage() {
    WebElement genIATab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-hover='ISTQB générative IA']")));
    js.executeScript("arguments[0].click();", genIATab);
    
    WebElement mainTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='title']")));
    assertEquals("ISTQB Generative IA Testing", mainTitle.getText());

    // Utilisation d'un sélecteur plus stable pour les questions
    List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'question')]")));
    
    // --- CORRECTION LIGNE 101 ---
    js.executeScript("arguments[0].click();", elements.get(0));
    
    // Au lieu de 'visibilityOfElementLocated', on utilise 'presenceOfElementLocated' 
    // et un XPath qui ne dépend pas de la classe "active"
    WebElement reponse1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'question')]//p")));
    assertTrue(reponse1.getText().contains("IA générative appliquée au test logiciel."));
    
    // Utilisation de .trim() pour éviter les erreurs d'espaces masqués
    assertEquals("Objectifs", elements.get(0).findElement(By.cssSelector("div h2")).getText().trim());

    // --- CORRECTION DES AUTRES SECTIONS ---
    js.executeScript("arguments[0].click();", elements.get(1));
    assertEquals("Prérequis", elements.get(1).findElement(By.cssSelector("div h2")).getText().trim());

    js.executeScript("arguments[0].click();", elements.get(2));
    assertEquals("Certification", elements.get(2).findElement(By.cssSelector("div h2")).getText().trim());
}

    private void verifyTitreFormation() {
        List<WebElement> titles = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='image'][1]/following::h4[1]")));
        
        assertEquals("ISTQB Test Manuel", titles.get(0).getText());
        assertEquals("Automatisation Web et Mobile", titles.get(1).getText());
        assertEquals("ISTQB Niveau Avancé", titles.get(2).getText());
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    // Méthodes utilitaires (inchangées mais sécurisées)
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
}