package pan.eduard.Practice1.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pan.eduard.Practice1.Mapper.EventPlaceRowMapper;
import pan.eduard.Practice1.domain.EventPlace;
import java.util.List;


@Repository
public class EventPlaceRepository {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public EventPlaceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<EventPlace> findAll() {

        String sql = "SELECT * FROM event_place";

        List<EventPlace> eventPlaces = jdbcTemplate.query(sql, new EventPlaceRowMapper());

        return eventPlaces;

    }
    public void insertEventPlace(String name, String country, String city) {
        jdbcTemplate.update("INSERT INTO event_place (name, country, city) VALUES (?, ?, ?)", name, country, city
        );
    }
    public boolean deleteEventPlace(int id){
        String sql = "DELETE FROM event_place WHERE id = ?";
        Object[] args = new Object[] {id};
        return jdbcTemplate.update(sql, args) == 1;
    }
    public EventPlace findByEventPlaceId(int id) {
        String sql = "SELECT * FROM event_place WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EventPlaceRowMapper());
    }
    public EventPlace findByEventPlaceName(String name) {
        String sql = "SELECT * FROM event_place WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, new EventPlaceRowMapper());
    }

}
