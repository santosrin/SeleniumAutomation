package com.qa.base;

import com.qa.utils.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        TestBase.driver = driver;
    }

    public static Properties prop;
    FileInputStream fis = null;
    public TestBase() {
        try {
            prop = new Properties();
            fis = new FileInputStream(System.getProperty("user.dir")+
                    "/src/test/java/com/qa/config/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        //Set window size, delete cookies and timeout properties
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

}
