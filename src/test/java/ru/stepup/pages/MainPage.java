package ru.stepup.pages;


import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

@Getter
public class MainPage {
    private SelenideElement infoButton = $("a[href=\"/information\"]");
    private SelenideElement readyToFlightButton = $("a[href=\"/information#flight\"]");
    private SelenideElement infoUsefulButton = $("a[href=\"/information#useful\"]");
    private SelenideElement infoCompanyButton = $("a[href=\"/information#company\"]");
    private SelenideElement imgLogo = $("a.dp-1abiuov-root-root-root img[alt=\"«Авиакомпания «Победа», Группа «Аэрофлот»\"]");
    private SelenideElement searchBlock = $("div.dp-13bei22-root-card");
    private SelenideElement fromWhereSearchInput = $("div.dp-9qwv4e-root input[placeholder=\"Откуда\"]");
    private SelenideElement toWhereSearchInput = $("div.dp-9qwv4e-root input[placeholder=\"Куда\"]");
    private SelenideElement departingSearchInput = $("div.dp-9qwv4e-root input[placeholder=\"Туда\"]");
    private SelenideElement departingSearchDiv = $("div.dp-9qwv4e-root div.dp-rryixc-root div.dp-1dr6zbu-root");
    private SelenideElement returningSearchInput = $("div.dp-9qwv4e-root input[placeholder=\"Обратно\"]");
    private SelenideElement submitSearchButton = $("button[type=\"submit\"].dp-g0u6ma-root-root");
    private SelenideElement dropDownSearchMenu = $("div.dp-1ct2iey-root button[type=\"button\"]");
    private SelenideElement bookingRadioButton = $("button.dp-mjn6ft-root-SegmentedControlGroupItem-root:nth-child(3)");
    private SelenideElement bookingSurname = $("input[placeholder=\"Фамилия клиента\"]");
    private SelenideElement bookingTicketNumber = $("input[placeholder=\"Номер бронирования или билета\"]");
    private SelenideElement bookingSearchButton = $("button.dp-1a9gei0-root-root");

    public MainPage() {
    }

    public String getTitleText() {
        return title();
    }

    public boolean isLogoPresent() {
        return imgLogo.isDisplayed();
    }
}
