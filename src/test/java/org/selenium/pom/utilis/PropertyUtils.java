package org.selenium.pom.utilis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    public static Properties propertyLoader(String filepath)
    {
        Properties prop= new Properties();
        BufferedReader reader;
        try {
            reader=new BufferedReader(new FileReader(filepath));
            try {
                prop.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load the Properties file " +filepath);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("properties file not found in the classpath:" +filepath);
        }
        return prop;
    }
}
