/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2;

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
 *
 * @author renxihai
 */
public class FileOperator {
    public static List<String> readCSVFile(String file){
        //Preserve this input path
        List<String> list = new ArrayList();
        
        try (InputStream in = new FileInputStream(file)){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(in))){
                String out;
                while ((out = br.readLine()) != null){
                    list.add(out);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        } 
        return list;
    }
    
    public static void WriteFile(String file,String content){
  
        try(FileWriter writer = new FileWriter(new File(file))){
            writer.write(content);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
