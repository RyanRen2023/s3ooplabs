/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/07
 * Description: OOP Lab 1
 */
package com.algonquin.cst8288.s3ooplabs.lab01;

/**
 * CarBuilder class is a concrete builder that implements the VehicleBuilder
 * interface. It builds a Car object step by step.
 *
 * @see VehicleBuilder
 * @see Vehicle
 * @see Car
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class CarBuilder implements VehicleBuilder {

    /**
     * The Vehicle instance being built.
     */
    private Vehicle car;

    /**
     * Constructs a new CarBuilder and initializes a new Car object.
     */
    public CarBuilder() {
        car = new Car();
    }

    /**
     * Sets the wheels of the car being built.
     *
     * @param wheels the wheels to set
     * @return the current instance of the builder
     */
    @Override
    public VehicleBuilder buildWheels(String wheels) {
        car.setWheels(wheels);
        return this;
    }

    /**
     * Sets the engine of the car being built.
     *
     * @param engine the engine to set
     * @return the current instance of the builder
     */
    @Override
    public VehicleBuilder buildEngine(String engine) {
        car.setEngine(engine);
        return this;
    }

    /**
     * Sets the body of the car being built.
     *
     * @param body the body to set
     * @return the current instance of the builder
     */
    @Override
    public VehicleBuilder buildBody(String body) {
        car.setBody(body);
        return this;
    }

    /**
     * Sets the model of the car being built.
     *
     * @param model the model to set
     * @return the current instance of the builder
     */
    @Override
    public VehicleBuilder buildModel(String model) {
        car.setModel(model);
        return this;
    }

    /**
     * Builds and returns the constructed car.
     *
     * @return the built car
     */
    @Override
    public Vehicle build() {
        return car;
    }
}
