package com.example;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

@Epic("Testing Challenges Website")
@Feature("Базовые проверки")
@Owner("Ваше Имя")
public class SimpleTest extends BaseTest {

    @Test
    @DisplayName("Проверка открытия сайта")
    @Story("Сайт должен открываться и загружаться")
    @Severity(SeverityLevel.BLOCKER)
    void testSiteOpens() {
        // Базовая проверка - страница открылась
        System.out.println("✓ Сайт открыт: " + title());
        System.out.println("✓ Текущий URL: " + webdriver().driver().url());

        // Делаем скриншот для отчета
        screenshot("site_opened");

        // Тест проходит, если не упал при открытии
    }
}