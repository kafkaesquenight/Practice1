package pan.eduard.Practice1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pan.eduard.Practice1.domain.MyEvent;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface EventRepository extends JpaRepository<MyEvent, Long> {
    MyEvent findMyEventByNameContainingIgnoreCase(String name);

    @Query("SELECT e from MyEvent e WHERE LOWER(e.name) = LOWER(:name)")
    MyEvent retrieveByName(@Param("name") String name);
    @Transactional
    void deleteById(int id);

    @Query(value = "SELECT * from my_event e", nativeQuery = true)
    List<MyEvent> findAllEventsNative();

    @Query("SELECT e from MyEvent e WHERE e.id = :id")
    MyEvent retrieveById(@Param("id") int id);
    @Modifying
    @Query(
            value = "truncate table my_event",
            nativeQuery = true
    )
    void truncateMable();
}