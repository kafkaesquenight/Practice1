package pan.eduard.Practice1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pan.eduard.Practice1.domain.Player;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findPlayerByNicknameContainingIgnoreCase(String nickname);

    @Query("SELECT p from Player p WHERE LOWER(p.first_name) = LOWER(:first_name)")
    Player retrieveByFirstName(@Param("first_name") String first_name);
    @Transactional
    void deleteById(int id);


    @Query(value = "SELECT * from player p", nativeQuery = true)
    List<Player> findAllPlayersNative();

    @Query("SELECT p from Player p WHERE p.id = :id")
    Player retrieveById(@Param("id") int id);

}