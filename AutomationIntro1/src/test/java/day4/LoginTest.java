package day4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest{

    @Test
    public void Login() throws InterruptedException {
        goToLandingPage();
        LoginPage loginPage= new LoginPage(getDriver());
        Thread.sleep(2000);
        DashboardPage dashboardPage=loginPage.login("Admin","admin123");
        assertEquals("Welcome Rosy",dashboardPage.getWelcomePanel().getText());
    }


}
