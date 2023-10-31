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
    @Autowired
    private DataSource dataSource;
    public List<Team> getAllTeams() throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from team");
        List<Team> teams = new ArrayList<>();
        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            Team team = Team.builder().id(id).name(name).build();
            teams.add(team);
        }
        return teams;
    }

    public void insertTeam() throws SQLException {
        Connection conn = dataSource.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO team(name) VALUES (?)");
        stmt.setString(1, name);
        stmt.executeUpdate();
    }

    public void deleteTeamById(int m) throws SQLException     {
        Connection conn = dataSource.getConnection();
        try{
            PreparedStatement p = conn.prepareStatement("delete from team where id=:m");
            p.execute();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public Team findTeamById(int m) throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from team where id=:m");
        Team team;
        String name = result.getString("name");
        team = Team.builder().id(m).name(name).build();
        return team;
    }

    public Team findTeamByName(String n) throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from team where name=:n");
        Team team;
        int id = result.getInt("id");
        String name = result.getString("name");
        team = Team.builder().id(id).name(name).build();
        return team;
    }
}
