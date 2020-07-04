package com.qa.pom;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//span[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//span[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//span[contains(text(),'Tasks')]")
    WebElement tasksLink;

    @FindBy(xpath = "//div[contains(text(),'Deals Summary')]")
    WebElement dealsSummary;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public ContactsPage clickOnContactsLink() {
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink() {
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOnTasksLink() {
        tasksLink.click();
        return new TasksPage();
    }

    public String verifyDealsSummaryTitle() {
        String dealsSum = dealsSummary.getText();
        return dealsSum;
    }
}
