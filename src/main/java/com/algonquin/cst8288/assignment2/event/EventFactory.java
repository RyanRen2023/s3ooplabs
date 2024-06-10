/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.logger.LMSLogger;

/**
 *
 * @author renxihai
 */
public class EventFactory {

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
                LMSLogger.getLMSLogger().error(EventFactory.class.getSimpleName()+ " Unsupported Event Type: "+ type);
                throw new IllegalArgumentException("Unsupported Event Type");

        }

    }

}
