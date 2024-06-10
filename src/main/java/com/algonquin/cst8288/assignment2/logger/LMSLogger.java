/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/14
 * Description: Assignment 2 - Library Management System
 */
package com.algonquin.cst8288.assignment2.logger;

import static com.algonquin.cst8288.assignment2.logger.LogLevel.DEBUG;
import static com.algonquin.cst8288.assignment2.logger.LogLevel.ERROR;
import static com.algonquin.cst8288.assignment2.logger.LogLevel.INFO;
import static com.algonquin.cst8288.assignment2.logger.LogLevel.TRACE;
import static com.algonquin.cst8288.assignment2.logger.LogLevel.WARN;

/**
 * A logger class to handle logging at different levels. This class uses the
 * Singleton design pattern to ensure only one instance of the logger is
 * created. It supports logging messages at various levels such as TRACE, DEBUG,
 * INFO, WARN, and ERROR.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class LMSLogger {

    private static LMSLogger lmsLogger;

    /**
     * The current logging level.
     */
    LogLevel logLevel;

    /**
     * Private constructor to prevent instantiation.
     *
     * @param logLevel the initial logging level
     */
    private LMSLogger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * Sets the logging level.
     *
     * @param logLevel the new logging level
     */
    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;

    }

    /**
     * Gets the singleton instance of the logger.
     *
     * @return the singleton instance of LMSLogger
     */
    public static LMSLogger getLMSLogger() {
        if (lmsLogger == null) {
            lmsLogger = new LMSLogger(LogLevel.INFO);
        }
        return lmsLogger;
    }

    /**
     * Logs a message at the current logging level.
     *
     * @param log the message to log
     */
    public void log(String log) {
        log(logLevel, log);
    }

    /**
     * Logs a message at the specified logging level.
     *
     * @param logLevel the logging level
     * @param log the message to log
     */
    private void log(LogLevel logLevel, String log) {

        switch (logLevel) {
            case TRACE:
                System.out.printf("Logger Level TRACE : %s\n", log);
                break;
            case DEBUG:
                System.out.printf("Logger Level DEBUG: %s\n", log);
                break;
            case INFO:
                System.out.printf("Logger Level INFO : %s\n", log);
                break;
            case WARN:
                System.out.printf("Logger Level WARN: %s\n", log);
                break;
            case ERROR:
                System.out.printf("Logger Level ERROR : %s\n", log);
                break;
        }
    }

    /**
     * Logs an info level message.
     *
     * @param log the message to log
     */
    public void info(String log) {
        this.log(LogLevel.INFO, log);
    }

    /**
     * Logs a debug level message.
     *
     * @param log the message to log
     */
    public void debug(String log) {
        this.log(LogLevel.DEBUG, log);
    }

    /**
     * Logs an error level message.
     *
     * @param log the message to log
     */
    public void error(String log) {
        this.log(LogLevel.ERROR, log);
    }

    /**
     * Logs a trace level message.
     *
     * @param log the message to log
     */
    public void trace(String log) {
        this.log(LogLevel.TRACE, log);
    }

    /**
     * Logs a warning level message.
     *
     * @param log the message to log
     */
    public void warn(String log) {
        this.log(LogLevel.WARN, log);
    }
}
