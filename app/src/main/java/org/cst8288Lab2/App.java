/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - Main Application
 */
package org.cst8288Lab2;

import org.cst8288Lab2.utility.Validation;
import org.cst8288Lab2.utility.FileOperator;
import org.cst8288Lab2.utility.Peer;
import org.cst8288Lab2.utility.Formatter;
import org.cst8288Lab2.dao.DataOperator;
import java.util.ArrayList;
import java.util.List;
import org.cst8288Lab2.dto.CourseDTO;
import org.cst8288Lab2.dto.StudentCourseDTO;
import org.cst8288Lab2.dto.StudentDTO;
import org.cst8288Lab2.report.ErrorReport;
import org.cst8288Lab2.report.ImportedReport;
import org.cst8288Lab2.report.Report;

/**
 * The main application class for Lab 2. This class reads a CSV file, validates
 * the data, updates the database, and generates reports.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class App {

    static Validation validation = new Validation();
    static Formatter formatter = new Formatter();
    static DataOperator dataOperator = new DataOperator();
    static FileOperator fileOperator = new FileOperator();

    /**
     * Parses the file: bulk-import.csv Validates each item in each row and
     * updates the database accordingly.
     *
     * @param args -
     */
    public static void main(String[] args) {
        
        System.out.println("1. init arguments.");
        String baseDir = "./data/";
        String csvFile = baseDir + "bulk-import.csv";
        String successReportFile = baseDir + "import-report.md";
        String errorReportFile = baseDir + "error-report.md";

        System.out.println("2. Read CSV file");
        List<String> list = fileOperator.readCSVFile(csvFile);

        List<Peer<String[], Peer<Boolean, List<String>>>> importedList = new ArrayList();
        List<Peer<String[], Peer<Boolean, List<String>>>> errorList = new ArrayList();

        System.out.println("3. Format and validate data");
        for (int i = 1; i < list.size(); i++) {
            String[] content = formatter.listStringFormat(list.get(i).split(","));
            if (content.length == 7) {
                Peer<Boolean, List<String>> validResult = validation.validate(content[0], content[3], content[5], content[6]);
                if (validResult.getK()) {
                    importedList.add(new Peer<>(content, validResult));
                } else {
                    errorList.add(new Peer<>(content, validResult));
                }
            }
        }
        
        System.out.println("3. Save imported data to database");
        for (int i = 1; i < importedList.size(); i++) {
            Peer<String[], Peer<Boolean, List<String>>> importedData = importedList.get(i);
            String[] content = importedData.getK();
            StudentDTO sd = dataOperator.assembleStudent(content);
            CourseDTO cd = dataOperator.assembleCourse(content);
            StudentCourseDTO scd = dataOperator.assembleStudentCourse(content);
            dataOperator.saveNewData(sd, cd, scd);
        }
        
        System.out.println("4. Write to import-report.md");
        Report importedReport = new ImportedReport(importedList);
        String report = importedReport.generateReport();
        fileOperator.writeFile(successReportFile, report);

        System.out.println("5. Write to error-report.md");
        Report errorReport = new ErrorReport(errorList);
        String errReport = errorReport.generateReport();
        fileOperator.writeFile(errorReportFile, errReport);

    }

}
