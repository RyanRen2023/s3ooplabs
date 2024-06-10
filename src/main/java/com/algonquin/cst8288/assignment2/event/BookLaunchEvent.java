/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/14
 * Description: Assignment 2 - Library Management System
 */
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;

/**
 * Represents a book launch event. This class provides specific implementations
 * for a book launch event, including the calculation of the admission fee.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @autor Xihai Ren
 */
public class BookLaunchEvent extends Event {

    /**
     * Constructs a new BookLaunchEvent. Initializes the event activities, name,
     * and description with the book launch event type.
     */
    public BookLaunchEvent() {
        this.setEventActivities(EventType.BOOK_LAUNCH.name());
        this.setEventName(EventType.BOOK_LAUNCH.name());
        this.setEventDescription(EventType.BOOK_LAUNCH.name());
    }

    /**
     * Calculates the admission fee for the book launch event. The admission fee
     * is calculated based on a constant rate and duration.
     */
    @Override
    public void calculateAdmissionFee() {
        this.setAdmissionFees(Constants.BOOK_LAUNCH_RATE * Constants.BOOK_LAUNCH_DURATION);
        LMSLogger.getLMSLogger().info(String.format("The Book Launch Admission Fee is %.2f", this.getAdmissionFees()));
    }
}
