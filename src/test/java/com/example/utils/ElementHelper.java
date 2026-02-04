package com.example.utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ElementHelper {

    public static SelenideElement findByNameOrId(String partialName) {
        return $(By.xpath(
                String.format("//*[contains(@name, '%s') or contains(@id, '%s') or contains(@placeholder, '%s')]",
                        partialName, partialName, partialName)
        ));
    }

    public static void safeClick(String elementText) {
        $(By.xpath(String.format("//*[contains(text(), '%s')]", elementText)))
                .shouldBe(visible, Duration.ofSeconds(10))
                .shouldBe(enabled)
                .click();
    }

    public static void waitForPageLoad() {
        $("body").shouldBe(visible, Duration.ofSeconds(15));
    }
}