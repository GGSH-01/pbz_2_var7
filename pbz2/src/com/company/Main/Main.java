

package com.company.Main;


import com.company.View.MainWindow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static Connection conn;

    public static Connection returnCon() {
        return conn;
    }


    public static Connection connect() throws SQLException {
        final String url = "jdbc:postgresql://localhost/store";
        final String user = "postgres";
        final String password = "1375GoS_hKo2616";
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        connect();
        Statement statement = conn.createStatement();

        MainWindow mainWindow = new MainWindow();
    }

}
