package ru.stepup.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

@Getter
public class BookingPage {
    private SelenideElement checkBoxAgreement = $("div.customCheckbox");
    private SelenideElement buttonSearch = $("button.btn_search");
    private SelenideElement errorMessage = $("div.message_error");

    public BookingPage() {}

    public String getTitleText() {
        return title();
    }
}
