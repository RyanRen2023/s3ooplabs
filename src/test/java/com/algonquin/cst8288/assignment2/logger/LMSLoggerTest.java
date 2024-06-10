/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment2.logger;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author renxihai
 */
public class LMSLoggerTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    LMSLogger instance = LMSLogger.getLMSLogger();

    public LMSLoggerTest() {
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    /**
     * Test of setLogLevel method, of class LMSLogger.
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
     * Test of getLMSLogger method, of class LMSLogger.
     */
    @Test
    public void testGetLMSLogger() {
        System.out.println("Test Singleton Instance");
        LMSLogger expResult = LMSLogger.getLMSLogger();
        LMSLogger result = LMSLogger.getLMSLogger();
        assertSame(expResult, result);

    }

    /**
     * Test of log method, of class LMSLogger.
     */
    @Test
    public void testLog() {
        System.out.println("log");
        String info = "This is default info level";
        LMSLogger instance = LMSLogger.getLMSLogger();
        instance.log(info);
    }

    /**
     * Test of info method, of class LMSLogger.
     */
    @Test
    public void testInfo() {
        System.out.println("info");
        String log = "";
        LMSLogger instance = LMSLogger.getLMSLogger();
        instance.info(log);
        assertTrue(outContent.toString().trim().contains("Logger Level INFO"));

    }

    /**
     * Test of debug method, of class LMSLogger.
     */
    @Test
    public void testDebug() {
        System.out.println("debug");
        String log = "";
        LMSLogger instance = LMSLogger.getLMSLogger();;
        instance.debug(log);
        assertTrue(outContent.toString().trim().contains("Logger Level DEBUG"));

    }

    /**
     * Test of error method, of class LMSLogger.
     */
    @Test
    public void testError() {
        System.out.println("error");
        String log = "";
        LMSLogger instance = LMSLogger.getLMSLogger();;
        instance.error(log);
        assertTrue(outContent.toString().trim().contains("Logger Level ERROR"));

    }

    /**
     * Test of trace method, of class LMSLogger.
     */
    @Test
    public void testTrace() {
        System.out.println("trace");
        String log = "";
        LMSLogger instance = LMSLogger.getLMSLogger();;
        instance.trace(log);
        assertTrue(outContent.toString().trim().contains("Logger Level TRACE"));

    }

    /**
     * Test of warn method, of class LMSLogger.
     */
    @Test
    public void testWarn() {
        System.out.println("warn");
        String log = "";
        LMSLogger instance = LMSLogger.getLMSLogger();;
        instance.warn(log);
        assertTrue(outContent.toString().trim().contains("Logger Level WARN"));

    }

}
