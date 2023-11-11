package pan.eduard.Practice1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pan.eduard.Practice1.domain.Player;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class PlayerRepository {
    private DataSource dataSource;
    @Autowired

    public PlayerRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Player> getPlayers() throws SQLException{
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from player");
        List<Player> players = new ArrayList<>();
        while (result.next()){
            int id = result.getInt("id");
            String nickname = result.getString("nickname");
            String first_name = result.getString("first_name");
            String last_name = result.getString("last_name");
            int team_id = result.getInt("team_id");
            Player player = Player.builder().id(id).nickname(nickname).first_name(first_name).last_name(last_name).team_id(team_id).build();
            players.add(player);
        }
        return players;
    }

    public void insertPlayer(int id, String nickname, String first_name, String last_name, int team_id) throws SQLException{
        PreparedStatement statement = dataSource.getConnection().prepareStatement("INSERT INTO player(id, nickname, first_name, last_name, team_id) VALUES (?, ?, ?, ?, ?)");
        statement.setLong(1, id);
        statement.setString(2, nickname);
        statement.setString(3, first_name);
        statement.setString(4, last_name);
        statement.setInt(5, team_id);
        statement.execute();
    }
    public Player findPlayerById(int id) throws SQLException{
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from player WHERE id = ?");
            int player_id = result.getInt("id");
            String nickname = result.getString("nickname");
            String first_name = result.getString("first_name");
            String last_name = result.getString("last_name");
            int team_id = result.getInt("team_id");
            Player player = Player.builder().id(id).nickname(nickname).first_name(first_name).last_name(last_name).team_id(team_id).build();
        return player;
    }
    public Player findPlayerByNickname(String nickname) throws SQLException{
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from player WHERE nickname = ? ");
        int id = result.getInt("id");
        String first_name = result.getString("first_name");
        String last_name = result.getString("last_name");
        int team_id = result.getInt("team_id");
        Player player = Player.builder().id(id).nickname(nickname).first_name(first_name).last_name(last_name).team_id(team_id).build();
        return player;
    }
}
