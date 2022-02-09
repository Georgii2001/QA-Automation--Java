package day4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends BasePage {
    public AdminPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(id= "btnAdd")
    WebElement addButton;
    @FindBy(id="searchSystemUser_userName")
    WebElement searchUserInput;
    @FindBy(id="searchBtn")
    WebElement  searchButton;
    @FindBy(xpath= "/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr/td[2]")
    WebElement firstTableResult;
    @FindBy(id="btnAdd")
    private WebElement addButtonJob;
    @FindBy(id="menu_admin_Job")
    private WebElement job;
    @FindBy(id="menu_admin_viewJobTitleList")
    private WebElement jobTitleList;

    public  AdminPage clickJob(){
        getJob().click();
        return new AdminPage(getDriver());
    }
    public  AdminPage clickJobTitleList(){
        getJobTitleList().click();
        return new AdminPage(getDriver());
    }

    public AddUserPage clickAddButton(){
        getAddButton().click();
        return new AddUserPage(getDriver());
    }

    public JobTitlePage clickAddButtonJob(){
        getAddButtonJob().click();
        return new JobTitlePage(getDriver());
    }

    public  String searchUser(String username) {
        new WebDriverWait(getDriver(),3).until(ExpectedConditions.elementToBeClickable(getSearchButton()));
       // getSearchButton().click();
        new WebDriverWait(getDriver(),3).until(ExpectedConditions.elementToBeClickable(getFirstTableResult()));
        return getFirstTableResult().getText();
    }

    public WebElement getAddButton(){return addButton; }
    public WebElement getSearchUserInput(){return searchUserInput; }
    public WebElement getSearchButton(){return searchButton; }
    public WebElement getFirstTableResult(){return firstTableResult; }
    public WebElement getAddButtonJob(){ return addButtonJob; }
    public WebElement getJob(){ return job; }
    public WebElement getJobTitleList(){ return jobTitleList; }
}
