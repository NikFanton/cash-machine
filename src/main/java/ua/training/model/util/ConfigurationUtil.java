package ua.training.model.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationUtil {
    private static Properties properties = new Properties();

    public String getProperty(String propertyName) {
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/config/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(propertyName);
    }
}
