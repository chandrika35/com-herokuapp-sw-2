package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public static WebDriver driver;
    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver();
        driver.get(baseUrl);

    }
    public void closeBrowser(){
        driver.quit();
    }
}