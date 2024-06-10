/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/14
 * Description: Assignment 2 - Library Management System
 */
package com.algonquin.cst8288.assignment2.library;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventFactory;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;

/**
 * Represents an academic library. This class provides specific implementations
 * for creating events suitable for an academic library, such as workshops and
 * book launches.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class AcademicLibrary extends Library {

    /**
     * Creates an event based on the specified EventType. Logs the operation and
     * returns the appropriate event instance.
     *
     * @param eventType the type of event to create
     * @return the created Event object
     * @throws IllegalArgumentException if the EventType is unsupported
     */
    @Override
    public Event createEvent(EventType eventType) {
        switch (eventType) {
            case WORKSHOP:
            case BOOK_LAUNCH:
                return EventFactory.createEvent(eventType);
            default:
                LMSLogger.getLMSLogger().error(this.getClass().getSimpleName() + " Unsupported Event Type: " + eventType);
                throw new IllegalArgumentException("Unsupported eventType");
        }
    }
}
