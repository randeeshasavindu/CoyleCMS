package com.coylecms.qa.pages;

import com.coylecms.qa.base.TestBase;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class CoyleMembersPage extends TestBase {

    WebDriverWait wait;
    public int number;

    @FindBy(xpath = "//img[contains(@src, 'logo')]")
    WebElement CoyleLogo;

    @FindBy(xpath = "//p[contains(text(),'Chamber of Young Lankan Entrepreneurs')]")
    WebElement CoyleName;

    @FindBy(xpath = "//p[normalize-space()='COYLE Members']")
    WebElement CoyleMembersTab;

    @FindBy(xpath = "//p[normalize-space()='Categories']")
    WebElement CategoriesBtn;

    @FindBy(xpath = "//p[normalize-space()='Sectors']")
    WebElement SectorsBtn;

    @FindBy(xpath = "//p[normalize-space()='Companies']")
    WebElement CompaniesBtn;

    @FindBy(xpath = "//button[@class='btn parent_active px-5 py-2']")
    WebElement AddCategoriesBtn;

    @FindBy(xpath = "//input[@id='mat-input-1']" )
    WebElement enterCatNumber;

    @FindBy(xpath = "//mat-option[@id='mat-option-0']")
    WebElement category1;

    @FindBy(xpath = "//mat-option[@id='mat-option-1']")
    WebElement category2;

    @FindBy(xpath = "//div[@id='mat-select-value-1']")
    WebElement clickCategoryDropDown;

    @FindBy(xpath = "//button[@class='btn parent_active px-5 py-2 mx-3 ng-star-inserted']")
    WebElement addBtn;

    @FindBy(xpath = "//p[normalize-space()='Members']")
    WebElement MembersBtn;

    @FindBy(xpath = "//p[normalize-space()='Events']")
    WebElement EventsTab ;

    @FindBy(xpath = "//p[normalize-space()='News']")
    WebElement NewsTab;

    @FindBy(xpath = "//p[normalize-space()='Account Settings']")
    WebElement AccountSettingsTab ;

    @FindBy(xpath = "//p[normalize-space()='Logout']")
    WebElement LogoutBtn;

    @FindBy(xpath = "//button[@class='btn parent_active px-5 py-2']")
    WebElement addSectorBtn;

    public CoyleMembersPage(){
        PageFactory.initElements(driver,this);
    }

    //actions
    public String  validateTitleOfTheDBPage(){
        return driver.getTitle();
    }

    public boolean validateLogoDisplay(){
        return CoyleLogo.isDisplayed();
    }

    public boolean validateCoyleNameDisplay(){
        return CoyleName.isDisplayed();

    }

    public void clickCoyleMembersTab() throws InterruptedException {
        CoyleMembersTab.click();
        Thread.sleep(3000);
    }


    public void clickAddCategoriesBtn(){
        AddCategoriesBtn.click();
    }

    public Void addRandomNumberToCategory(String number) throws InterruptedException {
        enterCatNumber.clear();  // Clear the field first
        enterCatNumber.sendKeys("Category " + number);  // Send the generated number
        Thread.sleep(3000);
        return null;
    }

    public void selectCategory() throws InterruptedException {
        clickCategoryDropDown.click();
        Thread.sleep(3000);
        category1.click();
        category2.click();
        Thread.sleep(3000);
    }

    public void clickAdd() throws InterruptedException {
        WebElement popupBG = driver.findElement(By.xpath("//div[@class='cdk-overlay-backdrop cdk-overlay-transparent-backdrop cdk-overlay-backdrop-showing']"));
        popupBG.click();

        addBtn.click();
        Thread.sleep(3000);
        WebElement addSuccessMsgCloseBtn = driver.findElement(By.xpath("//mat-icon[normalize-space()='close']"));
        addSuccessMsgCloseBtn.click();
        Thread.sleep(3000);
    }

    public void searchForNumber() throws InterruptedException {
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='mat-input-0']"));  // Locate the search bar
        searchBar.click();
        searchBar.clear();  // Clear any existing text in the search bar
        String categoryName = "Category0001";
        for (char c : categoryName.toCharArray()) {
            searchBar.sendKeys(Character.toString(c)); //typing the text slowly
            Thread.sleep(200);
       /* searchBar.sendKeys("Category0001");
        *//*searchBar.sendKeys(Keys.ENTER);*/

    }}

    public void clickSectorsBtn() throws InterruptedException {
        SectorsBtn.click();
        Thread.sleep(2000);

    }

    public void clickAddSectorBtn(){
        addSectorBtn.click();
    }

    public void typeSectorName() throws InterruptedException {
        /*WebElement SectorName = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
        SectorName.click();
        Thread.sleep(1000);

        SectorName.sendKeys("TestAutomationSector");
        Thread.sleep(1000);*/

        // Wait for the popup to appear (explicit wait)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='px15_text col-12 mb-1 text-center']")));

// Now, locate the text field within the popup
        WebElement closeBtn = popup.findElement(By.xpath("//mat-icon[normalize-space()='close']"));

        Thread.sleep(3000);
        closeBtn.click();
        Thread.sleep(3000);
    }


// Enter text into the text field
        /*textField.sendKeys("AutomationSector");*/

        /*SectorNameField.sendKeys("TestAutomationSector");
        for (char c : "TestAutomationSector".toCharArray()) {
            SectorNameField.sendKeys(Character.toString(c)); //typing the text slowly
            Thread.sleep(200);*/
        public void searchForSector() throws InterruptedException {

            //verify the sectors title
/*
            WebElement verifySectorsTitle = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/mat-drawer-container/mat-drawer-content/section/app-sectors/section/div[1]/div[1]/h2"));
            String actualText = verifySectorsTitle.getText();

            String expectedText = "Sectors";

            assertEquals("Correct text is displayed",actualText,expectedText);*/

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement SectorSearchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-input-4\"]")));  // Locate the search bar
            SectorSearchBar.click();
            SectorSearchBar.clear();  // Clear any existing text in the search bar
            String sectorName = "TestSector0001";
            for (char c : sectorName.toCharArray()) {
                SectorSearchBar.sendKeys(Character.toString(c)); //typing the text slowly
                Thread.sleep(200);
                /* searchBar.sendKeys("Category0001");
                 *//*searchBar.sendKeys(Keys.ENTER);*/

            }}
    }














