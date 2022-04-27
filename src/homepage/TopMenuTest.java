package homepage;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Utility;

import java.time.Duration;
import java.util.List;


public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/ftrfgtrrgrftfvgvtgtti";
    public static WebDriver driver;
   // static String menu = "Apparel";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

   // @After
    public void tearDown(){
        closeBrowser();
    }



    @Test
    public void verifyUserCanNavigateToComputerMenu() throws InterruptedException {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        selectMenu("Computers", By.xpath("//h1[contains(text(),'Computers')]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Computers')]"), "Computers");
    }

    @Test
    public void verifyUserCanNavigateToElectronicsMenu() throws InterruptedException {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        selectMenu("Electronics",By.xpath("//h1[contains(text(),'Electronics')]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Electronics')]"), "Electronics");
    }

    @Test
    public void verifyUserCanNavigateToApparelMenu() throws InterruptedException {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        selectMenu("Apparel",By.xpath("//h1[contains(text(),'Apparel')]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Apparel')]"), "Apparel");
    }

    @Test
    public void verifyUserCanNavigateToDigitalDownloadsMenu() throws InterruptedException {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]"));
        selectMenu("Digital downloads",By.xpath("//h1[contains(text(),'Digital downloads')]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Digital downloads')]"), "Digital downloads");
    }
    @Test
    public void verifyUserCanNavigateToBooksMenu() throws InterruptedException {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]"));
        selectMenu("Books",By.xpath("//h1[contains(text(),'Books')]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Books')]"), "Books");
    }

    @Test
    public void verifyUserCanNavigateToJewelryMenu() throws InterruptedException {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]"));
        selectMenu("Jewelry",By.xpath("//h1[contains(text(),'Jewelry')]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Jewelry')]"), "Jewelry");
    }

    @Test
    public void verifyUserCanNavigateToGiftCardsMenu() throws InterruptedException {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));
        selectMenu("Gift Cards",By.xpath("//h1[contains(text(),'Gift Cards')]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Gift Cards')]"), "Gift Cards");
    }


    }

