package ru.netology.domain.data;

import lombok.Data;
import lombok.Value;

@Data

public class DataHelper {

    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;


        public static AuthInfo getAuthInfo() {

            return new AuthInfo("vasya", "qwerty123");
        }
    }


    public static AuthInfo getInvInfo() {

        return new AuthInfo("vasya", "qwerty");
    }
}
