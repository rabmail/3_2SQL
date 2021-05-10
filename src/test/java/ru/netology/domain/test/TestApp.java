package ru.netology.domain.test;

import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.domain.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.domain.data.DataHelper.AuthInfo.getAuthInfo;

import static ru.netology.domain.data.DataHelper.getInvInfo;
import static ru.netology.domain.data.DataSQL.dropSql;
import static ru.netology.domain.data.DataSQL.getVerificationCode;

public class TestApp {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @AfterAll
    public static void clearSql() {
        dropSql();
    }

    @Test
    void shouldValidVerfication() {
        val loginPage = new LoginPage();
        val authInfo = getAuthInfo();
        val verificationPage = loginPage.authValid(authInfo);
        val verificationCode = getVerificationCode(authInfo);
        val dataPage = verificationPage.verificationValid(verificationCode);
        dataPage.dashboardPageVisible();
    }
//docker-compose up
//java -jar artifacts/app-deadline.jar -P:jdbc.url=jdbc:mysql://localhost:3306/app -P:jdbc.user=app -P:jdbc.pass


    @Test
    void shouldInvalidVerfication() {
        val errorAut = "Пользователь заблокирован";
        val loginPage = new LoginPage();
        val authInfo = getInvInfo();
        loginPage.authValid(authInfo);
        loginPage.clear();
        loginPage.authValid(authInfo);
        loginPage.clear();
        loginPage.authValid(authInfo);
        assertEquals(errorAut, "Пользователь заблокирован");
    }

}
