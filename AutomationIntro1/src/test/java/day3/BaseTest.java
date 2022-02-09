package day3;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    @Before
    public void setUp() throws IOException {
        FileReader fileReader= new FileReader("src/main/resources/app.properties");
        Properties properties = new Properties();
        properties.load(fileReader);
        String browser= properties.getProperty("browser");
        String url= properties.getProperty("url");

        switch (browser){
            case "chrome":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "internetExplorer":
                System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                break;
        }
        driver.get(url);
        System.out.println("BROWSER=" +browser);
        System.out.println("url=" + url);
    }


    @After
    public void after()
    {
        driver.quit();
    }
}
