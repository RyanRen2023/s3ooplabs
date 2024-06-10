/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/14
 * Description: Assignment 2 - Library Management System
 */
package com.algonquin.cst8288.assignment2.logger;

/**
 * An enumeration of log levels in the Library Management System. This enum
 * defines various log levels, each with an associated integer value.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public enum LogLevel {
    TRACE(1),
    DEBUG(2),
    INFO(3),
    WARN(4),
    ERROR(5);

    /**
     * The integer value associated with the log level.
     */
    final int level;

    /**
     * Constructs a LogLevel with the specified integer value.
     *
     * @param level the integer value associated with the log level
     */
    LogLevel(int level) {
        this.level = level;
    }

    /**
     * Gets the integer value associated with the log level.
     *
     * @return the integer value of the log level
     */
    public int getLevel() {
        return this.level;
    }
}
    