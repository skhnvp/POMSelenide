package ru.stepup;

import com.codeborne.selenide.Configuration;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stepup.utils.ConfigReader;

import java.io.ByteArrayInputStream;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeSuite
    public void setupAll() {
        Configuration.browser = ConfigReader.getProperty("browser");
        Configuration.browserSize = ConfigReader.getProperty("browser.size");
        Configuration.baseUrl = ConfigReader.getProperty("base.url");
        Configuration.timeout = Long.parseLong(ConfigReader.getProperty("timeout"));
        Configuration.pageLoadStrategy = ConfigReader.getProperty("page.load.strategy");
        Configuration.reportsFolder = ConfigReader.getProperty("reports.folder");
        Configuration.screenshots = true;
        Configuration.savePageSource = true;
    }

    @BeforeMethod
    public void openBrowser() {
        open(ConfigReader.getProperty("base.url"));
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
