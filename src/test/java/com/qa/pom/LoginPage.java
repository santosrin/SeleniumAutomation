package com.qa.pom;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends TestBase {

    //Page Factory - Object Repository
    @FindBy(xpath = "//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
    WebElement loginBtn;

    @FindBy(name="email")
    WebElement email;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
    WebElement submitBtn;

    @FindBy(xpath = "//a[@class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")
    WebElement signUpBtn;

    @FindBy(xpath = "//div[@class='rd-navbar-panel']//span[contains(text(),'free')]")
    WebElement crmLogo;

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    //Actions
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateCRMLogo() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(crmLogo));
        return crmLogo.isDisplayed();
    }

    public HomePage login(String un,String pwd) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        loginBtn.click();
        email.sendKeys(un);
        password.sendKeys(pwd);
        submitBtn.click();
        return new HomePage();
    }
}

