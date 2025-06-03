package ru.stepup.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

@Getter
public class BookingPage {
    private final SelenideElement CHECK_BOX_AGREEMENT = $("div.customCheckbox");
    private final SelenideElement BUTTON_SEARCH = $("button.btn_search");
    private final SelenideElement ERROR_MESSAGE = $("div.message_error");

    public BookingPage() {}

    @Step(value = "Получение заголовка страницы")
    public String getTitleText() {
        return title();
    }
}
