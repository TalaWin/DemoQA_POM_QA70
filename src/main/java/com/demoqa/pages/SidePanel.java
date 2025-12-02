package com.demoqa.pages;

import com.demoqa.core.BasePage;
import com.demoqa.pages.bookstore.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {

    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Login']")
    WebElement login;

    public LoginPage selectLogin() {
        closeFixedBannerIfPresent();
        click(login);
        return new LoginPage(driver);
    }
}
