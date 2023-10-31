package pan.eduard.Practice1.Mapper;

import org.springframework.jdbc.core.RowMapper;
import pan.eduard.Practice1.domain.MyEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventRowMapper implements RowMapper<MyEvent> {

    @Override
    public MyEvent mapRow(ResultSet rs, int rowNum) throws SQLException {

        MyEvent event = new MyEvent();
        event.setEventId(rs.getInt("id"));
        event.setName(rs.getString("name"));
        event.setEventDate(rs.getDate("date"));
        event.setPlace_id(rs.getInt("place_id"));
        return event;
    }
}
