/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.dao;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author renxihai
 */
public class PropertiesTool {

    private static Properties properties;

    public static Properties getProperties() {
        if (properties == null) {
            InputStream inStream = null;
            try {
                properties = new Properties();
                inStream = Files.newInputStream(Paths.get("data/database.properties"));
                properties.load(inStream);
            } catch (IOException ex) {
                Logger.getLogger(PropertiesTool.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    inStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(PropertiesTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return properties;
    }

    public static void reset() {
        properties = null;
    }

}
