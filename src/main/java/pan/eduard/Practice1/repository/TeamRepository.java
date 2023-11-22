package pan.eduard.Practice1.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pan.eduard.Practice1.domain.Team;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findTeamByNameContainingIgnoreCase(String name);

    @Query("SELECT t from Team t WHERE LOWER(t.name) = LOWER(:name)")
    Team retrieveByName(@Param("name") String name);
    @org.springframework.transaction.annotation.Transactional
    void deleteById(int id);

    @Modifying
    @Transactional
    @Query(value = "insert into team (id, name) VALUES (?, ?)", nativeQuery = true)
    void insertTeam(int id, String name);

    @Query(value = "SELECT * from team t", nativeQuery = true)
    List<Team> findAllTeamsNative();

    @Query("SELECT t from Team t WHERE t.id = :id")
    Team retrieveById(@Param("id") int id);
}