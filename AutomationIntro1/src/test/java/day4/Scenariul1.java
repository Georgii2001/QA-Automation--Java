package day4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Scenariul1 extends BaseTest {

    @Test
    public void Scenariul1Test()  {
        goToLandingPage();
        LoginPage loginPage= new LoginPage(getDriver());
        DashboardPage dashboardPage=loginPage.login("Admin","admin123");
        assertEquals("Welcome Paul",dashboardPage.getWelcomePanel().getText());

        AdminPage adminPage= dashboardPage.clickAdminButton();
        adminPage.clickJob();
        adminPage.clickJobTitleList();
        JobTitlePage jobTitlePage= adminPage.clickAddButtonJob();
        String textJob="Tester it";
        jobTitlePage.getJobTitle().sendKeys(textJob);
        jobTitlePage.clickSaveButton();
        assertEquals("https://opensource-demo.orangehrmlive.com/index.php/admin/viewJobTitleList",driver.getCurrentUrl() );
        List<WebElement> jobTitleSearch = driver.findElements(By.className("left"));
        int ok=0;
        for(WebElement job : jobTitleSearch )
        {
            if(job.getText().equals(textJob))
            {
                job.click();
                ok++;
            }
        }
        assertEquals(1,ok);
    }
}
