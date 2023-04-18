package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class TopMenuTest extends BaseTest {
    String baseurl = "https://demo.nopcommerce.com";

    @Before
    public void setUp() {
        // Open browser and launch base url
        openBrowser(baseurl);
    }

    @After
    public void terminateBrowser() {
        // Close all windows
        closeBrowser();
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        String expectedMessage = "Computers";
        //Element to click on Computers tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//h1"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to click on Computer tab", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        String expectedMessage = "Electronics";
        //Element to click on Electronics tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//h1"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to click on Electronics tab", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfull() {
        String expectedMessage = "Apparel";
        //Element to click on Apparel tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Apparel ']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//h1"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to click on Apparel tab", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfull() {
        String expectedMessage = "Digital downloads";
        //Element to click on Digital downloads tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Digital downloads ']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//h1"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to click on Digital downloads tab", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        String expectedMessage = "Books";
        //Element to click on Books tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Books ']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//h1"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to click on Books tab", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        String expectedMessage = "Jewelry";
        //Element to click on Jewelry tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Jewelry ']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//h1"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to click on Jewelry tab", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfull() {
        String expectedMessage = "Gift Cards";
        //Element to click on Gift Cards tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Gift Cards ']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//h1"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to click on Gift Cards tab", expectedMessage, actualMessage);
    }
}


