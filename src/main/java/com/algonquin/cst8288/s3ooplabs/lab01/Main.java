/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/07
 * Description: OOP Lab 1
 */
package com.algonquin.cst8288.s3ooplabs.lab01;

import java.util.List;

/**
 * Main class to demonstrate the creation and management of vehicles.
 *
 * @see Vehicle
 * @see VehicleManager
 * @see VehicleFactory
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @autor Xihai Ren
 */
public class Main {

    /**
     * The main method to execute the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        VehicleManager vehicleManager = VehicleManager.getInstance();
        VehicleFactory vehicleFactory = new VehicleFactory();

        // Create a car and add it to the vehicle manager
        Vehicle car = vehicleFactory.productVehicle("Car");
        vehicleManager.add(car);

        // Create a motorcycle and add it to the vehicle manager
        Vehicle motorcycle = vehicleFactory.productVehicle("Motorcycle");
        vehicleManager.add(motorcycle);

        // Retrieve and print the list of vehicles
        List<Vehicle> vehicleList = vehicleManager.retrieve();
        for (Vehicle v : vehicleList) {
            System.out.println(v);
        }
    }
}
