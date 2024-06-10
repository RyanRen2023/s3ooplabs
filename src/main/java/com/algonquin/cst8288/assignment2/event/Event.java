/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/14
 * Description: Assignment 2 - Library Management System
 */
package com.algonquin.cst8288.assignment2.event;

/**
 * An abstract class representing a generic event. This class provides common
 * properties and methods for different types of events. Subclasses must
 * implement the abstract method calculateAdmissionFee to provide specific
 * admission fee calculations.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public abstract class Event {

    protected int eventId;
    protected String eventName;
    protected String eventDescription;
    protected String eventActivities;
    protected double admissionFees;

    /**
     * Default constructor.
     */
    public Event() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    /**
     * Gets the name of the event.
     *
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Sets the name of the event.
     *
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Gets the description of the event.
     *
     * @return the eventDescription
     */
    public String getEventDescription() {
        return eventDescription;
    }

    /**
     * Sets the description of the event.
     *
     * @param eventDescription the eventDescription to set
     */
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    /**
     * Gets the activities of the event.
     *
     * @return the eventActivities
     */
    public String getEventActivities() {
        return eventActivities;
    }

    /**
     * Sets the activities of the event.
     *
     * @param eventActivities the eventActivities to set
     */
    public void setEventActivities(String eventActivities) {
        this.eventActivities = eventActivities;
    }

    /**
     * Gets the admission fees for the event.
     *
     * @return the admissionFees
     */
    public double getAdmissionFees() {
        return admissionFees;
    }

    /**
     * Sets the admission fees for the event.
     *
     * @param admissionFees the admissionFees to set
     */
    public void setAdmissionFees(double admissionFees) {
        this.admissionFees = admissionFees;
    }

    /**
     * Gets the ID of the event.
     *
     * @return the eventId
     */
    public int getEventId() {
        return eventId;
    }

    /**
     * Sets the ID of the event.
     *
     * @param eventId the eventId to set
     */
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    /**
     * Abstract method to calculate the admission fee for the event. Subclasses
     * must provide their own implementation of this method.
     */
    public abstract void calculateAdmissionFee();
}
