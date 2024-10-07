package com.coylecms.qa.pages;

import com.coylecms.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(xpath = "//input[@placeholder=' Email']")
    WebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(xpath = "//button[@class='mt-3 w-100 btn button_submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//a[@class='paragraph-text px-2 my-auto']")
    WebElement forgot_pw;

    @FindBy(xpath = "//input[@id='remember_me']")
    WebElement rememberMe_chkBox;

    @FindBy(xpath = "/html/body/app-root/app-login/div/div/div/div/div[1]/img")
    WebElement COYLELogo;

    //initializing the page object
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    //actions
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateCOYLEImage(){
        return COYLELogo.isDisplayed();
    }

    public DashboardPage login(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();

        return new DashboardPage();

    }
}
