package pom.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import resources.DriverManager;

import java.time.Duration;

public class BaseTest extends BasePage {
    protected WebDriver driver;
    String baseURL = "https://timecost.techcoachralph.dev/";
    protected WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void setUpTest(){
        driver = new DriverManager().initializeDriver();
        driver.get(baseURL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
