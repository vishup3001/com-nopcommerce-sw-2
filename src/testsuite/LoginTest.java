package testsuite;


import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {
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
    public void userShouldNavigateToLoginPageSuccessfully() {

        String expectedMessage = "Welcome, Please Sign In!";
        // Element to click on login link
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//h1"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to click on login button", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        RegisterTest obj = new RegisterTest();
        // register new user to login because after few hours old user is deleted
        obj.userSholdRegisterAccountSuccessfully();
        String newEmail = obj.email;
        String expectedMessage = "Log out";
        // Element to click on login
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        // Element to send username
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(newEmail);
        // Element to send password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Admin123");
        // Element to click on LOGIN
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//a[@class='ico-logout']"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to login", expectedMessage, actualMessage);

    }

    @Test
    public void verifyTheErrorMessage() {
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        // Element to click on login
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        // Element to send username
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("demo@gmail.com");
        // Element to send password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Admin");
        // Element to click on LOGIN
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to display error message while invalid login ", expectedMessage, actualMessage);
    }
}


