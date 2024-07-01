/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2;


/**
 *
 * @author renxihai
 */
public class Formatter {
    
    public static String[] listStringFormat(String[] content){
        for (int i = 0; i < content.length; i++) {
            String string = content[i];
            content[i] = content[i].trim();
        }
        return content;
    }
    
}
