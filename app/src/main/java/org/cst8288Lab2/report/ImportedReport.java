/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - Imported Report Generation
 */

package org.cst8288Lab2.report;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import org.cst8288Lab2.utility.Peer;

/**
 * A class for generating reports for successfully imported items.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 * 
 * @author Xihai Ren
 */
public class ImportedReport implements Report {

    private List<Peer<String[], Peer<Boolean, List<String>>>> list;

    /**
     * Constructs an ImportedReport with the specified list of successfully imported items.
     *
     * @param list a list of Peer objects, each containing the row data and validation results
     */
    public ImportedReport(List<Peer<String[], Peer<Boolean, List<String>>>> list) {
        this.list = list;
    }

    /**
     * Generates the import report in markdown format.
     *
     * @return a string containing the generated import report
     */
    @Override
    public String generateReport() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        StringBuilder sb = new StringBuilder();
        sb.append("# Import Report\n");
        sb.append("## Successfully Imported Items\n");
        sb.append(String.format("## Date and Time: %s\n", formattedDateTime));
        sb.append(String.format("## Number of Records Added: %d\n", list.size()));

        for (int i = 0; i < list.size(); i++) {
            sb.append(String.format("- Row %d: %s \n", i + 1, Arrays.toString(list.get(i).getK())));
        }
        return sb.toString();
    }
}