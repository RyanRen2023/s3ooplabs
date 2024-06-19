/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/14
 * Description: Assignment 2 - Library Management System
 */
package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventFactory;
import com.algonquin.cst8288.assignment2.event.EventType;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the DBOperations class. This class contains tests to verify
 * the functionality of the DBOperations class, including testing the creation,
 * retrieval, update, and deletion of events in the database.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class DBOperationsTest {

    /**
     * Default constructor for DBOperationsTest.
     */
    public DBOperationsTest() {
    }

    /**
     * Tests the createEvent method of the DBOperations class. Verifies that an
     * event can be created in the database.
     */
    @Test
    public void testCreateEvent() {
        System.out.println("createEvent");
        Event event = EventFactory.createEvent(EventType.BOOK_LAUNCH);
        int event_id = DBOperations.createEvent(event);
        assertTrue(event_id > 0);
    }

    /**
     * Tests the retrieveEvent method of the DBOperations class. Verifies that
     * an event can be retrieved from the database by its ID.
     */
    @Test
    public void testRetrieveEvent() {
        System.out.println("retrieveEvent");
        Event event = EventFactory.createEvent(EventType.BOOK_LAUNCH);
        int event_id = DBOperations.createEvent(event);
        Event result = DBOperations.retrieveEvent(event_id);
        assertNotNull(result);
        assertEquals(result.getEventId(), event_id);
    }

    /**
     * Tests the updateEvent method of the DBOperations class. Verifies that an
     * event can be updated in the database.
     */
    @Test
    public void testUpdateEvent() {
        System.out.println("updateEvent");
        Event event = EventFactory.createEvent(EventType.BOOK_LAUNCH);
        int event_id = DBOperations.createEvent(event);
        Random random = new Random();
        String expected = "this is a new name " + random.nextInt(100);
        event = DBOperations.retrieveEvent(event_id);
        event.setEventName(expected);
        event.calculateAdmissionFee();
        DBOperations.updateEvent(event);
        Event event2 = DBOperations.retrieveEvent(event_id);
        assertEquals(event2.getEventName(), expected);
    }

    /**
     * Tests the deleteEvent method of the DBOperations class. Verifies that an
     * event can be deleted from the database.
     */
    @Test
    public void testDeleteEvent() {
        System.out.println("deleteEvent");
        Event event = EventFactory.createEvent(EventType.BOOK_LAUNCH);
        int event_id = DBOperations.createEvent(event);
        boolean result = DBOperations.deleteEvent(event_id);
        assertTrue(result);
    }
}
