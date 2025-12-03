package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * JSExecutor – "лаборатория JavaScript" для demoqa.
 * <p>
 * Зачем он нам:
 * - показать, как выполнять JavaScript из теста;
 * - уметь подсвечивать элементы (рамки, фон) для скринов;
 * - уметь брать URL, title, весь текст страницы;
 * - уметь обновлять страницу и переходить по URL через JS.
 * <p>
 * В обычных тестах мы используем Selenium (click(), sendKeys()).
 * Здесь – демонстрируем, что можно делать поверх этого через js.executeScript(...).
 */
public class JSExecutor extends BasePage {

    // Конструктор: просто передаём драйвер в BasePage,
    // там уже инициализируется js = (JavascriptExecutor) driver;
    public JSExecutor(WebDriver driver) {
        super(driver);
    }


    /**
     * Класс-«робот», который работает напрямую через JavaScript:
     * - заполняет поля по id,
     * - меняет цвет рамок,
     * - кликает по кнопкам,
     * - читает URL, текст и т.п.
     * robot сам красит поля, чтобы мы могли сделать скрин и показать разработчику.
     */

    // Вводим имя и email + подсвечиваем поля разными цветами
    public JSExecutor enterPersonalData(String name, String email) {

        // Заполняем поле Full Name по id='userName'
        js.executeScript(
                "document.getElementById('userName').value='" + name + "';"
        );

        // Ставим зелёную рамку 5px у Full Name
        js.executeScript(
                "document.getElementById('userName').style.border='5px solid green';"
        );

        // Заполняем поле Email по id='userEmail'
        js.executeScript(
                "document.getElementById('userEmail').value='" + email + "';"
        );

        // Ставим красную рамку 3px у Email
        js.executeScript(
                "document.getElementById('userEmail').style.border='3px solid red';"
        );

        // возвращаем this, чтобы можно было писать цепочку:
        // new JSExecutor(driver).enterPersonalData(...).clickOnSubmitButton();
        return this;
    }

    /**
     * Нажать на кнопку Submit через JavaScript и подсветить её.
     * Используем на той же странице Text Box.
     * <p>
     * // Кликаем по Submit и красим кнопку
     */
    public JSExecutor clickOnSubmitButton() {

        // Нажимаем на кнопку с id='submit'
        js.executeScript("document.querySelector('#submit').click();");

        // Красим кнопку в красный для наглядности
        js.executeScript(
                "document.querySelector('#submit').style.backgroundColor='red';"
        );

        return this;
    }

    /**
     * Получить весь текст страницы (innerText) и вывести в консоль.
     * Полезно как демонстрация: JS может вернуть сразу все тексты,
     * даже если мы не знаем, где они лежат.
     */

    // Опционально: вывести весь текст страницы в консоль
    public JSExecutor getInnerText() {
        String innerText = js
                .executeScript("return document.documentElement.innerText;")
                .toString();
        System.out.println("===== INNER TEXT START =====");
        System.out.println(innerText);
        System.out.println("===== INNER TEXT END =====");
        return this;
    }

    /**
     * Вывести в консоль текущий URL через JS.
     * Аналог driver.getCurrentUrl(), но демонстрирует доступ к document.URL.
     */

    // Опционально: вывести текущий URL
    public JSExecutor verifyUrl() {
        String url = js.executeScript("return document.URL;").toString();
        System.out.println("URL (document.URL) = " + url);
        System.out.println("==========================================");
        return this;
    }

    /**
     * Обновить страницу через JavaScript.
     * Аналог driver.navigate().refresh(), только через history.go(0).
     */

    // Опционально: обновить страницу
    public JSExecutor refreshPage() {
        js.executeScript("history.go(0);");
        return this;
    }

    /**
     * Перейти на новый URL через JS.
     * По сути то же самое, что driver.get(url),
     * но здесь мы меняем window.location.
     */

    // Опционально: перейти на другую страницу
    public JSExecutor navigateToNewTab(String url) {
        js.executeScript("window.location='" + url + "';");
        return this;
    }

    /**
     * Получить заголовок вкладки (document.title) и вывести в консоль.
     * Полезно для быстрой проверки, что мы попали на нужную страницу.
     */
    // Опционально: вывести title вкладки
    public JSExecutor verifyNewPageIconTitle() {
        String iconTitle = js.executeScript("return document.title;").toString();
        System.out.println("iconTitle -> " + iconTitle);
        return this;
    }
}

/*Коротко: что мы этим классом проверяем

Что мы умеем дергать JavaScript из тестов:
менять значения полей,
менять стили (border, background),
вызывать .click(), .refresh(), менять window.location.

Что страница действительно реагирует на наши JS-действия:
поля заполнились,
рамки подсветились,
кнопка стала красной,
URL / title совпадают с ожидаемыми.

Когда использовать:
когда нужно подсветить элементы для скриншотов / дебага;
когда Selenium-клик не срабатывает (перекрытия, странные слушатели на странице);
когда нужны данные из document: URL, title, innerText и т.п.;
как учебный пример для интервью: «Да, я работала с JavascriptExecutor, вот примеры».*/


/*Зачем вообще нужен JSExecutor?

Цель урока:
Показать, что WebDriver умеет выполнять JavaScript в браузере через JavascriptExecutor.
Научить, когда JS может помочь, если:
обычный Selenium-клик/ввод не срабатывает,
нужно сделать что-то, что Selenium вообще не умеет (например, перекрасить элемент, вытащить document.URL, document.title, весь текст страницы и т.п.).
Сделать «демо-сценарий» типа:
робот заходит на Elements → Text Box,
сам заполняет поля Full Name / Email,
подкрашивает рамки разными цветами,
нажимает Submit и подсвечивает кнопку.
Этот класс — не класс страницы, а «лаборатория для JavaScript», где мы тренируемся управлять страницей именно через JS.
Где он используется в проекте
Типичный тест (потом напишем ElementsTests, но логику тебе важно понять):
new HomePage(driver).selectElements();
→ переходим в раздел Elements.

sidePanel.selectTextBox();
→ слева выбираем пункт Text Box.

new JSExecutor(driver)
→ создаём наш «JS-инструмент».

.enterPersonalData("TalaQwerty", "tala@example.com")
→ через JS заполняем поля и подсвечиваем их.

.clickOnSubmitButton()
→ нажимаем кнопку Submit и красим её в красный.

Обычно Selenium хватило бы, чтобы ввести текст и нажать кнопку.
Но перекрасить рамки / кнопку, дернуть произвольные JS-функции — это уже чистый JavaScript, и мы именно это здесь отрабатываем.*/
