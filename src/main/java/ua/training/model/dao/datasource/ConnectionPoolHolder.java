package ua.training.model.dao.datasource;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource dSource = new BasicDataSource();
//                    dSource.setUrl("jdbc:mysql://localhost/cashmachine");
//                    dSource.setDriverClassName("com.mysql.jdbc.Driver");
//                    dSource.setUsername("root");
//                    dSource.setPassword("root");
//                    dSource.setMinIdle(5);
//                    dSource.setMaxIdle(10);
////                    dSource.setMaxActive(15);
//                    dSource.setMaxOpenPreparedStatements(100);
                    try {
                        Properties configFile = new Properties();
                        configFile.load(ConnectionPoolHolder.class.getClassLoader()
                                .getResourceAsStream(ConnectionConstants.CONFIG_FILE_PATH));
                        dSource.setUrl(configFile.getProperty(ConnectionConstants.DATABASE_URL));
                        dSource.setUsername(configFile.getProperty(ConnectionConstants.DATABASE_USER));
                        dSource.setPassword(configFile.getProperty(ConnectionConstants.DATABASE_PASSWORD));
                        dSource.setDriverClassName(configFile.getProperty(ConnectionConstants.DATABASE_DRIVER));
                        dSource.setMinIdle(Integer.parseInt(configFile.getProperty(ConnectionConstants.DATABASE_MIN_IDLE)));
                        dSource.setMaxIdle(Integer.parseInt(configFile.getProperty(ConnectionConstants.DATABASE_MAX_IDLE)));
                        dSource.setMaxOpenPreparedStatements(Integer.parseInt(configFile.getProperty(
                                ConnectionConstants.DATABASE_MAX_OPEN_PREPARED_STATEMENTS)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    dataSource = dSource;
                }
            }
        }
        return dataSource;
    }
}
