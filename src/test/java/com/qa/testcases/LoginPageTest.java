package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pom.HomePage;
import com.qa.pom.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    private static Logger logger = LogManager.getLogger(LoginPageTest.class);

//    public LoginPageTest() {
//        super();
//    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        logger.info("Setup Done");
    }

    @Test(priority = 0)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"Free CRM #1 cloud software for any business large or small");
    }

    @Test(priority = 1)
    public void crmLogoImageTest() throws InterruptedException {
        boolean flag = loginPage.validateCRMLogo();
        Assert.assertTrue(flag);
    }

    @Test(priority = 2)
    public void loginTest() {
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        String homePageTitle = homePage.verifyHomePageTitle();
        logger.info("homePageTitle: "+ homePageTitle);
        Assert.assertEquals(homePageTitle,"Cogmento CRM");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
