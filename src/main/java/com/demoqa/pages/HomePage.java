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

    public SidePanel selectBookStore() {
        closeFixedBannerIfPresent();
        scrollIntoView(bookStore);
        click(bookStore);
        return new SidePanel(driver);
    }
}
