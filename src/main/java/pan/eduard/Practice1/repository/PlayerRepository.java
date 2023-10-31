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
    @Autowired
    private DataSource dataSource;
    public List<Player> getAllPlayers() throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from player");
        List<Player> players = new ArrayList<>();
        while (result.next()) {
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

    public void insertPlayer() throws SQLException {
        Connection conn = dataSource.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO player(nickname, first_name, last_name, team_id) VALUES (?, ?, ?, ?)");
        stmt.setString(1, nickname);
        stmt.setString(2, first_name);
        stmt.setString(3, last_name);
        stmt.setInt(4,team_id);
        stmt.executeUpdate();
    }

    public void deletePlayerById(int m) throws SQLException     {
        Connection conn = dataSource.getConnection();
        try{
            PreparedStatement p = conn.prepareStatement("delete from player where id=:m");
            p.execute();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public Player findPlayerById(int m) throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from player where id=:m");
        Player player;
            String nickname = result.getString("nickname");
            String first_name = result.getString("first_name");
            String last_name = result.getString("last_name");
            int team_id = result.getInt("team_id");
            player = Player.builder().id(m).nickname(nickname).first_name(first_name).last_name(last_name).team_id(team_id).build();
        return player;
    }

    public Player findPlayerByFirstName(String n) throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from player where first_name=:n");
        Player player;
        int id = result.getInt("id");
        String nickname = result.getString("nickname");
        String last_name = result.getString("last_name");
        int team_id = result.getInt("team_id");
        player = Player.builder().id(id).nickname(nickname).first_name(n).last_name(last_name).team_id(team_id).build();
        return player;
    }

}
