package pan.eduard.Practice1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pan.eduard.Practice1.domain.Player;
import pan.eduard.Practice1.repository.PlayerRepository;

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
        return playerRepository.findAllPlayersNative();
    }
    public void addPlayer(String nickname, String first_name, String last_name, int team_id){
        Player player = Player.builder().nickname(nickname).first_name(first_name).last_name(last_name).team_id(team_id).build();
        playerRepository.save(player);
    }
    public void removePlayerById(int id){
        playerRepository.deleteById(id);
    }
    public Player findPlayerById(int id) {
        return playerRepository.retrieveById(id);
    }
    public Player findPlayerByFirstName(String first_name) {
        return playerRepository.retrieveByFirstName(first_name);
    }
}