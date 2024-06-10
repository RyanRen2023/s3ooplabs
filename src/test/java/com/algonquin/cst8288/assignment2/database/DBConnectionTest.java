/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/14
 * Description: Assignment 2 - Library Management System
 */
package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the DBConnection class. This class contains tests to verify
 * the functionality of the DBConnection class, including testing the singleton
 * nature of the database connection.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class DBConnectionTest {

    /**
     * Default constructor for DBConnectionTest.
     */
    public DBConnectionTest() {
    }


    /**
     * Tests the getConnection method of the DBConnection class. Verifies that
     * the method returns the same Connection instance (singleton pattern).
     */
    @Test
    public void testGetConnection() {
        System.out.println("test Singleton Connection");
        Connection expResult = DBConnection.getConnection();
        Connection result = DBConnection.getConnection();
        assertEquals(expResult, result);
    }

}
