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
 * Represents a workshop event.
 * This class provides specific implementations for a workshop event, including
 * the calculation of the admission fee.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 * 
 * @author Xihai Ren
 */
public class WorkShopEvent extends Event {

    /**
     * Constructs a new WorkShopEvent.
     * Initializes the event activities, name, and description with the workshop event type.
     */
    public WorkShopEvent() {
        this.setEventActivities(EventType.WORKSHOP.name());
        this.setEventName(EventType.WORKSHOP.name());
        this.setEventDescription(EventType.WORKSHOP.name());
    }

    /**
     * Calculates the admission fee for the workshop event.
     * The admission fee is calculated based on a constant rate and duration.
     */
    @Override
    public void calculateAdmissionFee() {
        this.setAdmissionFees(Constants.WORKSHOP_RATE * Constants.WORKSHOP_DURATION);
        LMSLogger.getLMSLogger().info(String.format("The Workshop Admission Fee is %.2f", this.getAdmissionFees()));
    }
}
