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
 * Represents a kids story event.
 * This class provides specific implementations for a kids story event, including
 * the calculation of the admission fee.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 * 
 * @author Xihai Ren
 */
public class KidsStoryEvent extends Event {

    /**
     * Constructs a new KidsStoryEvent.
     * Initializes the event activities, name, and description with the kids story event type.
     */
    public KidsStoryEvent() {
        this.setEventActivities(EventType.KIDS_STORY.name());
        this.setEventName(EventType.KIDS_STORY.name());
        this.setEventDescription(EventType.KIDS_STORY.name());
    }

    /**
     * Calculates the admission fee for the kids story event.
     * The admission fee is calculated based on a constant rate and duration.
     */
    @Override
    public void calculateAdmissionFee() {
        this.setAdmissionFees(Constants.KIDS_STORYTIME_RATE * Constants.KIDS_STORYTIME_DURATION);
        LMSLogger.getLMSLogger().info(String.format("The Kids Story Admission Fee is %.2f", this.getAdmissionFees()));
    }
}
