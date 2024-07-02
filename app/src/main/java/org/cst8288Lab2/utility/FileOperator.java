/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - File Operations
 */
package org.cst8288Lab2.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A utility class to perform file operations such as reading from a CSV file
 * and writing content to a file.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class FileOperator {

    /**
     * Reads a CSV file and returns its content as a list of strings, where each
     * string represents a line in the file.
     *
     * @param file the path to the CSV file
     * @return a list of strings containing the lines of the CSV file
     */
    public List<String> readCSVFile(String file) {
        List<String> list = new ArrayList<>();
        try (InputStream in = new FileInputStream(file); BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String out;
            while ((out = br.readLine()) != null) {
                list.add(out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Writes the specified content to a file.
     *
     * @param file the path to the file
     * @param content the content to write to the file
     */
    public void writeFile(String file, String content) {
        try (FileWriter writer = new FileWriter(new File(file))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
