package com.coylecms.qa.testcases;

import com.coylecms.qa.pages.DashboardPage;
import com.coylecms.qa.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DashboardPageTCs extends LoginPageTCs {

    DashboardPage dashboardPage;
    DashboardPage validateCoyleNameDisplay;

    public DashboardPageTCs(){
        super();
    }

    @BeforeClass
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void dashboardPageTitleTest(){
        String title = dashboardPage.validateTitleOfTheDBPage();
        Assert.assertEquals(title,"Coyle");
    }

    @Test(priority = 2)
    public void dashboardPageCoyleLogoImageTest(){
        boolean DashboardLogo = dashboardPage.validateLogoDisplay();
        Assert.assertTrue(DashboardLogo);

        if (DashboardLogo) {
            System.out.println("Logo present");
        } else {
            System.out.println("Logo not present");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test(priority = 3)
    public void coyleNameDisplay(){
        boolean isDisplayed = dashboardPage.validateCoyleNameDisplay();

        // Assert that the COYLE name is displayed
        Assert.assertTrue(isDisplayed, "Chamber of Young Lankan Entrepreneurs");
    }

    @Test(priority = 4)
    public void clickCoyleMembersBtn(){
       dashboardPage.clickCoyleMembersTab();
    }

    @AfterClass
    public void tearDown(){
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        driver.quit();
    }


}
