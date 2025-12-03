package com.demoqa.pages;

import com.demoqa.alertsFrameWindows.AlertsPage;
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

    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBox;

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;


    public LoginPage selectLogin() {
        closeFixedBannerIfPresent();
        scrollIntoView(login);
        click(login);
        return new LoginPage(driver);
    }


    public JSExecutor selectTextBox() {
        closeFixedBannerIfPresent();
        scrollIntoView(textBox);
        click(textBox);
        return new JSExecutor(driver);
    }


    public AlertsPage selectAlerts() {
        closeFixedBannerIfPresent();
        scrollIntoView(alerts);
        click(alerts);
        return new AlertsPage(driver);
    }
}
