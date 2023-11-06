package pan.eduard.Practice1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pan.eduard.Practice1.domain.EventPlace;
import pan.eduard.Practice1.domain.MyEvent;
import pan.eduard.Practice1.domain.Player;
import pan.eduard.Practice1.repository.PlayerRepository;

import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
public class PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        try {
            return playerRepository.getAllPlayers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addPlayer(String nickname, String first_name, String last_name, int team_id){
        try {
            playerRepository.insertPlayer(nickname, first_name, last_name, team_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void removePlayer(int id){
        try {
            playerRepository.deletePlayerById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Player findPlayerById(int id) {
        try {
            return playerRepository.findPlayerById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Player findPLayerByFirstName(String first_name) {
        try {
            return playerRepository.findPlayerByFirstName(first_name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
