/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/07
 * Description: OOP Lab 1
 */
package com.algonquin.cst8288.s3ooplabs.lab01;

/**
 * MotorcycleBuilder class is a concrete builder that implements the VehicleBuilder interface.
 * It builds a Motorcycle object step by step.
 *
 * @see VehicleBuilder
 * @see Vehicle
 * @see Motorcycle
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class MotorcycleBuilder implements VehicleBuilder {

    /**
     * The Motorcycle instance being built.
     */
    private Vehicle motorcycle;

    /**
     * Constructs a new MotorcycleBuilder and initializes a new Motorcycle object.
     */
    public MotorcycleBuilder() {
        motorcycle = new Motorcycle();
    }

    /**
     * Sets the wheels of the motorcycle being built.
     * 
     * @param wheels the wheels to set
     * @return the current instance of the builder
     */
    @Override
    public VehicleBuilder buildWheels(String wheels) {
        motorcycle.setWheels(wheels);
        return this;
    }

    /**
     * Sets the engine of the motorcycle being built.
     * 
     * @param engine the engine to set
     * @return the current instance of the builder
     */
    @Override
    public VehicleBuilder buildEngine(String engine) {
        motorcycle.setEngine(engine);
        return this;
    }

    /**
     * Sets the body of the motorcycle being built.
     * 
     * @param body the body to set
     * @return the current instance of the builder
     */
    @Override
    public VehicleBuilder buildBody(String body) {
        motorcycle.setBody(body);
        return this;
    }

    /**
     * Sets the model of the motorcycle being built.
     * 
     * @param model the model to set
     * @return the current instance of the builder
     */
    @Override
    public VehicleBuilder buildModel(String model) {
        motorcycle.setModel(model);
        return this;
    }

    /**
     * Builds and returns the constructed motorcycle.
     * 
     * @return the built motorcycle
     */
    @Override
    public Vehicle build() {
        return motorcycle;
    }
}
