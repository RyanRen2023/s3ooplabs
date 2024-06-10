package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection = null;

    private String serverUrl = "jdbc:mysql://localhost:3306/bookvault";
    private String userString = "Xihai";
    private String passwordString = "Xihai1234";
    private String driverString = "com.mysql.cj.jdbc.Driver";

    private DBConnection() {

    }

    static Connection getConnection() {

        if (connection == null) {
            DBConnection db = new DBConnection();
            connection = db.initConnection();
        }
        LMSLogger.getLMSLogger().log(DBConnection.class.getSimpleName() + " get connection.");

        return connection;

    }

    private Connection initConnection() {
        LMSLogger.getLMSLogger().log(DBConnection.class.getSimpleName() + " init connection.");
        try {
            Class.forName(driverString);
            return DriverManager.getConnection(serverUrl, userString, passwordString);

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
