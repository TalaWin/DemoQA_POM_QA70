package com.demoqa.core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    protected JavascriptExecutor js;

    @FindBy(id = "fixedban")
    WebElement fixedBanner;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.js = (JavascriptExecutor) driver;
    }

    public void click(WebElement element) {
        element.click();
    }


    public void type(WebElement element, String text) {
        if (text != null) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }


    public void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("window.scrollBy(0, -150);");

    }


    public void clickWithJS(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
    }


    public void typeWithJS(WebElement element, String text) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].value = arguments[1];", element, text);
    }


    public void closeFixedBannerIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOf(fixedBanner));
            js.executeScript("arguments[0].style.display='none';", fixedBanner);
        } catch (TimeoutException | NoSuchElementException e) {

        }
    }


    public WebDriverWait getWait(int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }


    public boolean isAlertPresent(int seconds) {
        try {
            Alert alert = getWait(seconds)
                    .until(ExpectedConditions.alertIsPresent());
            if (alert == null) {
                return false;
            } else {
                driver.switchTo().alert().accept();
                return true;
            }
        } catch (TimeoutException e) {
            return false;
        }
    }


    public boolean isContains(String text, WebElement element) {
        return element.getText().contains(text);
    }
}