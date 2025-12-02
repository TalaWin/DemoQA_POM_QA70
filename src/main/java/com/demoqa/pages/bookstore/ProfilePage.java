package com.demoqa.pages.bookstore;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement userNameValue;

    public ProfilePage verifyUserName(String name) {
        Assertions.assertTrue(
                userNameValue.getText().contains(name),
                "Ожидалось имя пользователя: " + name +
                        ", а на странице отображается: " + userNameValue.getText()
        );
        return this;
    }
}
