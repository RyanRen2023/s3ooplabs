/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2;

import java.util.ArrayList;
import java.util.List;
import org.cst8288Lab2.dto.Term;

/**
 *
 * @author renxihai
 */
public class Validation {

    private static boolean validateStudentId(String studentId) {
        String regex = "\\d{9}";
        return null != studentId && String.valueOf(studentId).matches(regex);
    }

    private static boolean validateCourseId(String courseId) {
        String regex = "[a-zA-Z]{3}[0-9]{4}";
        return null != courseId && courseId.matches(regex);
    }

    private static boolean validateTerm(int termNo) {
        return termNo >= 1 && termNo <= 3;
    }

    private static boolean validateYear(int year) {
        return year >= 1967 && year < 2025;
    }

    public static Peer<Boolean, List<String>> validate(String studentId, String courseId, String termNo, String year) {
        List<String> errInfo = new ArrayList();
        boolean isStudentIdValid = validateStudentId(studentId);
        boolean isCourseIdValid = validateCourseId(courseId);
        boolean isTermValid = validateTerm(Term.getTerm(termNo).getTermNumber());
        boolean isYearValid = validateYear(Integer.parseInt(year));
        if (!isStudentIdValid) {
            errInfo.add("studentId should be length of 9 digits");
        }
        if (!isCourseIdValid) {
            errInfo.add("courseId should be length of 7 characters (3 letters followed by 4 digits)");
        }
        if (!isTermValid) {
            errInfo.add("term should be one of three options: “WINTER”, “SUMMER”, “FALL”");

        }

        if (!isYearValid) {
            errInfo.add("year should length of 4 digits");
        }
        boolean isValid = isStudentIdValid && isCourseIdValid && isTermValid && isYearValid;
        return new Peer<Boolean,List<String>>(isValid, errInfo);
    }

}
