package com.example;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Epic("Testing Challenges Website")
@Feature("Анализ структуры сайта")
@Owner("Ваше Имя")
public class AnalyzePageTest extends BaseTest {

    @Test
    @DisplayName("Анализ структуры страницы")
    @Story("Сбор информации о элементах на странице")
    @Severity(SeverityLevel.MINOR)
    void analyzePage() {
        sleep(3000);

        System.out.println("=== АНАЛИЗ СТРУКТУРЫ САЙТА ===");
        System.out.println("Заголовок: " + title());

        // Простой анализ
        System.out.println("Всего элементов: " + $$("*").size());
        System.out.println("Div элементов: " + $$("div").size());
        System.out.println("Ссылок: " + $$("a").size());

        screenshot("analysis_result");
    }
}