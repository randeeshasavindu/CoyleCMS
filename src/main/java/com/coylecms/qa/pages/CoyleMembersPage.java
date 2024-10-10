package com.coylecms.qa.pages;

import com.coylecms.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoyleMembersPage extends TestBase {

    WebDriverWait wait;
    public int number;

    @FindBy(xpath = "//img[contains(@src, 'logo')]")
    WebElement CoyleLogo;

    @FindBy(xpath = "//p[contains(text(),'Chamber of Young Lankan Entrepreneurs')]")
    WebElement CoyleName;

    @FindBy(xpath = "//p[normalize-space()='COYLE Members']")
    WebElement CoyleMembersTab;

    @FindBy(xpath = "/html/body/app-root/app-dashboard/mat-drawer-container/mat-drawer/div/div/div[2]/app-nav-parent/mat-tree/mat-nested-tree-node[1]/div[2]")
    WebElement expandedList;

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

    //initializing the dashboardPage

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

    public void clickCoyleMembersTab(){
        CoyleMembersTab.click();
    }

    public boolean validateExpandedList(){
        return expandedList.isDisplayed();
    }

    public void clickAddCategoriesBtn(){
        AddCategoriesBtn.click();
    }

    public Void addRandomNumberToCategory(String number){
        enterCatNumber.clear();  // Clear the field first
        enterCatNumber.sendKeys("Category " + number);  // Send the generated number
        return null;
    }

    public void selectCategory() throws InterruptedException {
        clickCategoryDropDown.click();
        Thread.sleep(1500);
        category1.click();
        category2.click();
    }

    public void clickAdd() throws InterruptedException {
        WebElement popupBG = driver.findElement(By.xpath("//div[@class='cdk-overlay-backdrop cdk-overlay-transparent-backdrop cdk-overlay-backdrop-showing']"));
        popupBG.click();

        addBtn.click();
        WebElement addSuccessMsgCloseBtn = driver.findElement(By.xpath("//mat-icon[normalize-space()='close']"));
        addSuccessMsgCloseBtn.click();
        Thread.sleep(1500);
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





}
