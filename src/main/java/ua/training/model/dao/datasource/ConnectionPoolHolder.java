package ua.training.model.dao.datasource;

import org.apache.commons.dbcp.BasicDataSource;
import ua.training.constant.database.Configuration;
import ua.training.model.util.ConfigurationUtil;

import javax.sql.DataSource;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource dSource = new BasicDataSource();
                    dSource.setDriverClassName(ConfigurationUtil.getString(Configuration.DATABASE_DRIVER));
                    dSource.setUrl(ConfigurationUtil.getString(Configuration.DATABASE_URL));
                    dSource.setUsername(ConfigurationUtil.getString(Configuration.DATABASE_USER));
                    dSource.setPassword(ConfigurationUtil.getString(Configuration.DATABASE_PASSWORD));
                    dSource.setMinIdle(ConfigurationUtil.getInt(Configuration.DATABASE_MIN_IDLE));
                    dSource.setMaxIdle(ConfigurationUtil.getInt(Configuration.DATABASE_MAX_IDLE));
                    dSource.setMaxActive(ConfigurationUtil.getInt(Configuration.DATABASE_MAX_ACTIVE));
                    dSource.setMaxOpenPreparedStatements(ConfigurationUtil.getInt(Configuration.DATABASE_MAX_OPEN_PREPARED_STATEMENTS));
                    dataSource = dSource;
                }
            }
        }
        return dataSource;
    }
}
