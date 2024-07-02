package org.cst8288Lab2.dao;

/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - DAO Pattern
 */
import org.cst8288Lab2.utility.PropertiesTool;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * A singleton class to manage database connections. This class provides a
 * single instance of the database connection and ensures that only one
 * connection is used throughout the application.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @autor Xihai Ren
 */
public class DBConnection {

    private static Connection connection = null;

    private final String serverUrl;
    private final String userString;
    private final String passwordString;
    private final String driverString = "com.mysql.cj.jdbc.Driver";

    /**
     * Private constructor to prevent instantiation.
     */
    private DBConnection() {
        Properties properties = PropertiesTool.getProperties();
        String db = properties.getProperty("db");
        String name = properties.getProperty("name");
        String host = properties.getProperty("host");
        String port = properties.getProperty("port");
        String pass = properties.getProperty("pass");
        String user = properties.getProperty("user");
        serverUrl = String.format("jdbc:mysql://%s:%s/%s", host,port,name);
        userString = user;
        passwordString = pass;
    }

    /**
     * Returns the singleton instance of the database connection. If the
     * connection does not exist, it initializes the connection.
     *
     * @return the singleton instance of the database connection
     */
    public static Connection getConnection() {
        if (connection == null) {
            DBConnection db = new DBConnection();
            connection = db.initConnection();
        }

        return connection;
    }

    /**
     * Initializes the database connection. Loads the JDBC driver and
     * establishes the connection using the specified server URL, username, and
     * password.
     *
     * @return the initialized database connection
     */
    private Connection initConnection() {
        try {
            Class.forName(driverString);
            return DriverManager.getConnection(serverUrl, userString, passwordString);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
