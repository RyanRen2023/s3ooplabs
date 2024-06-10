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
 * Unit tests for the WorkShopEvent class. This class contains tests to verify
 * the functionality of the WorkShopEvent class, including testing the
 * calculation of admission fees.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class WorkShopEventTest {

    /**
     * Default constructor for WorkShopEventTest.
     */
    public WorkShopEventTest() {
    }

    /**
     * Tests the calculateAdmissionFee method of the WorkShopEvent class.
     * Verifies that the admission fee is correctly calculated.
     */
    @Test
    public void testCalculateAdmissionFee() {
        System.out.println("calculateAdmissionFee");
        WorkShopEvent instance = new WorkShopEvent();
        instance.calculateAdmissionFee();
        assertEquals(Constants.WORKSHOP_RATE * Constants.WORKSHOP_DURATION, instance.getAdmissionFees(), 0);
    }
}
