/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/14
 * Description: Assignment 2 - Library Management System
 */
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.logger.LMSLogger;

/**
 * A factory class for creating Event objects based on EventType.
 * This class provides a method to create specific event instances such as
 * WorkShopEvent, KidsStoryEvent, MovieNightEvent, and BookLaunchEvent.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 * 
 * @author Xihai Ren
 */
public class EventFactory {

    /**
     * Creates an Event object based on the specified EventType.
     * Logs the creation process and returns the appropriate event instance.
     *
     * @param type the type of event to create
     * @return the created Event object
     * @throws IllegalArgumentException if the EventType is unsupported
     */
    public static Event createEvent(EventType type) {
        switch (type) {
            case WORKSHOP:
                LMSLogger.getLMSLogger().info(EventFactory.class.getSimpleName() + " is creating WorkShopEvent.");
                return new WorkShopEvent();
            case KIDS_STORY:
                LMSLogger.getLMSLogger().info(EventFactory.class.getSimpleName() + " is creating KidsStoryEvent.");
                return new KidsStoryEvent();
            case MOVIE_NIGHT:
                LMSLogger.getLMSLogger().info(EventFactory.class.getSimpleName() + " is creating MovieNightEvent.");
                return new MovieNightEvent();
            case BOOK_LAUNCH:
                LMSLogger.getLMSLogger().info(EventFactory.class.getSimpleName() + " is creating BookLaunchEvent.");
                return new BookLaunchEvent();
            default:
                LMSLogger.getLMSLogger().error(EventFactory.class.getSimpleName() + " Unsupported Event Type: " + type);
                throw new IllegalArgumentException("Unsupported Event Type");
        }
    }
}
