/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.dto;

/**
 *
 * @author renxihai
 */
public enum Term {
    WINTER(1),
    SUMMER(2),
    FALL(3);

    private final int termNumber;

    private Term(int termNumber) {
        this.termNumber = termNumber;
    }

    public int getTermNumber() {
        return termNumber;
    }

    public static Term getTerm(int termNumber) {
        switch (termNumber) {
            case 1:
                return WINTER;
            case 2:
                return SUMMER;
            case 3:
                return FALL;
            default:
                throw new IllegalArgumentException("Unsupported arguments!");
        }
    }

    public static Term getTerm(String term) {
        if (term.equalsIgnoreCase(WINTER.name())) {
            return WINTER;
        }

        if (term.equalsIgnoreCase(SUMMER.name())) {
            return SUMMER;
        }

        if (term.equalsIgnoreCase(FALL.name())) {
            return FALL;
        }

        throw new IllegalArgumentException("Unsupported arguments!");

    }

}
