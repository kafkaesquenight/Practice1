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
public interface EventPlaceRepository extends JpaRepository<EventPlace, Integer> {
    @Query("SELECT * FROM EventPlace ep")
    List<EventPlace> findAllPlaces();
    @Query("SELECT * FROM EventPlace ep where ep.id =: epid")
    List<EventPlace> findPlaceById(@Param("id") int epid);
    @Query("SELECT * FROM EventPlace ep where ep.country =: countryn")
    List<EventPlace> findPlaceByCountry(@Param("country") String countryn);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO event_place (id, name, country, city) VALUES (?, ?, ?, ?)", nativeQuery = true)
    EventPlace save(int id, String name, String country, String city);
    @Modifying
    @Query("delete from EventPlace ep where ep.city =: name")
    void deleteByCity(@Param("city") String name);
}
