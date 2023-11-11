package pan.eduard.Practice1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pan.eduard.Practice1.domain.Player;
import pan.eduard.Practice1.domain.Team;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeamRepository {

    private DataSource dataSource;
    @Autowired
    public TeamRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Team> getAllTeams() throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from team");
        List<Team> teams = new ArrayList<>();
        while (result.next()){
            int id = result.getInt("id");
            String name = result.getString("name");
            Team team = Team.builder().id(id).name(name).build();
            teams.add(team);
        }
        return teams;
    }

    public void insertTeam(int id, String name) throws SQLException {
        PreparedStatement statement = dataSource.getConnection().prepareStatement("INSERT INTO team(id, name) VALUES (?, ?)");
        statement.setLong(1, id);
        statement.setString(2, name);
        statement.execute();
    }

    public void deleteTeamById(int m) throws SQLException     {
        PreparedStatement statement = dataSource.getConnection().prepareStatement("DELETE FROM team where id = " + m);
        statement.execute();
    }

    public Team findTeamById(int m) throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        String query = "SELECT * from team WHERE id = " + m;
        ResultSet result = stmt.executeQuery(query);
        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            Team team = Team.builder().id(id).name(name).build();
            return team;
        }
        return Team.builder().build();
    }

    public Team findTeamByName(String n) throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        String query = "SELECT * from team WHERE name = " + n;
        ResultSet result = stmt.executeQuery(query);
        while (result.next()) {
            int id = result.getInt("id");
            Team team = Team.builder().id(id).name(n).build();
            return team;
        }
        return Team.builder().build();
    }
}
