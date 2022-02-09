package day4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobTitlePage extends BasePage {


    public JobTitlePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(),this);
    }


    @FindBy(id="jobTitle_jobTitle")
    private WebElement jobTitle;
    @FindBy(id="btnSave")
    private WebElement saveButton;

    public AdminPage clickSaveButton(){
        getSaveButton().click();
        return new AdminPage(getDriver());
    }

    public WebElement getJobTitle(){ return jobTitle; }
    public WebElement getSaveButton(){ return saveButton; }


}


