/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/07
 * Description: OOP Lab 1
 */
package com.algonquin.cst8288.s3ooplabs.lab01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * VehicleFactoryTest class contains unit tests for the VehicleFactory class.
 *
 * @see VehicleFactory
 * @see Vehicle
 * @see Car
 * @see Motorcycle
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @autor Xihai Ren
 */
public class VehicleFactoryTest {

    public VehicleFactoryTest() {
    }

    /**
     * Test of productVehicle method for creating a Car, of class
     * VehicleFactory.
     */
    @Test
    public void testProductVehicleCar() {
        System.out.println("test producting Vehicle Car");
        String vehicle = "Car";
        VehicleFactory instance = new VehicleFactory();
        Vehicle result = instance.productVehicle(vehicle);
        assertTrue(result instanceof Car);
    }

    /**
     * Test of productVehicle method to ensure two Car objects are different
     * instances, of class VehicleFactory.
     */
    @Test
    public void testProductVehicleTwoDiffCar() {
        System.out.println("test producting two different Vehicle Cars");
        String vehicle = "Car";
        VehicleFactory instance = new VehicleFactory();
        Vehicle result1 = instance.productVehicle(vehicle);
        Vehicle result2 = instance.productVehicle(vehicle);
        assertNotSame(result1, result2);
    }

    /**
     * Test of productVehicle method for creating a Motorcycle, of class
     * VehicleFactory.
     */
    @Test
    public void testProductVehicleMotorcycle() {
        System.out.println("test producting Vehicle Motorcycle");
        String vehicle = "Motorcycle";
        VehicleFactory instance = new VehicleFactory();
        Vehicle result = instance.productVehicle(vehicle);
        assertTrue(result instanceof Motorcycle);
    }

    /**
     * Test of productVehicle method for handling an unrecognized vehicle type,
     * of class VehicleFactory.
     */
    @Test
    public void testProductVehicleNull() {
        System.out.println("test producting Vehicle for an unrecognized vehicle type");
        String vehicle = "Other";
        VehicleFactory instance = new VehicleFactory();
        Vehicle result = instance.productVehicle(vehicle);
        assertNull(result);
    }
}
