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
        return teamRepository.findAllTeamsNative();
    }
    public void addTeam(int id, String name){
        teamRepository.insertTeam(id, name);
    }
    public void removeTeamById(int id){
        teamRepository.deleteById(id);
    }
    public Team findTeamById(int id) {
        return teamRepository.retrieveById(id);
    }
    public Team findTeamByName(String first_name) {
        return teamRepository.retrieveByName(first_name);
    }

}