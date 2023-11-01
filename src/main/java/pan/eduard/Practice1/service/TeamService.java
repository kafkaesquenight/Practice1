package pan.eduard.Practice1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pan.eduard.Practice1.domain.Player;
import pan.eduard.Practice1.domain.Team;
import pan.eduard.Practice1.repository.TeamRepository;

import java.sql.SQLException;

@Service
@Slf4j
public class TeamService {
    private TeamRepository teamRepository;
    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    public Team findTeamById(int id) {
        try {
            return teamRepository.findTeamById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
