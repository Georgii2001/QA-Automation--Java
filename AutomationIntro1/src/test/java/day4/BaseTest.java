package day4;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;
    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void goToLandingPage(){
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    }

    WebDriver getDriver() { return driver; }

    @After
    public void after(){ driver.quit(); }

}
