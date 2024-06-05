/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/07
 * Description: OOP Lab 1
 */
package com.algonquin.cst8288.s3ooplabs.lab01;

/**
 * Motorcycle class represents a specific type of Vehicle.
 *
 * @see Vehicle
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @autor Xihai Ren
 */
public class Motorcycle extends Vehicle {
    
    /**
     * Constructs a new Motorcycle object and sets its type to "Motorcycle".
     */
    public Motorcycle() {
        super();
        this.setType("Motorcycle");
    }
    
    /**
     * Starts the motorcycle.
     */
    @Override
    public void start() {
        System.out.println("Motorcycle start()");
    }
    
    /**
     * Stops the motorcycle.
     */
    @Override
    public void stop() {
        System.out.println("Motorcycle stop()");
    }
    
    /**
     * Moves the motorcycle forward.
     */
    @Override
    public void forward() {
        System.out.println("Motorcycle forward()");
    }
    
    /**
     * Moves the motorcycle backward.
     */
    @Override
    public void back() {
        System.out.println("Motorcycle back()");
    }
}
