package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@class = 'radius']")).click();
        String expectedMessage = "Secure Area";// Expected message given in requirement
        String actualMessage = driver.findElement(By.xpath("//h2[contains(text(),' Secure Area')]")).getText();
        Assert.assertEquals("User should not log in successfully",expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {

        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@class = 'radius']")).click();
        String expectedMessage = "Your username is invalid!";
        String actualMessage = driver.findElement(By.xpath("//div[@class = 'flash error']")).getText().substring(0, 25);
        Assert.assertEquals("Unable to verify User Name error message.",expectedMessage, actualMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage() {

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//button[@class = 'radius']")).click();
        String expectedMessage = "Your password is invalid!";
        String actualMessage = driver.findElement(By.xpath("//div[@class = 'flash error']")).getText().substring(0, 25);
        Assert.assertEquals("Password error message was not verified.",expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}