/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/07
 * Description: OOP Lab 1
 */
package com.algonquin.cst8288.s3ooplabs.lab01;

/**
 * Vehicle is an abstract class that represents a generic vehicle. It provides
 * the basic structure and behavior that all specific vehicle types must
 * implement.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @autor Xihai Ren
 */
public abstract class Vehicle {

    // Fields representing the properties of a vehicle
    private String wheels;
    private String body;
    private String engine;
    private String model;
    private String type;

    /**
     * Gets wheels of the vehicle.
     *
     * @return the wheels of the vehicle
     */
    public String getWheels() {
        return wheels;
    }

    /**
     * Sets wheels of the vehicle.
     *
     * @param wheels the wheels to set
     */
    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    /**
     * Gets the body type of the vehicle.
     *
     * @return the vehicle body of the vehicle
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the body type of the vehicle.
     *
     * @param vehicle body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Gets the engine type of the vehicle.
     *
     * @return the engine of the vehicle
     */
    public String getEngine() {
        return engine;
    }

    /**
     * Sets the engine type of the vehicle.
     *
     * @param engine the engine to set
     */
    public void setEngine(String engine) {
        this.engine = engine;
    }

    /**
     * Gets the model of the vehicle.
     *
     * @return the model of the vehicle
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the vehicle.
     *
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the type of the vehicle.
     *
     * @return the type of the vehicle
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the vehicle.
     *
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Constructs a new Vehicle object with the specified type.
     *
     * @param type the type of the vehicle
     */
    public Vehicle(String type) {
        this.type = type;
    }

    /**
     * Constructs a new Vehicle object with default settings.
     */
    public Vehicle() {
    }

    /**
     * Returns a string representation of the vehicle.
     *
     * @return a string representation of the vehicle
     */
    @Override
    public String toString() {
        return "Vehicle{" + "type=" + type + ", model=" + model + ", engine=" + engine + ", body=" + body + ", wheels=" + wheels + '}';
    }

    /**
     * Starts the vehicle.
     */
    public abstract void start();

    /**
     * Stops the vehicle.
     */
    public abstract void stop();

    /**
     * Moves the vehicle forward.
     */
    public abstract void forward();

    /**
     * Moves the vehicle backward.
     */
    public abstract void back();

}
