package com.coylecms.qa.pages;

import com.coylecms.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsPage extends TestBase {

    LoginPage loginPage;

    @FindBy(xpath = "//p[normalize-space()='News']")
    WebElement NewsTabBtn;

    public void LoginPage(){
        PageFactory.initElements(driver,this);
    }

    //actions

    //click news tab button
    public void clickNewsTabBtn(){
        NewsTabBtn.click();
    }
    //verify the display of News page
    public void verifyNewsPageSubTitle(){
        WebElement newSubTitle = driver.findElement(By.xpath("//p[@class='light_text_color px15_text']"));

        String newsSubTitleText = newSubTitle.getText();

        // Verify the title by checking if it contains the expected value
        if (newsSubTitleText.contains("All of the News are shown below.")) {
            System.out.println("News title is displayed correctly: " + newsSubTitleText);
        } else {
            System.out.println("News title is incorrect or not found!");
        }
    }
}