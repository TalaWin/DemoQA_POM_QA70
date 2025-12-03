package com.demoqa.alertsFrameWindows;

import com.demoqa.core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public AlertsPage verifyAlertWithTime() {
        click(timerAlertButton);

        Alert alert = getWait(7).until(ExpectedConditions.alertIsPresent());
        alert.accept();

        return this;
    }

    public AlertsPage clickOnConfirmButton() {
        click(confirmButton);
        return this;
    }

    public AlertsPage selectResult(String text) {
        Alert alert = getWait(5).until(ExpectedConditions.alertIsPresent());

        if (text.equalsIgnoreCase("Cancel")) {
            alert.dismiss();
        } else {
            alert.accept();
        }

        return this;
    }


    public AlertsPage verifyResult(String text) {
        String result = confirmResult.getText();

        if (!result.contains(text)) {
            throw new AssertionError("Ожидалось: " + text + ", но на странице: " + result);
        }

        return this;
    }
}
