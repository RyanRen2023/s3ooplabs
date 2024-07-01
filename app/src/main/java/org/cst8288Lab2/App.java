/*
 * Main
 */
package org.cst8288Lab2;

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
 * App
 */
public class App {

    /**
     * Parses the file: bulk-import.csv Validates each item in each row and
     * updates the database accordingly.
     *
     * @param args -
     */
    public static void main(String[] args) {
        String baseDir = "./data/";
        String csvFile = baseDir + "bulk-import.csv";
        String successReportFile = baseDir + "import-report.md";
        String errorReportFile = baseDir + "error-report.md";
        List<String> list = FileOperator.readCSVFile(csvFile);

        List<Peer<String[], Peer<Boolean, List<String>>>> importedList = new ArrayList();
        List<Peer<String[], Peer<Boolean, List<String>>>> errorList = new ArrayList();
        for (int i = 1; i < list.size(); i++) {
            String[] content = Formatter.listStringFormat(list.get(i).split(","));
            Peer<Boolean, List<String>> validResult = Validation.validate(content[0], content[3], content[5], content[6]);
            if (validResult.getK()) {
                System.out.println("write to import-report.md");
                importedList.add(new Peer<>(content, validResult));               

            } else {
                System.out.println("write to error-report.md");
                errorList.add(new Peer<>(content, validResult));

            }

        }
        
        for (int i = 1; i < importedList.size(); i++) {
                Peer<String[], Peer<Boolean, List<String>>> importedData = importedList.get(i);
                String[] content = importedData.getK();
                StudentDTO sd = DataOperator.assembleStudent(content);
                CourseDTO cd = DataOperator.assembleCourse(content);
                StudentCourseDTO scd = DataOperator.assembleStudentCourse(content);
                DataOperator.clearExistsData(sd, cd, scd);
                DataOperator.saveNewData(sd, cd, scd);
        }
        
        Report importedReport = new ImportedReport(importedList);
        String report = importedReport.generateReport();
        FileOperator.WriteFile(successReportFile, report);
        
        Report errorReport = new ErrorReport(errorList);
        String errReport = errorReport.generateReport();
        FileOperator.WriteFile(errorReportFile, errReport);

    }

}
