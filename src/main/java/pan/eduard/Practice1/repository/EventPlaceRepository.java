package pan.eduard.Practice1.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pan.eduard.Practice1.domain.EventPlace;
import java.util.List;


@Repository
public interface EventPlaceRepository extends JpaRepository<EventPlace, Long> {
    EventPlace findEventPlaceByNameContainingIgnoreCase(String name);

    @Query("SELECT ep from EventPlace ep WHERE LOWER(ep.name) = LOWER(:name)")
    EventPlace retrieveByName(@Param("name") String name);
    @org.springframework.transaction.annotation.Transactional
    void deleteById(int id);


    @Query(
            value = "SELECT * from event_place ep",
            nativeQuery = true)
    List<EventPlace> findAllEventPlaceNative();

    @Query("SELECT ep from EventPlace ep WHERE ep.id = :id")
    EventPlace retrieveById(@Param("id") int id);
    @Modifying
    @Query(
            value = "truncate table event_place",
            nativeQuery = true
    )
    void truncateTable();
}