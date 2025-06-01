package ru.stepup.utils;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;

public class AllureAttachments {
    public static void screenshot(String name) {
        Allure.addAttachment(
                name,
                "image/png",
                new ByteArrayInputStream(Selenide.screenshot(OutputType.BYTES)),
                "png"
        );
    }
}
