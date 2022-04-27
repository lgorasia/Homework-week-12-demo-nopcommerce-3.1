package computer;

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

import javax.swing.*;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/ftrfgtrrgrftfvgvtgtti";

    //static WebDriver driver;

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //@After
    public void tearDown() {
        closeBrowser();
    }

    @Test
    public void verifyProductArrangeInDecendingOrder() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        // clickOnElement();
        Select sortBy = new Select(driver.findElement(By.xpath("//select[@id='products-orderby']")));
        sortBy.selectByVisibleText("Name: Z to A");

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        Select sortBy = new Select(driver.findElement(By.xpath("//select[@id='products-orderby']")));
        sortBy.selectByVisibleText("Name: A to Z");
        //Add to cart
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        String expectedText = "Build your own computer";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals(expectedText, actualText);
// select processor
        Thread.sleep(1000);
        Select sortProcessor = new Select(driver.findElement(By.xpath("//select[@id='product_attribute_1']")));
        sortProcessor.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

// select RAM
        Thread.sleep(1000);
        Select ram = new Select(driver.findElement(By.xpath("//select[@id='product_attribute_2']")));
        ram.selectByVisibleText("8GB [+$60.00]");

//Select HDD radio
        Thread.sleep(1000);
        clickOnElement(By.cssSelector("#product_attribute_3_7"));

// select os radio
        Thread.sleep(1000);
        clickOnElement(By.cssSelector("#product_attribute_4_9"));

        // check boxes
        Thread.sleep(3000);
//        Actions actions = new Actions(driver);
//        WebElement office = driver.findElement(By.id(""))
//        actions.moveToElement(actions)
//        clickOnElement(By.name("product_attribute_5"));
        clickOnElement(By.id("product_attribute_5_12"));
// verify price
        Thread.sleep(1000);
        String expectedValue = "$1,475.00";
        String actualValue = getTextFromElement(By.id("price-value-1"));
        Assert.assertEquals(expectedValue, actualValue);

        //add to cart
        clickOnElement(By.cssSelector("#add-to-cart-button-1"));

        //verify product added to cart
        String ecpectedAddToCartMessage = "The product has been added to your shopping cart";
        String actualAddToCartMessage = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals(ecpectedAddToCartMessage, actualAddToCartMessage);

        //close green bar
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
// select item from cart
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        WebElement cart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement cartItem = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        actions.moveToElement(cart).moveToElement(cartItem).click().build().perform();

//verify shpping cart
        String expectedCartMessage = "Shopping cart";
        String actualCartMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals(expectedCartMessage, actualCartMessage);
// chagne quantity
        Actions actions1 = new Actions(driver);
        WebElement quantity = driver.findElement(By.xpath("//input[@value='1']"));
        quantity.clear();

       // driver.findElements(By.id("itemquantity11247")).clear();
        sendTextToElement(By.xpath("//input[@value='1']"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //Verify the new total
        String expectedNewTotal = "$2,950.00";
        String actualNewTotal = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        Assert.assertEquals(expectedNewTotal, actualNewTotal);

        //click on check box and agreed terms
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));


        //verify signIn
        String expectedWelcomeMessage = "Welcome, Please Sign In!";
        String actualWelcomeMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals(expectedWelcomeMessage,actualWelcomeMessage);

        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //check out as guest
        Thread.sleep(3000);
        sendTextToElement(By.id("BillingNewAddress_FirstName"),"Karan");
        sendTextToElement(By.id("BillingNewAddress_LastName"),"Arjun");
        sendTextToElement(By.id("BillingNewAddress_Email"),"karn@gmail.com");
        Select country = new Select(driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']")));
        country.selectByVisibleText("United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"London");
        sendTextToElement(By.cssSelector("#BillingNewAddress_Address1"),"21 ABC road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"HA2 6CZ");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"07463251145");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        //next day delivery
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

        //selct credit card
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

        Select card = new Select(driver.findElement(By.xpath("//select[@id='CreditCardType']")));
        card.selectByVisibleText("Master card");

        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Karan Arjun");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"1111 2222 3333 4444");

        Select month = new Select(driver.findElement(By.xpath("//select[@id='ExpireMonth']")));
        month.selectByVisibleText("02");

        Select year = new Select(driver.findElement(By.xpath("//select[@id='ExpireYear']")));
        year.selectByVisibleText("2023");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"256");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //varify details
        String expectedPaymentMethod = "Credit Card";
        String actualPaymentMethod = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals(expectedPaymentMethod,actualPaymentMethod);

        String expectedShippingMethod ="Next Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        Assert.assertEquals(expectedShippingMethod,actualShippingMethod);

        String expectedTotal = "$2,950.00";
        String actualTotal = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals(expectedTotal,actualTotal);

        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //Thank you
        String expectedThanks = "Thank you";
        String actaulThanks = getTextFromElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-1 div.page.checkout-page.order-completed-page div.page-title > h1:nth-child(1)"));

        Assert.assertEquals(expectedThanks,actaulThanks);

        //order processed

        String expectedProcessMessage ="Your order has been successfully processed!";
        String actualProcessedMessage =getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals(expectedProcessMessage,actualProcessedMessage);

        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //Welcome to out store

        String expectedWelcome = "Welcome to our store";
        String actualWelcome = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals(expectedWelcome,actualWelcome);











//        Select sortProcessor = new Select(driver.findElement(By.xpath("//select[@id='product_attribute_1']")));
//        sortProcessor.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");









        // clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/h2[1]/a[1]"));
//        String expectedText = "Buildd your own computer";
//        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
//        Assert.assertEquals(expectedText, actualText);

    }
}
