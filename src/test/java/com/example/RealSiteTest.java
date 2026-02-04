package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class RealSiteTest extends BaseTest {

    @Test
    void checkRealContent() {
        // Ждем загрузки
        sleep(3000);

        System.out.println("=== РЕАЛЬНЫЙ КОНТЕНТ САЙТА ===");

        // 1. Получаем весь текст страницы
        String allText = $(By.tagName("body")).getText();
        System.out.println("Текст страницы (первые 500 символов):");
        System.out.println(allText.substring(0, Math.min(500, allText.length())));

        // 2. Смотрим на структуру
        System.out.println("\n=== СТРУКТУРА ===");
        System.out.println("Заголовок страницы: " + title());
        System.out.println("URL: " + webdriver().driver().url());

        // 3. Ищем ссылки
        System.out.println("\nСсылок на странице: " + $$("a").size());

        // 4. Ищем div'ы с классами
        System.out.println("\n=== DIV ЭЛЕМЕНТЫ ===");
        $$("div").forEach(div -> {
            String divClass = div.getAttribute("class");
            if (divClass != null && !divClass.isEmpty()) {
                System.out.println("Div class: " + divClass);
            }
        });

        screenshot("real_content");
    }
}