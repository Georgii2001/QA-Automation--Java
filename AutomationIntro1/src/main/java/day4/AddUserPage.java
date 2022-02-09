package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUserPage extends BasePage {

    public AddUserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(id="systemUser_userType")
    private WebElement userRole;
    @FindBy(id="systemUser_employeeName_empName")
    private WebElement employeename;
    @FindBy(id="systemUser_userName")
    private WebElement username;
    @FindBy(id="systemUser_status")
    private WebElement status;
    @FindBy(id="systemUser_password")
    private WebElement password;
    @FindBy(id="systemUser_confirmPassword")
    private WebElement confirmPassword;
    @FindBy(id="btnSave")
    private WebElement saveButton;

    public WebElement getUserRole(){ return userRole; }
    public WebElement getEmployeename(){ return employeename; }
    public WebElement getUsername(){ return username; }
    public WebElement getStatus(){ return status; }
    public WebElement getPassword(){ return password; }
    public WebElement getConfirmPassword(){ return confirmPassword; }
    public WebElement getSaveButton(){ return saveButton; }
///????
    public AdminPage clickSaveButton(){
        getSaveButton().click();
        return new AdminPage(getDriver());
    }

    public void insertEmployeeName(String employee){

        getEmployeename().sendKeys(employee);
        getDriver().findElement(By.xpath("/html/body/div[4]/ul/li[1]")).click();
    }
}









