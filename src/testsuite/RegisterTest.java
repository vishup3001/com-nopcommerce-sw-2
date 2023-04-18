package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class RegisterTest extends BaseTest {
    String baseurl = "https://demo.nopcommerce.com";
    String email;

    @Before
    public void setUp() {
        // Open browser and launch base url
        openBrowser(baseurl);
    }

    @After
    public void terminateBrowser() {
        // close browser method
        closeBrowser();
    }

    @Test
    public void UserShouldNavigateToRegisterPageSuccessfully() {

        String exceptedMessage = "Register";
        // Element to click on Register tab
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//h1"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to click on Register button", exceptedMessage, actualMessage);

    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        // String that generate unique value every time
        String name = UUID.randomUUID().toString();
        email = name + "@gmail.com";
        String exceptedMessage = "Your registration completed";
        // Element to click on Register tab
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        // Element to click on Gender radio button
        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        // Element to send FirstName
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Demo");
        // Element to send LastName
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Test");
        // method to select date of birth filed
        dateOfBirth(10, "October", "1992");
        // Element to send Email
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
        // Element to send Password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Admin123");
        // Element to send ConfirmPassword
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("Admin123");
        // Element to click on Register Button
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//div[@class='result']"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to Register", exceptedMessage, actualMessage);


    }

    /**
     * This method is used to select date of birth in registration form
     *
     * @param day
     * @param month
     * @param year
     */
    public void dateOfBirth(int day, String month, String year) {

        Select se = new Select(driver.findElement(By.xpath("//*[@name='DateOfBirthDay']")));
        se.selectByIndex(day);

        Select se1 = new Select(driver.findElement(By.xpath("//*[@name='DateOfBirthMonth']")));
        se1.selectByVisibleText(month);

        Select se2 = new Select(driver.findElement(By.xpath("//*[@name='DateOfBirthYear']")));
        se2.selectByVisibleText(year);


    }
}