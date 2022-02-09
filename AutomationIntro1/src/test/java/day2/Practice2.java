package day2;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice2 {
    @Test
    public void FirstSeleniumTest(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");
        System.out.println("Title" + driver.getTitle());
        System.out.println("Url: " + driver.getCurrentUrl() );

        Dimension d1= driver.manage().window().getSize();
        System.out.println("Dimension : " + d1);

        driver.manage().window().maximize();
        driver.navigate().refresh();


        Dimension d2= new Dimension(300,200);
        driver.manage().window().setSize(d2);

        driver.close();
    }


}
