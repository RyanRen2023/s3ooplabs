/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.library;

/**
 *
 * @author renxihai
 */
public class LibraryFactory {

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
