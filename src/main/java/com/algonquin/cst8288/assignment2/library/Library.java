/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/14
 * Description: Assignment 2 - Library Management System
 */
package com.algonquin.cst8288.assignment2.library;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;

/**
 * An abstract class representing a generic library. This class provides a
 * method to create events, which must be implemented by subclasses.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public abstract class Library {

    /**
     * Creates an event based on the specified EventType. Subclasses must
     * provide their own implementation of this method.
     *
     * @param eventType the type of event to create
     * @return the created Event object
     */
    public abstract Event createEvent(EventType eventType);
}
