package ua.training.model.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.constant.LogMessages;
import ua.training.constant.database.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationUtil {
    private static final Logger logger = LogManager.getLogger(ConfigurationUtil.class);
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream(Configuration.CONFIG_FILE_PATH));
        } catch (IOException e) {
            logger.error(e.getMessage() + " " + LogMessages.LOAD_CONFIG_FILE_ERROR);
        }
    }

    public static String getString(String key) {
        return properties.getProperty(key);
    }

    public static Integer getInt(String key) {
        return Integer.valueOf(getString(key));
    }
}
