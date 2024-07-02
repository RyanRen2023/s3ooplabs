/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - JUnit Test Class for DBConnection
 */

package org.cst8288Lab2.dao;

import java.sql.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A JUnit test class for testing the DBConnection class.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 * 
 * @autor renxihai
 */
public class DBConnectionTest {
    
    public DBConnectionTest() {
    }

    /**
     * Sets up resources before any tests are run.
     */
    @BeforeAll
    public static void setUpClass() {
    }

    /**
     * Cleans up resources after all tests are completed.
     */
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Sets up resources before each test is run.
     */
    @BeforeEach
    public void setUp() {
    }

    /**
     * Cleans up resources after each test is run.
     */
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getConnection method, of class DBConnection.
     * This test ensures that the connection is successfully established and is not null.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        Connection result = DBConnection.getConnection();
        assertNotNull(result);
    }
}