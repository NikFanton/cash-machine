package ua.training.model.dao.datasource;

public interface ConnectionConstants {
    String DATABASE_DRIVER = "db.driver";
    String DATABASE_URL = "db.url";
    String DATABASE_USER = "db.user";
    String DATABASE_PASSWORD = "db.password";
    String DATABASE_MIN_IDLE = "db.min.idle";
    String DATABASE_MAX_IDLE = "db.max.idle";
    String DATABASE_MAX_OPEN_PREPARED_STATEMENTS = "db.max.open.prepared.statements";

    String CONFIG_FILE_PATH = "/database/config.properties";
}
