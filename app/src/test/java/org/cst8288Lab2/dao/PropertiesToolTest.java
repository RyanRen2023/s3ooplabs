/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - JUnit Test Class for PropertiesTool
 */

package org.cst8288Lab2.dao;

import org.cst8288Lab2.utility.PropertiesTool;
import java.util.Properties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A JUnit test class for testing the PropertiesTool class.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 * 
 * @autor Xihai Ren
 */
public class PropertiesToolTest {

    public PropertiesToolTest() {
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
     * Test of getProperties method, of class PropertiesTool.
     */
    @Test
    public void testGetProperties() {
        System.out.println("getProperties");
        Properties prop = PropertiesTool.getProperties();
        assertNotNull(prop);
        assertEquals("mysql", prop.getProperty("db"));
    }

    /**
     * Test of reset method, of class PropertiesTool.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        Properties prop1 = PropertiesTool.getProperties();
        PropertiesTool.reset();
        Properties prop2 = PropertiesTool.getProperties();
        assertNotSame(prop2, prop1);
    }
}