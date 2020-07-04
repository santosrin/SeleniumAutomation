package com.qa.pom;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.Objects;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
    WebElement contactsLabel;

    @FindBy(xpath = "//button[contains(text(),'New')]")
    WebElement contactsNewButton;

    @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastName;

    @FindBy(xpath = "//textarea[@name='description']")
    WebElement description;

    @FindBy(xpath = "//button[@class='ui linkedin button']")
    WebElement saveBtn;

    public ContactsPage() {
        PageFactory.initElements(driver,this);
    }

    public boolean verifyContactsLabel() {
        return contactsLabel.isDisplayed();
    }

    public void clickContactNewButton() {
        contactsNewButton.click();
    }

    public void selectContactByName(String name) {
        TestBase.getDriver().findElement(By.xpath("//td[contains(text(),'"+name+"')]")).click();
    }

    public void createNewContact(String fn , String ln , String desc) {
        firstName.sendKeys(fn);
        lastName.sendKeys(ln);
        description.sendKeys(desc);
        saveBtn.click();
    }

}
