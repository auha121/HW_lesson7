package ru.gb.tests.swipe;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;
import ru.gb.listeners.AllureListener;

@Listeners(AllureListener.class)
public class CheckScreenshotSwipePageTest extends BaseTest {

    @Test
    @Description("Проверяем UI страницы Swipe с помощью скриншота.")
    public void CheckScreenshotSwipePage() {
        openApp()
                .clickSwipeButton()
                .checkScreenshot("swipePage.png", "CheckScreenshotSwipePage");
    }
}
