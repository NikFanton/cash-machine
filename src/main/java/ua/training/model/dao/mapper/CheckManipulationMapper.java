package ua.training.model.dao.mapper;

import ua.training.model.entity.CheckManipulation;
import ua.training.model.entity.enums.CheckManipulationType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

public class CheckManipulationMapper implements BaseMapper<CheckManipulation> {
    @Override
    public CheckManipulation extractFromResultSet(ResultSet resultSet, String prefix) throws SQLException {
        Long id = resultSet.getLong(prefix + "id");
        String typeName = resultSet.getString(prefix + "check_manipulation_type");
        CheckManipulationType type = CheckManipulationType.valueOf(typeName);
        LocalTime time = resultSet.getTime(prefix + "date_time_of_operation").toLocalTime();
        LocalDate date = resultSet.getDate(prefix + "date_time_of_operation").toLocalDate();
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        return new CheckManipulation(id, dateTime, type);
    }

    @Override
    public CheckManipulation makeUnique(Map<Long, CheckManipulation> cache, CheckManipulation checkManipulation) {
        cache.putIfAbsent(checkManipulation.getId(), checkManipulation);
        return cache.get(checkManipulation.getId());
    }
}
