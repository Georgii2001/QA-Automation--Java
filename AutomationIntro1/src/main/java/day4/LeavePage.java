package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeavePage extends BasePage {
    public LeavePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(id="menu_leave_Entitlements")
    private WebElement entitlementsButton;
    @FindBy(id="menu_leave_addLeaveEntitlement")
    private WebElement addEntitlementsButton;
    @FindBy(id="entitlements_employee_empName")
    private WebElement employee;
    @FindBy(id="entitlements_entitlement")
    private WebElement entitlements;
    @FindBy(id="btnSave")
    private WebElement saveButton;
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr/td[5]")
    private WebElement day;

    public LeavePage clickSaveButton(){
       new WebDriverWait(getDriver(),3).until(ExpectedConditions.elementToBeClickable(getSaveButton()));
        getSaveButton().click();
        return new LeavePage(getDriver());
    }
    public LeavePage clickEntitlementsButton(){
         getEntitlementsButton().click();
        return new LeavePage(getDriver());
    }
    public LeavePage clickAddEntitlementsButton(){
        getAddEntitlementsButton().click();
        return new LeavePage(getDriver());
    }
    public LeavePage addEmployee(String employeeName){
       getEmployee().sendKeys(employeeName);
       getDriver().findElement(By.xpath("/html/body/div[4]/ul/li")).click();
       return new LeavePage(getDriver());
    }

    public WebElement getSaveButton(){ return saveButton; }
    public WebElement getEntitlementsButton(){ return entitlementsButton; }
    public WebElement getAddEntitlementsButton(){ return addEntitlementsButton; }
    public WebElement getEmployee(){ return employee; }
    public WebElement getEntitlements(){ return entitlements; }
    public WebElement getDay(){ return day; }
}
