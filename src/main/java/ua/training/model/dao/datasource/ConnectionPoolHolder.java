package ua.training.model.dao.datasource;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource dSource = new BasicDataSource();
                    try {
                        Properties configFile = new Properties();
                        configFile.load(ConnectionPoolHolder.class.getClassLoader()
                                .getResourceAsStream(ConnectionConstants.CONFIG_FILE_PATH));
                        dSource.setUrl(configFile.getProperty(ConnectionConstants.DATABASE_URL));
                        dSource.setUsername(configFile.getProperty(ConnectionConstants.DATABASE_USER));
                        dSource.setPassword(configFile.getProperty(ConnectionConstants.DATABASE_PASSWORD));
                        dSource.setDriverClassName(configFile.getProperty(ConnectionConstants.DATABASE_DRIVER));
                        dSource.setMinIdle(5);
                        dSource.setMinIdle(10);
                        dSource.setMaxOpenPreparedStatements(100);
                        dataSource = dSource;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return dataSource;
    }
}
