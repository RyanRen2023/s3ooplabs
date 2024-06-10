/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventFactory;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.event.WorkShopEvent;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author renxihai
 */
public class DBOperationsTest {

    public DBOperationsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createEvent method, of class DBOperations.
     */
    @Test
    public void testCreateEvent() {
        System.out.println("createEvent");
        Event event = new WorkShopEvent();
        event.setEventName("Work shop at Jun 9,2024");
        event.setEventDescription("this work shop is public");
        event.setEventActivities(EventType.WORKSHOP.name());
        event.calculateAdmissionFee();
        DBOperations.createEvent(event);

    }

    /**
     * Test of retrieveEvent method, of class DBOperations.
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
     * Test of updateEvent method, of class DBOperations.
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
        DBOperations.updateEvent(event);
        Event event2 = DBOperations.retrieveEvent(event_id);
        assertEquals(event2.getEventName(), expected);

    }

    /**
     * Test of deleteEvent method, of class DBOperations.
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
