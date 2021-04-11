package ru.netology.domain.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.domain.data.DataSQL.dropSql;

public class Test {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @AfterAll
    public static void clearSql() {
        dropSql();
    }


}
