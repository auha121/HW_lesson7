package ru.gb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.gb.locators.SwipePageLocators;

import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class SwipePage{

    // Метод позволяет работать с локаторами для нужной нам страницы.
    private SwipePageLocators locator() {
        return new SwipePageLocators();
    }

    @Step("Первое движение Swipe")
    public SwipePage clickSwipeFirstChange() {
        $(locator().swipeButton(1)).waitUntil(Condition.visible, 1000);
        WebDriver driver = WebDriverRunner.getWebDriver();
        new TouchAction((PerformsTouchActions) driver)
                // Точка куда нажимаем и держим
                .press(PointOption.point(540, 1080))
                //  Время удержания
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                // Точка куда движется свайп
                .moveTo(PointOption.point(50,1080))
                .release().perform();
        return this;
    }

    @Step("Swipe в положении {swipe_number}")
    public SwipePage clickSwipeButtonChange(Integer swipe_number) {
        $(locator().swipeButton(swipe_number)).click();
        return this;
    }

    @Step("Делаем скриншот {imageName} страницы и сравниваем с требованием.")
    public SwipePage checkScreenshot(String imageName, String methodName) {
        // Загружаем ожидаемое изображения для сравнения.
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources("src/main/resources/expectedScreenshots/" + imageName);
        // Делаем актуальный скриншот, используя элемент и игнорируя другие части экрана.
        File actualScreenshot = $(locator().swipeScreen()).screenshot();
        // Загружаем актуальный скриншот.
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources("screenshots/actual/" + actualScreenshot.getName());

        // Где будем хранить скриншот с различиями в случае падения теста.
        File resultDestination = new File("diff/diff_" + methodName + ".png");

        // Сравниваем.
        ImageComparisonResult imageComparisonResult = new ImageComparison(expectedImage, actualImage, resultDestination).compareImages();
        assertEquals(ImageComparisonState.MATCH, imageComparisonResult.getImageComparisonState());
        return this;
    }
}
