package ru.gb.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ru.gb.locators.LoginPageLocators;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    // Метод позволяет работать с локаторами для нужной нам страницы.
    private LoginPageLocators locator() {
        return new LoginPageLocators();
    }

    @Step("Кликаем по кнопке 'LOGIN' в форме")
    public LoginPage clickLoginButton() {
        $(locator().loginButton()).click();
        return this;
    }

    @Step("Проверяем текст ошибки")
    public LoginPage checkLoginErrorText(String text) {
        $(locator().loginErrorText()).shouldHave(Condition.text(text));
        return this;
    }

    @Step("Вводим логин")
    public LoginPage inputLogin(String login) {
        $(locator().loginLogin()).sendKeys(login);
        return this;
    }

    @Step("Вводим пароль")
    public LoginPage inputPassword(String password) {
        $(locator().loginPassword()).sendKeys(password);
        return this;
    }

    @Step("Кликаем по кнопке 'LOGIN'")
    public LoginPage inputButtonClick() {
        $(locator().loginButton()).click();
        return this;
    }

    @Step("Проверяем корректность ввода логина и пароля")
    public LoginPage checkMessage(String text) {
        $(locator().happyText()).shouldHave(Condition.text(text));
        return this;
    }
}


