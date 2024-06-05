/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/07
 * Description: OOP Lab 1
 */
package com.algonquin.cst8288.s3ooplabs.lab01;

/**
 * VehicleDirector class is responsible for constructing a Vehicle using a
 * VehicleBuilder.
 *
 * @see VehicleBuilder
 * @see Vehicle
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @autor Xihai Ren
 */
public class VehicleDirector {

    /**
     * The builder used to construct a Vehicle.
     */
    private VehicleBuilder vehicleBuilder;

    /**
     * Constructs a Vehicle with the specified model, engine, body, and wheels.
     *
     * @param model the model of the vehicle
     * @param engine the engine of the vehicle
     * @param body the body of the vehicle
     * @param wheels the wheels of the vehicle
     * @return the constructed vehicle
     */
    public Vehicle builderVehicle(String model, String engine, String body, String wheels) {
        vehicleBuilder.buildModel(model).buildBody(body).buildEngine(engine).buildWheels(wheels);
        return vehicleBuilder.build();
    }

    /**
     * Sets the VehicleBuilder used by this director.
     *
     * @param vehicleBuilder the VehicleBuilder to set
     * @throws IllegalArgumentException if the vehicleBuilder is null
     */
    public void setVehicleBuilder(VehicleBuilder vehicleBuilder) {
        if (vehicleBuilder == null) {
            throw new IllegalArgumentException("VehicleBuilder should not be null!");
        }
        this.vehicleBuilder = vehicleBuilder;
    }

    /**
     * Resets the VehicleBuilder to null.
     */
    public void reset() {
        this.vehicleBuilder = null;
    }
}
