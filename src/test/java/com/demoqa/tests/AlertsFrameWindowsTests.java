package com.demoqa.tests;

import com.demoqa.alertsFrameWindows.AlertsPage;
import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlertsFrameWindowsTests extends TestBase {

    SidePanel sidePanel;
    AlertsPage alerts;

    @BeforeEach
    public void precondition() {
        new HomePage(driver).selectAlertsFrameWindows();
        sidePanel = new SidePanel(driver);
        alerts = new AlertsPage(driver);
    }

    @Test
    @DisplayName("Проверка alert, который появляется через 5 сек")
    public void waitAlertTest() {
        sidePanel.selectAlerts();
        alerts.verifyAlertWithTime();
    }

    @Test
    @DisplayName("Проверка выбора Cancel в Confirm Alert")
    public void alertWithSelectResultTest() {
        sidePanel.selectAlerts();
        alerts
                .clickOnConfirmButton()
                .selectResult("Cancel")
                .verifyResult("Cancel");
    }
}
