package ua.training.model.dao.connection.pool;

import org.apache.commons.dbcp.BasicDataSource;
import ua.training.model.util.ConnectionConstants;

import javax.sql.DataSource;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource dSource = new BasicDataSource();
                    dSource.setUrl(ConnectionConstants.DATABASE_URL);
                    dSource.setUsername(ConnectionConstants.DATABASE_USER);
                    dSource.setPassword(ConnectionConstants.DATABASE_PASSWORD);
                    dSource.setDriverClassName(ConnectionConstants.DATABASE_DRIVER);
                    dSource.setMinIdle(5);
                    dSource.setMinIdle(10);
                    dSource.setMaxOpenPreparedStatements(100);
                    dataSource = dSource;
                }
            }
        }
        return dataSource;
    }
}
