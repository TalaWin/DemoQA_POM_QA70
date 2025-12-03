       📘 **DemoQA POM Project — Lesson 24 (Book Store Login)**

This project implements UI test automation for https://demoqa.com

using the Page Object Model (POM) structure.
It covers the Book Store Application module, including:

* navigating to the Book Store section
* opening the side panel menu
* performing user login
* validating displayed username

Prepared as part of QA70 training.

## 📁 Project Structure

```
src/
├── main/
│   └── java/com/demoqa/
│       ├── core/
│       │   └── BasePage.java
│       └── pages/
│           ├── HomePage.java
│           ├── SidePanel.java
│           └── bookstore/
│               ├── LoginPage.java
│               └── ProfilePage.java
│
└── test/
    └── java/com/demoqa/
        ├── core/
        │   └── TestBase.java
        └── tests/
            └── BookStoreTests.java
```


**1. BasePage**

Base class containing common utilities:

✔ click(element)

Standard Selenium WebDriver click.

✔ type(element, text)

Click → clear → sendKeys
Ensures clean and stable text input.

✔ scrollIntoView(element)

Scrolls smoothly to an element

shifts the viewport slightly upward to avoid footer overlap.

✔ clickWithJS(element)

JavaScript click — used when Selenium click is blocked by overlays.

✔ typeWithJS(element, text)

JavaScript value injection (rarely needed).

✔ closeFixedBannerIfPresent()

Hides DemoQA’s #fixedban advertisement block
— prevents footer from intercepting clicks.
This solves a common DemoQA interaction issue.

**2. TestBase**

Sets up the browser before each test:

launches Chrome

expands the window

sets implicit wait (10s)

opens https://demoqa.com

Shared environment for all tests.

**3. HomePage**

Handles top-level navigation.

✔ selectBookStore()

closes fixed banner

scrolls to the Book Store card

clicks it

returns new SidePanel instance

**4. SidePanel**

Interacts with the left vertical menu.

✔ selectLogin()

closes the banner

scrolls into view

clicks “Login”

returns LoginPage

**5. LoginPage**

Handles login form.

✔ enterUserData(name, password)

Inputs username and password.

✔ clickOnLoginButton()

Navigates to ProfilePage.

**6. ProfilePage**
   
✔ verifyUserName(name)

Asserts that the displayed username matches the expected one.
Detailed assertion messages are included for easier debugging.

**🧪 Tests**
BookStoreTests

Flow:

* Open Book Store
* Select “Login”
* Enter credentials
* Click Login
* Validate username

Example:

new SidePanel(driver).selectLogin();
new LoginPage(driver)
.enterUserData("TalaQwerty", "Aa345678!")
.clickOnLoginButton()
.verifyUserName("TalaQwerty");

🧱 What was implemented in Lesson 24
* ✔ Complete POM architecture for Book Store
* ✔ Automatic closing of blocking banner
* ✔ Safe scrolling & clicking strategies
* ✔ Correct page-to-page transitions
* ✔ Username verification
* ✔ Strong base for future expansion (Elements, Alerts, JSExecutor, etc.)

* 🚀 Ready for Next Lessons

This project now serves as a stable foundation for:
* Elements module → TextBox
* JS Executor tasks
* Alerts / Frames
* Select / MoveToElement
* Upload & Download
* Widgets
* Forms