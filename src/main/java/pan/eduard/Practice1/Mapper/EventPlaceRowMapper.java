package pan.eduard.Practice1.Mapper;

import org.springframework.jdbc.core.RowMapper;
import pan.eduard.Practice1.domain.EventPlace;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventPlaceRowMapper implements RowMapper<EventPlace> {

    @Override
    public EventPlace mapRow(ResultSet rs, int rowNum) throws SQLException {

        EventPlace eventPlace = new EventPlace();
        eventPlace.setPlaceId(rs.getInt("id"));
        eventPlace.setName(rs.getString("name"));
        eventPlace.setCity(rs.getString("city"));
        eventPlace.setCountry(rs.getString("country"));
        return eventPlace;
    }
}
