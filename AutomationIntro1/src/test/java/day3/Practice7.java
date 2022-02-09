package day3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Practice7 {

    WebDriver driver;
    Actions actions;

    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options= new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        driver= new ChromeDriver(options);
        actions= new Actions(driver);
    }

    @Test
    public void dragAndDrop(){

        driver.get("http://webdriveruniversity.com/Actions/index.html");
        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(from,to).perform();
        assertEquals("Dropped!",to.getText());
    }

    @Test
    public void contextClick() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element= driver.findElement(By.id("hot-spot"));
        actions.contextClick(element).perform();
        assertEquals("You selected a context menu", driver.switchTo().alert().getText());
        Alert alert= driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(2000);
    }

    @Test
    public void KeyboardInteractions(){

        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement target= driver.findElement(By.id("target"));
        actions.keyDown(Keys.SHIFT).sendKeys(target,"endava").keyUp(Keys.SHIFT).sendKeys(target,"endava").perform();
    }
    
    @Test
    public void multipleSelect() throws InterruptedException {
        
    driver.get("http://book.theautomatedtester.co.uk/multi-select.html");
    Select select = new Select(driver.findElement(By.id("selectWithMultipleEqualsMultiple")));
    select.deselectAll();
    List<WebElement> options=select.getOptions();
    actions.keyDown(Keys.CONTROL)
            .click(options.get(1)).click(options.get(2)).perform();
    Thread.sleep(2000);
    }
    
    @After
    public void after()
    {
        driver.quit();
    }

}

