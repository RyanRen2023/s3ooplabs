/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.report;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import org.cst8288Lab2.Peer;

/**
 *
 * @author renxihai
 */
public class ImportedReport implements Report {

    private List<Peer<String[], Peer<Boolean, List<String>>>> list;

    public ImportedReport(List<Peer<String[], Peer<Boolean, List<String>>>> list) {
        this.list = list;
    }

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
