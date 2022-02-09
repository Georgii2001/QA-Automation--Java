package day2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Practice3 {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
    }

    @Test
    public void loginFailWrongUsername() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.tagName("Button")).click();
        Thread.sleep(2000);
        assertEquals("http://the-internet.herokuapp.com/login", driver.getCurrentUrl());
        WebElement flash = driver.findElement(By.id("flash"));
        assertTrue(flash.isDisplayed());
        assertTrue(flash.getText().contains("Your username is invalid!"));
    }

    @Test
    public void loginFailWrongPassword() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.tagName("Button")).click();
        Thread.sleep(2000);
        assertEquals("http://the-internet.herokuapp.com/login", driver.getCurrentUrl());
        WebElement flash = driver.findElement(By.id("flash"));
        assertTrue(flash.isDisplayed());
        assertTrue(flash.getText().contains("Your password is invalid!"));
    }

    @Test
    public void loginSucces() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.tagName("Button")).click();
        Thread.sleep(2000);
        assertEquals("http://the-internet.herokuapp.com/secure", driver.getCurrentUrl());
        WebElement flash = driver.findElement(By.id("flash"));
        assertTrue(flash.isDisplayed());
        assertTrue(flash.getText().contains("You logged into a secure area!"));
        assertTrue(driver.findElement(By.xpath("//i[contains(text(),'Logout')]")).isDisplayed());

    }
    @After
    public void cleanUp(){
        driver.quit();
    }
}