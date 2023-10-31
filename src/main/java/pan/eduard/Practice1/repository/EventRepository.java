package pan.eduard.Practice1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pan.eduard.Practice1.Mapper.EventRowMapper;
import pan.eduard.Practice1.domain.MyEvent;

import java.sql.Date;
import java.util.List;


@Repository
public class EventRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<MyEvent> findAll() {

        String sql = "SELECT * FROM event";

        List<MyEvent> events = jdbcTemplate.query(sql, new EventRowMapper());

        return events;

    }
    void insertEvent(String name, Date date, int event_id) {
        jdbcTemplate.update("INSERT INTO event (name, date, event_id) VALUES (?, ?, ?)", name, date, event_id
        );
    }
    public boolean deleteEvent(int id){
        String sql = "DELETE FROM event WHERE id = ?";
        Object[] args = new Object[] {id};
        return jdbcTemplate.update(sql, args) == 1;
    }
    public MyEvent findByEventId(int id) {
        String sql = "SELECT * FROM event WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EventRowMapper());
    }
    public MyEvent findByEventName(String name) {
        String sql = "SELECT * FROM event WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, new EventRowMapper());
    }
}
