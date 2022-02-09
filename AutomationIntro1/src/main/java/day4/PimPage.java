package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PimPage extends BasePage{
    public PimPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(id="menu_pim_viewEmployeeList")
    private WebElement employeeList;
    @FindBy(id="searchBtn")
    private WebElement searchButton;
    @FindBy(xpath="/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr/td[5]")
    private WebElement jobTable;

    public  PimPage clickEmployeeList(){
        getEmployeeList().click();
        return new PimPage(getDriver());
    }
    public  PimPage selectJob( String job){
        WebElement searchJob=getDriver().findElement(By.id("empsearch_job_title"));
        Select select= new Select(searchJob);
        select.selectByVisibleText(job);

        return new PimPage(getDriver());
    }

    public  PimPage selectStatus( String status){
        WebElement searchStatus=getDriver().findElement(By.id("empsearch_employee_status"));
        Select select= new Select(searchStatus);
        select.selectByVisibleText(status);
        return new PimPage(getDriver());
    }
    public PimPage clickSearchBtn(){
        new WebDriverWait(getDriver(),3).until(ExpectedConditions.elementToBeClickable(getSearchButton()));
        getSearchButton().click();
        return new PimPage(getDriver());
    }

    public WebElement getEmployeeList(){return employeeList; }
    public WebElement getSearchButton(){return searchButton; }
    public WebElement getJobTable(){return jobTable; }



}
