package ru.netology.domain.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

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
