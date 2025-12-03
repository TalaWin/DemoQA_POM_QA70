package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".card:nth-child(6)")
    WebElement bookStore;

    @FindBy(css = ".card:nth-child(1)")
    WebElement elements;

    @FindBy(css = ".card:nth-child(3)")
    WebElement alertsFrameWindows;

    public SidePanel selectBookStore() {
        closeFixedBannerIfPresent();
        scrollIntoView(bookStore);
        click(bookStore);
        return new SidePanel(driver);
    }

    public SidePanel selectElements() {
        closeFixedBannerIfPresent();
        scrollIntoView(elements);
        click(elements);
        return new SidePanel(driver);
    }

    public SidePanel selectAlertsFrameWindows() {
        closeFixedBannerIfPresent();
        scrollIntoView(alertsFrameWindows);
        click(alertsFrameWindows);
        return new SidePanel(driver);
    }
}
