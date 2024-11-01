package com.coylecms.qa.testcases;


import com.coylecms.qa.base.TestBase;
import com.coylecms.qa.pages.CoyleMembersPage;
import com.coylecms.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class CoyleMembersPageTCs extends TestBase {


    LoginPage loginPage;
    CoyleMembersPage CoyleMembersPage;

    public CoyleMembersPageTCs(){
        super();
    }

    @BeforeClass
    public void setUp() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        CoyleMembersPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));*/
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboardHeader")));*/

    }

    @Test(priority = 1)
    public void dashboardPageTitleTest(){
        String title = CoyleMembersPage.validateTitleOfTheDBPage();
        Assert.assertEquals(title,"Coyle");
    }

    @Test(priority = 2)
    public void dashboardPageCoyleLogoImageTest(){
        boolean DashboardLogo = CoyleMembersPage.validateLogoDisplay();
        Assert.assertTrue(DashboardLogo);

        if (DashboardLogo) {
            System.out.println("Logo present");
        } else {
            System.out.println("Logo not present");
        }
    }

    @Test(priority = 3)
    public void coyleNameDisplay() throws InterruptedException {
        boolean isDisplayed = CoyleMembersPage.validateCoyleNameDisplay();


        // Assert that the COYLE name is displayed
        Assert.assertTrue(isDisplayed, "Chamber of Young Lankan Entrepreneurs");
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void clickCoyleMembersBtn() throws InterruptedException {
        CoyleMembersPage.clickCoyleMembersTab();
    }

    @Test(priority = 5)
    public void clickAddCategoriesBtn(){
        CoyleMembersPage.clickAddCategoriesBtn();
    }

    @Test(priority = 6)
    public void addRandomNumberToCategory() throws InterruptedException {
        // Generate a random number
        Random random = new Random();
        int randomNumber = random.nextInt(1000);  // Generate a random number between 0 and 999

        // Convert the number to a String
        String randomNumberString = String.valueOf(randomNumber);

        // Use the CoyleMembersPage method to enter the random number into the text field
        CoyleMembersPage.addRandomNumberToCategory(randomNumberString);

        // Add additional assertions or actions as needed

    }

    @Test(priority = 7)
    public void selectCategoryFromList() throws InterruptedException {
        CoyleMembersPage.selectCategory();

    }

    @Test(priority = 8)
    public void clickAddBtn() throws InterruptedException {
        CoyleMembersPage.clickAdd();
        Thread.sleep(1500);
    }

    @Test(priority = 9)
    public void searchCategoryNumber() throws InterruptedException {
        CoyleMembersPage.searchForNumber();
        /*Thread.sleep(1500);*/
    }

    @Test(priority = 10)
    public void clickSectorsTab() throws InterruptedException {
        CoyleMembersPage.clickSectorsBtn();
    }

    @Test(priority = 11)
    public void clickAddSectorBtn(){

        CoyleMembersPage.clickAddSectorBtn();
    }

    @Test(priority = 12)
    public void typeSectorName() throws InterruptedException {
        CoyleMembersPage.typeSectorName();
    }

    @Test(priority = 13)
    public void searchSectorNumber() throws InterruptedException {
        CoyleMembersPage.searchForSector();
        /*Thread.sleep(1500);*/
    }



    /*@AfterClass
    public void tearDown(){
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        driver.quit();
    }*/

}
