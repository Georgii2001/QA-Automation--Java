package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(id= "txtUsername")
    private WebElement usernameInput;

    @FindBy(id= "txtPassword")
    private WebElement passwordInput;

    @FindBy(id= "btnLogin")
    private WebElement loginButton;


    public DashboardPage login(String username, String password ){
        getUsernameImput().sendKeys(username);
        getPasswordImput().sendKeys(password);
        new WebDriverWait(getDriver(),10).until(ExpectedConditions.elementToBeClickable(By.id("btnLogin")));
        getLoginButton().click();
        return new DashboardPage(getDriver());
    }

    private WebElement getPasswordImput() { return passwordInput; }

    private WebElement getUsernameImput() { return usernameInput; }

    private WebElement getLoginButton() { return loginButton; }

}
