package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/ftrfgtrrgrftfvgvtgtti-";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

     @After
    public void tearDown() {
        closeBrowser();
    }

    @Test
    public void textVerified() {
        Actions actions = new Actions(driver);
        WebElement electonics = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        WebElement cellPhone = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        actions.moveToElement(electonics).moveToElement(cellPhone).click().build().perform();
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement electonics = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        WebElement cellPhone = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        actions.moveToElement(electonics).moveToElement(cellPhone).click().build().perform();
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals(expectedText, actualText);
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        clickOnElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-2 div.page.category-page div.page-body div.products-container div.products-wrapper div.product-list div.item-grid div.item-box:nth-child(3) div.product-item div.details h2.product-title > a:nth-child(1)"));
//        //verify nokia
        String expectedNokia = "Nokia Lumia 1020";
        String actualNokia = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals(expectedNokia, actualNokia);
//        //verify price
        String expectedPrice = "$349.00";
        String actualPrice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals(expectedPrice, actualPrice);
//change quantity and add to cart
        driver.findElement(By.cssSelector("#product_enteredQuantity_20")).clear();
        sendTextToElement(By.cssSelector("#product_enteredQuantity_20"), "2");
        clickOnElement(By.cssSelector("#add-to-cart-button-20"));
        // green bar message
        String ecpectedAddToCartMessage = "The product has been added to your shopping cart";
        String actualAddToCartMessage = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals(ecpectedAddToCartMessage, actualAddToCartMessage);
        //close green bar
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        // hover mouse on shopping cart
        Thread.sleep(3000);
        actions = new Actions(driver);
        WebElement cart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement cartItem = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        actions.moveToElement(cart).moveToElement(cartItem).click().build().perform();
        //varify message shopping cart
        String exprcctedCartMessage = "Shopping cart";
        String actualCartMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals(exprcctedCartMessage, actualCartMessage);
        //Varify Quantity
//        String expectedQuantiy ="2";
//        String actualQuantitiy1 = getTextFromElement(By.xpath("//td[@class='quantity']"));
//        Assert.assertEquals(expectedQuantiy,actualQuantitiy1);

// verify total
        String expectedTotal = "$698.00";
        String actualTotal = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]"));
        Assert.assertEquals(expectedTotal, actualTotal);
        //click on terms and check out
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));

        // verify welcome

        String expectedWelcome = "Verify the Text “Welcome, Please Sign In!";
        String actualWelcome = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
//click on registration and varify it

        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        String expectedRegisterd = "Register";
        String actualRegistered = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals(expectedRegisterd, actualRegistered);

        //fill registration form
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Karan");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Arjun");
        sendTextToElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]"), "17");
        sendTextToElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[2]"), "05");
        sendTextToElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[3]"), "1984");
        sendTextToElement(By.xpath("//input[@id='Email']"), "13abcedfedd@yahoo.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "142536");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "142536");
        clickOnElement(By.xpath("//button[@id='register-button']"));

        // registration complete and click on continue
        String expectedcomplete = "Your registration completed";
        String actualcomplete = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals(expectedcomplete, actualcomplete);
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //verify shopping cart
        String expectedCart = "Shopping cart";
        String actualCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals(expectedCart, actualCart);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //check out form

        Select select = new Select(driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']")));
        select.selectByVisibleText("United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendTextToElement(By.cssSelector("#BillingNewAddress_Address1"), "12 Jenner avenue");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA26RT");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07463251254");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));


        //2nd class
        clickOnElement(By.id("shippingoption_2"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

// select card
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));


// payment information
        Select select1 = new Select(driver.findElement(By.xpath("//select[@id='CreditCardType']")));
        select1.selectByVisibleText("Visa");
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "L J Bhatt");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1111 2222 3333 4444");
        sendTextToElement(By.xpath("//select[@id='ExpireMonth']"), "01");
        sendTextToElement(By.xpath("//select[@id='ExpireYear']"), "2023");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "254");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //verify
        Thread.sleep(3000);
        String expectedPaymentMethod = "Credit Card";
        String actualPaymentMethod = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals(expectedPaymentMethod, actualPaymentMethod);

        String expectedShippingMessage = "2nd Day Air";
        String actualShippingMessage = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        Assert.assertEquals(expectedShippingMessage, actualShippingMessage);

        String expectedTotalPrice = "$698.00";
        String actualTotalPrice = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals(expectedTotalPrice, actualTotalPrice);
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //verify thank you
        Thread.sleep(3000);
        String expectedThakYou = "Thank you";
        String actualThankYou = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals(expectedThakYou, actualThankYou);

        // order processed
        String expectedProcessed = "Your order has been successfully processed!";
        String actualProcessed = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals(expectedProcessed, actualProcessed);
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //verify Url
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);


    }
}
