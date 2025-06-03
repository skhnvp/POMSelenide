package ru.stepup.pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

@Getter
public class MainPage {
    private final SelenideElement INFO_BUTTON = $("a[href=\"/information\"]");
    private final SelenideElement READY_TO_FLIGHT_BUTTON = $("a[href=\"/information#flight\"]");
    private final SelenideElement INFO_USEFUL_BUTTON = $("a[href=\"/information#useful\"]");
    private final SelenideElement INFO_COMPANY_BUTTON = $("a[href=\"/information#company\"]");
    private final SelenideElement IMG_LOGO = $("a.dp-1abiuov-root-root-root img[alt=\"«Авиакомпания «Победа», Группа «Аэрофлот»\"]");
    private final SelenideElement SEARCH_BLOCK = $("div.dp-13bei22-root-card");
    private final SelenideElement FROM_WHERE_SEARCH_INPUT = $("div.dp-9qwv4e-root input[placeholder=\"Откуда\"]");
    private final SelenideElement TO_WHERE_SEARCH_INPUT = $("div.dp-9qwv4e-root input[placeholder=\"Куда\"]");
    private final SelenideElement DEPARTING_SEARCH_INPUT = $("div.dp-9qwv4e-root input[placeholder=\"Туда\"]");
    private final SelenideElement DEPARTING_SEARCH_DIV = $("div.dp-9qwv4e-root div.dp-rryixc-root div.dp-1dr6zbu-root");
    private final SelenideElement RETURNING_SEARCH_INPUT = $("div.dp-9qwv4e-root input[placeholder=\"Обратно\"]");
    private final SelenideElement SUBMIT_SEARCH_BUTTON = $("button[type=\"submit\"].dp-g0u6ma-root-root");
    private final SelenideElement DROP_DOWN_SEARCH_MENU = $("div.dp-1ct2iey-root button[type=\"button\"]");
    private final SelenideElement BOOKING_RADIO_BUTTON = $("button.dp-mjn6ft-root-SegmentedControlGroupItem-root:nth-child(3)");
    private final SelenideElement BOOKING_SURNAME = $("input[placeholder=\"Фамилия клиента\"]");
    private final SelenideElement BOOKING_TICKET_NUMBER = $("input[placeholder=\"Номер бронирования или билета\"]");
    private final SelenideElement BOOKING_SEARCH_BUTTON = $("button.dp-1a9gei0-root-root");

    public MainPage() {
    }

    @Step(value = "Получение заголовка страницы")
    public String getTitleText() {
        return title();
    }

    @Step(value = "Получение логотипа страницы")
    public boolean isLogoPresent() {
        return IMG_LOGO.isDisplayed();
    }


    /* TODO
    * 1. переписать всю логику тестов, чтобы она хранилась в Page
    * 2. перенести аннотации Step
    * 3. проверки должны быть через селенидовский ассерт should, shouldBe, shouldHave
    * 4. при необходимости (если слишком громоздко)разделить страницу по функционали или:
    *
    * Если методов очепнь много, много разбить класс страницы на 2, или даже 3 части, в один странице,
    * например, положить элементы и клики, на второй действия, в третьей только проверки, будет более аккуратно выглядеть
    * */
}
