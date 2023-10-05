package nl.han.aim.oose.dea.datasource.util;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

public class DatabaseProperties {
    private Properties properties;
    public DatabaseProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
        } catch (IOException e) {
//            logger.log(Level.SEVERE, "Can't access property file database.properties", e);
        }
    }


    public String connectionString()
    {
        return properties.getProperty("connectionString");
    }
    public String driver(){ return properties.getProperty("driver");}
}
