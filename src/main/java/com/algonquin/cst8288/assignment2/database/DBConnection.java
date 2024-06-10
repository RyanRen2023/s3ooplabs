/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/14
 * Description: Assignment 2 - Library Management System
 */
package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    private String serverUrl = "jdbc:mysql://localhost:3306/bookvault";
    private String userString = "Xihai";
    private String passwordString = "Xihai1234";
    private String driverString = "com.mysql.cj.jdbc.Driver";

    /**
     * Private constructor to prevent instantiation.
     */
    private DBConnection() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    /**
     * Returns the singleton instance of the database connection. If the
     * connection does not exist, it initializes the connection.
     *
     * @return the singleton instance of the database connection
     */
    static Connection getConnection() {
        if (connection == null) {
            DBConnection db = new DBConnection();
            connection = db.initConnection();
        }
        LMSLogger.getLMSLogger().log(DBConnection.class.getSimpleName() + " get connection.");

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
        LMSLogger.getLMSLogger().log(DBConnection.class.getSimpleName() + " init connection.");
        try {
            Class.forName(driverString);
            return DriverManager.getConnection(serverUrl, userString, passwordString);
        } catch (ClassNotFoundException | SQLException ex) {
            LMSLogger.getLMSLogger().error(ex.getMessage());
        }
        return null;
    }
}
