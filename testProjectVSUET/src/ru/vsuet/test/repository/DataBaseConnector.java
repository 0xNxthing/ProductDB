/* package ru.vsuet.test.repository;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {

    public DataBaseConnector(){

        String host = "jdbc:h2:~/test";
        String username = "admin";
        String password = "admin";

        try {
            Connection connection = DriverManager.getConnection(host, username, password);
            System.out.println("Connected to DB");
        } catch(SQLException e) {
            throw new RuntimeException("Error with DB connecting..");
        }

    }

    public Connection getConnection() {
        return connection;
    }
}
*/
