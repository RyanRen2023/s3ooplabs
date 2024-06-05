/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/07
 * Description: OOP Lab 1
 */
package com.algonquin.cst8288.s3ooplabs.lab01;

import java.util.ArrayList;
import java.util.List;

/**
 * VehicleManager class is responsible for managing a collection of Vehicle objects.
 * It follows the Singleton design pattern to ensure only one instance of the manager exists.
 *
 * @see Vehicle
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @autor Xihai Ren
 */
public class VehicleManager {

    private List<Vehicle> vehicleList;
    private static VehicleManager vehicleManager;

    /**
     * Private constructor to prevent instantiation from outside the class.
     * Initializes the vehicle list.
     */
    private VehicleManager() {
        vehicleList = new ArrayList<>();
    }

    /**
     * Returns the single instance of VehicleManager.
     * Creates the instance if it does not already exist.
     *
     * @return the single instance of VehicleManager
     */
    public static VehicleManager getInstance() {
        if (vehicleManager == null) {
            vehicleManager = new VehicleManager();
        }
        return vehicleManager;
    }

    /**
     * Adds a vehicle to the vehicle list.
     *
     * @param vehicle the vehicle to add
     */
    public void add(Vehicle vehicle) {
        this.vehicleList.add(vehicle);
    }

    /**
     * Retrieves the list of vehicles.
     *
     * @return the list of vehicles
     */
    public List<Vehicle> retrieve() {
        return this.vehicleList;
    }
}
