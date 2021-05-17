package ru.netology.domain.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

@Data

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id='code'] input");
    private SelenideElement verifyButton = $("[data-test-id='action-verify']");
    private SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public VerificationPage() {
        codeField.shouldBe(visible);
    }


    public DataPages verificationValid(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();

        return new DataPages();
    }
}

