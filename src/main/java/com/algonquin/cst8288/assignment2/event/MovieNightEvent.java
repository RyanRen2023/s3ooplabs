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
 * Represents a movie night event.
 * This class provides specific implementations for a movie night event, including
 * the calculation of the admission fee.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 * 
 * @author Xihai Ren
 */
public class MovieNightEvent extends Event {

    /**
     * Constructs a new MovieNightEvent.
     * Initializes the event activities, name, and description with the movie night event type.
     */
    public MovieNightEvent() {
        this.setEventActivities(EventType.MOVIE_NIGHT.name());
        this.setEventName(EventType.MOVIE_NIGHT.name());
        this.setEventDescription(EventType.MOVIE_NIGHT.name());
    }

    /**
     * Calculates the admission fee for the movie night event.
     * The admission fee is calculated based on a constant rate and duration.
     */
    @Override
    public void calculateAdmissionFee() {
        this.setAdmissionFees(Constants.MOVIE_NIGHT_RATE * Constants.MOVIE_NIGHT_DURATION);
        LMSLogger.getLMSLogger().info(String.format("The Movie Night Admission Fee is %.2f", this.getAdmissionFees()));    
    }
}
