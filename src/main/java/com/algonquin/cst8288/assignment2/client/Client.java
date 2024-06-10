package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.DBOperations;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.library.Library;
import com.algonquin.cst8288.assignment2.library.LibraryFactory;
import com.algonquin.cst8288.assignment2.library.LibraryType;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        List<Event> list = new ArrayList<>();
        Library publicLib = LibraryFactory.getLibraryByType(LibraryType.PUBLIC);
        Library academicLib = LibraryFactory.getLibraryByType(LibraryType.ACADEMIC);

        Event ev1 = publicLib.createEvent(EventType.MOVIE_NIGHT);
        Event ev2 = publicLib.createEvent(EventType.KIDS_STORY);
        Event ev3 = academicLib.createEvent(EventType.WORKSHOP);
        Event ev4 = academicLib.createEvent(EventType.BOOK_LAUNCH);

        list.add(ev1);
        list.add(ev2);
        list.add(ev3);
        list.add(ev4);


        for (Event ev : list) {
            System.out.println();
            ev.calculateAdmissionFee();
            DBOperations.createEvent(ev);
        }
        

    }
}
