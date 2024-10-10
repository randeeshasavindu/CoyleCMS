package com.coylecms.qa.testcases;

import com.coylecms.qa.base.TestBase;
import com.coylecms.qa.pages.CoyleMembersPage;
import com.coylecms.qa.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPageTCs extends TestBase {

    LoginPage loginPage;
    CoyleMembersPage coyleMembersPage;
    WebDriverWait wait;


    public LoginPageTCs(){
        super();
    }

    @BeforeClass
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title , "Coyle");
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

        System.out.println("Title is " + title);

    }

    @Test(priority = 2)
    public void coyleLogoImageTest(){
        boolean logo = loginPage.validateCOYLEImage();
        Assert.assertTrue(logo);

        if (logo) {
            System.out.println("Logo present");
        } else {
            System.out.println("Logo not present");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test(priority = 3)
    public void loginTest(){
        coyleMembersPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        System.out.println("Navigated to the Dashboard Page Successfully");
    }

    @AfterClass
    public void tearDown(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();
    }
}
