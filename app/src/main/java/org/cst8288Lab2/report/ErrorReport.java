/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - Error Report Generation
 */
package org.cst8288Lab2.report;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import org.cst8288Lab2.utility.Peer;

/**
 * A class for generating error reports for items that failed to import.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class ErrorReport implements Report {

    private List<Peer<String[], Peer<Boolean, List<String>>>> list;

    /**
     * Constructs an ErrorReport with the specified list of failed import items.
     *
     * @param list a list of Peer objects, each containing the row data and
     * validation results
     */
    public ErrorReport(List<Peer<String[], Peer<Boolean, List<String>>>> list) {
        this.list = list;
    }

    /**
     * Generates the error report in markdown format.
     *
     * @return a string containing the generated error report
     */
    @Override
    public String generateReport() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        StringBuilder sb = new StringBuilder();
        sb.append("# Error Report\n");
        sb.append("## Items that Failed to Import\n");
        sb.append(String.format("## Date and Time: %s\n", formattedDateTime));
        sb.append(String.format("## Number of Records Added: %d\n", list.size()));

        for (int i = 0; i < list.size(); i++) {
            sb.append(String.format("- Row %d: %s \n", i + 1, Arrays.toString(list.get(i).getK())));
            List<String> errList = list.get(i).getV().getV();
            for (int j = 0; j < errList.size(); j++) {
                sb.append(String.format("   - Error %d: %s \n", j + 1, errList.get(j)));
            }
        }
        return sb.toString();
    }
}
