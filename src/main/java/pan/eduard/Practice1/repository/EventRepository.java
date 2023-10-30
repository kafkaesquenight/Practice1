package pan.eduard.Practice1.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pan.eduard.Practice1.domain.MyEvent;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<MyEvent, Integer> {
    @Query("SELECT * FROM MyEvent mE")
    List<MyEvent> findAllEvents();
    @Query("SELECT * FROM MyEvent mE where mE.id =: eId")
    List<MyEvent> findEventById(@Param("id") int eId);
    @Query("SELECT * FROM MyEvent mE where mE.name =: eName")
    List<MyEvent> findEventByName(@Param("name") String eName);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO my_event (id, name, date, place_id) VALUES (?, ?, ?, ?)", nativeQuery = true)
    MyEvent save(int id, String name, String country, int place_id);
    @Modifying
    @Query("delete from MyEvent mE where mE.id =: eId")
    void deleteEventById(@Param("id") int eId);
}
