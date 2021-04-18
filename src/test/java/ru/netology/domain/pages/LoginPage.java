package ru.netology.domain.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import ru.netology.domain.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");
    private SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public VerificationPage authValid(DataHelper.AuthInfo info) {
        validAuthorization(info);
        return new VerificationPage();

    }

    public LoginPage clear() {
        clearField();
        return new LoginPage();
    }

    public void validAuthorization(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
    }

    public void invalidAuthorization(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        Faker faker = new Faker();
        passwordField.setValue(faker.internet().password());
        loginButton.click();
    }

    public void clearField() {
        loginField.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        passwordField.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
    }
}

