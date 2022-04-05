package ru.gb.locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class SwipePageLocators {
    public By swipeButton(Integer swipe_number) {
        return MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Carousel\"]/android.view.ViewGroup["+ swipe_number + "]/android.view.ViewGroup");
    }

    public By swipeScreen() {
        return MobileBy.AccessibilityId("Swipe-screen");
    }
}
