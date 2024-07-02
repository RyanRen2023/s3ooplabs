/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - Properties Utility Tool
 */
package org.cst8288Lab2.utility;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A utility class for loading and accessing properties from a properties file.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author renxihai
 */
public class PropertiesTool {

    private static Properties properties;

    /**
     * Returns the properties loaded from the properties file. If the properties
     * have not been loaded yet, this method will load them.
     *
     * @return the loaded properties
     */
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
                if (inStream != null) {
                    try {
                        inStream.close();
                    } catch (IOException ex) {
                        Logger.getLogger(PropertiesTool.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return properties;
    }

    /**
     * Resets the properties, causing them to be reloaded the next time they are
     * requested.
     */
    public static void reset() {
        properties = null;
    }
}
