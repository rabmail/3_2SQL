package ru.netology.domain.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DataPages {
    private SelenideElement head = $("[data-test-id=dashboard]");

    public void dashboardPageVisible() {
        head.shouldBe(Condition.visible);
    }

}
