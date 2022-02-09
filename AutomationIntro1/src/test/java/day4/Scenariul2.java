package day4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Scenariul2 extends BaseTest {

    @Test
    public void Scenariul2Test() throws InterruptedException {
        goToLandingPage();
        LoginPage loginPage = new LoginPage(getDriver());
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        assertEquals("Welcome test1", dashboardPage.getWelcomePanel().getText());

        PimPage pimPage= dashboardPage.clickPimButton();
        pimPage.clickEmployeeList();
        Thread.sleep(1000);
        String job="QA Lead";
        String status="Full-Time Permanent";
        pimPage.selectJob(job);
        pimPage.selectStatus(status);
        pimPage.clickSearchBtn();
        assertEquals(job,pimPage.getJobTable().getText());
    }
}
