package ru.netology.domain.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class ErrorPage {
    private SelenideElement errorAut = $(withText("Пользователь заблокирован"));

    public void errorPageVisible() {
        errorAut.shouldBe(Condition.visible);

    }

}
