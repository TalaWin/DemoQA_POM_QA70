📘 **DemoQA POM Project — Lesson 25 (JSExecutor + Alerts + Elements)**


This project implements UI test automation for https://demoqa.com

📌 Project Overview

This project was created as part of the QA70 training program and follows the Page Object Model (POM) design pattern.
It covers the following DemoQA modules:

Book Store Application (login + profile verification)
Alerts, Frame & Windows (timer alert, confirm alert)
Elements → Text Box (field highlighting using JavaScript)
The framework includes JavaScript execution support (JSExecutor) and extended base logic (BasePage).

Prepared as part of QA70 training.

## 📁 Project Structure

```
src/
├── main/
│   └── java/com/demoqa/
│       ├── core/
│       │   └── BasePage.java
│       │
│       ├── alertsFrameWindows/
│       │   └── AlertsPage.java
│       │
│       └── pages/
│           ├── HomePage.java
│           ├── SidePanel.java
│           ├── JSExecutor.java
│           │
│           └── bookstore/
│               ├── LoginPage.java
│               └── ProfilePage.java
│
└── test/
    └── java/com/demoqa/
        ├── core/
        │   └── TestBase.java
        │
        └── tests/
            ├── BookStoreTests.java
            ├── AlertsFrameWindowsTests.java
            └── ElementsTests.java
```

**🧩 Core Logic**

**_1. BasePage_**

A shared superclass containing reusable utilities:

* click(element) — safe click
* type(element, text) — click + clear + sendKeys
* scrollIntoView(element) — smooth scrolling
* clickWithJS(element) — JS click when Selenium is blocked
* typeWithJS(element, text) — JS-based text input
* closeFixedBannerIfPresent() — hides the bottom #fixedban ad
* getWait(seconds) — unified WebDriverWait
* isAlertPresent() — wait for and handle browser alerts

**_2. TestBase_**

Sets up the browser before each test:

launches Chrome
expands the window
sets implicit wait (10s)
opens https://demoqa.com
Shared environment for all tests.

**_3. HomePage_**

Navigation to the main DemoQA modules:

* selectBookStore()
* selectElements()
* selectAlertsFrameWindows()

**_4. SidePanel_**
Sidebar navigation inside DemoQA modules:

* selectLogin()
* selectTextBox()
* selectAlerts()

Each method returns the appropriate Page Object.

**_5. LoginPage_**

Handles login form

✔ enterUserData(name, password)

Inputs username and password.

✔ clickOnLoginButton()

Navigates to ProfilePage.

**_6. ProfilePage_*

✔ verifyUserName(name)

Asserts that the displayed username matches the expected one.
Detailed assertion messages are included for easier debugging.

**_7. JSExecutor_**
A helper class for operations that Selenium cannot handle reliably:

* highlights fields with colors
* sets input value directly via JavaScript
* clicks buttons via JS
* extracts innerText
* retrieves current URL
* refreshes page

**_Bookstore Module Pages_**

**_LoginPage_**
Handles username/password input and clicking the Login button.

**_ProfilePage_**
Validates that the logged-in username is displayed correctly.
Used in ElementsTests.

**_ProfilePage_**
**_AlertsPage

Supports:
* Timer Alert (alert appears after 5 seconds)
* Confirm Alert (OK / Cancel)
* Result message verification

**🧪 Tests**
Test Suites
**_BookStoreTests_**
login flow
profile username check

**_AlertsFrameWindowsTests_**
timer alert check
confirm alert (Cancel / OK)

**_ElementsTests_**
highlighting Text Box fields via JS
entering data with JS
clicking Submit with JS

🚀 How to Run Tests
Using IntelliJ IDEA

Right-click → Run test

Using Maven
mvn clean test

🧱 What was implemented in Lesson 25

* ✔ Added full navigation to Elements and Alerts, Frame & Windows
* ✔ Implemented JSExecutor page with custom JS interactions
* ✔ Added highlight logic for Text Box fields (green/red borders)
* ✔ Implemented clicking on Submit via JavaScript
* ✔ Implemented retrieving inner text & current URL
* ✔ Created full ElementsTests suite
* ✔ Added Alerts module with:
* ▸ waiting for timed alert (5 sec)
* ▸ handling Confirm alert (OK/Cancel)
* ▸ verifying alert result on the page
* ✔ Implemented AlertsPage following POM best practices
* ✔ Extended SidePanel with new menu actions
* ✔ Stabilized navigation using scrollIntoView + banner protection
* ✔ Added clean test scenarios with chaining (fluent API)

**_📦 Technologies Used_**
Java 17
Selenium 4.36+
JUnit 5
Maven
Page Object Model (POM)