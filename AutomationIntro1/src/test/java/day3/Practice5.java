package day3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

import java.util.Set;

import static org.junit.Assert.assertEquals;



public class Practice5 {
    WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void JsAlertTest() throws InterruptedException{

        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebDriverWait wait2= new WebDriverWait(driver, 2);
        WebElement JsConfirm= driver.findElements(By.tagName("Button")).get(1);
        JsConfirm.click();
        Thread.sleep(1000);
        //spune daca a aparut alerta
        wait2.until(ExpectedConditions.alertIsPresent());
        Alert alert= driver.switchTo().alert();
        System.out.println(alert.getText());
        assertEquals("I am a JS Confirm", alert.getText());
        Thread.sleep(2000);
        alert.dismiss();
        wait2.until(ExpectedConditions.textToBePresentInElementLocated(By.id("result"),"You clicked: Cancel"));
        assertEquals("You clicked: Cancel", driver.findElement(By.id("result")).getText());

    }

    @Test
    public void iFrameTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement textArea =driver.findElement(By.xpath("/html/body/p"));
        Thread.sleep(2000);
        textArea.clear();
        textArea.sendKeys("New text");
        driver.switchTo().defaultContent();
    }

    @Test
    public void windowTest() {
    driver.get("http://the-internet.herokuapp.com/windows");

    String firstWindow= driver.getWindowHandle();
    System.out.println("First window handle" + firstWindow);

    WebElement link =driver.findElement(By.linkText("Click Here"));
    link.click();
    System.out.println("After click : ");
    System.out.println(driver.getCurrentUrl());
    System.out.println(driver.getWindowHandle());
    Set<String> allWindows =driver.getWindowHandles();
    for(String window : allWindows)
     {
        if(!window.equals(firstWindow))
            driver.switchTo().window(window);
     }

        System.out.println("After switch : ");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle());

        assertEquals("http://the-internet.herokuapp.com/windows/new",driver.getCurrentUrl());
        assertEquals("New Window", driver.getTitle());
    }

    @Test
    public void JsPromptAlert(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebDriverWait wait3= new WebDriverWait(driver, 2);
        WebElement JsPrompt= driver.findElements(By.tagName("Button")).get(2);
        JsPrompt.click();
        wait3.until(ExpectedConditions.alertIsPresent());
        Alert alert= driver.switchTo().alert();
        System.out.println(alert.getText());
        assertEquals("I am a JS prompt", alert.getText());
        alert.dismiss();
        wait3.until(ExpectedConditions.textToBePresentInElementLocated(By.id("result"),"You entered: null"));
        assertEquals("You entered: null", driver.findElement(By.id("result")).getText());

    }



    @After
    public void cleanUp() {
        driver.quit();
    }
}
