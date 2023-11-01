package pan.eduard.Practice1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pan.eduard.Practice1.domain.MyEvent;
import pan.eduard.Practice1.domain.Player;
import pan.eduard.Practice1.repository.PlayerRepository;

import java.sql.SQLException;

@Service
@Slf4j
public class PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    public Player findPlayerById(int id) {
        try {
            return playerRepository.findPlayerById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
