/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/14
 * Description: Assignment 2 - Library Management System
 */
package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.DBOperations;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.library.Library;
import com.algonquin.cst8288.assignment2.library.LibraryFactory;
import com.algonquin.cst8288.assignment2.library.LibraryType;
import java.util.ArrayList;
import java.util.List;

/**
 * Client class to demonstrate the creation and handling of events.
 * This class demonstrates the use of the Library Management System by creating 
 * different types of events for public and academic libraries, calculating their 
 * admission fees, and saving them to the database.
 *
 * @see Library
 * @see LibraryFactory
 * @see LibraryType
 * @see Event
 * @see EventType
 * @see DBOperations
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 * 
 * @author Xihai Ren
 */
public class Client {

    /**
     * The main method to execute the client operations.
     * This method initializes libraries, creates events, calculates their admission 
     * fees, and stores them in the database.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // List to store events
        List<Event> list = new ArrayList<>();

        // Initialize public and academic libraries using the factory
        Library publicLib = LibraryFactory.getLibraryByType(LibraryType.PUBLIC);
        Library academicLib = LibraryFactory.getLibraryByType(LibraryType.ACADEMIC);

        // Create events for the public library
        Event ev1 = publicLib.createEvent(EventType.MOVIE_NIGHT);
        Event ev2 = publicLib.createEvent(EventType.KIDS_STORY);

        // Create events for the academic library
        Event ev3 = academicLib.createEvent(EventType.WORKSHOP);
        Event ev4 = academicLib.createEvent(EventType.BOOK_LAUNCH);

        // Add events to the list
        list.add(ev1);
        list.add(ev2);
        list.add(ev3);
        list.add(ev4);

        // Process each event: calculate admission fee and store in the database
        for (Event ev : list) {
            System.out.println();
            ev.calculateAdmissionFee();
            DBOperations.createEvent(ev);
        }
    }
}
