package com.coylecms.qa.testcases;

import com.coylecms.qa.base.TestBase;
import com.coylecms.qa.pages.CoyleMembersPage;
import com.coylecms.qa.pages.LoginPage;
import com.coylecms.qa.pages.NewsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewsPageTCs extends TestBase {

    LoginPage loginPage;
    CoyleMembersPage CoyleMembersPage;
    NewsPage newsPage;

    public NewsPageTCs(){
        super();
    }

    @BeforeClass
    public void setUp() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        CoyleMembersPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyClickNewsTabBtn() throws InterruptedException {
        newsPage.clickNewsTabBtn();
        Thread.sleep(1500);
    }
}
