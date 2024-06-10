/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/14
 * Description: Assignment 2 - Library Management System
 */
package com.algonquin.cst8288.assignment2.constants;

/**
 * A final class to hold constant values used in the Library Management System.
 * This class contains constants for event durations and rates for various types
 * of events such as workshops, kids storytime, movie nights, and book launches.
 * These constants are used throughout the application to ensure consistency.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @autor Xihai Ren
 */
public final class Constants {

    // Event durations in hours
    public static final double WORKSHOP_DURATION = 1.5;
    public static final double KIDS_STORYTIME_DURATION = 1.0;
    public static final double MOVIE_NIGHT_DURATION = 2.5;
    public static final double BOOK_LAUNCH_DURATION = 2.0;

    // Event rates per hour
    public static final double WORKSHOP_RATE = 10.0;
    public static final double KIDS_STORYTIME_RATE = 3.0;
    public static final double MOVIE_NIGHT_RATE = 3.0;
    public static final double BOOK_LAUNCH_RATE = 4.0;

    /**
     * Private constructor to prevent instantiation.
     */
    private Constants() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }
}
