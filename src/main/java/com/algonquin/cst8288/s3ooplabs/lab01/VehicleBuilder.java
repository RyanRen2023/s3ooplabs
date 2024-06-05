/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/07
 * Description: OOP Lab 1
 */
package com.algonquin.cst8288.s3ooplabs.lab01;

/**
 * VehicleBuilder interface defines the methods required to build a Vehicle.
 * This interface follows the Builder design pattern, allowing for the
 * step-by-step construction of a Vehicle object.
 *
 * @see Vehicle
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @autor Xihai Ren
 */
public interface VehicleBuilder {

    /**
     * Sets the wheels of the vehicle being built.
     *
     * @param wheels the wheels to set
     * @return the current instance of the builder
     */
    public VehicleBuilder buildWheels(String wheels);

    /**
     * Sets the engine of the vehicle being built.
     *
     * @param engine the engine to set
     * @return the current instance of the builder
     */
    public VehicleBuilder buildEngine(String engine);

    /**
     * Sets the body of the vehicle being built.
     *
     * @param body the body to set
     * @return the current instance of the builder
     */
    public VehicleBuilder buildBody(String body);

    /**
     * Sets the model of the vehicle being built.
     *
     * @param model the model to set
     * @return the current instance of the builder
     */
    public VehicleBuilder buildModel(String model);

    /**
     * Builds and returns the constructed vehicle.
     *
     * @return the built vehicle
     */
    public Vehicle build();

}
