/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/14
 * Description: Assignment 2 - Library Management System
 */
package com.algonquin.cst8288.assignment2.library;

/**
 * An enumeration of library types in the Library Management System. This enum
 * defines the various types of libraries that can be created and managed,
 * including public libraries and academic libraries.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public enum LibraryType {

    PUBLIC("Public Library"),
    ACADEMIC("Academic Library");

    private final String name;

    /**
     * Constructs a LibraryType with the specified name.
     *
     * @param name the name of the library type
     */
    LibraryType(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the library type.
     *
     * @return the name of the library type
     */
    public String getLibraryTypeName() {
        return this.name;
    }
}
