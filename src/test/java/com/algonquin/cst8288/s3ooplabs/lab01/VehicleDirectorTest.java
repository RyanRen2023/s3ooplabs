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
 * VehicleDirectorTest class contains unit tests for the VehicleDirector class.
 *
 * @see VehicleDirector
 * @see Vehicle
 * @see Car
 * @see Motorcycle
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class VehicleDirectorTest {

    public VehicleDirectorTest() {
    }

    /**
     * Test of builderVehicle method for creating a Car, of class
     * VehicleDirector.
     */
    @Test
    public void testBuilderVehicleCar() {
        System.out.println("test building Vehicle Car");
        String model = "Toyota";
        String engine = "V6";
        String body = "Sport";
        String wheels = "4 wheels";
        VehicleDirector instance = new VehicleDirector();
        instance.setVehicleBuilder(new CarBuilder());
        Vehicle expResult = new Car();
        expResult.setModel(model);
        expResult.setEngine(engine);
        expResult.setBody(body);
        expResult.setWheels(wheels);
        Vehicle result = instance.builderVehicle(model, engine, body, wheels);
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of builderVehicle method for creating a Motorcycle, of class
     * VehicleDirector.
     */
    @Test
    public void testBuilderVehicleMotorcycle() {
        System.out.println("Test building Vehicle Motorcycle");
        String model = "Yamaha";
        String engine = "Inline-4";
        String body = "Sport";
        String wheels = "2 wheels";
        VehicleDirector instance = new VehicleDirector();
        instance.setVehicleBuilder(new MotorcycleBuilder());
        Vehicle expResult = new Motorcycle();
        expResult.setModel(model);
        expResult.setEngine(engine);
        expResult.setBody(body);
        expResult.setWheels(wheels);
        Vehicle result = instance.builderVehicle(model, engine, body, wheels);
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of setVehicleBuilder method when setting a null builder, of class
     * VehicleDirector.
     */
    @Test
    public void testSetVehicleBuilderNull() {
        System.out.println("test setVehicleBuilder with null");
        VehicleBuilder vehicleBuilder = null;
        VehicleDirector instance = new VehicleDirector();
        assertThrows(IllegalArgumentException.class, () -> {
            instance.setVehicleBuilder(vehicleBuilder);
        });
    }

    /**
     * Test of setVehicleBuilder method for setting a CarBuilder, of class
     * VehicleDirector.
     */
    @Test
    public void testSetVehicleBuilderCar() {
        System.out.println("test setVehicleBuilder Car");
        VehicleBuilder vehicleBuilder = new CarBuilder();
        VehicleDirector instance = new VehicleDirector();
        instance.setVehicleBuilder(vehicleBuilder);
        String model = "Toyota";
        String engine = "V6";
        String body = "Sport";
        String wheels = "4 wheels";
        Vehicle vehicle = instance.builderVehicle(model, engine, body, wheels);
        assertTrue(vehicle instanceof Car);
    }

    /**
     * Test of setVehicleBuilder method for setting a MotorcycleBuilder, of
     * class VehicleDirector.
     */
    @Test
    public void testSetVehicleBuilderMotorcycle() {
        System.out.println("test setVehicleBuilder with MotorcycleBuilder");
        VehicleBuilder vehicleBuilder = new MotorcycleBuilder();
        VehicleDirector instance = new VehicleDirector();
        instance.setVehicleBuilder(vehicleBuilder);
        String model = "Yamaha";
        String engine = "Inline-4";
        String body = "Sport";
        String wheels = "2 wheels";
        Vehicle vehicle = instance.builderVehicle(model, engine, body, wheels);
        assertTrue(vehicle instanceof Motorcycle);
    }

    /**
     * Test of reset method, of class VehicleDirector.
     */
    @Test
    public void testReset() {
        System.out.println("test VehicleBuilder reset");
        String model = "Toyota";
        String engine = "V6";
        String body = "Sport";
        String wheels = "2 wheels";
        VehicleDirector instance = new VehicleDirector();
        instance.reset();
        assertThrows(NullPointerException.class, () -> {
            instance.builderVehicle(model, engine, body, wheels);
        });
    }
}
