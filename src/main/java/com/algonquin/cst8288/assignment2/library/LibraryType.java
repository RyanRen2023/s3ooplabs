/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.library;

/**
 *
 * @author renxihai
 */
public enum LibraryType {

    PUBLIC("Public Library"),
    ACADEMIC("Academic Library");

    String name;

    LibraryType(String name) {
        this.name = name;
    }

    String getLibraryTypeName() {
        return this.name;
    }

}
