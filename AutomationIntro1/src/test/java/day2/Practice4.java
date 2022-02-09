package day2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Practice4<publc> {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        driver.manage().window().maximize();
    }

    @Test
    public void selectTest() throws InterruptedException {
        WebElement dropdown1=driver.findElement(By.id("dropdowm-menu-1"));
        Select select1= new Select(dropdown1);
        select1.selectByIndex(2);
        Thread.sleep(2000);


        WebElement dropdown2=driver.findElement(By.id("dropdowm-menu-2"));
        Select select2= new Select(dropdown2);
        select2.selectByValue("junit");
        Thread.sleep(2000);

        WebElement dropdown3=driver.findElement(By.id("dropdowm-menu-3"));
        Select select3= new Select(dropdown3);
        select3.selectByVisibleText("CSS");
        Thread.sleep(2000);

        List<WebElement> options3= select3.getOptions();
        options3.forEach(o -> System.out.printf("%s",o.getAttribute("value")));

    }

    @Test
    public void checkboxTest() throws InterruptedException{
    WebElement option2=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/label[2]/input"));
    option2.click();
    Thread.sleep(2000);
    WebElement option3=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/label[3]/input"));
    assertTrue(option3.isSelected());
    option3.click();

    assertTrue(option2.isSelected());
    assertFalse(option3.isSelected());
    }

    @Test
    public void radioButtonTest(){
        List<WebElement> radioGrup=  driver.findElements(By.name("color"));
        System.out.println(radioGrup.size());
        for(WebElement radio : radioGrup)
        {
            if(radio.getAttribute("value").equals("orange"))
            {
                radio.click();
            }
        }
        WebElement orange = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/form/input[4]"));
        assertTrue(orange.isSelected());

    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}

