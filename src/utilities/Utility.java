package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Utility extends BaseTest {

    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void verifyExpectedAndActual(By by, String expectedText) {
        String actualText = getTextFromElement(by);
        Assert.assertEquals(actualText, expectedText);

    }

    public void selectMenu(String menu, By by) throws InterruptedException {
        List<WebElement> names = driver.findElements(by);
        for (WebElement name : names) {
            if (name.getText().equalsIgnoreCase(menu)) {
                Thread.sleep(2000);
                name.click();
                break;
            }
        }
    }
}