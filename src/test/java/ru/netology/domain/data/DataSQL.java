package ru.netology.domain.data;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSQL {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://192.168.99.100:3306/app", "app", "pass");
    }

    public static void dropSql() {
        val runner = new QueryRunner();
        val users = "DELETE FROM users";
        val verificationCodes = "DELETE FROM auth_codes";
        val cards = "DELETE FROM cards";

        try (Connection connection = getConnection()) {
            runner.update(connection, users);
            runner.update(connection, verificationCodes);
            runner.update(connection, cards);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
