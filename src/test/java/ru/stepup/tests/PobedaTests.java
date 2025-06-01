package ru.stepup.tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import ru.stepup.BaseTest;
import ru.stepup.pages.BookingPage;
import ru.stepup.pages.MainPage;
import ru.stepup.utils.AllureAttachments;
import ru.stepup.utils.OpenNewWindow;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.*;


@Epic(value = "StepUp Java-Selenide-Allure Tests")
public class PobedaTests extends BaseTest {
    MainPage mainPage = new MainPage();;

    @Severity(value = SeverityLevel.CRITICAL)
    @Feature(value = "Pobeda")
    @Description("Проверка начальной страницы")
    @TmsLink(value = "https://testit.link/test1")
    @Link(name = "Документация", url = "https://online.stepup.study/viewer/sessions/5845/tasks/2558")
    @Story(value = "https://online.stepup.study/viewer/sessions/5845/tasks/2558")
    @Test(description = "Задание №1. Page Object. Всплывающее окно")
    public void testModalWindow() {
        step("Текст заголовка страницы: Авиакомпания «Победа» - купить билеты на самолёт дешево онлайн, прямые и трансферные рейсы;\n"+
                "на странице есть логотип Победы.", () -> {
            assertThat(mainPage.isLogoPresent()).isTrue();
            assertThat(mainPage.getTitleText()).isEqualTo("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");
        });

        step("Навести мышку на пункт «Информация»", () -> {
            mainPage.getInfoButton().hover();
        });

        step("Убедиться, что появилось всплывающее окно, которое содержит следующие заголовки: «Подготовка к полету», «Полезная информация», «О компании»", () -> {
            assertThat(mainPage.getInfoCompanyButton().isDisplayed()).isTrue();
            assertThat(mainPage.getInfoUsefulButton().isDisplayed()).isTrue();
            assertThat(mainPage.getReadyToFlightButton().isDisplayed()).isTrue();
        });

        AllureAttachments.screenshot("Всплывающее окно");
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @Feature(value = "Pobeda")
    @Description("Проверка ошибки поиска")
    @TmsLink(value = "https://testit.link/test2")
    @Link(name = "Документация", url = "https://online.stepup.study/viewer/sessions/5845/tasks/2559")
    @Story(value = "https://online.stepup.study/viewer/sessions/5845/tasks/2559")
    @Test(description = "Задание №2. Page Object. Инициирование поиска")
    public void testSearchTickets() {
        step("Текст заголовка страницы: Авиакомпания «Победа» - купить билеты на самолёт дешево онлайн, прямые и трансферные рейсы;\n"+
                "на странице есть логотип Победы.", () -> {
            assertThat(mainPage.isLogoPresent()).isTrue();
            assertThat(mainPage.getTitleText()).isEqualTo("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");
        });

        step("Проскроллить страницу к блоку поиска билета и убедиться, что блок с поиском билета действительно отображается (есть поле Откуда, Куда, Дата вылета Туда, Дата вылета Обратно)", () -> {
            mainPage.getSearchBlock().scrollTo();
            assertThat(mainPage.getFromWhereSearchInput().isDisplayed()).isTrue();
            assertThat(mainPage.getToWhereSearchInput().isDisplayed()).isTrue();
            assertThat(mainPage.getDepartingSearchInput().isDisplayed()).isTrue();
            assertThat(mainPage.getReturningSearchInput().isDisplayed()).isTrue();
        });


        step("Выбрать (или ввести) следующие критерии поиска:\n" +
                "откуда – Москва (без выбора аэропорта) + нажать Enter\n" +
                "куда – Санкт-Петербург + нажать Enter\n" +
                "Нажать кнопку «Поиск».", () -> {
            mainPage.getFromWhereSearchInput().setValue("Санкт-Петербург").pressEnter();
            mainPage.getToWhereSearchInput().setValue("Москва").pressEnter();
            mainPage.getSubmitSearchButton().click();
        });


        step("Убедиться, что около поля «Туда» появилась красная обводка.", () -> {
            mainPage.getDepartingSearchDiv()
                    .shouldHave(cssValue("border-top-color", "rgba(213, 0, 98, 1)"));
        });

        AllureAttachments.screenshot("Красная обводка");
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @Feature(value = "Pobeda")
    @Description("Проверка обводки при ошибке поиска брони")
    @TmsLink(value = "https://testit.link/test3")
    @Link(name = "Документация", url = "https://online.stepup.study/viewer/sessions/5845/tasks/2560")
    @Story(value = "https://online.stepup.study/viewer/sessions/5845/tasks/2560")
    @Test(description = "Задание №3. Page Object. Результаты поиска")
    public void testSearchBookings() {
        step("Текст заголовка страницы: Авиакомпания «Победа» - купить билеты на самолёт дешево онлайн, прямые и трансферные рейсы;\n"+
                "на странице есть логотип Победы.", () -> {
            assertThat(mainPage.isLogoPresent()).isTrue();
            assertThat(mainPage.getTitleText()).isEqualTo("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");
        });

        step("кликнуть на пункт «Управление бронированием»", () -> {
            mainPage.getBookingRadioButton().click();
        });


        step("Убедиться, что открылась необходимая страница:\n" +
                "а) есть поле «Номер заказа или билета»;\n" +
                "б) есть поле «Фамилия клиента»;\n" +
                "в) есть кнопка «Поиск».", () -> {
            assertThat(mainPage.getBookingSurname().isDisplayed()).isTrue();
            assertThat(mainPage.getBookingTicketNumber().isDisplayed()).isTrue();
            assertThat(mainPage.getBookingSearchButton().isDisplayed()).isTrue();
        });

        String firstWindow = WebDriverRunner.getWebDriver().getWindowHandle();

        step("Ввести в поля ввода данные:\n" +
                "номер заказа – XXXXXX, фамилия – Qwerty\n" +
                "и нажать кнопку «Поиск»", () -> {
            mainPage.getBookingSurname().setValue("Qwerty");
            mainPage.getBookingTicketNumber().setValue("XXXXXX");
            mainPage.getBookingSearchButton().click();
        });

        OpenNewWindow.wait(firstWindow);
        webdriver().shouldHave(title("Просмотр заказа"));
        BookingPage bookingPage = new BookingPage();

        step("Убедиться, что в новой вкладке на экране отображается текст ошибки «Заказ с указанными параметрами не найден»", () -> {
            bookingPage.getCheckBoxAgreement().click();
            bookingPage.getButtonSearch().click();
            assertThat(bookingPage.getErrorMessage().isDisplayed()).isTrue();
            assertThat(bookingPage.getErrorMessage().getText()).isEqualTo("Заказ с указанными параметрами не найден");
        });

        AllureAttachments.screenshot("Заказ с указанными параметрами не найден");
    }

    @Severity(value = SeverityLevel.MINOR)
    @Feature(value = "Failure")
    @Flaky
    @Test
    public void errorTest() {
        throw new RuntimeException();
    }
}
