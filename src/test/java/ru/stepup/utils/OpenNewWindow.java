package ru.stepup.utils;

import com.codeborne.selenide.WebDriverRunner;

public class OpenNewWindow {
    public static void wait(String originalWindow) {
        for (String window : WebDriverRunner.getWebDriver().getWindowHandles()) {
            if (!window.equals(originalWindow)) {
                WebDriverRunner.getWebDriver().switchTo().window(window);
                break;
            }
        }
    }
}
