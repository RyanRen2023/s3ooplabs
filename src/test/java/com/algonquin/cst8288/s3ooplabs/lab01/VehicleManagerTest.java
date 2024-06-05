/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/07
 * Description: OOP Lab 1
 */
package com.algonquin.cst8288.s3ooplabs.lab01;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * VehicleManagerTest class contains unit tests for the VehicleManager class.
 *
 * @see VehicleManager
 * @see Vehicle
 * @see Car
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @autor Xihai Ren
 */
public class VehicleManagerTest {

    public VehicleManagerTest() {
    }

    /**
     * Test of getInstance method, of class VehicleManager.
     */
    @org.junit.jupiter.api.Test
    public void testGetInstance() {
        System.out.println("test getInstance");
        VehicleManager expResult = VehicleManager.getInstance();
        VehicleManager result = VehicleManager.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class VehicleManager.
     */
    @org.junit.jupiter.api.Test
    public void testAdd() {
        System.out.println("test add");
        Vehicle vehicle = new Car();
        VehicleManager instance = VehicleManager.getInstance();
        instance.add(vehicle);
        assertTrue(instance.retrieve().contains(vehicle));
    }

    /**
     * Test of retrieve method, of class VehicleManager.
     */
    @org.junit.jupiter.api.Test
    public void testRetrieve() {
        System.out.println("test retrieve");
        VehicleManager instance = VehicleManager.getInstance();
        List<Vehicle> result = instance.retrieve();
        assertNotNull(result);
    }
}
