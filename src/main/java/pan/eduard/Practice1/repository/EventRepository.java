package pan.eduard.Practice1.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pan.eduard.Practice1.domain.MyEvent;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface EventRepository extends JpaRepository<MyEvent, Long> {
    MyEvent findMyEventByNameContainingIgnoreCase(String name);

    @Query("SELECT e from MyEvent e WHERE LOWER(e.name) = LOWER(:name)")
    MyEvent retrieveByName(@Param("name") String name);

    void deleteById(int id);
    @Modifying
    @Transactional
    @Query(value = "insert into my_event (id, name, date, place_id) VALUES (?, ?, ?, ?)", nativeQuery = true)
    void insertEvent(int id, String name, LocalDate date, int place_id);

    @Query(value = "SELECT * from my_event e", nativeQuery = true)
    List<MyEvent> findAllEventsNative();

    @Query("SELECT e from MyEvent e WHERE e.id = :id")
    MyEvent retrieveById(@Param("id") int id);
}