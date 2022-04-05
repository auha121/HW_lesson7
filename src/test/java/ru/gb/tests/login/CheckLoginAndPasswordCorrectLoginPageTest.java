package ru.gb.tests.login;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;

public class CheckLoginAndPasswordCorrectLoginPageTest extends BaseTest {

    public static String LOGIN = "Bill@yk.my";
    public static String PASSWORD = "12345678";
    public static String VALID_HAPPY_TEXT = "You are logged in!";

    @Test
    @Description("Проверяем корректный ввод логина и пароля")
    public void CheckLoginAndPasswordCorrect() {
        openApp()
                .clickLoginMenuButton()
                .inputLogin(LOGIN)
                .inputPassword(PASSWORD)
                .inputButtonClick()
                .checkMessage(VALID_HAPPY_TEXT);
    }
}
