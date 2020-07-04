package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pom.ContactsPage;
import com.qa.pom.HomePage;
import com.qa.pom.LoginPage;
import com.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    TestUtil testUtil;
    String sheetName = "contacts";

    @BeforeMethod
    public void setup() {
        initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        contactsPage = homePage.clickOnContactsLink();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DataProvider
    public Object[][] getCRMTestData() {
        Object[][] data = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 0)
    public void verifyContactsPageLabel() {
        Assert.assertTrue(contactsPage.verifyContactsLabel());
    }

    @Test(priority = 1,dataProvider = "getCRMTestData")
    public void createNewContact(String firstname,String lastname,
                                 String description) throws InterruptedException{
        contactsPage.clickContactNewButton();
        Thread.sleep(5000);
        //driver.navigate().refresh();
        contactsPage.createNewContact(firstname,lastname,description);
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void selectContactsTest() throws  InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(5000);
        contactsPage.selectContactByName("Vishy4 Tom4");
        boolean flag = driver.findElement(By.xpath
                ("//div[@class='ui checked fitted read-only checkbox']//label")).isEnabled();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void selectMultiContactsTest() throws  InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(5000);
        contactsPage.selectContactByName("Vishy4 Tom4");
        boolean flag = driver.findElement(By.xpath
                ("//div[@class='ui checked fitted read-only checkbox']//label")).isEnabled();
        Assert.assertTrue(flag);
        contactsPage.selectContactByName("Vishy3 Tom3");
        boolean flag1 = driver.findElement(By.xpath
                ("//div[@class='ui checked fitted read-only checkbox']//label")).isEnabled();
        Assert.assertTrue(flag1);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
