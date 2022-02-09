package day4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage{

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(),this);
    }

   @FindBy(id="welcome")
   private WebElement welcomePanel;
   @FindBy(id="menu_admin_viewAdminModule")
   private WebElement adminButton;
   @FindBy(id="menu_pim_viewPimModule")
   private WebElement pimButton;
   @FindBy(id="menu_leave_viewLeaveModule")
   private WebElement leaveButton;

    public AdminPage clickAdminButton(){
        getAdminButton().click();
        return new AdminPage(getDriver());
    }

    public PimPage clickPimButton(){
        getPimButton().click();
        return new PimPage(getDriver());
    }

    public LeavePage clickLeaveButton(){
        getLeaveButton().click();
        return new LeavePage(getDriver());
    }

    public WebElement getAdminButton()  {return adminButton;   }
    public WebElement getWelcomePanel() { return welcomePanel; }
    public WebElement getPimButton() { return pimButton; }
    public WebElement getLeaveButton() { return leaveButton; }

}
