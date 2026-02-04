package com.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeAll
    public static void setupAll() {
        // Включаем Allure логирование
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );

        // Настройки Selenide
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void openBrowser() {
        open("http://testingchallenges.thetestingmap.org/");
    }

    @AfterEach
    public void afterTest() {
        // Скриншот для Allure
        try {
            byte[] screenshot = Selenide.screenshot(OutputType.BYTES);
            if (screenshot != null) {
                Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
            }
        } catch (Exception e) {
            System.out.println("Не удалось сделать скриншот: " + e.getMessage());
        }

        // Закрываем браузер
        closeWebDriver();
    }
}