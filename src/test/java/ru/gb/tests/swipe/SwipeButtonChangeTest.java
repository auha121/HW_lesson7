package ru.gb.tests.swipe;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;
import ru.gb.listeners.AllureListener;

@Listeners(AllureListener.class)
public class SwipeButtonChangeTest extends BaseTest {

    @Test
    @Description("Проверяем переключение Swipe")
    public void swipeButtonChange() {
        openApp()
                .clickSwipeButton()
                .clickSwipeFirstChange()
                .clickSwipeButtonChange(3)
                .clickSwipeButtonChange(2)
                .clickSwipeButtonChange(1)
                .clickSwipeButtonChange(5)
                .clickSwipeButtonChange(1);
    }

}
