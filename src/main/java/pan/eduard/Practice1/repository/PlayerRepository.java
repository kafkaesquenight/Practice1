package pan.eduard.Practice1.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pan.eduard.Practice1.domain.Player;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findPlayerByNameContainingIgnoreCase(String name);

    @Query("SELECT p from Player p WHERE LOWER(p.first_name) = LOWER(:first_name)")
    Player retrieveByFirstName(@Param("first_name") String first_name);
    @org.springframework.transaction.annotation.Transactional
    void deleteById(int id);

    @Modifying
    @Transactional
    @Query(value = "insert into player (id, nickname, first_name, last_name, team_id) VALUES (?, ?, ?, ?, ?)", nativeQuery = true)
    void insertPlayer(int id, String nickname, String first_name, String last_name, int team_id);

    @Query(value = "SELECT * from player p", nativeQuery = true)
    List<Player> findAllPlayersNative();

    @Query("SELECT p from Player p WHERE p.id = :id")
    Player retrieveById(@Param("id") int id);
}