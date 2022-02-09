package day4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class CreateUserAndTest extends BaseTest{

    @Test
    public void CreateUserAndTestIt() throws InterruptedException {
        goToLandingPage();
        LoginPage loginPage= new LoginPage(getDriver());
        DashboardPage dashboardPage=loginPage.login("Admin","admin123");
        assertEquals("Welcome Paul",dashboardPage.getWelcomePanel().getText());

        System.out.println("Am ajuns in pagina de dashboard");
        AdminPage adminPage= dashboardPage.clickAdminButton();
        AddUserPage addUserPage=adminPage.clickAddButton();
        new Select(addUserPage.getUserRole()).selectByIndex(1);

        String employeeName= "Aaliyah Haq";
        addUserPage.insertEmployeeName(employeeName);
        String user= "edi19";
        addUserPage.getUsername().sendKeys(user);
        new Select(addUserPage.getStatus()).selectByIndex(1);

        addUserPage.getPassword().sendKeys("admin123");
        addUserPage.getConfirmPassword().sendKeys("admin123");

        AdminPage adminPage1 = addUserPage.clickSaveButton();

        Thread.sleep(1000);

        adminPage1.getSearchUserInput().sendKeys(user);
        adminPage1.getSearchButton().click();
        assertEquals(user,adminPage1.searchUser(user));


    }


}
