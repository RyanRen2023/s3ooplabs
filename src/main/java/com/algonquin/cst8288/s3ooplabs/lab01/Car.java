/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor:Islam Gomaa
 * Due Date: 2024/06/07
 * Description: OOP Lab 1
 */
package com.algonquin.cst8288.s3ooplabs.lab01;

/**
 * Car class represents a specific type of Vehicle.
 *
 * @see Vehicle
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class Car extends Vehicle {

    /**
     * Constructs a new Car object and sets its type to "Car".
     */
    public Car() {
        super();
        this.setType("Car");
    }

    /**
     * Starts the car.
     */
    @Override
    public void start() {
        System.out.println("Car started.");
    }

    /**
     * Stops the car.
     */
    @Override
    public void stop() {
        System.out.println("Car stopped.");
    }

    /**
     * Moves the car forward.
     */
    @Override
    public void forward() {
        System.out.println("Car moving forward.");
    }

    /**
     * Moves the car backward.
     */
    @Override
    public void back() {
        System.out.println("Car moving backward.");
    }
}
