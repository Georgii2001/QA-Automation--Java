package day3;

import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.logging.FileHandler;
import java.io.IOException;

import static java.util.logging.FileHandler.*;
import static org.openqa.selenium.io.FileHandler.copy;

public class Practice6 {
    @Test
    public void ScreenShotTest() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/broken_images");
        TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
        File ss= takeScreenshot.getScreenshotAs(OutputType.FILE);
        copy(ss, new File("src/main/resources/screenshot.jpg"));

        driver.quit();
    }
}
