package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static Connection connection;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/task_jdbc?useSSL=false", "root", "11111111");

        } catch (SQLException e) {
            System.out.println("Cannot establish a connection: " + e.getMessage());
        }
        return connection;
    }
}
