package pan.eduard.Practice1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pan.eduard.Practice1.Mapper.EventRowMapper;
import pan.eduard.Practice1.domain.MyEvent;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Repository
public class EventRepository{

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public EventRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MyEvent> findAll() {
        String sql = "SELECT * FROM my_event";
        List<MyEvent> events = jdbcTemplate.query(sql, new EventRowMapper());
        return events;
    }
    public void insertEvent(String name, LocalDate date, int event_id) {
        jdbcTemplate.update("INSERT INTO my_event (id, name, date) VALUES (?, ?, ?)", event_id, name, date
        );
    }
    public boolean deleteEvent(int id){
        String sql = "DELETE FROM my_event WHERE id = ?";
        Object[] args = new Object[] {id};
        return jdbcTemplate.update(sql, args) == 1;
    }
    public MyEvent findByEventId(int id) {
        String sql = "SELECT * FROM my_event WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EventRowMapper());
    }
    public MyEvent findByEventName(String name) {
        String sql = "SELECT * FROM my_event WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, new EventRowMapper());
    }
}
