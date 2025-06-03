package ru.stepup.tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.stepup.BaseTest;
import ru.stepup.pages.BookingPage;
import ru.stepup.pages.MainPage;
import ru.stepup.utils.AllureAttachments;
import ru.stepup.utils.OpenNewWindow;
import ru.testit.annotations.Title;
import ru.testit.listener.BaseTestNgListener;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.*;

@Listeners(BaseTestNgListener.class)
@Epic(value = "StepUp Java-Selenide-Allure Tests")
public class PobedaTests extends BaseTest {
    MainPage mainPage = new MainPage();

    @Severity(value = SeverityLevel.CRITICAL)
    @Feature(value = "Pobeda")
    @Description("Проверка начальной страницы")
    @Title("Задание №1. Page Object. Всплывающее окно")
    @TmsLink(value = "https://team-pufj.testit.software/projects/1/tests/6")
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
            mainPage.getINFO_BUTTON().hover();
        });

        step("Убедиться, что появилось всплывающее окно, которое содержит следующие заголовки: «Подготовка к полету», «Полезная информация», «О компании»", () -> {
            assertThat(mainPage.getINFO_COMPANY_BUTTON().isDisplayed()).isTrue();
            assertThat(mainPage.getINFO_USEFUL_BUTTON().isDisplayed()).isTrue();
            assertThat(mainPage.getREADY_TO_FLIGHT_BUTTON().isDisplayed()).isTrue();
        });

        AllureAttachments.screenshot("Всплывающее окно");
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @Feature(value = "Pobeda")
    @Description("Проверка ошибки поиска")
    @Title("Задание №2. Page Object. Инициирование поиска")
    @TmsLink(value = "https://team-pufj.testit.software/projects/1/tests/5")
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
            mainPage.getSEARCH_BLOCK().scrollTo();
            assertThat(mainPage.getFROM_WHERE_SEARCH_INPUT().isDisplayed()).isTrue();
            assertThat(mainPage.getTO_WHERE_SEARCH_INPUT().isDisplayed()).isTrue();
            assertThat(mainPage.getDEPARTING_SEARCH_INPUT().isDisplayed()).isTrue();
            assertThat(mainPage.getRETURNING_SEARCH_INPUT().isDisplayed()).isTrue();
        });


        step("Выбрать (или ввести) следующие критерии поиска:\n" +
                "откуда – Москва (без выбора аэропорта) + нажать Enter\n" +
                "куда – Санкт-Петербург + нажать Enter\n" +
                "Нажать кнопку «Поиск».", () -> {
            mainPage.getFROM_WHERE_SEARCH_INPUT().setValue("Санкт-Петербург").pressEnter();
            mainPage.getTO_WHERE_SEARCH_INPUT().setValue("Москва").pressEnter();
            mainPage.getSUBMIT_SEARCH_BUTTON().click();
        });


        step("Убедиться, что около поля «Туда» появилась красная обводка.", () -> {
            mainPage.getDEPARTING_SEARCH_DIV()
                    .shouldHave(cssValue("border-top-color", "rgba(213, 0, 98, 1)"));
        });

        AllureAttachments.screenshot("Красная обводка");
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @Feature(value = "Pobeda")
    @Description("Проверка обводки при ошибке поиска брони")
    @Title("Задание №3. Page Object. Результаты поиска")
    @TmsLink(value = "https://team-pufj.testit.software/projects/1/tests/4")
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
            mainPage.getBOOKING_RADIO_BUTTON().click();
        });


        step("Убедиться, что открылась необходимая страница:\n" +
                "а) есть поле «Номер заказа или билета»;\n" +
                "б) есть поле «Фамилия клиента»;\n" +
                "в) есть кнопка «Поиск».", () -> {
            assertThat(mainPage.getBOOKING_SURNAME().isDisplayed()).isTrue();
            assertThat(mainPage.getBOOKING_TICKET_NUMBER().isDisplayed()).isTrue();
            assertThat(mainPage.getBOOKING_SEARCH_BUTTON().isDisplayed()).isTrue();
        });

        String firstWindow = WebDriverRunner.getWebDriver().getWindowHandle();

        step("Ввести в поля ввода данные:\n" +
                "номер заказа – XXXXXX, фамилия – Qwerty\n" +
                "и нажать кнопку «Поиск»", () -> {
            mainPage.getBOOKING_SURNAME().setValue("Qwerty");
            mainPage.getBOOKING_TICKET_NUMBER().setValue("XXXXXX");
            mainPage.getBOOKING_SEARCH_BUTTON().click();
        });

        OpenNewWindow.wait(firstWindow);
        webdriver().shouldHave(title("Просмотр заказа"));
        BookingPage bookingPage = new BookingPage();

        step("Убедиться, что в новой вкладке на экране отображается текст ошибки «Заказ с указанными параметрами не найден»", () -> {
            bookingPage.getCHECK_BOX_AGREEMENT().click();
            bookingPage.getBUTTON_SEARCH().click();
            assertThat(bookingPage.getERROR_MESSAGE().isDisplayed()).isTrue();
            assertThat(bookingPage.getERROR_MESSAGE().getText()).isEqualTo("Заказ с указанными параметрами не найден");
        });

        AllureAttachments.screenshot("Заказ с указанными параметрами не найден");
    }

    @Severity(value = SeverityLevel.MINOR)
    @Feature(value = "Failure")
    @Flaky
    @Title("errorTest")
    @TmsLink(value = "https://team-pufj.testit.software/projects/1/tests/7")
    @Test
    public void errorTest() {
        throw new RuntimeException();
    }
}
