package day4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class Scenariul3 extends BaseTest {
    @Test
    public void Scenariul3Test(){
        goToLandingPage();
        LoginPage loginPage = new LoginPage(getDriver());
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        assertEquals("Welcome Paul", dashboardPage.getWelcomePanel().getText());

        LeavePage leavePage = dashboardPage.clickLeaveButton();
        leavePage.clickEntitlementsButton();
        leavePage.clickAddEntitlementsButton();
        String employeeName="Alice Duval";
        leavePage.addEmployee(employeeName);
        String value ="8.00";
        leavePage.getEntitlements().sendKeys(value);
        leavePage.clickSaveButton();
        try {
            new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(leavePage.getDay()));
            assertEquals(value, leavePage.getDay().getText());
        }
        catch(Exception e)
        {
          driver.findElement(By.id("dialogUpdateEntitlementConfirmBtn")).click();
          new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(leavePage.getDay()));
          System.out.println("A mai fost adaugata o valoare anterior. 'Day' arata suma valorii precedente + valoarea actuala : " + leavePage.getDay().getText());

        }
    }
}
