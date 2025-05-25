package ru.stepup.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;
import ru.stepup.BaseTest;
import ru.stepup.pages.BookingPage;
import ru.stepup.pages.MainPage;
import ru.stepup.utils.OpenNewWindow;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.title;
import static org.assertj.core.api.Assertions.*;

public class PobedaTests extends BaseTest {
    MainPage mainPage = new MainPage();;
    @Test
    public void testModalWindow() {
        mainPage.getInfoButton().hover();

        assertThat(mainPage.isLogoPresent()).isTrue();
        assertThat(mainPage.getTitleText()).isEqualTo("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");

        assertThat(mainPage.getInfoCompanyButton().isDisplayed()).isTrue();
        assertThat(mainPage.getInfoUsefulButton().isDisplayed()).isTrue();
        assertThat(mainPage.getReadyToFlightButton().isDisplayed()).isTrue();
    }

    @Test
    public void testSearchTickets() {
        assertThat(mainPage.isLogoPresent()).isTrue();
        assertThat(mainPage.getTitleText()).isEqualTo("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");

        mainPage.getSearchBlock().scrollTo();
        assertThat(mainPage.getFromWhereSearchInput().isDisplayed()).isTrue();
        assertThat(mainPage.getToWhereSearchInput().isDisplayed()).isTrue();
        assertThat(mainPage.getDepartingSearchInput().isDisplayed()).isTrue();
        assertThat(mainPage.getReturningSearchInput().isDisplayed()).isTrue();

        mainPage.getFromWhereSearchInput().setValue("Санкт-Петербург").pressEnter();
        mainPage.getToWhereSearchInput().setValue("Москва").pressEnter();
        mainPage.getSubmitSearchButton().click();

        mainPage.getDepartingSearchDiv()
                .shouldHave(cssValue("border-top-color", "rgba(213, 0, 98, 1)"));
    }

    @Test
    public void testSearchBookings() {
        assertThat(mainPage.isLogoPresent()).isTrue();
        assertThat(mainPage.getTitleText()).isEqualTo("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");

        mainPage.getBookingRadioButton().click();

        assertThat(mainPage.getBookingSurname().isDisplayed()).isTrue();
        assertThat(mainPage.getBookingTicketNumber().isDisplayed()).isTrue();
        assertThat(mainPage.getBookingSearchButton().isDisplayed()).isTrue();

        String firstWindow = WebDriverRunner.getWebDriver().getWindowHandle();

        mainPage.getBookingSurname().setValue("Qwerty");
        mainPage.getBookingTicketNumber().setValue("XXXXXX");
        mainPage.getBookingSearchButton().click();

        OpenNewWindow.wait(firstWindow);

        webdriver().shouldHave(title("Просмотр заказа"));

        BookingPage bookingPage = new BookingPage();

        bookingPage.getCheckBoxAgreement().click();
        bookingPage.getButtonSearch().click();
        assertThat(bookingPage.getErrorMessage().isDisplayed()).isTrue();
        assertThat(bookingPage.getErrorMessage().getText()).isEqualTo("Заказ с указанными параметрами не найден");
    }
}
