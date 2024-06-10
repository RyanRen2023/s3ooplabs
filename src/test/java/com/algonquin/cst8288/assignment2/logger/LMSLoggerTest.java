/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/14
 * Description: Assignment 2 - Library Management System
 */
package com.algonquin.cst8288.assignment2.logger;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the LMSLogger class. This class contains tests to verify the
 * functionality of the LMSLogger class, including testing logging at different
 * levels and ensuring the singleton pattern.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class LMSLoggerTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    LMSLogger instance = LMSLogger.getLMSLogger();

    /**
     * Default constructor for LMSLoggerTest.
     */
    public LMSLoggerTest() {
    }

    /**
     * Sets up the test environment. This method is called before each test
     * method is executed. It redirects the standard output to a
     * ByteArrayOutputStream for testing purposes.
     */
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Tears down the test environment. This method is called after each test
     * method is executed. It restores the standard output to its original
     * state.
     */
    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    /**
     * Tests the setLogLevel method of the LMSLogger class. Verifies that the
     * log level can be set and that logging at the DEBUG level works.
     */
    @Test
    public void testSetLogLevel() {
        System.out.println("setLogLevel");
        LogLevel logLevel = LogLevel.DEBUG;
        LMSLogger instance = LMSLogger.getLMSLogger();
        instance.setLogLevel(logLevel);
        instance.log("Change to DEBUG Level");
        assertTrue(outContent.toString().trim().contains("Logger Level DEBUG"));
    }

    /**
     * Tests the getLMSLogger method of the LMSLogger class. Verifies that the
     * logger follows the singleton pattern.
     */
    @Test
    public void testGetLMSLogger() {
        System.out.println("Test Singleton Instance");
        LMSLogger expResult = LMSLogger.getLMSLogger();
        LMSLogger result = LMSLogger.getLMSLogger();
        assertSame(expResult, result);
    }

    /**
     * Tests the log method of the LMSLogger class. Verifies that a message can
     * be logged at the default INFO level.
     */
    @Test
    public void testLog() {
        System.out.println("log");
        String info = "This is default info level";
        instance.log(info);
        assertTrue(outContent.toString().trim().contains("Logger Level INFO"));
    }

    /**
     * Tests the info method of the LMSLogger class. Verifies that a message can
     * be logged at the INFO level.
     */
    @Test
    public void testInfo() {
        System.out.println("info");
        String log = "";
        instance.info(log);
        assertTrue(outContent.toString().trim().contains("Logger Level INFO"));
    }

    /**
     * Tests the debug method of the LMSLogger class. Verifies that a message
     * can be logged at the DEBUG level.
     */
    @Test
    public void testDebug() {
        System.out.println("debug");
        String log = "";
        instance.debug(log);
        assertTrue(outContent.toString().trim().contains("Logger Level DEBUG"));
    }

    /**
     * Tests the error method of the LMSLogger class. Verifies that a message
     * can be logged at the ERROR level.
     */
    @Test
    public void testError() {
        System.out.println("error");
        String log = "";
        instance.error(log);
        assertTrue(outContent.toString().trim().contains("Logger Level ERROR"));
    }

    /**
     * Tests the trace method of the LMSLogger class. Verifies that a message
     * can be logged at the TRACE level.
     */
    @Test
    public void testTrace() {
        System.out.println("trace");
        String log = "";
        instance.trace(log);
        assertTrue(outContent.toString().trim().contains("Logger Level TRACE"));
    }

    /**
     * Tests the warn method of the LMSLogger class. Verifies that a message can
     * be logged at the WARN level.
     */
    @Test
    public void testWarn() {
        System.out.println("warn");
        String log = "";
        instance.warn(log);
        assertTrue(outContent.toString().trim().contains("Logger Level WARN"));
    }
}
