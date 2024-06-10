/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/14
 * Description: Assignment 2 - Library Management System
 */
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the BookLaunchEvent class. This class contains tests to verify
 * the functionality of the BookLaunchEvent class, including testing the
 * calculation of admission fees.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class BookLaunchEventTest {

    /**
     * Default constructor for BookLaunchEventTest.
     */
    public BookLaunchEventTest() {
    }

    /**
     * Tests the calculateAdmissionFee method of the BookLaunchEvent class.
     * Verifies that the admission fee is correctly calculated.
     */
    @Test
    public void testCalculateAdmissionFee() {
        System.out.println("calculateAdmissionFee");
        BookLaunchEvent instance = new BookLaunchEvent();
        instance.calculateAdmissionFee();
        assertEquals(Constants.BOOK_LAUNCH_RATE * Constants.BOOK_LAUNCH_DURATION, instance.getAdmissionFees(), 0);
    }
}
