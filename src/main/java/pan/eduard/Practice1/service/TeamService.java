package pan.eduard.Practice1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pan.eduard.Practice1.domain.Player;
import pan.eduard.Practice1.domain.Team;
import pan.eduard.Practice1.repository.TeamRepository;

import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
public class TeamService {
    private TeamRepository teamRepository;
    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    public List<Team> getTeams() {
        try {
            return teamRepository.getAllTeams();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addTeam(String name){
        try {
            teamRepository.insertTeam(name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void removeTeam(int id){
        try {
            teamRepository.deleteTeamById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Team findTeamById(int id) {
        try {
            return teamRepository.findTeamById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Team findTeamByName(String name) {
        try {
            return teamRepository.findTeamByName(name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
