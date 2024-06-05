/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/07
 * Description: OOP Lab 1
 */
package com.algonquin.cst8288.s3ooplabs.lab01;

/**
 * VehicleFactory class is responsible for creating different types of vehicles.
 * It utilizes the VehicleDirector and various VehicleBuilder implementations to produce vehicles.
 *
 * @see VehicleDirector
 * @see CarBuilder
 * @see MotorcycleBuilder
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class VehicleFactory {

    private VehicleDirector vehicleDirector = new VehicleDirector();

    /**
     * Produces a Vehicle based on the specified type.
     *
     * @param vehicle the type of vehicle to produce (e.g., "Car", "Motorcycle")
     * @return the produced vehicle, or null if the type is not recognized
     */
    public Vehicle productVehicle(String vehicle) {
        if ("Car".equalsIgnoreCase(vehicle)) {
            vehicleDirector.setVehicleBuilder(new CarBuilder());
            return vehicleDirector.builderVehicle("Toyota", "V8", "SUV", "Four Wheels");
        } else if ("Motorcycle".equalsIgnoreCase(vehicle)) {
            vehicleDirector.setVehicleBuilder(new MotorcycleBuilder());
            return vehicleDirector.builderVehicle("Honda CBR500R", "500cc", "Sport Body", "Two Wheels");
        }
        return null;
    }
}
