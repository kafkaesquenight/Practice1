package pan.eduard.Practice1.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pan.eduard.Practice1.domain.Player;
import pan.eduard.Practice1.domain.Team;

import java.util.List;

@Repository
public interface TeamRepository {
    @Query("SELECT * FROM Team t")
    List<Team> findAllTeams();
    @Query("SELECT * FROM Team t where t.id =: tId")
    List<Team> findTeamById(@Param("id") int tId);
    @Query("SELECT * FROM Team t where t.name =: tName")
    List<Team> findTeamByName(@Param("name") String tName);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO team (id, name) VALUES (?, ?)", nativeQuery = true)
    Team save(int id, String name);
    @Modifying
    @Query("delete from Team t where t.name =: dName")
    void deleteTeamByName(@Param("name") String dName);
}
