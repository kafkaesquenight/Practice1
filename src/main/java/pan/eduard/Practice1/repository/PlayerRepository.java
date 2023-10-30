package pan.eduard.Practice1.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pan.eduard.Practice1.domain.Player;

import java.util.List;

@Repository
public interface PlayerRepository {
    @Query("SELECT * FROM Player p")
    List<Player> findAllPlayers();
    @Query("SELECT * FROM Player p where p.id =: pId")
    List<Player> findPlayerById(@Param("id") int pId);
    @Query("SELECT * FROM Player p where p.name =: eName")
    List<Player> findPlayerByName(@Param("name") String pName);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO player (id, nickname, first_name, last_name, player_team_id) VALUES (?, ?, ?, ?, ?)", nativeQuery = true)
    Player save(int id, String nickname, String first_name, String last_name, int player_team_id);
    @Modifying
    @Query("delete from Player p where p.first_name =: fName")
    void deletePlayerByFirstName(@Param("first_name") String fName);
}
