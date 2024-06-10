/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.library;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventFactory;
import com.algonquin.cst8288.assignment2.event.EventType;
import static com.algonquin.cst8288.assignment2.event.EventType.WORKSHOP;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;

/**
 *
 * @author renxihai
 */
public class AcademicLibrary extends Library {

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
