/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/14
 * Description: Assignment 2 - Library Management System
 */
package com.algonquin.cst8288.assignment2.library;

/**
 * A factory class for creating Library objects based on LibraryType.
 * This class provides a method to create specific library instances such as
 * PublicLibrary and AcademicLibrary.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 * 
 * @author Xihai Ren
 */
public class LibraryFactory {

    /**
     * Creates a Library object based on the specified LibraryType.
     * Returns the appropriate library instance.
     *
     * @param type the type of library to create
     * @return the created Library object
     * @throws IllegalArgumentException if the LibraryType is unsupported
     */
    public static Library getLibraryByType(LibraryType type) {
        Library library = null;
        switch (type) {
            case PUBLIC:
                library = new PublicLibrary();
                break;
            case ACADEMIC:
                library = new AcademicLibrary();
                break;
            default:
                throw new IllegalArgumentException("Unsupported Library Type!");
        }
        return library;
    }
}
