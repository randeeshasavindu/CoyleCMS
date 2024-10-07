package com.coylecms.qa.pages;

import com.coylecms.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends TestBase {

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

    public DashboardPage(){
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

    public void clickCategoriesBtn(){
        CategoriesBtn.click();
    }






}
