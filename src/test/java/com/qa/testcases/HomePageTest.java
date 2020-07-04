package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pom.ContactsPage;
import com.qa.pom.HomePage;
import com.qa.pom.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    ContactsPage contactsPage;

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        contactsPage = new ContactsPage();
    }

    @Test(priority = 0)
    public void verifyHomePageTitle(){
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle,"Cogmento CRM");
    }

    @Test(priority = 1)
    public void verifyDealsSummaryTitle(){
        String dealsSummaryTitle = homePage.verifyDealsSummaryTitle();
        Assert.assertEquals(dealsSummaryTitle,"Deals Summary");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
